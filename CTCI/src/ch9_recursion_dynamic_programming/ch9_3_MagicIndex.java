package ch9_recursion_dynamic_programming;

import java.util.Arrays;

public class ch9_3_MagicIndex {

   /*
    * Magic Index : A[i] = i
    * Given a sorted array of distinct integers, write a method to find a magic index
    * if one exists, in array A
    */
   public static void main(String[] args) {
      int[] arr  =new int[]{0,2,4,5};
      int[] arr2 = new int[] { -3, 3, 3, 3, 3, 20 };
      System.out.println(Arrays.toString(arr));
      System.out.println(findMagicIndex(arr));
      System.out.println(findMagicIndex2(arr));
      System.out.println(findMagicIndex3(arr2, 0, arr.length));
   }

   // time: O(n)
   public static int findMagicIndex(int[] arr) {
      int index = 0;
      while (index < arr.length) {
         if (arr[index] == index)
            return index;
         else if (index < arr[index]) { // key step here
            index = arr[index];
         } else
            index++;
      }
      return -1;
   }

   // binary search
   public static int findMagicIndex2(int[] arr) {
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

   // Follow Up
   // What if the values are not distinct?

   // binary search, have to search both halves each time
   public static int findMagicIndex3(int[] arr, int start, int end) {
      if (start > end)
         return -1;
      int mid = (start + end) >> 1;
      if (arr[mid] == mid)
         return mid;
      else if (arr[mid] > mid) {
         return Math.max(findMagicIndex3(arr, start, mid - 1), findMagicIndex3(arr, arr[mid], end));
      } else
         return Math.max(findMagicIndex3(arr, start, arr[mid]), findMagicIndex3(arr, mid + 1, end));
   }

}
