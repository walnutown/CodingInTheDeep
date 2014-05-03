package ch17_moderate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class ch17_14_FindMinWordBreak {

   /**
    * You have just completed a lengthy document when you have an unfortunate Find/Replace mishap.
    * You have accidently removed all spaces, punctuation, and capitalization in the document. A
    * sentence like "I reset the computer. It still didn't boot!" would become
    * "iresetthecomputeritstilldidntboot". You figure that you can add back in the punctuation and
    * capitalization later, once you get the individual words properly separated. Most of the words
    * will be in a dictionary, but some strings, like proper names, will not.
    * 
    * Given a dictionary (a list of words), design an algorithm to find the optimal way of
    * "unconcatenating" a sequence of words. In this case, "optimal" is defined to be the parsing
    * which minimizes the number of unrecognized sequence of characters.
    * 
    * For example, the string "jesslookedjustliketimherbrother" would be optimally parsed as
    * "JESS looked just like TIM her brother". This parsing has seven unrecognized characters, which
    * we have capitalized for clarity.
    */

   // A variant of Leetcode/WordBreak
   // Create a wrapper class to hold the minBreakWord and number of invalid characters 
   // Backtracking + memoization
   private String findMinWordBreak(String s, Set<String> dict) {
      if (s == null || s.length() == 0)
         return s;
      Map<Integer, R> map = new HashMap<Integer, R>();
      return dfs(s, 0, dict, map).value;
   }

   private R dfs(String s, int index, Set<String> dict, Map<Integer, R> map) {
      if (map.containsKey(index))
         return new R(map.get(index));
      if (index == s.length()) {
         return new R(0, "");
      }
      R min = new R(Integer.MAX_VALUE, "");
      for (int i = index; i < s.length(); i++) {
         R curr = new R(0, "");
         String word = s.substring(index, i + 1);
         R next = dfs(s, i + 1, dict, map);
         if (dict.contains(word)) {
            curr.value = word + " " + next.value;
            curr.invalidNum = next.invalidNum;
         } else {
            curr.value = word.toUpperCase() + " " + next.value;
            curr.invalidNum = word.length() + next.invalidNum;
         }
         min = min(curr, min);
      }
      map.put(index, min);
      return min;
   }

   private R min(R a, R b) {
      if (a == null)
         return b;
      if (b == null)
         return a;
      if (a.invalidNum < b.invalidNum)
         return a;
      else if (a.invalidNum > b.invalidNum)
         return b;
      else
         return a.value.length() < b.value.length() ? a : b;
   }

   private class R {
      int invalidNum;
      String value;

      public R(int invalidNum, String value) {
         this.invalidNum = invalidNum;
         this.value = value;
      }

      public R(R r) {
         this.invalidNum = r.invalidNum;
         this.value = r.value;
      }

      public String toString() {
         return invalidNum + " " + value;
      }
   }

   @Test
   public void test() {
      String str = "jesslookedjustliketimherbrother";
      // String str = "her";
      String[] ss = new String[] { "looked", "just", "like", "her", "brother" };
      Set<String> dict = new HashSet<String>(Arrays.asList(ss));
      System.out.println(findMinWordBreak(str, dict));
   }

}
