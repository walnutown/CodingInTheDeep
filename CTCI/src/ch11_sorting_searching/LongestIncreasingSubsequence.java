package ch11_sorting_searching;

import java.util.Arrays;

import org.junit.Test;

public class LongestIncreasingSubsequence {

   /*
    * Find the length of the longest increasing subsequence in an array of integers.
    * This subsequence is not necessarily contiguous.
    * e.g. [1,9,2], [1,2] or [1,9] is the longest increasing subsequence
    */
   
   /*
    * DP, memoize the LIS ending at index i, and then traverse to get max
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
    * Patience Sorting. Maintain potential longest increasing subsequences and update their tail elements
    * the list at index i has i+1 elements
    * refer: http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
    * time: O(nlgn)
    */
   public int findLIS2(int[] A){
      if (A==null || A.length==0)
         return 0;
      int N = A.length;
      int[] tails = new int[N];
      tails[0] = A[0];
      int len = 1;
      for (int i=1; i<N; i++){
         if (A[i]<tails[0])
            tails[0] = A[i];
         else if (A[i] > tails[len-1])
            tails[len++] = A[i];
         else
            tails[ceilIndex(tails, -1, len-1, A[i])] = A[i];
         System.out.println(Arrays.toString(tails));
      }
      return len;
   }
   
   // binary search the index of list and update its tail element
   private int ceilIndex(int[] tails, int start, int end, int key){
      while (start<end){
         int mid = (start+end)>>1;
         if (tails[mid]root<key)
            start = mid+1;
         else
            end = mid;
      }
      return end;
   }

   @Test
   public void test() {
      int[] arr = new int[] { 1, -2, 3, 9, 6, 8 };
      System.out.println(Arrays.toString(arr));
      System.out.println(findLIS(arr));
      System.out.println(findLIS2(arr));
   }

}
