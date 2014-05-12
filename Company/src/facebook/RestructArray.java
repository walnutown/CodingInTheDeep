package facebook;

import java.util.Arrays;

import org.junit.Test;

public class RestructArray {
   /**
    * Given an array arr[] of size n where every element is in range from 0 to n-1. Rearrange the
    * given array so that arr[i] becomes arr[arr[i]]. This should be done with O(1) extra space.
    * Examples:
    * Input: arr[] = {3, 2, 0, 1}
    * Output: arr[] = {1, 0, 3, 2}
    * Input: arr[] = {4, 0, 2, 1, 3}
    * Output: arr[] = {3, 4, 2, 0, 1}
    * Input: arr[] = {0, 1, 2, 3}
    * Output: arr[] = {0, 1, 2, 3}
    */

   // The requirement for this question is very vague
   // see http://www.careercup.com/question?id=4909367207919616
   // if we want to get arr[i] == arr[arr[i]], a sorted array [0, 1..n-1] always meets the
   // requirement

   // Below is the solution from CareerCup. Archive it here.
   /*
    * (x + y*z)/z = y provided x and y is less than z.
    * (x + y*z)%z = x provided x and y is less than z.
    * This is the concept used here.
    * Example:
    * (3 + 4*5)/5 = 4
    * (3 + 4*5)%5 = 3
    * arr[i] = arr[i] + arr[arr[i]]*size
    * so arr[i]/size = arr[arr[i]]
    */
   public int[] restruct(int[] A) {
      int N = A.length;
      for (int i = 0; i < N; i++) {
         // A[[i]]%N here, in case A[i] < i, which means that A[i] has been added
         // In that way, we have to %N to get the original value first
         A[i] = A[i] + A[A[i]] % N * N;
      }
      for (int i = 0; i < N; i++) {
         A[i] = A[i] / N;
      }
      return A;
   }

   @Test
   public void test() {
      int[] A = new int[] { 4, 0, 2, 1, 3 };
      System.out.println(Arrays.toString(restruct(A)));
   }
}
