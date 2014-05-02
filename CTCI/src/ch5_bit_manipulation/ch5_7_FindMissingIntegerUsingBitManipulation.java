package ch5_bit_manipulation;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ch5_7_FindMissingIntegerUsingBitManipulation {

   /**
    * An array A contains all the integers from 0 through n, except for one number which is missing.
    * In this problem, we cannot access an entire integer in A with a single operation. The elements
    * of A are represented in binary, and the only operation we can use to access them is
    * "fetch the j-th bit of A[i]" (j-th is starting from the least significant bit), which takes
    * constant time. Write code to find the missing integer. Can you do it in O(n) time?
    */

   // Variant of FindOneMissingInteger & FindTwoMissingIntegers

   // Key observation: if we have all numbers from 0-n, the number of zeros in each digit is always
   // larger than or equal to the number of ones. If count(0) <= count(1) in i-th digit, the i-th digit
   // of the missing number should be 0; otherwise, it should be 1. We recursively get each digit of
   // the missing number.
   // Besides, since we know that the missing number's value in i-th digit, we can narrow down the serach
   // range to 'ones' or 'zeros'
   // time: O(32n); space: O(32n)
   public int findMissingIntegerUsingBitManipulation(int[] nums, int n) {
      if (nums == null || nums.length == 0)
         return 0;
      List<Integer> A = new ArrayList<Integer>();
      for (int num : nums)
         A.add(num);
      return finder(A, 0);
   }

   private int finder(List<Integer> nums, int digit) {
      if (digit >= 32)
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
         // this digit of the missing number is 0, we narrow down the search range to numbers with 0
         // in this digit
         int v = finder(zeros, digit + 1);
         return (v << 1) | 0;
      } else {
         int v = finder(ones, digit + 1);
         return (v << 1) | 1;
      }
   }

   private int getBit(int num, int index) {
      return (num >> index) & 1;
   }

   @Test
   public void test() {
      int[] nums = new int[] { 0, 1, 2, 3, 4, 6 };
      System.out.println(findMissingIntegerUsingBitManipulation(nums, 5));
   }

}
