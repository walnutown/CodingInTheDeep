package google;

import org.junit.Test;

public class FindHNumber {
   /*
    * Given an integer array, find the number h that meets the following requirement:
    * there're h numbers that are greater than h
    * eg,
    * input: [2,3,5]
    * output: 2
    * input: [5,6,7,8]
    * output: 4
    * input: [4,6,7,8]
    * output: -1
    */
   
   // This question is vaguely defined

   // Modify countingSort, count the occurrence of each element, and get the suffix sum
   // time: O(K+N), K = Max-Min+1
   public int findH(int[] A) {
      int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
      for (int num : A) {
         max = Math.max(max, num);
         min = Math.min(min, num);
      }
      int K = max - min + 1;
      int[] C = new int[K];
      for (int num : A)
         C[num - min]++;
      for (int i = K - 2; i >= 0; i--) {
         int h = i + min;
         if (C[i + 1] > h)
            return -1;
         if (C[i + 1] == h)
            return h;
         C[i] += C[i + 1];
      }
      return C[0] < min ? C[0] : -1;
   }

   // Modify quick select, each time, we compare the pivot value and index
   // time: O(n)
   public int findH2(int[] A) {
      int N = A.length;
      int start = 0, end = N - 1;
      while (start <= end) {
         int pivot = partition(A, start, end);
         if (N-pivot-1 == A[pivot])
            return A[pivot];
         else if (N-pivot-1 > A[pivot])
            start = pivot+1;
         else
            end = pivot-1;    
      }
      if (end==-1 && A[start]>N)
         return N;
      return -1;
   }

   private int partition(int[] A, int start, int end) {
      int i = start, j = start;
      int pivotValue = A[end];
      for (; j < end; j++) {
         if (A[j] <= pivotValue)
            swap(A, i++, j);
      }
      swap(A, i, end);
      return i;
   }

   private void swap(int[] A, int i, int j) {
      int tmp = A[i];
      A[i] = A[j];
      A[j] = tmp;
   }

   @Test
   public void test() {
      int[] A = new int[] { 2, 4, 5 };
      int[] B = new int[] { 5, 6, 7, 8 };
      int[] C = new int[] { 4, 6, 7, 8 };
      System.out.println(findH(A));
      System.out.println(findH2(A));
      System.out.println(findH(B));
      System.out.println(findH2(B));
      System.out.println(findH(C));
      System.out.println(findH2(C));
   }
}
