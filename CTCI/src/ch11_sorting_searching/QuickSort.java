package ch11_sorting_searching;

import java.util.Arrays;

import org.junit.Test;

/**
 * Quick-sort is a divide and conquer algorithm.
 * It divides a large list into two smaller sub-lists,
 * then recursively sort the sub-lists
 */
public class QuickSort {

   // from CLRS, easier to deal with index
   public void quickSort(int[] arr, int start, int end) {
      if (arr == null || arr.length <= 1 || start >= end)
         return;
      int pivot = partition(arr, start, end);
      quickSort(arr, start, pivot - 1);
      quickSort(arr, pivot + 1, end);
   }

   private int partition(int[] arr, int start, int end) {
      int pivot_value = arr[end]; // choose last element's value as pivot here
      int i = start, j = start;
      for (; j <= end - 1; j++) {
         if (arr[j] <= pivot_value) {
            swap(arr, i++, j);
         }
      }
      swap(arr, i, end);  // put pivotValue into pivot position
      return i;
   }

   private void swap(int[] arr, int l, int r) {
      if (l == r)
         return;
      int tmp = arr[l];
      arr[l] = arr[r];
      arr[r] = tmp;
   }

   @Test
   public void test() {
      int[] arr = new int[] { 14, 8, 7, 2, 2, 3, 45, 44, 8, 2 };
      quickSort(arr, 0, arr.length - 1);
      System.out.println(Arrays.toString(arr));
   }

}
