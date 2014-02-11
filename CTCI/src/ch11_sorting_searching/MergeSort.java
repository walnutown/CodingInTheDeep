package ch11_sorting_searching;

import java.util.Arrays;

public class MergeSort {

   /**
    * Implement in place merge sort
    */
   /*
    * Because x is positive here, in JDK source code, the implementation of mergeSort uses x >>1 to
    * replace x/2
    * Below is some more:
    * First, dividing by two and shifting right by one will not yield the same result for negative
    * numbers in all cases. (Think of (-1)>>1 )
    * Second, where the shifted result is sufficent, its roughly 10 to 20 times faster than
    * dividing.
    * Third, the compiler will not optimize x/2 to x>>1 because in any non-trivial case it will be
    * unable to prove that the shifted operand is not negative
    */

   public static void main(String[] args) {
      int[] arr = new int[] { -1, 2, -5, 20, 6 };
      mergeSort(arr, 0, arr.length - 1);
      System.out.println(Arrays.toString(arr));
   }

   public static void mergeSort(int[] arr, int start, int end) {
      if (start >= end)
         return; // notice >= here, because in 'mergeSort(arr,start,mid)', 'mid' keep the same. if
                 // start>end, may cause dead loop
      int mid = (start + end) >> 1;
      mergeSort(arr, start, mid);
      mergeSort(arr, mid + 1, end);
      merge(arr, mid, start, end);
   }

   public static void merge(int[] arr, int mid, int start, int end) {
      int[] helper = new int[arr.length];
      for (int i = start; i <= end; i++)
         helper[i] = arr[i];
      int i = start, j = mid + 1, index = start;
      while (i <= mid && j <= end) {
         if (helper[i] < helper[j])
            arr[index++] = helper[i++];
         else
            arr[index++] = helper[j++];
      }
      while (i <= mid) {
         arr[index++] = helper[i++];
      }
      while (j <= end) {
         arr[index++] = helper[j++];
      }
   }
}
