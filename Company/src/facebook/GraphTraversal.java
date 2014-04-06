package facebook;

import org.junit.Test;

public class GraphTraversal {
   /*
    * Given the following 3 by 3 grid where the (first row, first column) is represented by (0,0):
    * (0,1), (1,2), (3,3)
    * (1,1), (3,3), (3,2)
    * (3,0), (1,3), null
    * we need to find if we can get to each cell in the table by following the cell locations at the
    * current cell we are at. We can only start at cell (0,0) and follow the cell locations from
    * that cell, to the cell it indicates and keep on doing the same for every cell.
    */

   // Maintain a variable to hold the number of visited cells
   // Set cell to (-1,-1) if it's visited
   // When we meet the visited cell, break and check number of visited cells
   // Take care of the null cell. This method will modify the original matrix
   // time: O(m*n); space: O(1)
   public boolean canTraversal(Cell[][] matrix) {
      if (matrix==null || matrix.length==0 || matrix[0].length==0)
         return false;
      int M = matrix.length, N = matrix[0].length;
      int count = M*N;
      int i=0, j=0;
      while (true){
         if (i<0 || i>=M || j<0 || j>=N)
            return count==0;
         Cell c = matrix[i][j];
         if (c==null)
            return count-1==0;
         if (isVisited(c))
            return count==0;
         i = c.x;
         j = c.y;
         setVisited(c);
         count--;
      }
   }
   
   private boolean isVisited(Cell c){
      return c.x==-1 && c.y==-1;
   }
   private void setVisited(Cell c){
      c.x = -1;
      c.y = -1;
   }

   private class Cell {
      int x;
      int y;

      public Cell(int x, int y) {
         this.x = x;
         this.y = y;
      }
   }
   
   @Test
   public void test(){
      Cell[][] matrix = new Cell[][]{
            {new Cell(0,1), new Cell(0,2), new Cell(1,2)},
            {new Cell(2,0), new Cell(1,0), new Cell(1,1)},
            {new Cell(2,1), new Cell(2,0), null}
      };
      System.out.println(canTraversal(matrix));
   }
}
