package ch17_moderate;

import java.util.Arrays;

public class ch17_1_SwapInPlace {

   /**
    * Write a function to swap two numbers in place (that is, without temporary variable)
    */
   public static void main(String[] args) {
      int[] nums = new int[]{3,4};
      System.out.println(Arrays.toString(nums));
      swapInPlace(nums);
      System.out.println(Arrays.toString(nums));
      swapInPlace2(nums);
      System.out.println(Arrays.toString(nums));
   }
   
   public static void swapInPlace(int[] nums){
      nums[0] = nums[0] + nums[1];
      nums[1] = nums[0] - nums[1];
      nums[0] = nums[0] - nums[1];
   }
   
   public static void swapInPlace2(int[] nums){ 
      nums[0] = nums[0] ^ nums[1];
      nums[1] = nums[0] ^ nums[1];
      nums[0] = nums[0] ^ nums[1];
   }

}
