package twitter;

import org.junit.Test;

public class EquilibriumIndexOfMatrix {
   /*
    * A non-empty zero-indexed matrix A consisting of N rows and M columns of integers is given. A
    * pair (P, Q) is called an
    * equilibrium point of matrix A if the following conditions are met:
    * - 0 <= P < N;
    * - 0 <= Q < M;
    * - the sum of elements in rows above the P-th row is equal to the sum of elements in rows below
    * the P-th row;
    * - the sum of elements in columns to the left of the Q-th column is equal to the sum of
    * elements in columns to the right of the Q-th column.
    * The sum of zero elements is assumed to be 0. This is the case when P = 0 or P = N - 1 and/or
    * when Q = 0 or Q = M
    * For example, consider matrix A consisting of five rows and three columns, such that:
    * A[0][0] = 2 A[0][1] = 7 A[0][2] = 5
    * A[1][0] = 3 A[1][1] = 1 A[1][2] = 1
    * A[2][0] = 2 A[2][1] = 1 A[2][2] = -7
    * A[3][0] = 0 A[3][1] = 2 A[3][2] = 1
    * A[4][0] = 1 A[4][1] = 6 A[4][2] = 8
    * Pair (1, 1) is an equilibrium point of matrix A, because:
    * - the sum of elements in the 0th row is equal to the sum of elements in the 2nd, 3rd and 4th
    * rows (the sum of both regions is 14);
    * - the sum of elements in the 0th column is equal to the sum of elements in the 2nd column (the
    * sum of both
    * regions is 8).
    * Pair (3, 1) is another equilibrium point of matrix A. This matrix contains no other
    * equilibrium points.
    * Write a function 
    * int matrix_equilibrium(NSMutableArray *A);
    * that, given a zero-indexed matrix A consisting of N rows and M columns of integers, returns
    * the number of equilibrium points of matrix A.
    * For example, given matrix A consisting of five rows and three columns such that:
    * A[0][0] = 2 A[0][1] = 7 A[0][2] = 5
    * A[1][0] = 3 A[1][1] = 1 A[1][2] = 1
    * A[2][0] = 2 A[2][1] = 1 A[2][2] = -7
    * A[3][0] = 0 A[3][1] = 2 A[3][2] = 1
    * A[4][0] = 1 A[4][1] = 6 A[4][2] = 8
    * the function should return 2, as explained above.
    * Assume that:
    * - N is an integer within the range [1..1,000,000];
    * - M is an integer within the range [1..1,000,000];
    * - the number of elements in matrix A is within the range [1..100,000,000];
    * - each element of matrix A is an integer within the range [-2,147,483,648.2,147,483,647].
    * Complexity:
    * - expected worst-case time complexity is O(N*M);
    * - expected worst-case space complexity is O(N+M).
    */
   
   public int equilibriumIndexOfMatrix(int[][] matrix){
      if (matrix.length==0 || matrix[0].length==0)
         return 0;
      int M = matrix.length, N=matrix[0].length;
      int count = 0;
      int[] rowSum = new int[M], colSum = new int[N];
      int totalSum = 0;
      for (int i=0; i<M; i++){
         for (int j=0; j<N; j++){
            rowSum[i] += matrix[i][j];
            colSum[j] += matrix[i][j];
            totalSum += matrix[i][j];
         }
      }
      for (int i=1; i<M; i++)
         rowSum[i] += rowSum[i-1];
      for (int j=1; j<N; j++)
         colSum[j] += colSum[j-1];
      for (int i=0; i<M; i++){
         for (int j=0; j<N; j++){
            int left = j>0 ? colSum[j-1]: 0, right = totalSum-colSum[j];
            int upper = i>0 ? rowSum[i-1]:0, below = totalSum-rowSum[i];
            if (isEquilibrium(left, right, upper, below))
               count++;
         }
      }
      return count;
   }
    
   // This solution wrongly understand the question
   public int equilibriumIndexOfMatrix2(int[][] matrix){
      if (matrix.length==0 || matrix[0].length==0)
         return 0;
      int M = matrix.length, N=matrix[0].length;
      int count = 0;
      int[] rowTotalSum = new int[M], colTotalSum = new int[N];
      for (int i=0; i<M; i++){
         for (int j=0; j<N; j++){
            rowTotalSum[i] += matrix[i][j];
            colTotalSum[j] += matrix[i][j];
         }
      }
      int[] rowLeftSum = new int[M], colUpperSum = new int[N];
      for (int i=0; i<M; i++){
         for (int j=0; j<N; j++){
            int val = matrix[i][j];
            int left = rowLeftSum[i], right = rowTotalSum[i]-val-rowLeftSum[i];
            int upper = colUpperSum[j], below = colTotalSum[j]-val - colUpperSum[j];
            if (isEquilibrium(left, right, upper, below))
               count++;
            rowLeftSum[i] += val;
            colUpperSum[j] += val;
         }
      }  
      return count;
   }
   
   private boolean isEquilibrium(int left, int right, int upper, int below){
      return (left == right && upper == below);
   }
   
   @Test
   public void testEquilibrium(){
      int[][] matrix = new int[][]{
            {2,7,5},
            {3,1,1},
            {2,1,-7},
            {0,2,1},
            {1,6,8}  
      };
      System.out.println(equilibriumIndexOfMatrix(matrix));
   }
   
}
