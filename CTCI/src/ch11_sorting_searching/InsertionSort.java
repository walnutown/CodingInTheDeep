package ch11_sorting_searching;

import java.util.Arrays;

import org.junit.Test;

public class InsertionSort {

   /**
    * Implement in place insertion sort
    */

   // time: O(n^2); space: O(1)
   public void insertionSort(int[] arr) {
      if (arr == null || arr.length <= 1)
         return;
      for (int i = 1; i < arr.length; i++) {
         insert(arr, i);
      }
   }

   // traverse from the end of sorted sub-array, move elements while find insertion position
   // we can use binary search here to optimize the running time of searching for the insertion
   // position but we still have to move the right half elements, which takes O(n)
   // time: O(n)
   private void insert(int[] arr, int num_index) {
      int num = arr[num_index];
      int i = num_index - 1;
      for (; i >= 0 && num < arr[i]; i--)
         arr[i + 1] = arr[i];
      arr[i + 1] = num;
   }

   @Test
   public void test() {
      int[] arr = new int[] { 20, -3, -10, 30, 50 };
      insertionSort(arr);
      System.out.println(Arrays.toString(arr));
   }

}
