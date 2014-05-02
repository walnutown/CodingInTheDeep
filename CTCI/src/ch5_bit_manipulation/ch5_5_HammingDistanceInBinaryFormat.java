package ch5_bit_manipulation;

import org.junit.Test;

public class ch5_5_HammingDistanceInBinaryFormat {

   /**
    * Calculate the number of bits that will need to be changed in order to convert an integer X
    * into another integer Y.
    */

   // Sol1:
   // count the edit distance digit by digit
   // time: O(32)
   public int bitConversion(int a, int b) {
      int count = 0;
      if (a == b)
         return 0;
      for (int i = 0; i < 32; i++) {
         int mask = 1 << i;
         if (((a & mask) > 0) != ((b & mask) > 0))
            count++;
      }
      return count;
   }

   // Sol2
   // get the C = A^B, then count the '1's in C 
   // time: O(k)
   public int bitConversion2(int a, int b) {
      int count = 0;
      int z = a ^ b;
      while (z != 0) {
         count += z & 1;
         z = z >> 1;
      }
      return count;
   }

   @Test
   public void test() {
      int a = 12, b = 16;
      System.out.println(Integer.toBinaryString(a));
      System.out.println(Integer.toBinaryString(b));
      System.out.println(bitConversion(a, b));
      System.out.println(bitConversion2(a, b));
   }

}
