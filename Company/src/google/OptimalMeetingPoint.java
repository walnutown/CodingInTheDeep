package google;

import java.util.Arrays;

import org.junit.Test;

public class OptimalMeetingPoint {

   /*
    * There is a matrix, m x n. Several groups of people locate at some certain spots. In the
    * following example, there are three groups and the number 4 indicates there are four people in
    * this group. Now we want to find a meeting point in the matrix so that the cost of all groups
    * moving to that point is the minimum. As for how to compute the cost of moving one group to
    * another point, please see the following example.
    * Group1: (0, 1), 4
    * Group2: (1, 3), 3
    * Group3: (2, 0), 5
    * . 4 . .
    * . . . 3
    * 5 . . .
    * If all of these three groups moving to (1, 1), the cost is: 4*((1-0)+(1-1)) +
    * 5*((2-1)+(1-0))+3*((1-1)+(3-1))
    */

   // http://www.careercup.com/question?id=12994675
   // http://www.careercup.com/question?id=4807138387951616
   
   // First, we know that the metric here is Manhattan distance, not Euclidean distance
   // for distance metric, see below
   // http://math.stackexchange.com/questions/139600/euclidean-manhattan-distance
   
   // Think about the one-dimensional question first. With 3 groups in a line,
   // how to find the optimal meeting point? We can traverse the N points in the line,
   // and get the cost of moving each group to that point. This seems to take O(N*k),
   // yet it can be done in O(N). We can get Cost[x] from Cost[x-1] in constant time
   // Now, back to the two-dimensional question. The optimal meeting point is actually
   // the point with minimum x-dimensional cost and minimum y-dimensional cost. Thus, we 
   // can divide it into two separate steps.
   // time: O(m*n); space: O(m+n)
   public int[] getOptimalMeetingPoint(int[][] matrix){
      int[] res = new int[2];
      res[0] = getOptimalMeetingPointInX(matrix);
      res[1] = getOptimalMeetingPointInY(matrix);
      return res;
   }
   
   private int getOptimalMeetingPointInX(int[][] matrix){
      int M = matrix.length, N = matrix[0].length;
      int[] X = new int[N];  // all the number of persons in i-th column
      for (int i=0; i<M; i++){
         for (int j=0;j<N; j++)
            X[j] += matrix[i][j];
      }
      int[] prefixSum = new int[N], suffixSum = new int[N]; // get prefix sum and suffix sum of each position in X
      for (int i=1; i<N; i++)
         prefixSum[i] = prefixSum[i-1] + X[i-1];
      for (int i=N-2; i>=0; i--)
         suffixSum[i] = suffixSum[i+1] + X[i+1];
      int[] cost = new int[N];
      for (int i=0; i<N; i++){  // get initial cost on left-most side
         if (X[i]>0)
            cost[0] += X[i]*i;
      }
      for (int i=1; i<N; i++)
         cost[i] = cost[i-1] + prefixSum[i] - suffixSum[i]-X[i];
      int minIndex = 0;
      for (int i=0; i<N; i++){
         if (cost[i]<cost[minIndex])
            minIndex = i;
      }
      return minIndex;
   }
   
   private int getOptimalMeetingPointInY(int[][] matrix){
      int M = matrix.length, N = matrix[0].length;
      int[] Y = new int[M];  // all the number of persons in i-th row
      for (int i=0; i<M; i++){
         for (int j=0;j<N; j++)
            Y[i] += matrix[i][j];
      }
      int[] prefixSum = new int[M], suffixSum = new int[M];
      for (int i=1; i<M; i++)
         prefixSum[i] = prefixSum[i-1] + Y[i-1];
      for (int i=M-2; i>=0; i--)
         suffixSum[i] = suffixSum[i+1] + Y[i+1];
      int[] cost = new int[M];
      for (int i=0; i<M; i++){
         if (Y[i]>0)
            cost[0] += Y[i]*i;
      }
      for (int i=1; i<M; i++)
         cost[i] = cost[i-1] + prefixSum[i] - suffixSum[i]-Y[i];
      int minIndex = 0;
      for (int i=0; i<M; i++){
         if (cost[i]<minIndex)
            minIndex = i;
      }
      return minIndex;
   }
   
   @Test
   public void test(){
      int[][] matrix = new int[][]{
            {9,9,9},
            {9,0,9},
            {9,9,9}
      };
      int[][] matrix1 = new int[][]{
            {0,0,1},
            {0,0,0},
            {0,0,0}
      };
      int[][] matrix2 = new int[][]{
            {1,0,2},
            {0,0,0},
            {0,0,0}
      };
      int[][] matrix3 = new int[][]{
            {0,0,1},
            {0,0,0},
            {0,0,2}
      };
      int[][] matrix4 = new int[][]{
            {1,0,2},
            {0,2,0},
            {0,0,0}
      };
      int[][] matrix5 = new int[][]{
            {1,0,2},
            {0,0,0},
            {0,2,0}
      };
      System.out.println(Arrays.toString(getOptimalMeetingPoint(matrix)));
      System.out.println(Arrays.toString(getOptimalMeetingPoint(matrix1)));
      System.out.println(Arrays.toString(getOptimalMeetingPoint(matrix2)));
      System.out.println(Arrays.toString(getOptimalMeetingPoint(matrix3)));
      System.out.println(Arrays.toString(getOptimalMeetingPoint(matrix4)));
      System.out.println(Arrays.toString(getOptimalMeetingPoint(matrix5)));
   }
   
}
