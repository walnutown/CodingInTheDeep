// don't have to check whether the sudoku is valid to be solved
public class Solution {
    int width;
    int height;
    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        width = board[0].length;
        height = board.length;
        if (width != 9 || height != 9 )
            return false;
        
        return rowCheck(board) && colCheck(board) && blockCheck(board);
    }
    
    public boolean rowCheck(char[][] board){
        int[][] rowFilled = new int[9][9];
        for (int i = 0 ; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if (board[i][j] == '.') 
                    continue;
                int val = board[i][j] - '1';
                if (rowFilled[i][val] == 1) 
                    return false;
                else 
                    rowFilled[i][val] = 1;
            }
        }
        return true;
    }
    
    public boolean colCheck(char[][] board){
        int[][] colFilled = new int[9][9];
        for (int i = 0 ; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (board[i][j] == '.') 
                    continue;
                int val = board[i][j] - '1';
                if (colFilled[j][val] == 1) 
                    return false;
                else 
                    colFilled[j][val] = 1;
            }
        }
        return true;
    }
    
    public boolean blockCheck(char[][] board){
        int[][] blockFilled = new int[9][9];
        for (int i = 0; i < 9; i++){
            for (int j = 0 ; j < 9; j++){
                // cal block index
                int x = (i/3) *3 + j/3;
                if (board[i][j] == '.')
                    continue;
                int val = board[i][j] - '1';
                if (blockFilled[x][val] == 1)
                    return false;
                else
                    blockFilled[x][val] = 1;
            }
        }
        return true;
    }
}