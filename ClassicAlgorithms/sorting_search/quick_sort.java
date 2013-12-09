package sorting_search;

import java.util.Arrays;

/**
 * Quick-sort is a divide and conquer algorithm. 
 * Quicksort divides a large list into two smaller sub-lists,
 * quicksort then recursively sort the sub-lists
 */
public class quick_sort {

  
   public static void main(String[] args) {
      int[] arr = new int[]{20};
      quickSort(arr, 0, arr.length-1);
      System.out.println(Arrays.toString(arr));
   }
   
   public static void quickSort(int[] arr, int start, int end){
      if (arr == null || arr.length <= 1 || start >= end)
         return;
      int pivot = partition(arr, start, end);
      if (start < pivot)
         quickSort(arr, start, pivot);
      if (pivot < end)
         quickSort(arr, pivot+1, end);  
   }
   
   public static int partition(int[] arr, int start, int end){
      int pivot = (start + end) >>1; // choose middle as pivot here
      while (start < end){
         while (arr[start] < arr[pivot])
            start++;
         while (arr[end] > arr[pivot])
            end--;
         if (start < end){
            swap(arr, start, end);
            start++;
            end--;
         }
      }
      return pivot;
   }
   
   public static void swap(int[] arr, int l, int r){
      int tmp = arr[l];
      arr[l] = arr[r];
      arr[r] = tmp;
   }

}
