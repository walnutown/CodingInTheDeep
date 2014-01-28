/*
    Follow up for "Unique Paths":

    Now consider if some obstacles are added to the grids. How many unique paths would there be?

    An obstacle and empty space is marked as 1 and 0 respectively in the grid.

    For example,
    There is one obstacle in the middle of a 3x3 grid as illustrated below.

    [
      [0,0,0],
      [0,1,0],
      [0,0,0]
    ]
    The total number of unique paths is 2.

    Note: m and n will be at most 100.
*/

// 2d DP, time: O(m*n); space: O(m*n)
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int w = obstacleGrid[0].length;
        int h = obstacleGrid.length;
        if (w==0 || h==0)   return 0;
        int[][] mem = new int[h][w];
        mem[0][0] = obstacleGrid[0][0] == 1? 0:1;
        for (int i=1; i<h; i++)
            mem[i][0] = obstacleGrid[i][0] == 1? 0:mem[i-1][0];
        for (int j=1; j<w; j++)                      
            mem[0][j] = obstacleGrid[0][j] == 1? 0:mem[0][j-1];
        for (int i=1; i<h; i++){
            for (int j=1; j<w; j++)
                mem[i][j] = obstacleGrid[i][j] == 1? 0: mem[i-1][j] + mem[i][j-1];
        }
        return mem[h-1][w-1];
    }
}
