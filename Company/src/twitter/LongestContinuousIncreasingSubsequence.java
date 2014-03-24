package twitter;

import org.junit.Test;

public class LongestContinuousIncreasingSubsequence {
   /*
    * Find the length of the longest increasing subsequence in an array of integers.
    * This subsequence should be contiguous.
    */
   
   // traverse the array and update the max length
   // time: O(n); space: O(1)
   public int findLISContinuous(int[] A) {
      if (A == null || A.length == 0)
         return 0;
      int len = 1, max = Integer.MIN_VALUE;
      for (int i = 1; i < A.length; i++) {
         if (A[i] > A[i - 1]) {
            len++;
            max = Math.max(max, len);
         } else
            len = 0;
      }
      return max;
   }

   @Test
   public void test(){
      int[] A = new int[]{ 1, -2, 3, 5, 6, 8 };
      System.out.println(findLISContinuous(A));
   }
}
