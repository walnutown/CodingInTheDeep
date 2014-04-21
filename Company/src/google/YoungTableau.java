package google;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;

public class YoungTableau {
   /*
    * Given a N*N Matrix.
    * All rows are sorted, and all columns are sorted.
    * Find the Kth Largest element of the matrix.
    */
   // http://www.careercup.com/question?id=6335704
   
   // This is actually a variant of merge sort.
   // Each row in the matrix can be regarded as a array of size N
   // Then the question becomes to merge sort M arrays of size N
   // time: O(klgk); sapce: O(k)
   public ArrayList<Integer> getKthLargestInYoungTableau(int[][] matrix, int k){
      int M = matrix.length, N = matrix[0].length;
      ArrayList<Integer> res = new ArrayList<Integer>();
      PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>(){
         public int compare(Cell c1, Cell c2){
            return c1.val - c2.val;
         }
      });
      for (int i=0; i<M; i++)
         minHeap.add(new Cell(i, 0, matrix[i][0]));
      while (--k>=0 && !minHeap.isEmpty()){
         Cell curr = minHeap.poll();
         if (curr.y+1<N)
            minHeap.add(new Cell(curr.x, curr.y+1, matrix[curr.x][curr.y+1]));
         res.add(curr.val);
      }
      return res;
   }
   
   class Cell{
      int x;
      int y;
      int val;
      public Cell(int x, int y, int val){
         this.x = x;
         this.y = y;
         this.val = val;
      }
   }
   
   @Test
   public void test(){
      int[][] matrix = new int[][]{
            {1,3,5,7},
            {2,4,6,8},
            {3,5,7,9},
            {4,6,8,10}
      };
      System.out.println(getKthLargestInYoungTableau(matrix, 3));
      System.out.println(getKthLargestInYoungTableau(matrix, 16));
   }
}
