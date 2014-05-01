package ch1_arrays_strings;

import org.junit.Test;

public class ch1_8_RotationString {

   /**
    * Assume you have a method isSubstring which checks if one word
    * is a substring of another. Given two strings, s1 and s2, write code
    * to check if s2 is a rotation of s1 using only one call to isSubstring
    * e.g. "erbottlewat" is a rotation of "waterbottle"
    */

   // The trick is that if one word A is a rotation of another one B, A should be
   // a substring of B+B.
   // time: O(n); space: O(n)
   public boolean isRotation(String s1, String s2) {
      if (s1 == null || s2 == null)
         return s1 == null && s2 == null;
      String s3 = s1 + s1;
      return isSubstring(s3, s2);
   }

   public boolean isSubstring(String s1, String s2) {
      for (int i = 0; i < s1.length() - s2.length(); i++) {
         int index = i;
         int j = 0;
         for (; j < s2.length(); j++) {
            if (s2.charAt(j) == s1.charAt(index))
               index++;
            else
               break;
         }
         if (j == s2.length())
            return true;
      }
      return false;
   }

   @Test
   public void test() {
      System.out.println(isRotation("abc", "bca"));
      System.out.println(isRotation("abc", "aca"));
   }

}
