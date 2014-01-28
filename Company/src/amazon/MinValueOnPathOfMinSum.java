package amazon;

import java.util.Arrays;

public class MinValueOnPathOfMinSum {

   /**
    * Given a board, find the min element on the path with min sum 
    */
   public static void main(String[] args) {
      int[][] grid = new int[][]{
            {10,2,3},
            {4,100,6},
            {1,6,9}
      };
      System.out.println(getMin(grid));
   }
   
   public static int getMin(int[][] grid){
      int m=grid.length, n=grid[0].length;
      if (m==0 || n==0) return 0;
      int[][] min = new int[m][n];
      int[][] dp = new int[m][n];
      dp[0][0] = grid[0][0]; min[0][0] = grid[0][0];
      for (int i=1; i<m; i++){
         dp[i][0] = dp[i-1][0] + grid[i][0];
         min[i][0] = Math.min(grid[i][0], min[i-1][0]);
      }
      for (int j=1; j<n; j++){
         dp[0][j] = dp[0][j-1] + grid[0][j];
         min[0][j] = Math.min(grid[0][j], min[0][j-1]);
      }
      for (int i=1; i<m; i++){
         for (int j=1; j<n; j++){
            dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            if (dp[i-1][j] == dp[i][j-1])
               min[i][j] = Math.min(min[i-1][j], min[i][j-1]);
            else
               min[i][j] = dp[i-1][j]<dp[i][j-1]? min[i-1][j]:min[i][j-1];
            min[i][j] = Math.min(min[i][j], grid[i][j]);
         }
      }
      return min[m-1][n-1];
   }
}
