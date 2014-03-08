package ch9_recursion_dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;

public class ch9_2_UniquePaths {

   /*
    * Robot moves in X * Y grid. Only right or down direction
    * How many paths are there for the robot to move from leftmost corner to rightmost corner
    */
   public static void main(String[] args) {
      int[][] grid = new int[][] { { 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 1 }, { 0, 0, 0, 1, 0 },
            { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, };
      System.out.println(robotMove(grid));
      grid[0][3] = 1;
      grid[1][4] = 1;
      grid[2][3] = 1;
      printGrid(grid);
      ArrayList<int[][]> paths = new ArrayList<int[][]>();
      robotMove2(grid, 0, 0, paths);
      for (int[][] path : paths)
         printGrid(path);
   }

   // Actually, we can directly use formula to calculate the number of paths
   // Num = C(X, X+Y) = (X+Y)!/(X!Y!)
   // see Leetcode -- UniquePaths
   public static int robotMove(int[][] grid) {
      int width = grid[0].length;
      int height = grid.length;
      int[][] mem = new int[height + 1][width + 1];
      mem[0][0] = 0;
      for (int i = 1; i <= width; i++)
         mem[0][i] = 1;
      for (int i = 1; i <= height; i++)
         mem[i][0] = 1;
      for (int i = 1; i <= width; i++) {
         for (int j = 1; j <= height; j++) {
            mem[i][j] = mem[i - 1][j] + mem[i][j - 1];
         }
      }
      return mem[height][width];
   }

   public static void printGrid(int[][] grid) {
      for (int i = 0; i < grid.length; i++) {
         System.out.println(Arrays.toString(grid[i]));
      }
      System.out.println("");
   }

   // Follow Up
   // Imagine certain spots are "off limits", such that the robot cannot step on them.
   // Design an algorithm to find a path for the robot from top left to bottom right.

   // the path will be marked on the grid as "8", "1" is obstacle
   public static void robotMove2(int[][] grid, int row, int colum, ArrayList<int[][]> res) {
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
}
