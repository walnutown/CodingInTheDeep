package google;

import java.util.HashMap;

import org.junit.Test;

public class AnagramSubstring {
   /*
    * Given String a and b, check if there's a substring in b that is an anagram of a
    * if there exist, return the substring, otherwise, return ""
    * eg,
    * input: a= "abc", b = "abbca"
    * output: bca
    */

   // Sliding Window
   // Maintain two tables, count occurrences of need characters and find characters
   // Maintain a variable to hold the total number of characters we've found so far
   // when number of find characters exceeds, adjust left border. 
   public String getAnagramSubstring(String a, String b) {
      if (a == null || b == null)
         return "";
      int M = a.length(), N = b.length();
      if (M > N)
         return "";
      int[] need = new int[256], find = new int[256];
      int i = 0, j = 0;
      for (; i < M; i++)
         need[(int) a.charAt(i)]++;
      i = 0;
      for (; i < N; i++) {
         int val = (int) b.charAt(i);
         if (find[val] < need[val])
            M--;
         find[val]++;
         if (find[val] > need[val]) {
            while (j <= i && b.charAt(j) != b.charAt(i)) {
               find[(int) b.charAt(j++)]--;
               M++;
            }
            find[val]--;
            j++;
         }
         if (M == 0)
            return b.substring(j, i + 1);
      }
      return "";
   }

   public static boolean anagram(String a, String b) {
      if (b.length() < a.length())
         return false;
      HashMap<Character, Integer> map = new HashMap<Character, Integer>();
      for (int i = 0; i < a.length(); i++) {
         if (!map.containsKey(a.charAt(i)))
            map.put(a.charAt(i), 1);
         else
            map.put(a.charAt(i), map.get(a.charAt(i)) + 1);
      }
      for (int i = 0; i <= b.length() - a.length(); i++) {
         if (map.containsKey(b.charAt(i))) {
            char c = b.charAt(i);
            HashMap<Character, Integer> cur = (HashMap<Character, Integer>) map.clone();
            HashMap<Character, Integer> mark = new HashMap<Character, Integer>();
            int j = i;
            while (true) {
               if (!cur.containsKey(c))
                  break;
               else {
                  if (!mark.containsKey(c))
                     mark.put(c, j);
                  if (cur.get(c) > 1)
                     cur.put(c, cur.get(c) - 1);
                  else
                     cur.remove(c);
               }
               if (cur.isEmpty())
                  return true;
               j++;
               c = b.charAt(j);
            }
            if (map.containsKey(c))
               i = mark.get(c);
            else
               i = j;
         }
      }
      return false;
   }

   @Test
   public void test() {
      String a = "abc", b = "adcba";
      String a1 = "abbc", b1 = "aeaabbcdd";
      System.out.println(getAnagramSubstring(a, b));
      System.out.println(getAnagramSubstring(a1, b1));
      System.out.println(anagram(a, b));
   }
}
