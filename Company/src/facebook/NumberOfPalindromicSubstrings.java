package facebook;

import java.util.ArrayList;

import org.junit.Test;

public class NumberOfPalindromicSubstrings {
   
   /**
    * Write a function for retrieving the total number of substring palindromes.
    * For example the input is 'abba' then the possible palindromes= a, b, b, a, bb, abba
    * So the result is 6.
    */
   
   // refer to Leetcode/LongestPalindromicSubstring
   /*
    * Traverse each character, set it as the middle and stretch on both sides, if the substring
    * remains to be a palindrome, we store the palindrome and continue stretch, otherwise, break
    * There're two cases:
    * [1] the length of palindrome is odd
    * [2] the length of palindrome is even
    * time: O(n^2); space: O()
    */
   public ArrayList<String> getNumberOfSubstringPalindromes(String s){
      ArrayList<String> res = new ArrayList<String>();
      if (s==null || s.length()==0)
         return res;
      int N = s.length();
      for (int k=0; k<N; k++){ // odd length
         res.add(s.charAt(k)+""); // add single character
         int i=k-1, j=k+1;
         while (i>=0 && j<N && s.charAt(i)==s.charAt(j)){
            res.add(s.substring(i, j+1));
            i--; j++;
         }
      }
      for (int k=0; k<N; k++){ // even length
         int i=k, j=k+1;
         while (i>=0 && j<N && s.charAt(i)==s.charAt(j)){
            res.add(s.substring(i, j+1));
            i--; j++;
         }
      }
      return res;
   }
   
   @Test
   public void test(){
      String s = "abba";
      System.out.println(getNumberOfSubstringPalindromes(s).toString());
   }
}
