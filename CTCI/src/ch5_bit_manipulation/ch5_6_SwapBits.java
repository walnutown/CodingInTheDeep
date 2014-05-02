package ch5_bit_manipulation;

import org.junit.Test;

public class ch5_6_SwapBits {

   /**
    * Write a program to swap odd and even bits in an integer with as few instructions as possible
    */

   /* Use mask number to get the odd bits and even bits, shift them to get new odd bits and even bits
    * <1> get all odd bits and right-shift by 1
    * <2> get all even bits and left-shift by 1
    * <3> a: 1010; 5:0101
    */
   public int swapBits(int num) {
      return ((num & 0xaaaaaaaa) >> 1) | ((num & 0x55555555) << 1);
   }

   @Test
   public void test() {
      int num = 345;
      System.out.println(Integer.toBinaryString(num));
      System.out.println(Integer.toBinaryString(swapBits(num)));
   }

}
