/*
  Given an integer n, return all distinct solutions to the n-queens puzzle.

  Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

  For example,
  There exist two distinct solutions to the 4-queens puzzle:

  [
   [".Q..",  // Solution 1
    "...Q",
    "Q...",
    "..Q."],

   ["..Q.",  // Solution 2
    "Q...",
    "...Q",
    ".Q.."]
  ]
*/

// DFS, use int[][] board to mark the position of queuens
public class Solution {
   public ArrayList<String[]> solveNQueens(int n){
        ArrayList<String[]> res = new ArrayList<String[]>();
        if (n == 0) return res;
        int[][] board = new int[n][n];
        finder(n, 0, res, board);
        return res;
   }
   
   public void finder(int n, int row, ArrayList<String[]> res, int[][] board){
       if (row == n){
           String[] str = new String[board.length];
           for (int i = 0; i<board.length; i++){
               str[i] = new String();
               for (int j=0; j<board[0].length; j++){
                   if (board[i][j] == 1)    str[i] += "Q";
                   else str[i] += ".";
               }
           }
           res.add(str);
           return;
       }
       for (int i=0; i<board[0].length; i++){
           if (isValid(board, row, i)){
                board[row][i] = 1;
                finder(n, row+1, res, board);
                board[row][i] = 0;
           }
       }
   }
   
   public boolean isValid(int[][] board, int row, int col){
       // check the same column
       for (int i=0; i<=row; i++)
           if (board[i][col] == 1)  return false;
       // check diagonal
       for (int i=row, j=col; i>=0 && j>=0; i--, j--)
           if (board[i][j] == 1)    return false;
       for (int i=row, j=col; i>=0 && j<board[0].length; i--, j++)
           if (board[i][j] == 1)    return false;
       return true;
   }
}

// bit manipulation, performance improvement in valid check step
public class Solution {
   public ArrayList<String[]> solveNQueens(int n){
        ArrayList<String[]> res = new ArrayList<String[]>();
        finder( 0, 0, 0, 0, new long[n], res);
        return res;
   }
   
   public void finder(int x, long col, long lDiagonal, long rDiagonal, long[] rows, ArrayList<String[]> res){
        if (x == rows.length){
            String[] r = new String[rows.length];
            for (int i=0; i<rows.length; i++){
                r[i] = Long.toBinaryString(rows[i]).replace('0', '.').replace('1', 'Q');
                while (r[i].length() < rows.length) r[i] = '.' + r[i];  // add '.' to fill the missing 0s
            }
            res.add(r);
        }
        else{
            long avail = ~(col | lDiagonal | rDiagonal);
            for (int i=0; i<rows.length; i++){
                long pos = avail & (1<<i);
                if (pos > 0){
                    rows[x] = pos;
                    finder(x+1, (col | pos), ((lDiagonal | pos) << 1), ((rDiagonal | pos) >> 1), rows, res);
                }
            }
        }
   }
}


