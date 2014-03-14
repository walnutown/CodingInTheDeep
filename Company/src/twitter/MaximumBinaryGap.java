package twitter;

import org.junit.Test;

public class MaximumBinaryGap {
   /*
    * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is
    * surrounded by ones at both ends in the binary representation of N.
    * For example, number 9 has binary representation 1001 and contains a binary gap of length 2.
    * The number 529 has binary representation 1000010001) and contains two binary gaps: one of
    * length 4 and one of length 3. The number 20 has binary representation 10100 and contains one
    * binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps.
    * Write a function:
    * class Solution { int binary_gap(int N); }
    * that, given a positive integer N, returns the length of its longest binary gap. The function
    * should return 0 if N doesn't contain a binary gap.
    * For example, given N = 1041 the function should return 5, because N has binary representation
    * 10000010001 and so its longest binary gap is of length 5.
    * Assume that:
    * N is an integer within the range [1..2,147,483,647].
    * Complexity:
    * expected worst-case time complexity is O(log(N));
    * expected worst-case space complexity is O(1).
    */
   
   // It's trivial to write a solution with O(32) worst case, the question is how to get the O(lgN) worst case?
   // Note the condition (N>0) and N>>=1, they ensure the O(lgN) worst case
   public int getMaxBinaryGap(int N){
      while (N>0 && (N&1)==0){
         N >>=1;   
      }
      if ((N&1)==0) // all 0s
         return 0;
      int max = 0, count = 0;
      while (N>0){        
         if ((N&1)==1)
            count=0;
         else
            count++;
         max = Math.max(count, max);
         N >>=1;
      }
      return max;
   }
   
   @Test
   public void testMaxBinaryGap(){
      for (int i=0; i<1042; i++){
         System.out.println(Integer.toBinaryString(i));
         System.out.println(getMaxBinaryGap(i));
      }
   }
}
