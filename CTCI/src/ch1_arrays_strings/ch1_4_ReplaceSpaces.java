package ch1_arrays_strings;

import org.junit.Test;

public class ch1_4_ReplaceSpaces {

   /**
    * Write a method to replace all spaces in a string with '%20'
    * You may assume that the string has sufficient space at the end of the string to hold
    * the additional characters, and that you are given the "true" length of the string
    * 
    */
   
   // Sol1, two pointers
   // Maintain a pointer A starting from the end of the string container,
   // another pointer B staring from the end of the actual string.
   // The key is that B is always in front of A
   // time: O(n); space: O(1)
   public void replaceWS(char[] str, int len) {
      int index = str.length - 1;
      for (int i = len - 1; i >= 0; i--) {
         if (str[i] != ' ')
            str[index--] = str[i];
         else {
            str[index] = '0';
            str[index - 1] = '2';
            str[index - 2] = '%';
            index -= 3;
         }
      }
      // there may be remaining chars at the head of str, depending on the str length
      if (index != -1) {
         int new_index = 0;
         for (int i = index + 1; i < str.length; i++) {
            str[new_index++] = str[i];
         }
         for (int i = new_index; i < str.length; i++) {
            str[new_index++] = '\u0000'; // '\u0000' is the default value of char
         }
      }
   }
   
   @Test
   public void test() {
      char[] str = new char[9];
      str[0] = 'a';
      str[1] = ' ';
      str[2] = 'b';
      System.out.println(str);
      replaceWS(str, 3);
      System.out.println(str);
   }
}
