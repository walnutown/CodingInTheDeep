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


// Accepted, Dec 27
public class Solution {
    public int totalNQueens(int n) {
        if (n == 0) return 0;
        int[] num = new int[1];
        int[][] board = new int[n][n];
        finder(board, 0, n, num);
        return num[0];
    }
    
    public void finder(int[][] board, int row, int n, int[] num){
        if (row == n){
            num[0]++;
            return;
        }
        for (int i =0; i < n; i++){
            if (isValid(board, row, i)){
                board[row][i] = 1;
                finder(board, row+1, n, num);
                board[row][i] = 0;
            }
        }
    }
    
    public boolean isValid(int[][] board, int row, int col){
        for (int i=0; i <= row; i++)
            if (board[i][col] == 1) return false;
        for (int i=row, j=col; i>=0 && j>=0; i--, j--)
            if (board[i][j] == 1)   return false;
        for (int i=row, j=col; i>=0 && j<board[0].length; i--, j++)
            if (board[i][j] == 1)   return false;
        return true;
    }
}