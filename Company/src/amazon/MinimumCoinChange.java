package amazon;

public class MinimumCoinChange {

   /**
    * Find the minimum number of coins needed to make change
    * if no way to make change, return Integer.MAX_VALUE
    */
   public static void main(String[] args) {
      int[] A= new int[]{2,3,5};
      int target = 9;
      System.out.println(minimumCoinChange(A, target));
   }
   
   public static int minimumCoinChange(int[] A, int target){
      if (A==null || A.length==0)   return 0;
      int[] dp = new int[target+1];
      dp[0] = 0;
      for (int i=1; i<=target; i++){
         int min = Integer.MAX_VALUE;
         for (int j=0; j<A.length; j++){
            if (i >= A[j] && dp[i-A[j]]>=0)  min = Math.min(min, dp[i-A[j]]);
         }
         dp[i] = min == Integer.MAX_VALUE ? min : min+1;;   // notice overflow here
      }
      return dp[target];
   }

}
