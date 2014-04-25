package amazon;

import org.junit.Test;

public class CoinChange {

   /**
    * Given a set of coins [v1, v2,...vn], find the number of ways to make a change of a target sum
    * all the values are positive integers
    * sum is positive integer
    * Sol:
    * same problem to leetcode - combinationSum. But different perspective.
    * Ref:
    * http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
    */

   // Sol2
   // Recursion
   // In each step, we consider two cases, include the coin value or not
   // time: O(2^n)
   public int coinChange2(int[] A, int target) {
      if (A == null || A.length == 0)
         return 0;
      return makeChange2(A, A.length - 1, target);
   }

   public int makeChange2(int[] A, int index, int target) {
      if (target < 0)
         return 0;
      if (target == 0)
         return 1;
      if (index < 0 && target > 0)
         return 0;
      // current coin type is included in the solution or not included
      return makeChange2(A, index - 1, target) + makeChange2(A, index, target - A[index]);
   }

   // Sol3 -- This solution is Wrong. Written down here for reference.
   // It's easy to come up with the following dp, yet it's WRONG
   // To get dp[i] in this solution, we traverse the coin set to find coin of value j that can be
   // deducted from i. This solution doesn't consider the order of values.
   // Thus, there may be duplicate combinations.
   public int coinChange3(int[] A, int target) {
      if (A == null || A.length == 0)
         return 0;
      int[] dp = new int[target + 1];
      dp[0] = 1;
      for (int i = 1; i <= target; i++) {
         for (int j = 0; j < A.length; j++) {        // cannot avoid duplicates like 1+2=3, 2+1=3
            if (i >= A[j])
               dp[i] += dp[i - A[j]];
         }
      }
      return dp[target];
   }

   // Sol4
   // DP
   // time: O(m*n); space: O(m*n)
   public int coinChange4(int[] A, int target) {
      if (A == null || A.length == 0)
         return 0;
      int N = A.length;
      int[][] dp = new int[target + 1][N];
      for (int i = 0; i < N; i++)
         dp[0][i] = 1;
      for (int i = 1; i <= target; i++) {
         for (int j = 0; j < N; j++) {
            // count solutions containing A[j]
            int x = i >= A[j] ? dp[i - A[j]][j] : 0;
            // count solutions not containing A[j]
            int y = j >= 1 ? dp[i][j - 1] : 0;
            dp[i][j] = x + y;
         }
      }
      return dp[target][N - 1];
   }
   
   // Sol5
   // space optimized DP
   // time: O(m*n); space: O(n)
   public int coinChange5(int[] A, int target) {
      if (A == null || A.length == 0)
         return 0;
      int[] dp = new int[target + 1];
      dp[0] = 1;
      for (int i = 0; i < A.length; i++) {
         for (int j = 1; j <= target; j++) {
            // dp[j], not include A[i]; dp[j-A[i]], include A[i]
            int x = dp[j];
            int y = j>=A[i]? dp[j-A[i]]:0;
            dp[j] = x + y;
         }
      }
      return dp[target];
   }

   @Test
   public void test() {
      int[] A = new int[] { 1, 2, 3 };
      int target = 4;
      System.out.println(coinChange2(A, target));
      System.out.println(coinChange3(A, target));
      System.out.println(coinChange4(A, target));
      System.out.println(coinChange5(A, target));
   }

}
