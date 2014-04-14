package google;

public class NumberOfValidParenthesis {
   
   public int getNumberOfValidParenthesis(int N){
      if (N==0)
         return 0;
      int[][] dp = new int[2*N+1][2*N+1];
      for (int i=1; i<=N; i++){
         for (int j=1; j<=N; j++){
            if (i-1>=j)
               dp[i][j] += dp[i-1][j];
            if (i>=j-1)
               dp[i][j] += dp[i][j-1];
         }
      }
   }
}
