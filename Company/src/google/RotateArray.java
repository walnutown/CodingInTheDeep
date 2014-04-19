package google;

import java.util.Arrays;

import org.junit.Test;

public class RotateArray {
   /*
    * Given an array, right rotate it by k steps
    * eg, given A = [1,2,3,4] ->right rotate it by 3 steps -> [2,3,4,1]
    */
   // http://www.geeksforgeeks.org/array-rotation/

   // Remember to mode k first to ensure k is in the range

   // Sol1
   // The naive solution is to rotate store the k elements in a temporary array and then copy them
   // back to the result array
   // time: O(n); space: O(k)
   public int[] rotateArray1(int[] A, int k) {
      if (k < 0)
         throw new IllegalArgumentException();
      if (k == 0)
         return A;
      int N = A.length, i = 0, j = 0;
      k = k % N;
      int[] tmp = new int[k];
      for (i = 0, j = N - k; i < k; i++, j++)
         tmp[i] = A[j];
      for (i = N - 1, j = N - k - 1; j >= 0; i--, j--)
         A[i] = A[j];
      for (i = k - 1; i >= 0; i--)
         A[i] = tmp[i];
      return A;
   }

   // Sol2
   // Rotate the array step by step, which means that we have to move the whole array right k times
   // time: O(n*k); space: O(1)
   public int[] rotateArray2(int[] A, int k) {
      if (k < 0)
         throw new IllegalArgumentException();
      if (k == 0)
         return A;
      k = k % A.length;
      while (--k >= 0)
         rightShiftArray(A);
      return A;
   }

   private void rightShiftArray(int[] A) {
      int N = A.length;
      int tmp = A[N - 1];
      for (int i = N - 2; i >= 0; i--)
         A[i + 1] = A[i];
      A[0] = tmp;
   }

   // Sol3, Reversal Algorithm
   // [1] reverse the whole array[0,n]
   // [2] reverse the subarray[0,k-1]
   // [3] reverse the subarray[k, n-1]
   // time: O(n); space: O(1)
   public int[] rotateArray3(int[] A, int k) {
      int N = A.length;
      k = k % N;
      reverse(A, 0, N - 1);
      reverse(A, 0, k - 1);
      reverse(A, k, N - 1);
      return A;
   }

   private void reverse(int[] A, int start, int end) {
      while (start < end) {
         int tmp = A[start];
         A[start] = A[end];
         A[end] = tmp;
         start++;
         end--;
      }
   }

   @Test
   public void test() {
      int[] A = new int[] { 1, 2, 3, 4 };
      int[] B = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
      int[] C = new int[] { 5, 6, 7, 8, 9 };
      System.out.println(Arrays.toString(rotateArray1(A, 2)));
      System.out.println(Arrays.toString(rotateArray2(B, 6)));
      System.out.println(Arrays.toString(rotateArray3(C, 11)));
   }
}
