package ch11_sorting_searching;

import java.util.Arrays;

public class ch11_11_6 {

   /*
    * Given an M * N matrix in which each row and each column is sorted in ascending order, 
    * write a method to find an element.  
    */
   public static void main(String[] args) {
      int[][] matrix = new int[][]{{1,2,3}, {4,5,6},{7,8,9}};
      int num = 7;
      printMatrix(matrix);
      System.out.println(matrixSearch2(matrix, num));
      
   }
   
   public static void printMatrix(int[][] matrix){
      for (int i = 0; i < matrix.length; i++){
         System.out.println(Arrays.toString(matrix[i]));
      }
   }
   
   
   public static String matrixSearch(int[][] matrix, int num){
      int i = matrix[0].length -1 ;
      while(i >= 0){
         if (num == matrix[0][i])
            return "(0, " + i + ")";
         if (num > matrix[0][i]){
            int j = matrix.length-1; // can use binary search here to optimize
            while (j > 0){
               if (matrix[j][i] == num){
                  return "(" + j + ", " + i + ")";
               }
               j--;
            }
         }
         i--;
      }
      return "Element Not Found";
   }
   
   public static String matrixSearch2(int[][] matrix, int num){
      int col = matrix[0].length - 1;
      int row = 0;
      while (col >= 0 && row < matrix.length){
         if (matrix[row][col] == num)
            return "(" + row + "," + col + ")";
         else if (matrix[row][col] > num)
            col--;
         else
            row++;
      }
      return "Element Not Found";
   }

}

// haven't reviewed the Solution#2 : binary search
