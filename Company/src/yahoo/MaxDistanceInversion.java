package yahoo;

import org.junit.Test;

public class MaxDistanceInversion {
   /**
    * Given an array arr[], find the maximum j Ð i such that arr[j] > arr[i].
    */
   // http://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/

   // This question is actually a variant of Leetcode/TrappingRainWater
   // We also have to get max/min value on left and right side of an element
   // The way to reduce computation is to pre-process the max and min

   // [1] get left min for each element
   // [2] get right max for each element
   // [3] find max distance
   // time: O(n); space: O(n)
   public int getMax(int[] A) {
      int N = A.length;
      int[] lmin = new int[N], rmax = new int[N];
      lmin[0] = A[0];
      rmax[N - 1] = A[N - 1];
      for (int i = 1; i < N; i++) {
         lmin[i] = Math.min(lmin[i - 1], A[i]);
      }
      for (int i = N - 2; i >= 0; i--) {
         rmax[i] = Math.max(rmax[i + 1], A[i]);
      }
      int i = 0, j = 0, maxDistance = 0;
      while (i < N && j < N) {
         if (lmin[i] < rmax[j]) {
            maxDistance = Math.max(maxDistance, j - i);
            j++;    // increment j to find potential farther j
         } else {
            i++;    // increment i to find smaller lmin[i] so that lmin[i]<rmax[j]
         }
      }
      return maxDistance;
   }

   @Test
   public void test() {
      int[] A = new int[] { 34, 8, 10, 3, 2, 80, 30, 33, 1 };
      System.out.println(getMax(A));
   }
}
