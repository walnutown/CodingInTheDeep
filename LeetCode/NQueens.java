// DFS
public class Solution {
   ArrayList<String[]> resList;
   
   int[] pos;
   public ArrayList<String[]> solveNQueens(int n)
   {
      // Start typing your Java solution below
      // DO NOT write main() function
      resList = new ArrayList<String[]>();
      pos = new int[n];
      if (n == 0)
      {
         return resList;
      }

      DFS(1, n);

      return resList;
   }

   public void DFS(int depth, int n)
   {
      if (depth > n)
      {
         return;
      }

      for (int i = 0; i < n; i++)
      {
         pos[depth-1] = i;
         if (isValid(depth-1))
         { 
            if (depth == n){
                addToList(n);
            }
            DFS(depth + 1, n);

         }
      }
   }
   
   public boolean isValid(int index){
       for (int i = 0; i < index; i++){
           if (pos[i] == pos[index] || Math.abs(pos[index] - pos[i]) == index-i){
               return false;
           }
       }
       return true;
   }

   public void addToList(int n)
   {
      String[] res = new String[n];
      for (int i = 0; i < n; i++){
          StringBuilder row = new StringBuilder();
          for (int j = 0 ; j< n; j++){
              if (pos[i] == j){
                  row.append('Q');
              }
              else{
                  row.append('.');
              }
          }
          res[i] = row.toString();
      }
      
      resList.add(res);
   }
}

// bit manipulation, O(n)
public class Solution {
   public ArrayList<String[]> solveNQueens(int n){
        ArrayList<String[]> res = new ArrayList<String[]>();
        finder(new long[n], 0, 0, 0, 0, res);
        return res;
   }
   
   public void finder(long[] rows, int curr, long row, long lDiagonal, long rDiagonal, ArrayList<String[]> res){
        long validator = (1 << rows.length) - 1;  // 1 1 1 1 ... -> all 1s
        if (row == validator)   buildBoard(rows, res);
        else{
            long candidates = ((~(row | lDiagonal | rDiagonal)) & validator);
            while (candidates > 0){
                // pick up lowset bit
                long pos = (candidates & (0 - candidates));
                // remove it from candidates
                candidates -= pos;
                // add to result row array
                rows[curr] = pos;
                finder(rows, curr+1, (row | pos), ((lDiagonal | pos) << 1), ((rDiagonal | pos) >> 1), res);
            }
        }
   }
   
   public void buildBoard(long[] rows, ArrayList<String[]> res){
        String[] r = new String[rows.length];
        for (int i=0; i<rows.length; i++){
            r[i] = Long.toBinaryString(rows[i]).replace('0', '.').replace('1', 'Q');
            while (r[i].length() < rows.length) r[i] = '.' + r[i];  // add '.' to make the length matches
        }
        res.add(r);
   }
}

// Accepted, DFS, use int[][] board to mark the position of queuens
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
