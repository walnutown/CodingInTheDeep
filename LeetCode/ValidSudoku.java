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

// Accepted
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board==null || board.length!=9 || board[0].length!=9)   return false;
        boolean[][] rows = new boolean[9][9];
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                if (board[i][j]=='.')   continue;
                else if (!rows[i][board[i][j]-'1'])    rows[i][board[i][j]-'1']=true;
                else    return false;
            }
        }
        boolean[][] cols = new boolean[9][9];
        for (int j=0; j<9; j++){
            for (int i=0; i<9; i++){
                if (board[i][j]=='.')   continue;
                else if (!cols[j][board[i][j]-'1'])    cols[j][board[i][j]-'1'] = true;
                else    return false;
            }
        }
        boolean[][] blocks = new boolean[9][9]; 
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                int x=(i/3)*3 + j/3;            // map each coordinates to corresponding balock, each block has a array to mark the number
                if (board[i][j] == '.') continue;
                else if (!blocks[x][board[i][j]-'1'])    blocks[x][board[i][j]-'1'] = true;
                else    return false;
            }
        }
        return true;
    }
}

// Accepted
// from AnnieKim, use bit vector to mark numbers, and combine the 3 for loops
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board==null || board.length!=9 || board[0].length!=9)   return false;
        int row, n=9;
        int[] cols = new int[n];
        int[] blocks = new int[n];
        for (int i=0; i<n; i++){
            row=0;
            for (int j=0; j<n; j++){
                if (board[i][j] == '.') continue;
                int bit = 1<<(board[i][j]-'1');
                int x = (i/3)*3 + j/3;
                if ((row&bit)>0 || (cols[j]&bit)>0 || (blocks[x]&bit)>0)    return false;
                row |= bit;
                cols[j] |= bit;
                blocks[x] |= bit;
            }
        }
        return true;
    }
}


















