package ch18_hard;

import java.util.Arrays;

import org.junit.Test;

public class FindMaxSubsquare2 {

   /**
    * Imagine you have a square matrix, where each cell is either black or white. Design an
    * algorithm to find the maximum subsquare such that all the cells in the subsquare are filled
    * with black pixels
    */

   // Pre-Process the square using dynamic programming
   // http://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
   // processed[i][j] = square[i][j]==0? 0 : Min(processed[i-1][j], processed[i][j-1], processed[i-1][j-1])+1
   // time: O(n^2)
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
   private int[][] processSquare(int[][] square) {
      int N = square.length;
      int[][] processed = new int[N][N];
      for (int i = 0; i < N; i++)
         processed[0][i] = square[0][i];
      for (int j = 0; j < N; j++)
         processed[j][0] = square[j][0];
      for (int i = 1; i <N-1; i++) {
         for (int j = 1; j <N-1; j++) {
            if (square[i][j] == 1)
               processed[i][j] = Math.min(Math.min(processed[i-1][j], processed[i][j-1]), processed[i-1][j-1]) + 1;
         }
      }
      printMatrix(processed);
      return processed;
   }

   private void printMatrix(int[][] processed) {
      for (int i = 0; i < processed.length; i++) {
         System.out.println(Arrays.toString(processed[i]));
      }
   }

   // [row, col] is the top-left corner of the subsquare
   private class Subsquare {
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

   // we should use 1 for black, 0 for white
   // if we're asked to find the subsqaure filled with 0, we can flip the color of cells first
   @Test
   public void test() {
      int[][] square = new int[][] { 
            { 1, 1, 1, 1 }, 
            { 1, 1, 0, 1 }, 
            { 1, 0, 1, 1 },
            { 1, 1, 1, 0 }, 
      };
      System.out.println(findMaxSubsquare2(square));
   }

}
