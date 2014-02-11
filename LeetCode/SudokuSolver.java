/*
    Write a program to solve a Sudoku puzzle by filling the empty cells.

    Empty cells are indicated by the character '.'.

    You may assume that there will be only one unique solution.
*/

// DFS
public class Solution {
    public void solveSudoku(char[][] board) {
        if (board==null || board.length!=9) return;
        solver(board, 0, 0);
    }
    public boolean solver(char[][] board, int x, int y){            // important to return boolean type here
        if (x>= board.length)   return true;
        if (y==board[0].length) return solver(board, x+1, 0);
        if (board[x][y] != '.') return solver(board, x, y+1);
        int[] nums = new int[10];
        for (int i=0; i<9; i++) {
            if(board[x][i] != '.') nums[board[x][i]-'0'] = 1;
            if(board[i][y] != '.') nums[board[i][y]-'0'] = 1;
        }
        for (int i=0; i < 3; i++){
            for (int j=0; j<3; j++){
                Character val = board[x/3*3 + i][y/3*3 + j];
                if(val != '.')  nums[val-'0'] = 1;
            }
        }
        for (int i=1; i<=9; i++){
            if(nums[i]==0){
                board[x][y] = (char)(i + '0');                      // need cast here
                if (solver(board, x, y+1))  return true;            // only one solution exit, if the result is found in this path, just return
                board[x][y] = '.';                                  // so that the board will not be clanend again
            }
        }
        return false;
    }
}