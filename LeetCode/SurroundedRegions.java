public class Solution {
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (board.length <= 2 || board[0].length <= 2){
            return;
        }
        
        int mWidth = board[0].length;
        int mHeight = board.length;
        
        int[][] flag = new int[mWidth][mHeight];
        
        for (int i = 0; i < mHeight; i++){
            if (board[i][0] == 'O'){
                flag[i][0] = 1;
            }
            if (board[i][mWidth-1] == 'O'){
                flag[i][mWidth-1] = 1;
            }
        }   
        for(int i = 0; i< mWidth; i++){
            if (board[0][i] == 'O'){
                flag[0][i] = 1;
            }
            if (board[mHeight - 1][i] == 'O'){
                flag[mHeight - 1][i] = 1;
            }
        }
        boolean[] cut = new boolean[mHeight];
        for (int i = 1; i < mWidth-1; i++){
            for (int j = 1; j < mHeight-1; j++){
                if (board[j][i] == 'O' && board[j][i-1] == 'O' && !cut[j]){
                    flag[j][i] = 1;
                }
                else{
                    cut[j] = true;
                }
            }
        }
        
        cut = new boolean[mHeight];
        for (int i = mWidth - 2; i > 0; i--){
            for (int j = 1; j < mHeight-1; j++){
                if (board[j][i] == 'O' && board[j][i+1] == 'O' && !cut[j]){
                    flag[j][i] = 1;
                }
                else{
                    cut[j] = true;
                }
            }
        }
        
        cut = new boolean[mWidth];
        for (int i = 1; i < mHeight-1; i++){
            for (int j = 1; j < mWidth-1; j++){
                if (board[i][j] == 'O' && board[i-1][j] == 'O' && !cut[j]){
                    flag[i][j] = 1;
                }
                else{
                    cut[j] = true;
                }
            }
        }
        
        cut = new boolean[mWidth];
        for (int i = mHeight - 2; i > 0; i--){
            for (int j = 1; j < mWidth-1; j++){
                if (board[i][j] == 'O' && board[i+1][j] == 'O' && !cut[j]){
                    flag[i][j] = 1;
                }
                else{
                    cut[j] = true;
                }
            }
        }
        
        
        for (int i = 0; i < mHeight; i++){
            for(int j = 0; j < mWidth; j++){
                if (flag[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }
        
    }
}