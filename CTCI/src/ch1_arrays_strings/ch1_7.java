package ch1_arrays_strings;

import java.util.Arrays;

public class ch1_7 {

   /**
    * write an algorithm such that if an element in an M * N matrix is 0, its entire
    * row and column are set to 0
    */
   public static void main(String[] args) {
      int[][] matrix = new int[][] { { 1, 0, 3 }, { 4, 5, 6 }, { 0, 8, 9 } };
      printMatrix(matrix);
      setZeros(matrix);
      printMatrix(matrix);
   }

   public static void setZeros(int[][] matrix) {
      int h = matrix.length;
      int w = matrix[0].length;
      boolean firstRowZero = false;
      boolean firstColZero = false;
      // check first row
      for (int i = 0; i < w; i++) {
         if (matrix[0][i] == 0){
            firstRowZero = true;
            break;
         }
      }
      // check first col
      for (int i = 0; i < h; i++) {
         if (matrix[i][0] == 0) {
            firstColZero = true;
            break;
         }
      }
      // check others
      for (int i = 1; i < h; i++) {
         for (int j = 1; j < w; j++) {
            if (matrix[i][j] == 0) {
               matrix[0][j] = 0;
               matrix[i][0] = 0;
            }
         }
      }
      // set others zeros
      for (int i = 0; i < h; i++) {
         if (matrix[i][0] == 0) {
            for (int j = 1; j < w; j++)
               matrix[i][j] = 0;
         }
      }
      for (int i = 0; i < w; i++) {
         if (matrix[0][i] == 0) {
            for (int j = 1; j < h; j++)
               matrix[j][i] = 0;
         }
      }
      // set first row and col zeros if necessary
      if (firstRowZero == true){
         for (int i = 0; i < w; i++)
            matrix[0][i] = 0;
      }
      if (firstColZero == true){
         for (int i = 0; i < h; i++)
            matrix[i][0] = 0;
      }      
   }

   public static void printMatrix(int[][] matrix) {
      for (int i = 0; i < matrix.length; i++)
         System.out.println(Arrays.toString(matrix[i]));
      System.out.println("");
   }

}
