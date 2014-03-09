package ch1_arrays_strings;

import java.util.Arrays;

public class SquareMatrixMultiply {

   /**
    * Given two square matrices of size N*N, get the multiplication matrix
    */
   public static void main(String[] args) {
      int[][] A = new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 }, };
      int[][] B = new int[][] { { 2, 2, 2 }, { 2, 2, 2 }, { 2, 2, 2 }, };
      printMatrix(A);
      printMatrix(B);
      printMatrix(multiply(A, B));
   }

   public static int[][] multiply(int[][] A, int B[][]) {
      int N = A.length;
      int[][] res = new int[N][N];
      for (int i = 0; i < N; i++) {
         for (int j = 0; j < N; j++) {
            for (int k = 0; k < N; k++) {
               res[i][j] += A[i][k] * B[k][j];
            }
         }
      }
      return res;
   }
   
   public static void printMatrix(int[][] A){
      for (int i=0; i<A.length; i++)
         System.out.println(Arrays.toString(A[i]));
      System.out.println("");
   }
}
