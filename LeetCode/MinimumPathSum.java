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


// cut the unnecessary subtrees
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