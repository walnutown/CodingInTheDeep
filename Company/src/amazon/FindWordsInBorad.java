package amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindWordsInBorad {

   /**
    * Given a board of characters and a dictionary of words
    * find all the valid words in the board
    */
   // similar to WordSearch -- leetcode
   // One optimization is to get the min and max length of words in the dict, so that we can terminate the DFS earlier 
   public static void main(String[] args) {
      char[][] board = new char[][]{
            {'a', 'p', 'p', 'l'},
            {'g', 'o', 'o', 'g'},
            {'f', 'a', 'c', 'e'},
            {'l', 'i', 'n', 'k'},
      };
      String[] strs = new String[]{"appoc", "ecai", "pocaf", "kegop", "go", "ll"};
      Set<String> dict = new HashSet<String>(Arrays.asList(strs));
      System.out.println(findWordsInBoard(board, dict));
   }

   public static Set<String> findWordsInBoard(char[][] board, Set<String> dict){
      Set<String> words = new HashSet<String>();
      for (int i=0; i<board.length; i++){
         for (int j=0; j<board[0].length; j++){
            finder(board, i, j, dict, words, new boolean[board.length][board[0].length], new StringBuilder());
         }
      } 
      return words;
   }
   
   public static void finder(char[][] board, int x, int y, Set<String> dict, Set<String> words, boolean[][] visited, StringBuilder sb){
      if (x<0 || x>=board.length || y<0 || y>=board[0].length || visited[x][y])
         return;
      sb.append(board[x][y]);
      visited[x][y] = true;
      if (dict.contains(sb.toString())){
         words.add(sb.toString());
      }
      finder(board, x+1, y, dict, words, visited, sb);
      finder(board, x-1, y, dict, words, visited, sb);
      finder(board, x, y+1, dict, words, visited, sb);
      finder(board, x, y-1, dict, words, visited, sb);
      sb.deleteCharAt(sb.length()-1);
      visited[x][y] = false;
   }

}
