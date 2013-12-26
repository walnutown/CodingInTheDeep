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


// Submission Result: Wrong Answer

// Input:   ["a"], "a"
// Output:  false
// Expected:   true
public class Solution {
    public boolean exist(char[][] board, String word) {
        return finder(board, 0, 0, word, 0, new HashSet<Integer>());    // should start from any point on the board
    }
    
    public int encode(int x, int y){
        return x * 7 + y * 9;
    }
    
    public boolean finder(char[][] board, int x, int y, String word, int index, Set<Integer> visited){
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || visited.contains(encode(x,y)))   return false;
        if (index == word.length()) return true;
        if (board[x][y] != word.charAt(index))  return false;
        visited.add(encode(x,y));
        boolean exist = false;
        exist = finder(board, x+1, y, word, index+1, visited) || finder(board, x-1, y, word, index+1, visited) || finder(board, x, y-1, word, index+1, visited) || finder(board, x, y+1, word, index+1, visited);
        visited.remove(encode(x,y));
        return exist;
    } 
}

// TLE
public class Solution {
    public boolean exist(char[][] board, String word) {
        boolean exist = false;
        for (int i = 0 ; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                exist = exist || finder(board, i, j, word, 0, new HashSet<Integer>());
            }
        }
        return exist;
    }
    
    public int encode(int x, int y){
        return x * 7 + y * 9;
    }
    
    public boolean finder(char[][] board, int x, int y, String word, int index, Set<Integer> visited){
        if (index == word.length()) return true;
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || visited.contains(encode(x,y)))   return false;
        if (board[x][y] != word.charAt(index))  return false;
        visited.add(encode(x,y));
        boolean exist = false;
        exist = finder(board, x+1, y, word, index+1, visited) || finder(board, x-1, y, word, index+1, visited) || finder(board, x, y-1, word, index+1, visited) || finder(board, x, y+1, word, index+1, visited);
        visited.remove(encode(x,y));
        return exist;
    }
    
}

// Accepted, directly uses a boolean matrix to mark visited node
public class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0 ; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == word.charAt(0))       // pruning here
                    if (finder(board, i, j, word, 0, new boolean[board.length][board[0].length]))    return true;
            }
        }
        return false;
    }
   
    public boolean finder(char[][] board, int x, int y, String word, int index, boolean[][] visited){
        if (board[x][y] != word.charAt(index))  return false;
        if (index == word.length()-1) return true;
        visited[x][y] = true;
        if (x+1 < board.length && !visited[x+1][y] && finder(board, x+1, y, word, index+1, visited))  return true;      // directly return , to prune
        if (x-1 >= 0 && !visited[x-1][y] && finder(board, x-1, y, word, index+1, visited))  return true;
        if (y-1 >= 0 && !visited[x][y-1] && finder(board, x, y-1, word, index+1, visited))  return true;
        if (y+1 < board[0].length && !visited[x][y+1] && finder(board, x, y+1, word, index+1, visited))  return true;
        visited[x][y] = false;
        return false;
    }
    
}