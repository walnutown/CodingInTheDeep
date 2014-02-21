package ch5_bit_manipulation;

public class ch5_1_InsertBitRange {

   /**
    * You're given two 32-bit numbers, N and M, and two bit positions, i and j.
    * Write a method to insert M into N such that M starts at bit j and ends at bit i.
    * You can assume that the bits j through i have enough space to fit all of M.
    * That is, if M=10011, you can assume that there are at least 5 bits between
    * j and i.
    * 
    * EXAMPLE:
    * input: N = 100000000, M = 10011, i=2, j=6
    * output: N = 101001100
    */
   public static void main(String[] args) {
      int M = 3, N = 100;
      int i = 3, j = 5;
      System.out.println("M: "+ Integer.toBinaryString(M));
      System.out.println("N: "+ Integer.toBinaryString(N));
      System.out.println(Integer.toBinaryString(insertBitRange(M, N, i, j)));

   }

   public static int insertBitRange(int M, int N, int i, int j) {
      N = clearBitRange2(N, i, j);
      return N | (M << i);
   }

   public static int clearBitRange(int N, int i, int j) {
      while (i <= j) {
         N = N & ~(1 << i);
         i++;
      }
      return N;
   }
   
   public static int clearBitRange2(int N, int i, int j){
      int allOnes = ~0;
      int left = allOnes << (j+1);
      int right = ((1<<i) - 1);
      int mask = left | right;
      return N & mask;
   }
   
   

}
