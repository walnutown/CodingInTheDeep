package linkedin;

import java.util.PriorityQueue;

public class PaintHouse {

   /**
    * Minimize the cost of painting K houses, each house has different
    * costs to paint in different colors, 2 houses (next to each other)
    * cannot be painted in the same color
    */
   public static void main(String[] args) {
      int[][] costs = new int[][] { 
            { 3, 2, 1 }, 
            { 3, 5, 1 }, 
            { 3, 2, 1 }
      };
      System.out.println(paintHouse(costs));
   }

   // costs[0][2] =1, house#0 takes 1 unit to paint color#2
   // costs[1][2] =2, house#1 takes 2 unit to paint color#2
   // time: O(m * n^2), m is the number of houses, n is the number of colors
   public static int paintHouse(int[][] costs) {
      int color = costs[0].length, house=costs.length;
      int[][] dp = new int[house][color];
      for (int i=0; i<color; i++)   dp[0][i] = costs[0][i];
      for (int i=1; i<house; i++){
         for (int j=0; j<color; j++){
            int min = Integer.MAX_VALUE;
            for (int k=0; k<color; k++){
               if (k==j) continue;
               min = Math.min(min, dp[i-1][k]+costs[i][j]);
            }
            dp[i][j] = min;
         }
      }
      int res = Integer.MAX_VALUE;
      for (int i=0; i<color; i++)
         res = Math.min(res, dp[house-1][i]);
      return res;
   }
   // O(m*n)
   // sort first to get the min cost of colors at each house
   // then dp
   
}
