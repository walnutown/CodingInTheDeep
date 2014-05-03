package ch9_recursion_dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class ch9_2_UniquePaths {

   /**
    * Robot moves in X * Y grid. Only right or down direction
    * Imagine certain spots are "off limits", such that the robot cannot step on them.
    * Design an algorithm to find a path for the robot from top left to bottom right.
    */

   // Backtracking
   // the path will be marked on the grid as "8" in the grid ("1" is obstacle)
   public void robotMove2(int[][] grid, int row, int colum, ArrayList<int[][]> res) {
      if (row == grid.length - 1 && colum == grid[0].length - 1) {
         int[][] tmp = new int[grid.length][grid[0].length];
         for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
               tmp[i][j] = grid[i][j];
            }
         }
         res.add(tmp);
         return;
      }
      grid[row][colum] = 8;
      if (row + 1 < grid.length && grid[row + 1][colum] != 1)
         robotMove2(grid, row + 1, colum, res);
      if (colum + 1 < grid[0].length && grid[row][colum + 1] != 1)
         robotMove2(grid, row, colum + 1, res);
      grid[row][colum] = 0;
   }

   private void printGrid(int[][] grid) {
      for (int i = 0; i < grid.length; i++) {
         System.out.println(Arrays.toString(grid[i]));
      }
      System.out.println("");
   }

   @Test
   public void test() {
      int[][] grid = new int[][] { { 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 1 }, { 0, 0, 0, 1, 0 },
            { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, };
      grid[0][3] = 1;
      grid[1][4] = 1;
      grid[2][3] = 1;
      printGrid(grid);
      ArrayList<int[][]> paths = new ArrayList<int[][]>();
      robotMove2(grid, 0, 0, paths);
      for (int[][] path : paths)
         printGrid(path);
   }

}
