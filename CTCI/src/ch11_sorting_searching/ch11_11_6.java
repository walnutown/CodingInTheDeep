package ch11_sorting_searching;

import java.util.Arrays;

public class ch11_11_6 {

   /*
    * Given an M * N matrix in which each row and each column is sorted in ascending order, 
    * write a method to find an element.  
    */
   public static void main(String[] args) {
      int[][] matrix = new int[][]{{1,2,3}, {4,5,6},{7,8,9}};
      int num = 5;
      printMatrix(matrix);
      System.out.println(matrixSearch(matrix, 5));
      
   }
   
   public static void printMatrix(int[][] matrix){
      for (int i = 0; i < matrix.length; i++){
         System.out.println(Arrays.toString(matrix[i]));
      }
   }
   
   
   public static String matrixSearch(int[][] matrix, int num){
      StringBuilder sb = new StringBuilder();
      int i = matrix[0].length -1 ;
      while(i >= 0 && num < matrix[0][i]){
         i--;
      }
      int j = 0;
      while (j < matrix.length){
         if (matrix[j][i] == num){
            break;
         }else if (matrix[j][i] < num){
            j++;
         }else{
            return "Element Not Found";
         }
      }
      sb.append(j);
      sb.append(" , ");
      sb.append(i);
      return sb.toString();
   }

}
