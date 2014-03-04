package groupon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FillBoardWithWords {

   /**
    * Given 16 characters (include duplicates) and a dictionary of words (each in 4 characters)
    * , fill the board (4*4 matrix) with valid words in the dictionary -- each row and column should
    * be a valid word
    */
   public final static int SIZE = 4;

   public static void main(String[] args) {
      char[][] board = new char[SIZE][SIZE];
      String[] strs = new String[] { "appl", "goog", "link", "agfl", "pocn", "lgek", "face", "poai" };
      Set<String> dict = new HashSet<String>(Arrays.asList(strs));
      char[] chars = new char[] { 'a', 'p', 'p', 'l', 'g', 'f', 'a', 'c', 'l', 'e', 'g', 'o', 'o',
            'i', 'n', 'k' };
      ArrayList<Character> charList = new ArrayList<Character>();
      for (char ch : chars) {
         charList.add(ch);
      }
      fillBoardWithWords(board, charList, dict);
      printBoard(board);
   }
   
   // O(n*n*16*n)
   // instead of set, we can also use a trie here
   public static void fillBoardWithWords(char[][] board, ArrayList<Character> charList, Set<String> dict) {
      Set<String> set = new HashSet<String>();
      for (String w : dict) {
         for (int i = 0; i < w.length(); i++) {
            set.add(w.substring(0, i + 1));
         }
      }
      solver(board, charList, 0, 0, set);
   }
   
   // O(16*n), n is the size of the board
   public static boolean solver(char[][] board, ArrayList<Character> charList, int x, int y, Set<String> set) {
      if (x == SIZE)
         return true;
      if (y == SIZE) {
         return solver(board, charList, x + 1, 0, set);
      }

      StringBuilder rowWord = new StringBuilder(), colWord = new StringBuilder();
      for (int i = 0; i < x; i++)
         colWord.append(board[i][y]);
      for (int j = 0; j < y; j++)
         rowWord.append(board[x][j]);
      for (int i = 0; i < charList.size(); i++) {
         char ch = charList.get(i);
         colWord.append(ch);
         rowWord.append(ch);
         if (set.contains(colWord.toString()) && set.contains(rowWord.toString())) {
            board[x][y] = ch;
            ArrayList<Character> tmp = new ArrayList<Character>(charList);
            tmp.remove(i);
            if (solver(board, tmp, x, y + 1, set))
               return true;
            board[x][y] = '\u0000';
         }
         colWord.deleteCharAt(colWord.length() - 1);
         rowWord.deleteCharAt(rowWord.length() - 1);
      }
      return false;
   }

   public static void printBoard(char[][] board) {
      for (int i = 0; i < board.length; i++)
         System.out.println(Arrays.toString(board[i]));
   }

}
