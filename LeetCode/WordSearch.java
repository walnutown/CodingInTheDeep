// TLE in large judge
public class Solution {
    int mWidth;
   int mHeight;
    
    public boolean exist(char[][] board, String word)
   {
      // Start typing your Java solution below
      // DO NOT write main() function
      if (word == null || word.length() == 0)
      {
         return true;
      }
      mWidth = board[0].length;
      mHeight = board.length;
      if (mWidth * mHeight < word.length())
      {
         return false;
      }

      for (int j = 0; j < mHeight; j++)
      {
         for (int k = 0; k < mWidth; k++)
         {
            if (board[j][k] == word.charAt(0))
            {
               if (DFS(board, j, k, word, 0) == true)
               {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public boolean DFS(char[][] board, int row, int col, String word, int index)
   {
      if (index == word.length())
      {
         return true;
      }
      if (row < 0 || row >= mHeight || col < 0 || col >= mWidth )
      {
         return false;
      }
      
      
      if (board[row][col] != word.charAt(index)){
         return false;
      }
      char temp = board[row][col];
      board[row][col] = '$';
      
      boolean  flag = DFS(board, row - 1, col, word, index + 1) || DFS(board, row + 1, col, word, index + 1) || DFS(board, row, col - 1, word, index + 1) || DFS(board, row, col + 1, word, index + 1);
      board[row][col] = temp;
      return flag;
   }
}

// pass both
public class Solution {
    int mWidth;
   int mHeight;
   boolean[][] visited;
    
    public boolean exist(char[][] board, String word)
   {
      // Start typing your Java solution below
      // DO NOT write main() function
      if (word == null || word.length() == 0)
      {
         return true;
      }
      mWidth = board[0].length;
      mHeight = board.length;
      visited = new boolean[mHeight][mWidth];
      if (mWidth * mHeight < word.length())
      {
         return false;
      }

      for (int j = 0; j < mHeight; j++)
      {
         for (int k = 0; k < mWidth; k++)
         {
            if (board[j][k] == word.charAt(0))
            {
               if (DFS(board, j, k, word, 0) == true)
               {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public boolean DFS(char[][] board, int row, int col, String word, int index)
   {
      
      if (board[row][col] != word.charAt(index)){
         return false;
      }
      if (index == word.length() -1)
      {
         return true;
      }
      char temp = board[row][col];
      visited[row][col] = true;
      if (row -1 >= 0 && !visited[row-1][col] && DFS(board, row - 1, col, word, index + 1)){
          return true;
      }
      if (row +1 < mHeight && !visited[row+1][col] && DFS(board, row + 1, col, word, index + 1)){
          return true;
      }
      if (col-1 >= 0 && !visited[row][col-1] && DFS(board, row, col - 1, word, index + 1) ){
          return true;
      }
      if (col+1 < mWidth && !visited[row][col+1] && DFS(board, row, col + 1, word, index + 1)){
          return true;
      }
      
      visited[row][col] = false;
      return false;
   }
}