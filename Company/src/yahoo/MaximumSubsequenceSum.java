package yahoo;

import org.junit.Test;

public class MaximumSubsequenceSum {
   /**
    * Given a sequence of numbers A(1) ..A(n), find the continuous subsequenceA(i)..A(j) for which
    * the sum of elements is maximum.
    * 
    * condition: we should not select two contiguous numbers
    */

   // This is a variant of Leetcode/MaximumSubarray

   // Dynamic Programming.
   // dp[i] -- the max sum of subsequence ending at A[i]
   // The recursive function is dp[i] = Max(A[i], dp[i-2]+A[i], dp[i-3]+A[i])
   // time: O(n); space: O(n)
   public int getMax(int[] A) {
      if (A == null || A.length == 0)
         return 0;
      int N = A.length, max = Integer.MIN_VALUE;
      int[] dp = new int[N];
      for (int i = 0; i < N; i++) {
         dp[i] = A[i];
         if (i - 2 >= 0)
            dp[i] = Math.max(dp[i], dp[i - 2] + A[i]);
         if (i - 3 >= 0)
            dp[i] = Math.max(dp[i], dp[i - 3] + A[i]);
         max = Math.max(max, dp[i]);
      }
      return max;
   }

   @Test
   public void test() {
      int[] A = new int[] { 1, 3, 5, -1, 12, 6, 7, 11 };
      System.out.println(getMax(new int[] { 1 }));
      System.out.println(getMax(new int[] { 1, 2 }));
      System.out.println(getMax(new int[] { 1, -4, 2 }));
      System.out.println(getMax(new int[] { -4, -5, -3, -9, -4 }));
      System.out.println(getMax(A));
   }
}
