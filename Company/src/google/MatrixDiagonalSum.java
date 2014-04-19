package google;

import java.util.Arrays;

import org.junit.Test;

public class MatrixDiagonalSum {
   /*
    * Given a matrix, return an array of diagonal(top-left -> bottom-right) sums
    * eg, M = {
    *   {1,2,3},
    *   {4,5,6},
    *   {7,8,9}
    * }
    * return [7,12,15,8,3]
    */
   
   // Left shift the ith row by i steps, and then add each column
   // We have a total of (numRow+numColumn-1) diagonals
   // Traverse each element in the matrix and add the element to corresponding diagonal sum
   // time: O(m*n)
   public int[] getSums(int[][] matrix){
      int M = matrix.length, N = matrix[0].length;
      int[] res = new int[M+N-1];
      for (int i=0; i<M; i++){
         for (int j=0; j<N; j++){
            int diagonalIndex = j + N-1-i;
            res[diagonalIndex] += matrix[i][j];
         }
      }
      return res;
   }
   
   @Test
   public void test(){
      int[][] matrix = new int[][]{
            {1,2,3},
            {4,5,6},
            {7,8,9}
      };
      System.out.println(Arrays.toString(getSums(matrix)));
   }
}
