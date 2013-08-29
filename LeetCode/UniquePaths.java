public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int width = obstacleGrid[0].length;
        int height = obstacleGrid.length;
        int[][] mem = new int[height][width];
        
        if (width == 0 || height == 0){
            return 0;
        }
        
        mem[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        
        for(int i = 1; i < width; i++){
            mem[0][i] = obstacleGrid[0][i] == 0? mem[0][i-1]: 0;
        }
        for(int i = 1; i < height; i++){
            mem[i][0] = obstacleGrid[i][0] == 0? mem[i-1][0]:0;
        }
        
        for(int i = 1; i< height; i++){
            for(int j = 1; j < width; j++){
                mem[i][j] = obstacleGrid[i][j] == 0? mem[i-1][j] + mem[i][j-1] : 0;
            }
        }
        
        return mem[height-1][width-1];
    }
}

