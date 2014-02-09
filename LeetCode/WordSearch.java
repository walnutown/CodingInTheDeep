/*
  Given a 2D board and a word, find if the word exists in the grid.

  The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

  For example,
  Given board =

  [
    ["ABCE"],
    ["SFCS"],
    ["ADEE"]
  ]
  word = "ABCCED", -> returns true,
  word = "SEE", -> returns true,
  word = "ABCB", -> returns false.
*/

// Use a boolean matrix to mark visited node
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

// TLE, encode coordinates to mark the visited ones
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

