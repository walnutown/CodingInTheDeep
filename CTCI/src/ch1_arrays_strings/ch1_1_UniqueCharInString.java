package ch1_arrays_strings;

import java.util.Arrays;

import org.junit.Test;

public class ch1_1_UniqueCharInString {

   /**
    * Implement an algorithm to determine if a string has all unique characters.
    * What if you cannot use additional data structure
    */

   // Sol1
   // The naive solution is to traverse each element, and for each element, find if there's
   // duplicate in the remaining substring
   // time: O(n^2); space: O(1)

   // Sol2
   // sort and then traverse
   // time: O(nlgn); space: O(1)
   public boolean isUnique2(String str) {
      char[] ch_arr = str.toCharArray();
      Arrays.sort(ch_arr);
      for (int i = 0; i < ch_arr.length - 1; i++) {
         if (ch_arr[i] == ch_arr[i + 1])
            return false;
      }
      return true;
   }

   // Sol3
   // use extra space to mark the appeared character
   // decide whether it's unicode character or ASCII character
   // ASCII: 128; ISO8859: 256, Unicode : 2^8, 2^16, 2^32
   // time: O(n); space: O(n)
   public boolean isUnique3(String str) {
      boolean[] set = new boolean[256];
      if (str.length() > 256)       // if the length is too long to have more than 256 characters
         return false;
      for (int i = 0; i < str.length(); i++) {
         if (set[str.charAt(i)] == true)
            return false;
         else
            set[str.charAt(i)] = true;
      }
      return true;
   }

   // Sol4, same idea as Sol3
   // the difference lies in that here we use bit vector to save more space
   // if the string only uses the lower case letter a through z, we can use only one integer
   // time: O(n); space: O(k), k = n/32;
   public boolean isUnique4(String str) {
      int checker = 0;
      for (int i = 0; i < str.length(); i++) {
         int val = str.charAt(i) - 'a';
         if ((checker & (1 << val)) > 0)
            return false;
         checker |= (1 << val);
      }
      return true;
   }

   @Test
   public void test() {
      System.out.println(isUnique2("abca"));
      System.out.println(isUnique3("abca"));
      System.out.println(isUnique4("abca"));
   }

}
