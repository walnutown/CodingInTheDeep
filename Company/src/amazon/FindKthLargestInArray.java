package amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import lib.ArrayGenerator;

public class FindKthLargestInArray {

   /**
    * Find the kth largest number in the array
    * Sol:
    * <1> sort, O(nlgn)
    * <2> heap, O(nlgk)
    * <3> quickSelect, O(n)
    */
   public static void main(String[] args) {
      ArrayGenerator gen = new ArrayGenerator();
      int[] A = gen.generateIntArray(10, 0, 50);
      //int[] A = new int[]{10, 26, 48, 40, 43, 34, 9, 46, 19, 5};
      int rank = 3;
      System.out.println(Arrays.toString(A));
      System.out.println(findKthLargestInArray(A, rank));
      System.out.println(findKthLargestInArray2(A, rank));
   }
   
   public static int findKthLargestInArray(int[] A, int k) {
      if (A == null || A.length == 0)
         return 0;
      Comparator<Integer> comp = new Comparator<Integer>(){
         public int compare(Integer a, Integer b){
            return -(a-b);
         }
      };
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, comp);
      for (int num : A){
         pq.add(num);
      }
      while (k-- > 1) pq.poll();
      return pq.poll();
   }
   
   // Quick Select
   public static int findKthLargestInArray2(int[] A, int k) {
      if (A == null || A.length == 0)
         return 0;
      return quickSelect(A, k);
   }

   public static int quickSelect(int[] A, int k) {
      int start = 0, end = A.length - 1;
      while (start < end) {
         int pivot = partition(A, start, end);
         if (pivot == k-1)
            return A[pivot];
         else if (pivot < k-1)   start = pivot+1;
         else end = pivot-1;
      }
      return A[start];
   }

   // partition the array and return the index of the new pivot
   public static int partition(int[] A, int start, int end) {
      int value = A[end];
      int i = start-1, j = start;
      for (; j < end; j++) {
         if (A[j] >= value)
            swap(A, ++i, j);
      }
      swap(A, i+1, end);
      return i+1;
   }

   public static void swap(int[] A, int a, int b) {
      if (a == b)
         return;
      int tmp = A[a];
      A[a] = A[b];
      A[b] = tmp;
   }
}
