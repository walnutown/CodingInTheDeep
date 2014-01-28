package rocketfuel;

/*
 * You are standing in a rectangular room and are about to fire a laser toward the east wall. Inside
 * the room a certain number of prisms have been placed. They will alter the direction of the laser
 * beam if it hits them. There are north-facing, east-facing, west-facing, and south-facing prisms.
 * If the laser beam strikes an east-facing prism, its course will be altered to be East, regardless
 * of what direction it had been going in before. If it hits a south-facing prism, its course will
 * be altered to be South, and so on. You are interested to know how far the laser will travel
 * before it hits a wall.
 * INPUT
 * Your program must read the room description from standard input. The room is represented as a
 * character array. The width and height of the array are the width and height of the room. The
 * characters inside the array denote the placement of the prisms and the laser's starting position.
 * Each line of input from STDIN represents a row of the array.
 * The number of lines/elements will not be specified in the input, so the program will have to keep
 * reading from STDIN until there are no more lines to read and determine the total number of
 * elements based on the input. However, the number of lines of input will be at most 50. Each line
 * will contain the same number of characters.
 * The resulting character array will contain exactly one '@' character, representing the laser's
 * position in the room, and any number of characters from the set {"^", "V", "<", ">", "-"}. The
 * first four of these represent prisms that are guaranteed to direct the laser in the direction in
 * which they are pointing. The "^" character directs the laser north, "<" directs it to the west,
 * and so on. The "-" character represents empty space.
 * OUTPUT
 * Your program should print to standard out a single string, terminated by a newline, representing
 * the distance that the laser will travel before hitting a wall. For example, if the laser travels
 * a distance of 14 cells before hitting a wall, then your program should print the string "14" to
 * STDOUT. Your program should treat the "@'"symbol the same as the "-" character, that is, as empty
 * space. So the laser will pass through the original location from which it was fired.
 * If the laser will get caught in an infinite loop, then your program should print "-1" to STDOUT.
 * Directions:
 * Please code this problem in Java, C++, C, or Python (all else being equal, we prefer Java) using
 * best coding practices.
 * NOTE: If you download the attached .zip file of examples, and you are running Windows, do not
 * look at them using the windows program "Notepad", because this will not show the carriage returns
 * properly in the input files. Look at them with WordPad. Each input file should consist of
 * multiple lines, each of the same length.
 * What We Are Looking For:
 * We are looking for clear, concise, well-documented, modular code that reflects good design,
 * object-oriented principles, and understanding of appropriate data structures. We not only want to
 * see code that works, but code that is as beautiful as you can make it according to your personal
 * coding aesthetic.
 * Examples:
 * Input:
 * @--
 * ---
 * ---
 * Output: 3
 * Input:
 * @-v
 * ---
 * ---
 * ---
 * Output: 6
 * Input:
 * @-v-
 * ----
 * --<-
 * Output: 7
 * Input:
 * @-v
 * ---
 * -^<
 * Output: 8
 * Input:
 * @-v
 * ->-
 * -^<
 * Output: 8
 * Input:
 * @-v
 * ->v
 * -^<
 * Output: -1
 */

/* Enter your code here. Read input from STDIN. Print output to STDOUT */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Laser {
   private static final char START = '@';
   private static final char EAST = '>';
   private static final char WEST = '<';
   private static final char NORTH = '^';
   private static final char SOUTH = 'v';
   private static final char NONE = '-';

   public Laser() {
   }

   public static void main(String[] args) {
      int num = Integer.MIN_VALUE;
      try{
      Laser laser = new Laser();
      Board board = laser.initBoard();
      System.out.println(board);
      
      num = laser.play(board, EAST);
      // num = Math.max(num, s.play(board, Direction.West));
      // num = Math.max(num, s.play(board, Direction.North));
      // num = Math.max(num, s.play(board, Direction.South));
      System.out.println(num);
      System.out.println("");
      }catch(InfiniteLoopException e){
         num = -1;
      }catch (Exception e) {
         e.printStackTrace();
      }finally{
         System.out.println(num);
      }
   }

   /**
    * Play the game
    * 
    * @param direct is the starting direction of the laser
    * @throws Exception 
    */
   public static int play(Board board, char direct) throws Exception {
      Cell curr = board.getStart();
      Cell next = null;
      int count = 1;
      while (true) {
         // find next cell
         curr.visit();
         if (direct == SOUTH) {
            next = board.getCell(curr.getX() + 1, curr.getY());
            if (next == null)
               break;
         } else if (direct == NORTH) {
            next = board.getCell(curr.getX() - 1, curr.getY());
            if (next == null)
               break;
         } else if (direct == WEST) {
            next = board.getCell(curr.getX(), curr.getY() - 1);
            if (next == null)
               break;
         } else if (direct == EAST) {
            next = board.getCell(curr.getX(), curr.getY() + 1);
            if (next == null)
               break;
         }
         // if there's a prism, do redirection
         char next_value = next.getValue();
         if ( next_value==EAST || next_value==WEST || next_value==SOUTH || next_value==NORTH){
            if (next.isVisited())   // if the prism has been visited, infinite
               throw new InfiniteLoopException("Infinite Loop");
            direct = next_value;
         }
         count++;
         curr = next;
      }
      return count;
   }

   /**
    * Initialize board configuration according to the input
    */
   public static Board initBoard() throws IOException {
      // Scanner in = new Scanner(System.in);
      Scanner in = new Scanner(new File("src/rocketfuel/input005.txt"));
      int colNum = 0;
      int rowNum = 0;
      StringBuilder sb = new StringBuilder();
      while (in.hasNextLine()) {
         String line = in.nextLine();
         if (rowNum == 0)
            colNum = line.length();
         sb.append(line);
         sb.append("\n");
         rowNum++;
      }
      Board board = new Board(rowNum, colNum);
      in = new Scanner(sb.toString());
      int row = 0;
      while (in.hasNextLine()) {
         String line = in.nextLine();
         for (int col = 0; col < line.length(); col++) {
            char curr = line.charAt(col);
            if (curr != NONE)
               board.setCellValue(row, col, curr);
            if (curr == START) // mark the starting point of the laser
               board.setStart(row, col);
         }
         row++;
      }
      return board;
   }

   /*
    * Board is a matrix of Cells
    */
   static class Board {
      private Cell[][] board;
      private int rowNum;
      private int colNum;
      private Cell start;

      public Board(int rowNum, int colNum) {
         this.rowNum = rowNum;
         this.colNum = colNum;
         board = new Cell[rowNum][colNum];
         for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
               board[i][j] = new Cell(i, j);
            }
         }
      }

      public Board(Board b) {
         this.rowNum = b.getRowNum();
         this.colNum = b.getColNum();
         board = new Cell[rowNum][colNum];
         for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
               board[i][j] = new Cell(b.getCell(i, j));
            }
         }
      }

      public void setStart(int row, int col) {
         start = new Cell(row, col, START);
      }

      public Cell getStart() {
         return start;
      }

      public Cell getCell(Cell c) {
         return this.getCell(c.getX(), c.getY());
      }

      public Cell getCell(int row, int col) {
         if (row < 0 || row >= this.getRowNum() || col < 0 || col >= this.getColNum())
            return null;
         return board[row][col];
      }

      public void setCellValue(int row, int col, char val) {
         if (row < 0 || row >= this.getRowNum() || col < 0 || col >= this.getColNum())
            return;
         this.getCell(row, col).setValue(val);
      }

      public int getRowNum() {
         return rowNum;
      }

      public int getColNum() {
         return colNum;
      }

      public String toString() {
         StringBuilder sb = new StringBuilder();
         for (int i = 0; i < this.getRowNum(); i++) {
            for (int j = 0; j < this.getColNum(); j++) {
               sb.append(this.getCell(i, j).getValue());
               sb.append(" ");
            }
            sb.append("\n");
         }
         sb.deleteCharAt(sb.length() - 1);
         return sb.toString();
      }
   }

   /*
    * Cell, store the location and value of a cell on the board
    */
   static class Cell {
      private int x;
      private int y;
      private char value;
      private boolean visited;

      public Cell() {
         x = 0;
         y = 0;
         this.setValue(NONE);
         visited = false;
      }

      public Cell(int x, int y) {
         this.x = x;
         this.y = y;
         this.setValue(NONE);
         visited = false;
      }

      public Cell(int x, int y, char val) {
         this.x = x;
         this.y = y;
         this.setValue(val);
         visited = false;
      }

      public Cell(Cell c) {
         x = c.getX();
         y = c.getY();
         this.setValue(c.getValue());
         visited = c.isVisited();
      }
      
      public void visit(){
         visited = true;
      }
      
      public boolean isVisited(){
         return visited;
      }

      public int getX() {
         return x;
      }

      public int getY() {
         return y;
      }

      public char getValue() {
         return value;
      }

      public void setValue(char value) {
         this.value = value;
      }

      public String toString() {
         return "[" + this.getX() + ", " + this.getY() + "]";
      }
   }
   
   public static class InfiniteLoopException extends Exception{
      public InfiniteLoopException(String message){
         super(message);
      }
   }
}