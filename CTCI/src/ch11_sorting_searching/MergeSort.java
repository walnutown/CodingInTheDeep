package ch11_sorting_searching;

import java.util.Arrays;

import org.junit.Test;

public class MergeSort {

   /**
    * Implement in place merge sort
    */

   // one optimization: insertion sort on small arrays may be faster in practice
   // Given n/k sublists of length k, sort each list using insertion sort and then merge all
   // sublists using the standard merging mechanism
   // The total running time is O(nk + nlg(n/k)), which is smaller than O(nlgn) when k<lgn

   public void mergeSort(int[] arr, int start, int end) {
      if (start >= end)
         return; // notice >= here, because in 'mergeSort(arr,start,mid)', 'mid' keep the same. if
                 // start>end, may cause endless loop
      int mid = (start + end) >> 1;
      mergeSort(arr, start, mid);
      mergeSort(arr, mid + 1, end);
      merge(arr, mid, start, end);
   }

   private void merge(int[] arr, int mid, int start, int end) {
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

   @Test
   public void test() {
      int[] arr = new int[] { -1, 2, -5, 20, 6 };
      mergeSort(arr, 0, arr.length - 1);
      System.out.println(Arrays.toString(arr));
   }

}
