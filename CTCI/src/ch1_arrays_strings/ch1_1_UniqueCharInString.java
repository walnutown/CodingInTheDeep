package ch1_arrays_strings;

import java.util.Arrays;

public class ch1_1_UniqueCharInString {

   /**
    * Implement an algorithm to determine if a string has all unique characters.
    * What if you cannot use additional data structure
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      System.out.println(isUnique_inPlace("abca"));
      System.out.println(isUnique_oneRun("abca"));
      System.out.println(isUnique_constSpace("abca"));
   }
   // O(nlgn)
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
   // ASCII: 128; ISO8859: 256, Unicode : 2^8, 2^16, 2^32 
   public static boolean isUnique_oneRun(String str){
      boolean[] char_set = new boolean[256];
      if (str.length() > 256)   return false;
      for (int i = 0; i < str.length(); i++){
         if (char_set[str.charAt(i)] == true)
            return false;
         else
            char_set[str.charAt(i)] = true;
      }
      return true;
   }
   
   // use bit vector, only support 32bit (or we can use long for 64bit)
   // the string only uses the lower case letter a through z 
   public static boolean isUnique_constSpace(String str){
      int checker = 0;
      for (int i = 0; i < str.length(); i++){
         int val = str.charAt(i) - 'a';
         if ((checker & (1<<val)) > 0)
            return false;
         checker |= (1<< val);
      }
      return true;
   }

}
