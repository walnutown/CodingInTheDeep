public class Solution {
    int[] pos;
    int count;
    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n == 0){
            return 0;
        }
        count = 0;
        pos = new int[n];
        DFS(0, n);
        return count;
    }
    
    public void DFS(int row, int maxRow){
        if (row >= maxRow){
            return;
        }
        for (int i = 0; i < maxRow; i++){
            pos[row] = i;
            if (isValid(row)){
                if (row == maxRow -1){
                    count++;
                }
                DFS(row+1, maxRow);
            }    
            
        }
        
    }
    
    public boolean isValid(int row){
        for (int i = 0 ; i < row; i++){
            if (pos[i] == pos[row] || Math.abs(pos[row]-pos[i]) == row -i){
                return false;
            }
        }
        
        return true;
    }
}