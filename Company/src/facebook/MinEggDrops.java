package facebook;

import org.junit.Test;

public class MinEggDrops {

   /**
    * Given k eggs and n floors, find the minimum number of drops that are needed to
    * find the critical floor in worst case.
    */

   // Refer to CTCI/ch6/MinimumDrops
   // [1] If the egg breaks after dropping from xth floor, then we only need to check for floors lower
   // than x with remaining eggs; so the problem reduces to x-1 floors and k-1 eggs
   // [2] If the egg doesn’t break after dropping from the xth floor, then we only need to check for
   // floors higher than x; so the problem reduces to n-x floors and k eggs.
   // time: O(k*n*n); space: O(k*n)
   public int getMinDrops(int k, int n) {
      if (k == 1)
         return n;
      if (n <= 1)
         return n;
      int[][] dp = new int[k + 1][n + 1];
      for (int i = 1; i <= n; i++)
         dp[1][i] = i;
      for (int i = 1; i <= k; i++)
         dp[i][1] = 1;
      for (int i = 2; i <= k; i++) {
         for (int j = 2; j <= n; j++) {
            dp[i][j] = j;
            for (int x = 1; x <= j; x++) { // Choose the floor of previous drop      
               int count = 1+ Math.max(dp[i-1][x-1], dp[i][j-x]); // we need the worst case
               dp[i][j] = Math.min(dp[i][j], count);
            }
         }
      }
      return dp[k][n];
   }
   
   @Test
   public void test(){
      int k = 2, n = 100;
      System.out.println(getMinDrops(k, n));
   }
}
