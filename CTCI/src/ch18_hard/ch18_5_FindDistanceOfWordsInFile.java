package ch18_hard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ch18_5_FindDistanceOfWordsInFile {

   /**
    * You have a large text file containing words. Given any two words, find the shortest distance
    * (in terms of number of words) between them in the file. If the operation will be repeated many
    * times for the file (but different pairs of words), can you optimize your solution?
    */
   // Assumption: the order of two words doesn't matter.

   // <1> store all the occurrence index of each word.
   // <2> Create a wrapper class called Pos, which include the index and word.
   // <3> Merge the two list of Pos, find the min distance between any two neighboring Pos (the two
   // neighboring Pos should be from different words)
   public static int findDistanceOfWordsInFile(String filename, String word1, String word2)
         throws FileNotFoundException {
      Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
      scanFile(map, filename);
      if (!map.containsKey(word1) || !map.containsKey(word2))
         return 0;
      ArrayList<Integer> wordPosList1 = map.get(word1), wordPosList2 = map.get(word2);
      ArrayList<Pos> res = new ArrayList<Pos>();
      int i = 0, j = 0; // merge the two lists
      while (i < wordPosList1.size() && j < wordPosList2.size()) {
         int pos1 = wordPosList1.get(i), pos2 = wordPosList2.get(j);
         if (pos1 < pos2) {
            res.add(new Pos(word1, pos1));
            i++;
         } else if (pos1 == pos2)
            throw new IllegalArgumentException("The index of the two words cannot be same");
         else {
            res.add(new Pos(word2, pos2));
            j++;
         }
      }
      while (i < wordPosList1.size()) {
         res.add(new Pos(word1, wordPosList1.get(i)));
         i++;
      }
      while (j < wordPosList2.size()) {
         res.add(new Pos(word2, wordPosList2.get(j)));
         j++;
      }
      int minDis = Integer.MAX_VALUE;
      for (int k = 1; k < res.size(); k++) {
         Pos pos1 = res.get(k - 1), pos2 = res.get(k);
         if (!pos1.word.equals(pos2.word))  // to make sure the pos is from two different words
            minDis = Math.min(minDis, pos2.pos - pos1.pos);
      }
      return minDis;
   }

   public static void scanFile(Map<String, ArrayList<Integer>> map, String filename)
         throws FileNotFoundException {
      Scanner scanner = new Scanner(new File(filename));
      int pos = 0;
      while (scanner.hasNextLine()) {
         String line = scanner.nextLine();
         String regex = "\\p{Punct} |\\t|\\r|\\n| "; // the regex is important here, notice
                                                     // whitespace
         String[] words = line.split(regex);
         for (String w : words) {
            if (map.containsKey(w))
               map.get(w).add(pos);
            else {
               map.put(w, new ArrayList<Integer>());
               map.get(w).add(pos);
            }
            pos++;
         }
      }
      System.out.println(map.toString());
   }

   public static class Pos {
      public String word;
      public int pos;

      public Pos(String word, int pos) {
         this.word = word;
         this.pos = pos;
      }
   }

   public static void main(String[] args) {
      try {
         String word1 = "the", word2 = "at", filename = "src/ch18_hard/test";
         System.out.println(findDistanceOfWordsInFile(filename, word1, word2));
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
   }
}
