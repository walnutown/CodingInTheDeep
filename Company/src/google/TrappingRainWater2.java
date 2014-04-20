package google;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;

public class TrappingRainWater2 {
   /*
    * Given a 2D matrix where each element represents the elevation(height) on that point, find how
    * many rain water it is able to hold.
    * For example, given the below 3×3 matrix:
    * 3 3 3
    * 3 0 3
    * 3 3 3
    * It should hold 3 units of rain water.
    */

   // This is the 2D version of Leetcode/TrappingRainWater
   // http://stackoverflow.com/questions/21818044/the-maximum-volume-of-trapped-rain-water-in-3d
   // http://blog.sina.com.cn/s/blog_b9285de20101j9a7.html

   // Sol1
   // The naive solution is to find the water that can be trapped in each position.
   // More specific, for each position, find all the paths from it to the border of
   // the matrix, we record the highest value on each path, and the final bar height
   // will be the minimum of those highest values.
   // time: O(n^4); space: O(1)

   // We can find that when we calculate the highest values on the path, there're lots of
   // duplicate calculations. We can optimize Sol1 through this observation.
   // Sol2
   // Maintain a mean heap, which holds the border cells of the matrix.
   // At first, add into the queue the cells on 4 sides of the matrix.
   // Each time, we pop the cell with mean height from the heap, 
   // add unvisited new cells into the heap, and update its height to final height after
   // it's filled by water
   // time: O(n^2*lgn); space: O(n^2)
   public int trapWater(int[][] M) {
      int N = M.length;
      PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(N * N, new Comparator<Cell>() {
         public int compare(Cell c1, Cell c2) {
            return c1.height - c2.height;
         }
      });
      boolean[][] visited = new boolean[N][N];
      initBorder(M, minHeap, visited);
      int sum = 0;
      while (!minHeap.isEmpty()) {
         Cell curr = minHeap.poll();
         ArrayList<Cell> neighbors = getNeighbors(curr, M, visited);
         for (Cell neighbor:neighbors){
            int finalHeight = Math.max(curr.height, neighbor.height);
            sum +=  finalHeight-neighbor.height;
            neighbor.height = finalHeight;
            minHeap.add(neighbor);
         }
      }
      return sum;
   }
   
   private void initBorder(int[][] M, PriorityQueue<Cell> minHeap, boolean[][] visited ){
      int N = M.length;
      for (int i = 0; i < N; i++) {
         minHeap.add(new Cell(0, i, M[0][i]));
         visited[0][i] = true;
         minHeap.add(new Cell(N-1, i, M[N - 1][i]));
         visited[N-1][i] = true;
      }
      for (int i = 1; i < N - 1; i++) {
         minHeap.add(new Cell(i, 0, M[i][0]));
         visited[i][0] = true;
         minHeap.add(new Cell(i, N-1, M[i][N - 1]));
         visited[i][N-1] = true;
      }
   }
   
   private ArrayList<Cell> getNeighbors(Cell c, int[][] M, boolean[][] visited){
      int i = c.i, j = c.j;
      ArrayList<Cell> neighbors = new ArrayList<Cell>();
      if (i-1>=0 && !visited[i-1][j]){
         neighbors.add(new Cell(i-1, j, M[i-1][j]));
         visited[i-1][j] = true;
      }
      if (i+1<M.length && !visited[i+1][j]){
         neighbors.add(new Cell(i+1, j, M[i+1][j]));
         visited[i+1][j] = true;
      }
      if (j-1>=0 && !visited[i][j-1]){
         neighbors.add(new Cell(i, j-1, M[i][j-1]));
         visited[i][j-1] = true;
      }
      if (j+1<M[0].length && !visited[i][j+1]){
         neighbors.add(new Cell(i, j+1, M[i][j+1]));
         visited[i][j+1] = true;
      }
      return neighbors;
   }

   private class Cell {
      int i;
      int j;
      int height;

      public Cell(int i, int j, int height) {
         this.i = i;
         this.j = j;
         this.height = height;
      }
      
      public String toString(){
         return height+"";
      }
   }
   
   @Test
   public void test(){
      int[][] M = new int[][]{
            {9,9,9,9},
            {9,0,0,9},
            {9,0,0,9},
            {9,9,9,9},
      };
      int[][] M1 = new int[][]{
            {9,9,9,9},
            {9,0,0,9},
            {9,0,0,9},
            {9,9,0,9},
      };
      int[][] M2 = new int[][]{
            {9,9,9,9},
            {9,0,0,9},
            {9,0,0,9},
            {9,9,1,9},
      };
      int[][] M3 = new int[][]{
            {9,9,9,9},
            {9,0,5,9},
            {9,0,0,9},
            {9,9,1,9},
      };
      System.out.println(trapWater(M));
      System.out.println(trapWater(M1));
      System.out.println(trapWater(M2));
      System.out.println(trapWater(M3));
   }

}
