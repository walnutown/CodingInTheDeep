package microsoft;

import java.util.Arrays;

public class InterleavingArray {

   /**
    * Given an array: [a1, a2, a3,..., an, b1, b2, b3,...,bn]
    * convert it into:
    * [a1,b1,a2,b2,...,an,bn]
    */
   public static void main(String[] args) {
      int[] A = new int[] { 1, 1, 1, 1, 1, 2, 2, 2, 2, 2 };
      // interleavingArray2(A);
      interleavingArray3(A);
      System.out.println(Arrays.toString(A));
   }

   /*
    * First swap elements in the middle pair
    * Next swap elements in the middle two pairs
    * Next swap elements in the middle three pairs
    * iterate n-1 steps.
    * Ex: with n = 4.
    * a1 a2 a3 a4 b1 b2 b3 b4
    * a1 a2 a3 b1 a4 b2 b3 b4
    * a1 a2 b1 a3 b2 a4 b3 b4
    * a1 b1 a2 b2 a3 b3 a4 b4
    */
   // time: O(n^2); space: O(1)
   public static void interleavingArray(int[] A) {
      if (A == null || A.length == 0)
         return;
      int len = A.length, N = len / 2;
      for (int i = 1; i < N; i++) {
         for (int j = 0; j < i; j++) {
            swap(A, N - i + 2 * j, N - i + 2 * j + 1);
         }
      }
   }

   public static void swap(int[] A, int a, int b) {
      int tmp = A[a];
      A[a] = A[b];
      A[b] = tmp;
   }

   /*-----------------------------------------------------*/

   // in place swap
   // time: O(n^2), space: O(1)
   public static void interleavingArray2(int[] A) {
      if (A == null || A.length == 0)
         return;
      int len = A.length, N = len / 2;
      for (int i = 0; i < len; i++) {
         int swap_index = getIndex(i, N);
         while (swap_index < i)
            swap_index = getIndex(swap_index, N);
         swap(A, i, swap_index);
      }
   }

   public static int getIndex(int i, int N) {
      return i % 2 * N + i / 2;  // i/2 is the index in the target sub-array, i%2 is the number of
                                // sub-arrays before the target sub-array
   }

   /*-----------------------------------------------------*/

   /*
    * we divide the array in four sections:[X,Y|A,B]
    * It is easy to see that with swaps we can modify it to the form [X,A|Y,B].
    * Now do recursion to solve [X|A] and [Y|B] separately,essentially using divide and conquer.
    */
   // time: O(nlgn); space: O(n)
   public static void interleavingArray3(int[] A) {
      if (A == null || A.length == 0)
         return;
      interleavingArray3Helper(A, 0, A.length - 1);
   }

   public static void interleavingArray3Helper(int[] A, int start, int end) {
      if (end - start <= 1)
         return;
      int len = end - start + 1, mid = start + len / 2, mid_l = start + len / 4, mid_r = mid + len / 4;
      rangeSwap(A, mid_l, mid - 1, mid, mid_r - 1);
      interleavingArray3Helper(A, start, mid_l + mid_r - 1 - mid);
      interleavingArray3Helper(A, mid_r - (mid - mid_l), end);
   }

   public static void rangeSwap(int[] A, int as, int ad, int bs, int bd) {
      if (ad - as == bd - bs) {
         for (int i = 0; i <= ad - as; i++)
            swap(A, as + i, bs + i);
      } else {
         int[] tmp = new int[ad - as + 1];
         for (int i = as; i <= ad; i++)
            tmp[i - as] = A[i];
         int index = as;
         for (int i = bs; i <= bd; i++)
            A[index++] = A[i];
         for (int i = 0; i < tmp.length; i++)
            A[index++] = tmp[i];
      }
   }

}
