package ch1_arrays_strings;

import java.util.Arrays;

public class ch1_3 {

   /**
    * Given two strings, write a method to decide if one is a permutation of the other
    */
   public static void main(String[] args) {
      System.out.println(isPermutation("abc", "bacd"));
      System.out.println(isPermutation_inPlace("abc", "cba"));
   }
   // O(n)
   public static boolean isPermutation(String a, String b){
      if (a == null || b == null)
         return a == null && b == null;
      if (a.length() != b.length())
         return false;
      int[] freq = new int[256];
      for (int i = 0; i < a.length(); i++){
         freq[a.charAt(i)]++;
      }
      for (int i = 0; i < b.length(); i++){
         freq[b.charAt(i)]--;
      }
      for (int f : freq){
         if (f != 0)
            return false;
      }
      return true;
   }
   // O(nlgn)
   public static boolean isPermutation_inPlace(String a, String b){
      if (a == null || b == null)
         return a == null && b == null;
      if (a.length() != b.length())
         return false;
      char[] a_arr = a.toCharArray();
      char[] b_arr = b.toCharArray();
      Arrays.sort(a_arr);
      Arrays.sort(b_arr);
      for (int i = 0; i < a_arr.length; i++){
         if (a_arr[i] != b_arr[i])
            return false;
      }
      return true;
   }

}
