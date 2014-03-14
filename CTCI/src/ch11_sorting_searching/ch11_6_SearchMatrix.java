package ch11_sorting_searching;

import java.util.Arrays;

public class ch11_6_SearchMatrix {

   /*
    * Given an M * N matrix in which each row and each column is sorted in ascending order,
    * write a method to find an element.
    */

   // start from top-right, find a path to the target num
   // time: O(m+n)
   public static String matrixSearch(int[][] matrix, int num) {
      int col = matrix[0].length - 1;
      int row = 0;
      while (col >= 0 && row < matrix.length) {
         if (matrix[row][col] == num)
            return "(" + row + "," + col + ")";
         else if (matrix[row][col] > num)
            col--;
         else
            row++;
      }
      return "Element Not Found";
   }

   public static void main(String[] args) {
      int[][] matrix = new int[][] { 
            { 15, 20, 40, 85 }, 
            { 20, 35, 89, 95 }, 
            { 30, 55, 95, 105 },
            { 40, 80, 100, 120 } };
      int num = 55;
      printMatrix(matrix);
      System.out.println(matrixSearch(matrix, num));

   }

   public static void printMatrix(int[][] matrix) {
      for (int i = 0; i < matrix.length; i++) {
         System.out.println(Arrays.toString(matrix[i]));
      }
   }

}