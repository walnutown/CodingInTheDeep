package ch9_recursion_dynamic_programming;

import java.util.Arrays;

import org.junit.Test;

public class ch9_3_MagicIndex {

   /**
    * Magic Index : A[i] = i
    * Given a sorted array of distinct integers, write a method to find a magic index in A
    * If no one exists, return -1
    */

   // Sol1
   // The naive solution is to traverse each index
   // time: average case O(n); space: O(1)

   // Sol2
   // One optimization to Sol1 is based on the following observation
   // if i < A[i], for all j>i, j<A[j], because A is a distinct and sorted array, A[j]-A[i]>=j-i
   // Thus, we have A[j]-j>= A[i]-i>0
   // To use this observation, once we find that i<A[i], we stop the traversal.
   // time: O(n)
   public int findMagicIndex(int[] arr) {
      int index = 0;
      while (index < arr.length) {
         if (arr[index] == index)
            return index;
         else if (index < arr[index])
            break;
         else
            index++;
      }
      return -1;
   }

   // Sol3
   // Use binary search
   // time: O(lgn); space: O(1)
   public int findMagicIndex2(int[] arr) {
      int start = 0, end = arr.length - 1;
      while (start <= end) {
         int mid = (start + end) / 2;
         if (arr[mid] == mid)
            return mid;
         else if (arr[mid] > mid)
            end = mid - 1;
         else
            start = mid + 1;
      }
      return -1;
   }

   @Test
   public void test() {
      int[] arr = new int[] { 0, 2, 4, 5 };
      System.out.println(Arrays.toString(arr));
      System.out.println(findMagicIndex(arr));
      System.out.println(findMagicIndex2(arr));
   }

}
