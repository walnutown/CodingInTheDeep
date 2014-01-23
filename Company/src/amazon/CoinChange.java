package amazon;

public class CoinChange {

   /**
    * Given a set of coins [v1, v2,...vn], find the number of ways to make a change of a target sum
    *   all the values are positive integers
    *   sum is positive integer
    * Sol:
    *   same problem to leetcode - combinationSum. But different perspective.
    * Ref:
    *   http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
    */
   public static void main(String[] args) {
      int[] A = new int[]{1,2,3};
      int target = 4;
      System.out.println(coinChange(A, target));
      System.out.println(coinChange2(A, target));
      System.out.println(coinChange3(A, target));
      System.out.println(coinChange4(A, target));
      System.out.println(coinChange5(A, target));
   }
   // 1d DP, time: O(m*n); space: O(n)
   public static int coinChange(int[] A, int target){
      if (A==null || A.length ==0)  return 0;
      int[] dp = new int[target+1];
      dp[0] = 1;
      for (int i=0; i<A.length; i++){
         for (int j=A[i]; j<=target; j++)   // in next recursion, index should be no less than the previous one, to avoid duplicates
            dp[j] += dp[j-A[i]];
      }
      return dp[target];
   }
   /*-----------------------------------------------------------*/
   // Accepted
   public static int coinChange2(int[] A, int target){
      if (A==null || A.length ==0)  return 0;
      return makeChange(A, target, 0);
   }
   public static int makeChange(int[] A, int target, int index){
      if (target < 0) return 0;
      if (target == 0)  return 1;
      int count = 0;
      for (int i=index; i<A.length; i++){
         count += makeChange(A, target-A[i], i);    // in next recursion, index should be no less than the previous one, to avoid duplicates
      }
      return count;
   }
   /*-----------------------------------------------------------*/
   // this dp is wrong
   public static int coinChange3(int[] A, int target){
      if (A==null || A.length ==0)  return 0;
      int[] dp = new int[target+1];
      dp[0] = 1;
      for (int i=1; i<=target; i++){
         for (int j=0; j<A.length; j++){        // cannot avoid duplicates like 1+2=3, 2+1=3
            if (i >= A[j])  dp[i] += dp[i-A[j]];
         }
      }
      return dp[target];
   }
   
   /*-----------------------------------------------------------*/
   // Accepted
   public static int coinChange4(int[] A, int target){
      if (A==null || A.length ==0)  return 0;
      return makeChange4(A, A.length-1, target);
   }
   public static int makeChange4(int[] A, int index, int target){
      if (target<0) return 0;
      if (target==0)    return 1;
      if (index<0 && target>0)  return 0;
      // current coin type is included in the solution or not included
      return makeChange4(A, index-1, target) + makeChange4(A, index, target-A[index]);  
   }
   // Accepted
   public static int coinChange5(int[] A, int target){
      if (A==null || A.length ==0)  return 0;
      int[][] dp = new int[target+1][A.length];
      for (int i=0; i<A.length; i++)    dp[0][i] = 1;
      for (int i=1; i<=target; i++){
         for (int j=0; j<A.length; j++){
            // count solutions of include A[j]
            int x = i>=A[j]? dp[i-A[j]][j] : 0;
            // count solutions of exclude A[j]
            int y = j>=1? dp[i][j-1] : 0;
            dp[i][j] = x + y;
         }
      }
      return dp[target][A.length-1];
   }
   

}
