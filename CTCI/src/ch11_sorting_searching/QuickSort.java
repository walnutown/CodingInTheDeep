package ch11_sorting_searching;

import java.util.Arrays;

/**
 * Quick-sort is a divide and conquer algorithm.
 * It divides a large list into two smaller sub-lists,
 * then recursively sort the sub-lists
 */
public class QuickSort {

   public static void main(String[] args) { 
      int[] arr = new int[]{14, 8, 27, 2, 2, 32, 45, 44, 28, 2};
      //quickSort(arr, 0, arr.length - 1);
      quickSort2(arr, 0, arr.length - 1);
      System.out.println(Arrays.toString(arr));
   }
   
   // from CTCI
   public static void quickSort(int[] arr, int start, int end) {
      if (arr == null || arr.length <= 1 || start >= end)
         return;
      int pivot = partition(arr, start, end);
      quickSort(arr, start, pivot - 1);
      quickSort(arr, pivot, end);
   }

   public static int partition(int[] arr, int start, int end) {
      int pivot = (start + end) >> 1; // choose middle element as pivot here
      int pivot_value = arr[pivot];
      while (start <= end) {  // need '=' here, think of the case [2,1,3] 
         while (arr[start] < pivot_value)
            start++;
         while (arr[end] > pivot_value)
            end--;
         if (start <= end) { // need '=' here, think of the case [1,3]
            swap(arr, start, end);
            start++;
            end--;
         }
      }
      return start;
   }

   public static void swap(int[] arr, int l, int r) {
      if (l==r) return;
      int tmp = arr[l];
      arr[l] = arr[r];
      arr[r] = tmp;
   }
   
   // from CLRS, easier to deal with index
   public static void quickSort2(int[] arr, int start, int end) {
      if (arr == null || arr.length <= 1 || start >= end)
         return;
      int pivot = partition(arr, start, end);
      quickSort(arr, start, pivot - 1);
      quickSort(arr, pivot+1, end);
   }
   
   public static int partition2(int[] arr, int start, int end) {
      int pivot_value = arr[end]; // choose last element as pivot here
      int i=start-1, j=start;
      for (; j<=end-1; j++){
         if (arr[j]<=pivot_value){
            swap(arr,++i,j);
         }
      }
      swap(arr, i+1, end);  // put last element into right position
      return i+1;
   }

}
