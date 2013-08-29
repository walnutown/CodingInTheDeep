// TLE in large judge
public class Solution {
    int sum;
    int min;
    int mWidth;
    int mHeight;
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        mWidth = grid[0].length;
        mHeight = grid.length;
        
        if (mHeight == 0 || mWidth == 0){
            return 0;
        }
        sum = 0;
        min = Integer.MAX_VALUE;
        DFS(grid, 0, 0);
        return min;
    }
    
    public void DFS(int[][] grid, int row, int col){
        if (row >= mHeight || col >= mWidth){
            return;
        }
        
        sum += grid[row][col];
        if (row == mHeight-1 && col == mWidth-1){
            min = Math.min(min, sum);
        }
        DFS(grid, row+1, col);
        DFS(grid, row, col+1);
        
        sum -= grid[row][col];
    }  
}


// cut the unnecessary subtrees, TLE in large judge
public class Solution {
    int sum;
    int min;
    int mWidth;
    int mHeight;
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        mWidth = grid[0].length;
        mHeight = grid.length;
        
        if (mHeight == 0 || mWidth == 0){
            return 0;
        }
        sum = 0;
        min = Integer.MAX_VALUE;
        DFS(grid, 0, 0);
        return min;
    }
    
    public void DFS(int[][] grid, int row, int col){
        
        sum += grid[row][col];
        
        if (row == mHeight-1 && col == mWidth-1){
            min = Math.min(min, sum);
        }
        // non-negative numbers, sum can only be increased
        if (row+1 < mHeight && sum < min){
            DFS(grid, row+1, col);
        }
        if (col+1 < mWidth && sum < min){
            DFS(grid, row, col+1);
        }
        
        sum -= grid[row][col];
    }
    
}



// 2d matrix DP
public class Solution {
    int[][] mem;
    int mWidth;
    int mHeight;
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        mWidth = grid[0].length;
        mHeight = grid.length;
        
        if (mHeight == 0 || mWidth == 0){
            return 0;
        }
        
        mem = new int[mHeight][mWidth];
        
        mem[0][0] = grid[0][0];
        for(int i=1; i < mHeight; i++){
            mem[i][0] = mem[i-1][0] + grid[i][0];
        }
        for(int i = 1; i < mWidth; i++){
            mem[0][i] = mem[0][i-1] + grid[0][i];
        }
        
        for(int i = 1; i < mHeight; i++){
            for(int j = 1; j < mWidth; j++){
                mem[i][j] = Math.min(mem[i-1][j], mem[i][j-1]) + grid[i][j];
            }
        }   
        return mem[mHeight-1][mWidth-1];
    }
}