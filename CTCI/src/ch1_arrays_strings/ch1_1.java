package ch1_arrays_strings;

import java.util.Arrays;

public class ch1_1 {

   /**
    * Implement an algorithm to determine if a string has all unique characters.
    * What if you cannot use additional data structure
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      System.out.println(isUnique_inPlace("abc"));
      System.out.println(isUnique_oneRun("abc"));
   }
   // O(lgn)
   public static boolean isUnique_inPlace(String str){
      char[] ch_arr = str.toCharArray();
      Arrays.sort(ch_arr);
      for (int i = 0; i < ch_arr.length-1; i++){
         if (ch_arr[i] == ch_arr[i+1])
            return false;
      }
      return true;
   }
   // decide whether it's unicode character or ASCII character
   public static boolean isUnique_oneRun(String str){
      boolean[] char_set = new boolean[256];
      if (str.length() > 256)   return false;
      for (int i = 0; i < str.length(); i++){
         if (char_set[str.charAt(i)] == true)
            return false;
         else
            char_set[str.charAt(i)] = false;
      }
      return true;
   }

}
