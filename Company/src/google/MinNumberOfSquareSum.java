package google;

import java.util.Arrays;

import org.junit.Test;

public class MinNumberOfSquareSum {
   /*
    * Given an interger, find the minNum of square expression of an integer
    * eg,
    * input: 14  (14 = 1 + 4 + 9)
    * output: minNum = 3
    */
   
   // Dynamic Programming
   // similar to coinChange
   // time: O(n^2); space: O(n)
   public int getMinNumber(int N){
      int[] dp = new int[N+1];
      Arrays.fill(dp, Integer.MAX_VALUE);
      dp[0] = 0;
      for (int i=1; i<=N; i++){
         for (int j = (int)Math.sqrt(i); j>=1; j--){
               dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
         }
      }
      return dp[N];
   }
   
   @Test
   public void test(){
      for (int i=0; i<=14; i++)
         System.out.println(i +": " + getMinNumber(i));
   }
}
