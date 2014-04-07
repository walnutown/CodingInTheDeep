package amazon;

import java.util.Arrays;

import org.junit.Test;

public class FindMissingTermInArithmeticProgression {

   /*
    * Input Format
    * The first line contains an Integer N, which is the number of terms which will be provided as
    * input.
    * This is followed by N consecutive Integers, with a space between each pair of integers. All of
    * these are on one line, and they are in AP (other than the point where an integer is missing).
    * 
    * Output Format
    * One Number which is the missing integer from the series.
    * 
    * Sample Input
    * 5
    * 1 3 5 9 11
    * 
    * Sample Output
    * 7
    * 
    * @throws Exception
    */
   // Note:
   // The length of input array is larger than 2.
   // The last term is not mising

   /**
    * Get the actual diff between two numbers in the array
    * Traverse the array and get the expected value at the index using formula
    * If the actual value is not equal to the expected value, the expected value is missing
    * time: O(n); space: O(1)
    */
   public int findMissingTermInAP(int[] A) throws Exception {
      if (A == null || A.length < 3)
         throw new Exception("Invalid input");
      int N = A.length;
      int diff = (A[N - 1] - A[0]) / N;
      for (int i = 1; i < N; i++) {
         int expected = A[0] + diff * i;
         if (A[i] != expected)
            return expected;
      }
      return -1;
   }
   
   /**
    * Get the expected sum with all numbers using formula sum = (A[start]+A[end])*(N+1)/2,
    * Compare expected sum with actual sum to get the missing value.
    * time: O(n); sapce:O(1)
    * 
    */
   public int findMissingTermInAP2(int[] A) throws Exception {
      if (A == null || A.length < 3)
         throw new Exception("Invalid input");
      int N = A.length;
      int expectedSum = (A[0] + A[N-1])*(N+1)/2;
      int actualSum = 0;
      for (int i=0; i<N; i++)
         actualSum += A[i];
      return expectedSum - actualSum;
   }

   /**
    * As seen in the solution above, we can use formula to get he expected value at each
    * index. In this way, we can use binary search. If the acutal middle value is equal to
    * the expected value, search right; otherwise, search left.
    * time: O(lgn); space: O(1)
    */
   public int findMissingTermInAP3(int[] A) throws Exception {
      if (A == null || A.length < 3)
         throw new Exception("Invalid input");
      int N = A.length;
      int start = 0, end = N - 1;
      int diff = (A[end] - A[start]) / N;
      while (start < end) {
         int mid = (start + end) >> 1;
         if (A[mid] == (A[0] + diff * mid)){
            start = mid + 1;
         }
         else
            end = mid; // take care here
      }
      return A[start]-diff;
   }

   @Test
   public void test() throws Exception {
      //int[] A = new int[] { 1, 3, 5, 7, 9, 11, 13 };
      int[] A = new int[] { 13,11,9,7,5,3,1 };
      for (int i=1; i<A.length-1; i++){
         int[] B = copyArrayExceptOne(A, i);
         System.out.println(Arrays.toString(B));
         System.out.println(findMissingTermInAP(B));
         System.out.println(findMissingTermInAP2(B));
         System.out.println(findMissingTermInAP3(B));
      }
      
   }
   
   private int[] copyArrayExceptOne(int[] A, int index){
      int[] B = new int[A.length-1];
      for (int i=0, j = 0; i<A.length; i++){
         if (i==index)
            continue;
         B[j++] = A[i];
      }
      return B;
   }

}
