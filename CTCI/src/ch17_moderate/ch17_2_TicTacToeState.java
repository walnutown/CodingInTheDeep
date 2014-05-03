package ch17_moderate;

public class ch17_2_TicTacToeState {

   /**
    * Design an algorithm to figure out if someone has win a game of tic-tac-toe
    */
   
   // similar to TicTacToeState(Company/slideshare)
   // Note"
   // consider one more point: How to improve the performance if we have to check state
   // in each step?

   // if the board is small (typical size is 3), we can store the all board states (3^9) in a map
   // the key is unique, representing the state of all cells in board, value is the result of the
   // board
   // one key for example, 3^0*c1 + 3^1*c2 + 3^2*c3+ ...

}
