/*
    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

    Note: You can only move either down or right at any point in time.
*/


// 2d DP, time: O(m*n); space: O(m*n)
// similar to uniquePaths, uniquePaths2
public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid==null || grid.length==0 || grid[0].length==0) return 0;
        int h = grid.length;
        int w = grid[0].length;
        int[][] mem = new int[h][w];
        mem[0][0] = grid[0][0];
        for (int i=1; i<h; i++) mem[i][0] = mem[i-1][0] + grid[i][0];
        for (int j=1; j<w; j++) mem[0][j] = mem[0][j-1] + grid[0][j];
        for (int i=1; i<h; i++){
            for (int j=1; j<w; j++){
                mem[i][j] = Math.min(mem[i-1][j], mem[i][j-1]) + grid[i][j];
            }
        }
        return mem[h-1][w-1];
    }
}