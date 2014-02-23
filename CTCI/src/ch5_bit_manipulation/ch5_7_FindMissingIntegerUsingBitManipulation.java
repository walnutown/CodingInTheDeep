package ch5_bit_manipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ch5_7_FindMissingIntegerUsingBitManipulation {

   /**
    * An array A contains all the integers from 0 through n, except for one number which is missing.
    * In this problem, we cannot access an entire integer in A with a single operation. The elements
    * of A are represented in binary, and the only operation we can use to access them is
    * "fetch the j-th bit of A[i]" (j-th is from the least significant bit), which takes constant
    * time. Write code to find the missing integer. Can you do it in O(n) time?
    */
   public static void main(String[] args) {
      int[] nums = new int[] { 0, 1, 2, 3, 4, 6 };
      System.out.println(findMissingIntegerUsingBitManipulation(nums, 5));
   }

   // Recursion, check from the right-most digit, count the number of 0s and 1s in each digit
   // compare with FindOneMissingInteger & FindTwoMissingIntegers
   public static int findMissingIntegerUsingBitManipulation(int[] nums, int n) {
      if (nums == null || nums.length == 0)
         return 0;
      List<Integer> A = new ArrayList<Integer>();
      for (int num : nums)
         A.add(num);
      return finder(A, 0);
   }

   public static int finder(List<Integer> nums, int digit) {
      if (digit >=32)
         return 0;
      List<Integer> zeros = new ArrayList<Integer>();
      List<Integer> ones = new ArrayList<Integer>();
      for (int i = 0; i < nums.size(); i++) {
         int num = nums.get(i);
         if (getBit(num, digit) == 0)
            zeros.add(num);
         else
            ones.add(num);
      }
      if (zeros.size() <= ones.size()) {
         int v = finder(zeros, digit + 1);
         return (v << 1) | 0;
      } else {
         int v = finder(ones, digit + 1);
         return (v << 1) | 1;
      }

   }

   public static int getBit(int num, int index) {
      return (num>>index) & 1;
   }

}
