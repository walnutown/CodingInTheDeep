package yahoo;

import java.util.Arrays;

import org.junit.Test;

public class ImplementStrstr2 {

   /**
    * Given two words, determine if the first word, or any anagram of it, appears in consecutive
    * characters of the second word. For instance, 'tea' appears as an anagram in the last three
    * letters of 'slate', but 'let' does not appear as an anagram in 'slate' even though all the
    * letters of let appear in 'slate'.
    * Return the anagram of the first word that has appeared in the second word.
    * Sample Input 1
    * tea
    * slate
    * Sample Output1
    * ate
    * Sample Input 2
    * let
    * slate
    * Sample Output2
    * NONE
    */
   // The question can be simplified as to find a substring that is anagram of the given string
   public String getSubstring(String S, String T) {
      int M = S.length(), N = T.length();
      if (M < N)
         return "";
      int[] need = new int[256], find = new int[256];
      for (int i = 0; i < N; i++) {
         need[T.charAt(i)]++;
      }
      int i = 0, j = 0, count = N;
      for (; j < M; j++) {
         char ch = S.charAt(j);
         if (need[ch] == 0) {
            i = j + 1;
            count = N;
            Arrays.fill(find, 0);
            continue;
         }
         find[ch]++;
         count--;
         while (i < j && find[ch] > need[ch]) {
            find[S.charAt(i)]--;
            i++;
            count++;
         }
         if (count == 0) {
            return S.substring(i, j + 1);
         }
      }
      return "";
   }
   
   @Test
   public void test(){
      String S = "slatet";
      String T1 = "ttea", T2 = "let";
      System.out.println(getSubstring(S, T1));
      System.out.println(getSubstring(S, T2));
   }

}
