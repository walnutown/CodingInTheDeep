package ch18_hard;

import org.junit.Test;

public class ch18_11_FindMaxSubsqaure {

   /**
    * Imagine you have a square matrix, where each cell is either black or white. Design an
    * algorithm to find the maximum subsquare such that all four borders are filled with black
    * pixels
    */

   // naive, O(n^4)
   // iteratively find the square of size N*N, (N-1)*(N-1), ...
   public Subsquare findMaxSubsquare(int[][] square) {
      for (int i = square.length; i >= 1; i--) {
         Subsquare s = findSquareWithSize(square, i);
         if (s != null)
            return s;
      }
      return null;
   }

   public Subsquare findSquareWithSize(int[][] square, int size) {
      // on an edge of length N, there're (N-size+1) subsquares of length 'size'
      for (int i = 0; i < square.length - size + 1; i++) {
         for (int j = 0; j < square.length - size + 1; j++) {
            if (isSquare(square, i, j, size))
               return new Subsquare(i, j, size);
         }
      }
      return null;
   }

   public boolean isSquare(int[][] square, int row, int col, int size) {
      for (int i = 0; i < size; i++) {
         if (square[row][col + i] == 0 || square[row + size - 1][col + i] == 0)
            return false;
      }

      for (int j = 0; j < size; j++) {
         if (square[row + j][col] == 0 || square[row + j][col + size - 1] == 0)
            return false;
      }
      return true;
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

   public Subsquare findMaxSubsquare2(int[][] matrix) {
      assert (matrix.length > 0);
      for (int row = 0; row < matrix.length; row++) {
         assert (matrix[row].length == matrix.length);
      }

      SquareCell[][] processed = processSquare(matrix);

      int N = matrix.length;

      for (int i = N; i >= 1; i--) {
         Subsquare square = findSquareWithSize2(processed, i);
         if (square != null) {
            return square;
         }
      }
      return null;
   }

   public Subsquare findSquareWithSize2(SquareCell[][] processed, int square_size) {
      // On an edge of length N, there are (N - sz + 1) squares of length sz.
      int count = processed.length - square_size + 1;

      // Iterate through all squares with side length square_size.
      for (int row = 0; row < count; row++) {
         for (int col = 0; col < count; col++) {
            if (isSquare2(processed, row, col, square_size)) {
               return new Subsquare(row, col, square_size);
            }
         }
      }
      return null;
   }

   private boolean isSquare2(SquareCell[][] matrix, int row, int col, int size) {
      SquareCell topLeft = matrix[row][col];
      SquareCell topRight = matrix[row][col + size - 1];
      SquareCell bottomRight = matrix[row + size - 1][col];
      if (topLeft.blacksRight < size) { // Check top edge
         return false;
      }
      if (topLeft.blacksBelow < size) { // Check left edge
         return false;
      }
      if (topRight.blacksBelow < size) { // Check right edge
         return false;
      }
      if (bottomRight.blacksRight < size) { // Check bottom edge
         return false;
      }
      return true;
   }

   public SquareCell[][] processSquare(int[][] matrix) {
      SquareCell[][] processed = new SquareCell[matrix.length][matrix.length];

      for (int r = matrix.length - 1; r >= 0; r--) {
         for (int c = matrix.length - 1; c >= 0; c--) {
            int blacksRight = 0;
            int blacksBelow = 0;
            if (matrix[r][c] == 1) { // only need to process if it's a black cell
               blacksRight++;
               blacksBelow++;
               if (c + 1 < matrix.length) { // next column over is on same row
                  SquareCell previous = processed[r][c + 1];
                  blacksRight += previous.blacksRight;
               }
               if (r + 1 < matrix.length) {
                  SquareCell previous = processed[r + 1][c];
                  blacksBelow += previous.blacksBelow;
               }
            }
            processed[r][c] = new SquareCell(blacksRight, blacksBelow);
         }
      }
      return processed;
   }

   public class SquareCell {
      public int blacksRight = 0;
      public int blacksBelow = 0;

      public SquareCell(int right, int below) {
         blacksRight = right;
         blacksBelow = below;
      }

      public void setZerosRight(int right) {
         blacksRight = right;
      }

      public void setZerosBelow(int below) {
         blacksBelow = below;
      }
   }

   @Test
   // 1 for black, 0 for white
   public void testSubSquare() {
      int[][] square = new int[][] { { 1, 1, 1, 1 }, { 1, 1, 0, 1 }, { 1, 0, 1, 1 },
            { 1, 1, 1, 1 }, };
      System.out.println(findMaxSubsquare(square));
      System.out.println(findMaxSubsquare2(square));

   }

}
