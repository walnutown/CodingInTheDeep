package ch7_math_probability;

import org.junit.Test;

public class BaseConversion {
   /**
    * Base conversion between base2 and base10.
    * Base2 is given as a string
    */

   // time: O(n); space:O(1), n is length of s
   public int convert2To10(String s) {
      long res = 0; // in case of overflow
      char[] ss = s.toCharArray();
      int pos = 0;
      for (int i = ss.length - 1; i >= 0; i--) {
         if (ss[i] == '1')
            res += Math.pow(2, pos);
         pos++;
      }
      return (int) res;
   }

   // time: O(lgN); space: O(lgN), N is the value of base10 number
   public String convert10To2(int num) {
      StringBuilder sb = new StringBuilder();
      while (num > 0) {
         sb.append(num % 2);
         num /= 2;
      }
      return sb.reverse().toString();
   }

   @Test
   public void test() {
      for (int i = 0; i < 100; i++) {
         String binary = Integer.toBinaryString(i);
         System.out.println(binary + ": " + convert10To2(i));
         System.out.println(i + ": " + convert2To10(binary));
         System.out.println();
      }
   }
}
