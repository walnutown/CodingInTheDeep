package ch17_moderate;

import java.util.Arrays;

public class ch17_6_SmallestUnsortedSubsequence {

   /**
    * Given an array of integers, write a method to find indices m and n such that if you sorted
    * elements m through n, the entire array would be sorted. Minimize n -m (that is, find the
    * smallest such sequence)
    */
   public static void main(String[] args) {
      int[] nums = new int[] { 1, 2, 3,5};
      System.out.println(Arrays.toString(smallestUnsortedSubsequence(nums)));
   }
   // <1> find longest increasing subsequence from left and right side
   // <2> shrink left and right sequence border according to min/max value of mid subsequence
   public static int[] smallestUnsortedSubsequence(int[] nums) {
      if (nums == null || nums.length <= 1)
         return null;
      int i = 0, j = nums.length - 1;
      while (i+1<nums.length && nums[i]<=nums[i+1])
         i++;
      while (j-1>=0 && nums[j]>=nums[j-1])
         j--;
      if (i>=j)
         return null;
      int midMin=Integer.MAX_VALUE, midMax = Integer.MIN_VALUE; 
      for (int k=i; k<=j; k++){
         midMin = Math.min(midMin, nums[k]);
         midMax = Math.max(midMax, nums[k]);
      }
      while (i>=0 && nums[i]>midMin)
         i--;
      while (j<nums.length && nums[j]<midMax)
         j++;  
      return Arrays.copyOfRange(nums, i+1, j);
   }

}
