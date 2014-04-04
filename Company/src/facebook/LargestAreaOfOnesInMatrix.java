package facebook;

import java.util.ArrayList;

import org.junit.Test;

public class LargestAreaOfOnesInMatrix {
   /*
    * Given a matrix consisting of 0's and 1's, find the largest connected component consisting of
    * 1's.
    */
   
   // dfs each connected area and find the max
   // we maintain a visited matrix to avoid revisiting
   // time: O(m*n); space: O(m*n)
   public int getMaxArea(int[][] matrix) {
      if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
         return 0;
      int max = 0;
      int M = matrix.length, N = matrix[0].length;
      boolean[][] visited = new boolean[M][N];
      for (int i = 0; i < M; i++) {
         for (int j = 0; j < N; j++) {
            if (matrix[i][j] == 1 && !visited[i][j]) {
               ArrayList<Integer> r = new ArrayList<Integer>();
               dfs(matrix, i, j, visited, r);
               max = Math.max(max, r.size());
            }
         }
      }
      return max;
   }

   private void dfs(int[][] matrix, int i, int j, boolean[][] visited, ArrayList<Integer> r) {
      if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j] || matrix[i][j] == 0)
         return;
      r.add(matrix[i][j]);
      visited[i][j] = true;
      dfs(matrix, i - 1, j, visited, r);
      dfs(matrix, i, j - 1, visited, r);
      dfs(matrix, i + 1, j, visited, r);
      dfs(matrix, i, j + 1, visited, r);
   }

   @Test
   public void test() {
      int[][] matrix = new int[][] { { 1, 1, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 1, 1 },
            { 1, 0, 1, 1 }, };
      System.out.println(getMaxArea(matrix));
   }

}