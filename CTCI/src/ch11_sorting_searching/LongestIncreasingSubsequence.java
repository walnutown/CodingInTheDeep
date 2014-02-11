package ch11_sorting_searching;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

   /*
    * Find the length of the longest increasing subsequence in an array of integers
    */
   public static void main(String[] args) {
      int[] arr = new int[]{1,-2, 3, 5, 6, 8};
      System.out.println(Arrays.toString(arr));
      System.out.println(findLIS(arr));
   }
   
   public static int findLIS(int[] arr){
      if (arr == null || arr.length == 0)
         return 0;
      int[] mem = new int[arr.length];
      mem[0] = 0;
      mem[1] = 1; // mem[i]: the longest increasing subsequence including arr[i]
      for (int i = 2; i < arr.length ; i++){
         for (int j = 0; j < i; j++){
            if (arr[i] > arr[j])
               mem[i] = Math.max(mem[i], mem[j]+1);
         }
      }
      int max = 0;
      for (int num : mem){
         max = Math.max(max, num);
      }
      return max;
   }

}
