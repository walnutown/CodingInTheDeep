package ch11_sorting_searching;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class LongestIncreasingSubsequence {

   /**
    * Find the length of the longest increasing subsequence in an array of integers.
    * This subsequence is not necessarily contiguous.
    * e.g. [1,9,2], [1,2] or [1,9] is the longest increasing subsequence
    */

   /*
    * DP
    * dp[i] -- length of LIS ending at index i
    * time: O(n^2); space: O(n)
    */
   public int findLIS(int[] arr) {
      if (arr == null || arr.length == 0)
         return 0;
      int[] mem = new int[arr.length];
      mem[0] = 0;
      mem[1] = 1; // mem[i]: the length of longest increasing subsequence (including arr[i])
      for (int i = 2; i < arr.length; i++) {
         for (int j = 0; j < i; j++) {
            if (arr[i] > arr[j])
               mem[i] = Math.max(mem[i], mem[j] + 1);
         }
      }
      int max = 0;
      for (int num : mem) {
         max = Math.max(max, num);
      }
      return max;
   }

   /*
    * Patience Sorting. http://en.wikipedia.org/wiki/Patience_sorting
    * This is basically a greedy algorithm.
    * Maintain several piles, piles[i] stores the top element of the pile. In each pile, all
    * elements are in ascending order from top to bottom. The number of piles is the length of the
    * LIS. LIS can be recovered by taking the top element in each pile.
    * http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
    * time: O(nlgn)
    */
   public int findLIS2(int[] A) {
      if (A == null || A.length == 0)
         return 0;
      int N = A.length;
      ArrayList<Integer> piles = new ArrayList<Integer>();
      piles.add(A[0]);
      for (int i = 1; i < N; i++) {
         int index = binarySearchCeil(piles, A[i]);
         if (index == piles.size())
            piles.add(A[i]);
         else
            piles.set(index, A[i]);
         System.out.println(piles);
      }
      return piles.size();
   }
   
   private int binarySearchCeil(ArrayList<Integer> A, int target){
      int start = 0, end = A.size()-1;
      while (start<=end){
         int mid = start+(end-start)/2;
         if (A.get(mid)>=target)
            end = mid-1;
         else
            start = mid+1;
      }
      return start;
   }

   @Test
   public void test() {
      int[] arr = new int[] { 1, -2, 3, 9, 6, 8 };
      System.out.println(Arrays.toString(arr));
      System.out.println(findLIS(arr));
      System.out.println(findLIS2(arr));
   }

}
