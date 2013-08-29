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