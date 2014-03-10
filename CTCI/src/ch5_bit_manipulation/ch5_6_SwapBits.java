package ch5_bit_manipulation;

public class ch5_6_SwapBits {

   /**
    * Write a program to swap odd and even bits in an integer with as few instructions as possible
    */
   public static void main(String[] args) {
      int num = 345;
      System.out.println(Integer.toBinaryString(num));
      System.out.println(Integer.toBinaryString(swapBits(num)));
   }

   /*
    * <1> get all odd bits and right-shift by 1
    * <2> get all even bits and left-shift by 1
    * <3> a: 1010; 5:0101
    */
   public static int swapBits(int num) {
      return ((num & 0xaaaaaaaa) >> 1) | ((num & 0x55555555) << 1);
   }

}
