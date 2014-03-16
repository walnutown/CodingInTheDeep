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

   public String findMinWordBreak(String str, Set<String> dict) {
      if (str == null || str.length() == 0)
         return "";
      Map<Integer, R> map = new HashMap<Integer, R>();
      return finder(str, dict, 0, 0, map).value;
   }

   /**
    * choose to break or not break at each character
    * @param map stores the min-break of str.substring(start)
    * @param start/end marks a single word
    */
   public R finder(String str, Set<String> dict, int start, int end, Map<Integer, R> map) {
      if (end == str.length()) // this termination state is IMPORTANT
         return new R(end - start, str.substring(start).toUpperCase());
      if (map.containsKey(start))
         return map.get(start);
      String word = str.substring(start, end + 1);
      // break at the end of the word
      R brek = new R(finder(str, dict, end + 1, end + 1, map));
      if (!dict.contains(word)) {
         brek.invalidNum += word.length();
         brek.value = word.toUpperCase() + " " + brek.value;
      } else
         brek.value = word + " " + brek.value;
      // not break at the end of the word
      R noBrek = finder(str, dict, start, end + 1, map);
      R min = min(brek, noBrek);
      map.put(start, min);
      return min;
   }

   public R min(R a, R b) {
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

   public class R {
      int invalidNum;
      String value;

      public R(int invalidNum) {
         this.invalidNum = invalidNum;
         value = "";
      }

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
