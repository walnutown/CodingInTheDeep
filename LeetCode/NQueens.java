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
// Basic Backtracking
// Note, we use a int matrix to mark the position of Queen and build board finally.
// Becuase operations on int array is easy than on string array
// time: O()
public class Solution {
   public ArrayList<String[]> solveNQueens(int n){
        ArrayList<String[]> res = new ArrayList<String[]>();
        if (n<=0)   return res;
        dfs(new int[n][n], 0, res);
        return res;
   }
   
   private void dfs(int[][] M, int rowNum, ArrayList<String[]> res){
       if (rowNum == M.length){
           res.add(buildBoard(M));
           return;
       }
       int N = M.length;
       for (int i=0; i<N; i++){
           if (isValid(M, rowNum, i)){
               M[rowNum][i] = 1;
               dfs(M, rowNum+1, res);
               M[rowNum][i] = 0;
           }
       }
   }
   
   private String[] buildBoard(int[][] M){
       int N = M.length;
       String[] board = new String[N];
       for (int i=0; i<N; i++){
           StringBuilder sb = new StringBuilder();
           for (int j=0; j<N; j++){
               if (M[i][j]==0)  sb.append('.');
               else    sb.append('Q');
           }
           board[i] = sb.toString();
       }
       return board;
   }
   
   private boolean isValid(int[][] M, int rowNum, int colNum){
       for (int i=0; i<rowNum; i++){
           if (M[i][colNum]==1) return false;
       }
       for (int i=rowNum-1, j=colNum-1; i>=0 && j>=0; i--,j--){
           if (M[i][j]==1)  return false;
       }
       for (int i=rowNum-1, j=colNum+1; i>=0 && j<M.length; i--,j++){
           if (M[i][j]==1)  return false;
       }
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


