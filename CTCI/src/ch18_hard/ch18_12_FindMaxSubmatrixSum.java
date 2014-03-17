package ch18_hard;

import org.junit.Test;

public class ch18_12_FindMaxSubmatrixSum {

   /**
    * Given an N*N matrix of positive and negative integers, write code to find the sub-matrix with
    * the largest possible sum.
    */
   @Test
   public  void test() {
      int[][] matrix = new int[][]{
            {1,1,1,-1},
            {1,2,1,-1},
            {1,1,1,1},
            {-1,-1,-1,1},
      };
      System.out.println(findMaxSubmatrixSum(matrix));
      System.out.println(findMaxSubmatrixSum2(matrix));
   }

   // Solution1
   // brute force, iterate through O(n^4) sub-matrices and it takes O(n^2) to compute the area of
   // each, total O(n^6)

   // Solution2
   // Dynamic Programming, O(n^4)
   // reduce the computation time of sub-matrix sum from O(n^2) to O(1)
   public int findMaxSubmatrixSum(int[][] matrix) {
      int max = Integer.MIN_VALUE;
      int rowNum = matrix.length, colNum = matrix[0].length;
      int[][] processed = processMatrix(matrix);
      for (int x1=0; x1<rowNum; x1++){
         for (int x2=x1+1; x2<rowNum; x2++){
            for (int y1=0; y1<colNum; y1++){
               for (int y2=y1+1; y2<colNum; y2++)
                  max = Math.max(max, computeSum(processed, x1, y1, x2, y2));
            }
         }
      }
      return max;
   }

   public int[][] processMatrix(int[][] matrix) {
      int[][] processed = new int[matrix.length][matrix[0].length];
      processed[0][0] = matrix[0][0];
      for (int i = 1; i < matrix.length; i++)
         processed[i][0] = processed[i - 1][0] + matrix[i][0];
      for (int j = 1; j < matrix[0].length; j++)
         processed[0][j] = processed[0][j - 1] + matrix[0][j];
      for (int i = 1; i < matrix.length; i++) {
         for (int j = 1; j < matrix[0].length; j++) {
            // dp equation
            processed[i][j] = processed[i - 1][j] + processed[i][j - 1] - processed[i - 1][j - 1] + matrix[i][j];
         }
      }
      return processed;
   }
   
   // compute the sum of matrix, [x1, x2], [y1, y2] 
   public int computeSum(int[][] processed, int x1, int y1, int x2, int y2 ){
      if (x1==0 && y1==0)
         return processed[x2][y2];
      else if (x1==0)
         return processed[x2][y2] - processed[x2][y1-1];
      else if (y1==0)
         return processed[x2][y2] - processed[x1-1][y2];
      else
         return processed[x2][y2] - processed[x1-1][y2] - processed[x2][y1-1] + processed[x1-1][y1-1];
   }
   
   // Solution3
   // get the sum of each column in sub-matrix first
   // then, get MaxSubArray of the columnSum array 
   // time: O(n^3)
   public int findMaxSubmatrixSum2(int[][] matrix) {
      int max = Integer.MIN_VALUE;
      int rowNum = matrix.length, colNum = matrix[0].length;
      int[] partialSum = new int[colNum];
      for (int rs=0; rs<rowNum; rs++){
         clearArray(partialSum);
         for (int rd=rs; rd<rowNum; rd++){
            for (int i=0; i<colNum; i++)
               partialSum[i] += matrix[rd][i];
            max = Math.max(max, maxSubArray(partialSum));
         }
      }
      return max;
   }
   
   public void clearArray(int[] A){
      for (int i=0; i<A.length; i++)
         A[i] = 0;
   }
   
   public int maxSubArray(int[] A){
      int max = Integer.MIN_VALUE, sum=0;
      for (int i=0; i<A.length; i++){
         sum = Math.max(sum+A[i], A[i]);
         max = Math.max(max, sum);
      }
      return max;
   }
}
