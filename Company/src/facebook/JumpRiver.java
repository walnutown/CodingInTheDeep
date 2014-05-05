package facebook;

import org.junit.Test;

public class JumpRiver {
   /**
    * Lets say there is a river that is η meters wide. At every meter from the starting shore, there
    * may or may not be a stone enough for frog to sit. Now a frog needs to cross the river. However
    * the frog has the limitation that if it has just jumped x meters, then it can take next jump
    * only of size x-1, x or x+1 meters. First jump can be of only 1 meter when starting from shore.
    * Assume frog can see all stone from this shore to opposite shore.
    * Determine whether the frog can cross the river.
    * @throws Exception 
    */

   // Sol1
   // Backtracking + memoization
   // time: O(2^n)
   
   // Sol2 
   // Dynamic Programming
   // dp[i][j]==true -- can jump to position i with speed j 
   // time: O(n^2); space: O(n^2)
   public boolean canJumpRiver(int[] A) throws Exception {
      if (A == null || A.length == 0)
         return true;
      int N = A.length;
      boolean[][] dp = new boolean[N][N+1];
      dp[0][1] = A[0]==1;
      for (int i=1; i<N; i++){
         for (int j=1; j<=N; j++){
            if (A[i]==0 || i<j)
               continue;
            if (dp[i-j][j] || dp[i-j][j-1] || (j+1<=N && dp[i-j][j+1])){
               dp[i][j] = true;
               if (i+j+1>=N)    // the last jump can reach the destination
                  return true;
            }
         }
      } 
      return false;
   }

   @Test
   public void test() throws Exception {
      int[] A = new int[] { 1, 0, 1, 0, 0, 1, 1 };
      int[] B = new int[] { 1, 0, 1, 0, 0, 0, 1 };
      System.out.println(canJumpRiver(A));
      System.out.println(canJumpRiver(B));
   }
}
