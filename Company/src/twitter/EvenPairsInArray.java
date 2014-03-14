package twitter;

import org.junit.Test;

public class EvenPairsInArray {
   /*
    * Write a function:
    * class Solution { public int solution(int[] A); }
    * that, given an array A consisting of N integers, returns the number of pairs (P, Q) such that
    * 0 ≤ P < Q < N and (A[P] + A[Q]) is even. The function should return −1 if the number of such
    * pairs exceeds 1,000,000,000.
    * For example, given array A such that:
    * A[0] = 2, A[1] = 1, A[2] = 5, A[3] = −6, A[4] = 9
    * the function should return 4, because there are four pairs that fulfill the above condition,
    * namely (0,3), (1,2), (1,4), (2,4).
    * Assume that:
    * N is an integer within the range [0..1,000,000];
    * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
    * Complexity:
    * expected worst-case time complexity is O(N);
    * expected worst-case space complexity is O(1), beyond input storage (not counting the storage
    * required for input arguments).
    * Elements of input arrays can be modified.
    */
   final static long NUM_LIMIT = 1000000000;
   
   // time: O(n); space: O(1)
   public long getNumberOfMagicPairs(long[] A) {
      long N = A.length;
      if (N < 0 || N > 1000000)
         return 0;
      int oddNum = 0, evenNum = 0, count = 0;
      for (long num : A) {
         if ((num & 1) == 1) {
            count += oddNum;
            oddNum++;
         } else {
            count += evenNum;
            evenNum++;
         }
      }
      return count > NUM_LIMIT ? -1 : count;
   }
   
   // count number of odds and evens. Two odds or two evens can form a even pair.
   // Use combinations to calculate the number.
   // time: O(n); space: O(1)
   public long getNumberOfMagicPairs2(long[] A) { 
      int odds = 0, evens = 0;
      for (long num:A){
         if ((num&1)==1)
            odds++;
         else
            evens++;
      }
      return odds*(odds-1)/2 + evens*(evens-1)/2;   
   }

   @Test
   public void testMagicPairs() {
      long[] A = new long[] { 2, 1, 5, -6, 9 };
      System.out.println(getNumberOfMagicPairs(A));
      System.out.println(getNumberOfMagicPairs2(A));
   }

}
