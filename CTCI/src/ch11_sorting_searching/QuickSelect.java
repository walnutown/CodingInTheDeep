package ch11_sorting_searching;

import org.junit.Test;

public class QuickSelect {

   /**
    * Select the kth smallest element in an unordered array
    */

   // The structure is a little like binary search.
   // Instead of recursing into both sides, as in quickSort, quickSelect only recurses into one side
   // Ð the side with the element it is searching for. This reduces the average complexity from O(n
   // log n) to O(n)
   // time: average O(n), worst O(n^2)
   public int quickSelect(int[] A, int k) {
      int start = 0, end = A.length - 1;
      while (start < end) {
         int pivot = partition(A, start, end);
         if (pivot == k - 1)
            return A[pivot];
         else if (pivot < k - 1)
            start = pivot + 1;
         else
            end = pivot - 1;
      }
      return A[start];
   }

   // The partition step is the same as it's in quickSort
   // partition the array and return the index of the pivot
   private int partition(int[] A, int start, int end) {
      int value = A[end];
      int i = start, j = start;
      for (; j < end; j++) {
         if (A[j] >= value)
            swap(A, i++, j);
      }
      swap(A, i, end);
      return i;
   }

   private void swap(int[] A, int a, int b) {
      if (a == b)
         return;
      int tmp = A[a];
      A[a] = A[b];
      A[b] = tmp;
   }

   @Test
   public void test() {
      int[] A = new int[] { 1, 3, 5, 2, 4 };
      System.out.println(quickSelect(A, 3));
   }
}
