package ch9_recursion_dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;

public class ch9_9_9 {

   /*
    * 8 Queens
    */
   public static void main(String[] args) {
      ArrayList<int[][]> res = new ArrayList<int[][]>();
      get8Q(res, new int[8][8], 0);
      for (int[][] tmp : res){
         printGrid(tmp);
      }
      System.out.println(res.size());
   }

   public static void get8Q(ArrayList<int[][]> res, int[][] r, int row){
      if (row == r.length){
         int[][] tmp = new int[r.length][r[0].length];
         for (int i = 0; i < r.length; i++){
            for (int j = 0; j < r[0].length; j++)
               tmp[i][j] = r[i][j]; 
         }
         res.add(tmp);
         return;
      }
      for (int col = 0; col < r[0].length; col++){
         if (isValid(r, row, col)){
            r[row][col] = 1;
            get8Q(res, r, row+1);
            r[row][col] = 0;
         }
      }
   }
   
   public static void printGrid(int[][] grid){
      for (int i = 0 ; i< grid.length ; i++){
         System.out.println(Arrays.toString(grid[i]));
      }
      System.out.println("");
   }
   
   public static boolean isValid(int[][] r, int row, int col){
      // check other elements in the same column
      for (int i = 0; i < row; i++){
         if (i != row && r[i][col] == 1)
            return false;
      }
      // no need to check elements in the same row
      // check diagonals
      for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
         if (r[i][j] == 1)
            return false;
      }
      for (int i=row-1, j=col+1; i>=0 && j<r[0].length; i--, j++){
         if (r[i][j] == 1)
            return false;
      }
      // no need to check the below, only need to check the rows above current row
//      for (int i=row+1, j=col+1; i<r.length && j<r[0].length; i++, j++){
//         if (r[i][j] == 1)
//            return false;
//      }
//      for (int i=row+1, j=col-1; i<r.length && j>=0; i++, j--){
//         if (r[i][j] == 1)
//            return false;
//      }
      return true;
   }
}
