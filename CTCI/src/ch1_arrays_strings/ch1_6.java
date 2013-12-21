package ch1_arrays_strings;

import java.util.Arrays;

public class ch1_6 {

   /**
    * Given an image represented by an N*N matrix, where each pixel in the image is 4 bytes
    * write a method to rotate the image by 90 degrees. Do this in place
    */
   public static void main(String[] args) {
      int[][] matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
      printMatrix(matrix);
      rotateImage(matrix, 3);
      printMatrix(matrix);
   }
   
   public static void rotateImage(int[][] matrix, int n){
      for (int level = 0; level < n/2; level++){
         int first = level;
         int last = n - 1 - level;
         for (int i = first; i < last; i++){
            int offset = i -first;
            // save top
            int top = matrix[first][i];
            // left -> top
            matrix[first][i] = matrix[last-offset][first];
            // bottom -> left
            matrix[last-offset][first] = matrix[last][last - offset];
            // right -> bottom
            matrix[last][last-offset] = matrix[i][last];
            // top -> right
            matrix[i][last] = top;
         }
      }
   }
   
   public static void printMatrix(int[][] matrix){
      for (int i = 0; i < matrix.length; i++)
         System.out.println(Arrays.toString(matrix[i]));
      System.out.println("");
   }
}
