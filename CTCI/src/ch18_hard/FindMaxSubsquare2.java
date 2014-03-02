package ch18_hard;

import java.util.Arrays;

import org.junit.Test;

public class FindMaxSubsquare2 {

   /**
    * Imagine you have a square matrix, where each cell is either black or white. Design an
    * algorithm to find the maximum subsquare such that all the cells in the subsquare are filled
    * with black pixels
    */
   
   
   
   @Test
   // we should use 1 for black, 0 for white
   // if we're asked to find the subsqaure filled with 0, we can flip the color of cells first
   public void test() {
      int[][] square = new int[][] { { 1, 1, 1, 1 }, { 1, 1, 0, 1 }, { 1, 0, 1, 1 },
            { 1, 1, 1, 1 }, };
      System.out.println(findMaxSubsquare2(square));
   }

   // Pre-Process the square using dynamic programming
   // http://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
   public Subsquare findMaxSubsquare2(int[][] square) {
      int[][] processed = processSquare(square);
      Subsquare max = new Subsquare(0, 0, 0);
      for (int i = 0; i < processed.length; i++) {
         for (int j = 0; j < processed.length; j++) {
            if (processed[i][j] > max.size)
               max = new Subsquare(i, j, processed[i][j]);
         }
      }
      return max;
   }

   // pre-process from bottom-right to top-left
   public int[][] processSquare(int[][] square) {
      int[][] processed = new int[square.length][square.length];
      for (int i = 0; i < square.length; i++)
         processed[square.length - 1][i] = square[square.length - 1][i];
      for (int j = 0; j < square.length; j++)
         processed[j][square.length - 1] = square[j][square.length - 1];
      for (int i = square.length - 2; i >= 0; i--) {
         for (int j = square.length - 2; j >= 0; j--) {
            if (square[i][j] == 1)
               processed[i][j] = Math.min(Math.min(processed[i + 1][j], processed[i][j + 1]), square[i][j]) + 1;
         }
      }
      printMatrix(processed);
      return processed;
   }

   public void printMatrix(int[][] processed) {
      for (int i = 0; i < processed.length; i++) {
         System.out.println(Arrays.toString(processed[i]));
      }
   }

   // [row, col] is the top-left corner of the subsquare
   public class Subsquare {
      int row;
      int col;
      int size;

      public Subsquare(int row, int col, int size) {
         this.row = row;
         this.col = col;
         this.size = size;
      }

      public String toString() {
         return "row: " + row + " col: " + col + " size: " + size;
      }
   }

}
