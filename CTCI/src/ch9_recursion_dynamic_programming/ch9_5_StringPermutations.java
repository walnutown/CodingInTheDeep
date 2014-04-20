package ch9_recursion_dynamic_programming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class ch9_5_StringPermutations {

   /*
    * Write a method to compute all permutations of a string
    * The string contains duplicate characters.
    */
   // see Leetcode-- Permutations
   // http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/

   // Backtracking
   // swap different characters to each position
   // time: O(n!); space: recursive stack
   public ArrayList<String> getPermutations(String S) {
      ArrayList<String> res = new ArrayList<String>();
      if (S == null || S.length() == 0)
         return res;
      char[] ss = S.toCharArray();
      dfs(ss, 0, res);
      return res;
   }

   private void dfs(char[] ss, int dep, ArrayList<String> res) {
      if (dep == ss.length) {
         res.add(new String(ss));
         return;
      }
      Set<Character> set = new HashSet<Character>();
      for (int i = dep; i < ss.length; i++) {
         if (!set.contains(ss[i])) {
            set.add(ss[i]);
            swap(ss, dep, i);
            dfs(ss, dep + 1, res);
            swap(ss, dep, i);
         }
      }
   }

   private void swap(char[] A, int i, int j) {
      char tmp = A[i];
      A[i] = A[j];
      A[j] = tmp;
   }

   // Insert characters to different positions of the previous strings
   // time: O(n!)
   public ArrayList<String> getPermutations2(String s) {
      ArrayList<String> res = new ArrayList<String>();
      if (s == null || s.length() == 0)
         return res;
      res.add(s.charAt(0) + "");
      for (int i = 1; i < s.length(); i++) {
         char curr = s.charAt(i);
         int size = res.size();
         for (int j = 0; j < size; j++) {
            StringBuilder sb = new StringBuilder(res.get(j));
            for (int k = 0; k <= sb.length(); k++) {
               sb.insert(k, curr);
               if (!res.contains(sb.toString())) // support duplicate characters here
                  res.add(sb.toString());
               sb.deleteCharAt(k);
            }
         }
         // remove the unneeded strings
         for (int j = 0; j < size; j++) {
            res.remove(0);
         }
      }
      return res;
   }

   @Test
   public void test() {
      System.out.println(getPermutations("abaa"));
      System.out.println(getPermutations2("abaa"));
   }

}
