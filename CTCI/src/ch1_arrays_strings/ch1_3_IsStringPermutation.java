package ch1_arrays_strings;

import java.util.Arrays;

import org.junit.Test;

public class ch1_3_IsStringPermutation {

   /**
    * Given two strings, write a method to decide if one is a permutation of the other
    */

   // Sol1
   // Count occurrence of each character in two words and compare
   // time: O(n); space: O(n)
   public boolean isPermutation(String a, String b) {
      if (a == null || b == null)
         return a == null && b == null;
      if (a.length() != b.length())
         return false;
      int[] freq = new int[256];    // assume we only have charset of ISO8859 or 2^8 unicode
      for (int i = 0; i < a.length(); i++) {
         freq[a.charAt(i)]++;
      }
      for (int i = 0; i < b.length(); i++) {
         freq[b.charAt(i)]--;
      }
      for (int f : freq) {
         if (f != 0)
            return false;
      }
      return true;
   }

   // Sol2
   // Sort two words and compare
   // time: O(nlgn), space: O(1)
   public boolean isPermutation2(String a, String b) {
      if (a == null || b == null)
         return a == null && b == null;
      if (a.length() != b.length())
         return false;
      char[] A = a.toCharArray();
      char[] B = b.toCharArray();
      Arrays.sort(A);
      Arrays.sort(B);
      for (int i = 0; i < A.length; i++) {
         if (A[i] != B[i])
            return false;
      }
      return true;
   }

   @Test
   public void test() {
      System.out.println(isPermutation("abc", "bacd"));
      System.out.println(isPermutation2("abc", "cba"));
   }

}
