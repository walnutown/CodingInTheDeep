package ch18_hard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.Test;

public class ch18_5_FindDistanceOfWordsInFile {

   /*
    * You have a large text file containing words. Given any two words, find the shortest distance
    * (in terms of number of words) between them in the file. If the operation will be repeated many
    * times for the file (but different pairs of words), can you optimize your solution?
    */
   // Assumption: the order of two words doesn't matter.
   // Based on the idea of inverted index

   // Sol1
   // <1> store all the occurrence index of each word.
   // <2> Create a wrapper class called Index, which include the index and word.
   // <3> Merge the two list of Index and sort, find the minDistance between any two neighboring
   // Index (the two
   // neighboring Index should be from different words)
   // Note 2 edge cases: 1, same word; 2, word not in the file
   // time: build index O(n), query O(mlgm); space: O(n)
   // n is the number of all words in file, m is the average number of one word in file
   public int findDistanceOfWordsInFile(String filename, String word1, String word2)
         throws Exception {
      Map<String, ArrayList<Index>> map = scanFile(filename);
      if (!map.containsKey(word1) || !map.containsKey(word2))
         throw new Exception("Word not found");
      if (word1.equals(word2))
         return 0;
      ArrayList<Index> res = new ArrayList<Index>();
      res.addAll(map.get(word1));
      res.addAll(map.get(word2));
      Collections.sort(res, new Comparator<Index>() {
         public int compare(Index in1, Index in2) {
            return in1.index - in2.index;
         }
      });
      int minDis = Integer.MAX_VALUE;
      for (int i = 1; i < res.size(); i++) {
         Index in1 = res.get(i - 1), in2 = res.get(i);
         if (!in1.word.equals(in2.word))  // to make sure the index is from two different words
            minDis = Math.min(minDis, in2.index - in1.index);
      }
      return minDis;
   }

   private Map<String, ArrayList<Index>> scanFile(String filename) throws FileNotFoundException {
      Map<String, ArrayList<Index>> map = new HashMap<String, ArrayList<Index>>();
      Scanner scanner = new Scanner(new File(filename));
      int pos = 0;
      while (scanner.hasNextLine()) {
         String line = scanner.nextLine();
         // the regex is important here, notice whitespace
         String regex = "\\p{Punct} |\\t|\\r|\\n| ";
         String[] words = line.split(regex);
         for (String w : words) {
            if (!map.containsKey(w))
               map.put(w, new ArrayList<Index>());
            map.get(w).add(new Index(w, pos));
            pos++;
         }
      }
      System.out.println(map.toString());
      return map;
   }

   class Index {
      public String word;
      public int index;

      public Index(String word, int index) {
         this.word = word;
         this.index = index;
      }

      public String toString() {
         return index + "";
      }
   }

   // Sol2, optimization to Sol1
   // In fact, there's no need to sort the final list
   // We can use the property that the two index lists is already sorted
   // time: build index O(n), query O(m)
   public int findDistanceOfWordsInFile2(String filename, String word1, String word2)
         throws Exception {
      Map<String, ArrayList<Integer>> map = scanFile2(filename);
      if (!map.containsKey(word1) || !map.containsKey(word2))
         throw new Exception("Word not found");
      if (word1.equals(word2))
         return 0;
      ArrayList<Integer> indices1 = map.get(word1), indices2 = map.get(word2);
      int i = 0, j = 0, min = Integer.MAX_VALUE, M = indices1.size(), N = indices2.size();
      Index prev = null;
      while (i < M && j < N) {
         Index curr = null;
         if (indices1.get(i) < indices2.get(j))
            curr = new Index(word1, indices1.get(i++));
         else
            curr = new Index(word2, indices2.get(j++));
         if (prev != null && !prev.word.equals(curr.word))
            min = Math.min(curr.index - prev.index, min);
         prev = curr;
      }
      if (i < M && prev.word.equals(word2))
         min = Math.min(indices1.get(i) - prev.index, min);
      if (j < N && prev.word.equals(word1))
         min = Math.min(indices2.get(j) - prev.index, min);
      return min;
   }

   private Map<String, ArrayList<Integer>> scanFile2(String filename) throws FileNotFoundException {
      Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
      Scanner scanner = new Scanner(new File(filename));
      int pos = 0;
      while (scanner.hasNextLine()) {
         String line = scanner.nextLine();
         // the regex is important here, notice whitespace
         String regex = "\\p{Punct} |\\t|\\r|\\n| ";
         String[] words = line.split(regex);
         for (String w : words) {
            if (!map.containsKey(w))
               map.put(w, new ArrayList<Integer>());
            map.get(w).add(pos);
            pos++;
         }
      }
      System.out.println(map.toString());
      return map;
   }

   @Test
   public void test() throws Exception {
      String word1 = "the", word2 = "at", filename = "src/ch18_hard/test";
      System.out.println(findDistanceOfWordsInFile(filename, word1, word2));
      System.out.println(findDistanceOfWordsInFile2(filename, word1, word2));
   }
}
