package ch11_sorting_searching;

import java.util.Arrays;

import org.junit.Test;

public class ch11_6_SearchMatrix {

   /*
    * Given an M * N matrix in which each row and each column is sorted in ascending order,
    * write a method to find an element.
    */

   // The basic idea is similar to binary search, we choose a starting point (top-right or
   // bottom-left), whose one-side neighbor is smaller than it, another side neighbor is larger than
   // it. Through comparison with current element, we move the position.
   // In the following implementation, we start from top-right, and find a path to the target number
   // time: O(m+n)
   public String matrixSearch(int[][] matrix, int num) {
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

   private void printMatrix(int[][] matrix) {
      for (int i = 0; i < matrix.length; i++) {
         System.out.println(Arrays.toString(matrix[i]));
      }
   }

   @Test
   public void test() {
      int[][] matrix = new int[][] { { 15, 20, 40, 85 }, { 20, 35, 89, 95 }, { 30, 55, 95, 105 },
            { 40, 80, 100, 120 } };
      int num = 55;
      printMatrix(matrix);
      System.out.println(matrixSearch(matrix, num));

   }

}