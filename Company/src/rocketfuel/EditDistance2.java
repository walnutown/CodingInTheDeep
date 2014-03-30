package rocketfuel;

import org.junit.Test;

public class EditDistance2 {
   /*
    * Given two words word1 and word2, find the minimum number of steps required to convert word1 to
    * word2. (each operation is counted as 1 step.)
    * You have the following 3 operations permitted on a word:
    * a) Insert a character
    * b) Delete any number of continuous characters
    * c) Replace a character
    */

   // the difference with Leetcode/EditDistance is that continuous deletion is allowed

   // Get the min steps of deletion operation and then compare it with insertion and replace
   // operation
   // time: O(m*n*m); space: O(m*n)
   public int minDistance(String A, String B) {
      int M = A.length(), N = B.length();
      if (M == 0 || N == 0)
         return M == 0 ? N : M;
      int[][] dp = new int[M + 1][N + 1];
      for (int i = 0; i <= M; i++)
         dp[i][0] = i;
      for (int j = 0; j <= N; j++)
         dp[0][j] = j;
      for (int i = 1; i <= M; i++) {
         for (int j = 1; j <= N; j++) {
            if (A.charAt(i - 1) == B.charAt(j - 1)) {
               dp[i][j] = dp[i - 1][j - 1];
               continue;
            }
            int minDelete = Integer.MAX_VALUE;
            for (int k = i; k > 0; k--)
               minDelete = Math.min(dp[k - 1][j], minDelete);
            dp[i][j] = Math.min(Math.min(minDelete, dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
         }
      }
      return dp[M][N];
   }

   // optimize running time. We can remove the for loop to find the min deletion steps
   // time: O(m*n); space: O(m*n)
   public int minDistance2(String A, String B) {
      int M = A.length(), N = B.length();
      if (M == 0 || N == 0)
         return M == 0 ? N : M;
      int[][] dp = new int[M + 1][N + 1];
      for (int i = 0; i <= M; i++)
         dp[i][0] = i;
      for (int j = 0; j <= N; j++)
         dp[0][j] = j;
      for (int j = 1; j <= N; j++) {
         int minDelete = Integer.MAX_VALUE;
         for (int i = 1; i <= M; i++) {
            if (A.charAt(i - 1) == B.charAt(j - 1)) {
               dp[i][j] = dp[i - 1][j - 1];
               continue;
            }
            minDelete = Math.min(dp[i - 1][j], minDelete);
            dp[i][j] = Math.min(Math.min(minDelete, dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
         }
      }
      return dp[M][N];
   }

   @Test
   public void test() {
      String A = "sunday", B = "sa";
      System.out.println(minDistance(A, B));
      System.out.println(minDistance2(A, B));
   }

}
