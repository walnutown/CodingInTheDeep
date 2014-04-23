/*
    Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

    The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
    
    Note:
    A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
*/

// from AnnieKim, use bit vector to mark numbers, and combine the 3 for loops
// time: O(n^2); space: O(n)
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board==null || board.length!=9 || board[0].length!=9)   return false;
        int n=9;
        int[] rows = new int[n];
        int[] cols = new int[n];
        int[] blocks = new int[n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (board[i][j] == '.') continue;
                int bit = 1<<(board[i][j]-'1');
                int x = (i/3)*3 + j/3;          // think how to convert a matrix to an array, i*width+j
                if ((rows[i]&bit)>0 || (cols[j]&bit)>0 || (blocks[x]&bit)>0)    return false;
                rows[i] |= bit;
                cols[j] |= bit;
                blocks[x] |= bit;
            }
        }
        return true;
    }
}

// check row, column, block seperately
// time: O(n^2); sapce: O(n^2)
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
                int x=(i/3)*3 + j/3;            // map each coordinates to corresponding block, each block has an array to mark the visited one
                if (board[i][j] == '.') continue;
                else if (!blocks[x][board[i][j]-'1'])    blocks[x][board[i][j]-'1'] = true;
                else    return false;
            }
        }
        return true;
    }
}

