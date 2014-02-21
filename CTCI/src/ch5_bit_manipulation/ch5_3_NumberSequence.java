package ch5_bit_manipulation;

public class ch5_3_NumberSequence {

   /**
    * Given a positive integer, print the next smallest and the next largest number that have the
    * same number of 1 bits in their binary representation.
    */
   public static void main(String[] args) {
      int num = 3456;
      System.out.println(Integer.toBinaryString(num));
      System.out.println(Integer.toBinaryString(getNextNumber(num)));
      System.out.println(Integer.toBinaryString(getPrevNumber(num)));
   }

   /*
    * We have to flip a zero to a one and flip a one to a zero.
    * The number will be bigger if and only if the zero-to-one bit was to the left of the
    * one-to-zero bit
    * <1> find the rightmost non-trailing zero -- p
    * <2> flip p to one
    * <3> clear all bits following p
    * <4> reset bits 0 through c1-1 to 1 (c1 is the number of 1 through p to 0)
    */
   public static int getNextNumber(int num) {
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

   public static int getPrevNumber(int num) {
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
      num &= ((~0)<<(pos+1)); // Clear all bits from pos onwards
      int mask = (1 << (c1 + 1)) - 1; // Sequence of (c1+1) ones
      num |= (mask << (c0 - 1));  
      return num;
   }

   public static int getBit(int num, int i) {
      return (num & (1 << i)) > 0 ? 1 : 0;
   }

}
