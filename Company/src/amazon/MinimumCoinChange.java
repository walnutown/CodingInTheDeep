package amazon;

import org.junit.Test;

public class MinimumCoinChange {

   /**
    * Find the minimum number of coins needed to make change
    * if there's no way to make change, return Integer.MAX_VALUE
    */

   /* Think why this dp works here, but not in CoinChange problem */

   // 2d DP, for each value, we find the minimum number of coins from all the possible combinations
   // time: O(m*n); space: O(m)
   public int minimumCoinChange(int[] A, int target) {
      if (A == null || A.length == 0)
         return 0;
      int[] dp = new int[target + 1];
      for (int i = 1; i <= target; i++) {
         int min = Integer.MAX_VALUE;
         for (int j = 0; j < A.length; j++) {
            if (i >= A[j])
               min = Math.min(min, dp[i - A[j]]);
         }
         dp[i] = min == Integer.MAX_VALUE ? min : min + 1;   // notice overflow here
      }
      return dp[target];
   }
   
   @Test
   public void test() {
      int[] A = new int[] { 2, 3, 5 };
      int target = 1;
      System.out.println(minimumCoinChange(A, target));
   }

}
