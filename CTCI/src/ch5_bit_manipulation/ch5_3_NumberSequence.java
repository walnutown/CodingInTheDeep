package ch5_bit_manipulation;

import org.junit.Test;

public class ch5_3_NumberSequence {

   /**
    * Given a positive integer, print the next smallest and the previous largest number that have the
    * same number of '1' in their binary representation.
    */

   /*
    * We have to flip a zero to a one and flip a one to a zero.
    * The number will be bigger if and only if the zero-to-one bit was on the left of the
    * one-to-zero bit
    * <1> find the rightmost non-trailing zero -- p
    * <2> flip p to one
    * <3> clear all bits following p
    * <4> reset bits 0 through c1-1 to 1 (c1 is the number of 1 through p to 0)
    */
   public int getNextNumber(int num) {
      int c0 = 0, c1 = 0, i = 0;
      while (i < 32 && getBit(num, i) == 0) {
         c0++;
         i++;
      }
      while (i < 32 && getBit(num, i) == 1) {
         c1++;
         i++;
      }
      /*
       * If i is 32, then n is a sequence of 1s followed by a sequence of 0s, or a sequence of 0s.
       * This is already the biggest number with c1 ones. Return error.
       */
      if (i == 32)
         return -1;
      int pos = c0 + c1; // position of right-most non-trailing zero
      num |= (1 << pos); // Flip right-most non-trailing zero
      num &= ~((1 << pos) - 1); // Clear all bits to the right of pos
      num |= (1 << (c1 - 1)) - 1;
      return num;
   }

   // Basically the same as get next smallest
   // The number will be smaller if and only if the one-to-zero bit was on the left of zero-to-one bit
   // So, we have to flip the rightmost non-trailing one
   public int getPrevNumber(int num) {
      int c0 = 0, c1 = 0, i = 0;
      while (i < 32 && getBit(num, i) == 1) {
         c1++;
         i++;
      }
      while (i < 32 && getBit(num, i) == 0) {
         c0++;
         i++;
      }
      /*
       * If i is 32, then n is a sequence of 1s followed by a sequence of 0s, or a sequence of 1s.
       * This is already the biggest number with c1 ones. Return error.
       */
      if (i == 32)
         return -1;
      int pos = c0 + c1; // position of right-most non-trailing one
      num &= ~(1 << pos); // flip
      num |= ((1<<pos)-1); // Set all bits from pos onwards to 1
      num &= ~((1 << c0-1)-1);    // reset zeros
      return num;
   }

   private int getBit(int num, int i) {
      return (num >> i) & 1;
   }

   @Test
   public void test() {
      int num = 3456;
      System.out.println(Integer.toBinaryString(num));
      System.out.println(Integer.toBinaryString(getNextNumber(num)));
      System.out.println(Integer.toBinaryString(getPrevNumber(num)));
   }

}
