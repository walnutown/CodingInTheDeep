package slideshare;

import java.util.Arrays;

public class TicTacToeState {

   public enum State{
      XWin, OWin, Stalemate, Continue
   }
   /**
    * Write a program that takes in a tic-tac-toe board (3x3) as input 
    * (it can be in whatever representation or format you choose). 
    * You must determine which of the following four states the board is in: 
    * player X won, player O won, stalemate, continue playing.  
    */
   // 1 for X, -1 for O, 0 for blank
   public static void main(String[] args) {
      int[][] board = new int[][]{
            {-1,1,-1},
            {-1,1,1},
            {1,-1,1}};
      printBoard(board);
      System.out.println(getState(board));
   }
   
   public static State getState(int[][] board){
      int size = board.length;
      boolean hasBlank = false;
      int i, j;
      for (i=0; i<size; i++){
         for (j=1; j<size; j++){
            if (board[i][j] == 0)   hasBlank = true;
            if (board[i][j] != board[i][j-1])   break;
         }
         if (j==size){
            if (board[i][size-1] == 1)   return State.XWin;
            if (board[i][size-1] == -1)  return State.OWin;
         }
      }
      // check two diagonals
      for (i=1; i<size; i++){
         j = i;
         if (board[i][j] != board[i-1][j-1])    break;
      }
      if (i==size){
         if (board[size-1][size-1] == 1)   return State.XWin;
         if (board[size-1][size-1] == -1)  return State.OWin;
      }
      
      for (i=1; i<size; i++){
         j = size-1-i;
         if (board[i][j] != board[i-1][j+1])    break;
      }
      if (i==size){
         if (board[size-1][0] == 1)   return State.XWin;
         if (board[size-1][0] == -1)  return State.OWin;
      }
      
      return hasBlank? State.Continue : State.Stalemate;
   }
   
   public static void printBoard(int[][] board){
      for (int i=0; i<board.length; i++)
         System.out.println(Arrays.toString(board[i]));
   }

}
