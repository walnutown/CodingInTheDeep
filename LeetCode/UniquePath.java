// TLE in large judge
public class Solution {
    int sum;
    int width;
    int height;
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (m == 0 || n == 0){
            return 0;
        }
        
        
        sum = 0;
        width = m;
        height = n;
        
        DFS(0,0);
        return sum;
    }
    
    public void DFS(int row, int col){
        
        if (row == width -1 && col == height-1){
            sum++;
        }
        
        if (row+1 < width){
            DFS(row+1, col);
        }
        if(col+1 < height){
            DFS(row, col+1);
        }
    }
}

// 2d matrix DP
public class Solution {
    int[][] mem;
    int width;
    int height;
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (m == 0 || n == 0){
            return 0;
        }
        
        width = m;
        height = n;
        mem = new int[height][width];
        mem[0][0] = 1;
        for(int i = 1; i < height; i++){
            mem[i][0] = 1;
        }
        
        for(int i = 1; i < width; i++){
            mem[0][i] = 1;
        }
        
        
        for(int i= 1; i < height; i++){
            for(int j = 1; j < width; j++){
                mem[i][j] = mem[i-1][j] + mem[i][j-1];
            }
        }
        
        return mem[height-1][width-1];
    }
}