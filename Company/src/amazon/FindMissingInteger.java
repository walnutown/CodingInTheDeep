package amazon;

import java.util.BitSet;

import org.junit.Test;

public class FindMissingInteger {

   /*
    * An array of integers from [1...n], there's one integer missing, find the missing integer
    */

   /**
    * Use Bitset
    * time: O(n); space: O(n/k), n is the max value, k is the number of bits used to represent an
    * integer, k's value depends on implementation. In Java, it is 2^6.
    */
   public int findMissingInteger(int[] A, int N) {
      if (A == null || A.length == 0)
         return 0;
      BitSet bs = new BitSet(N);
      for (int num : A)
         bs.set(num);
      for (int i = 1; i <= N; i++) {
         if (!bs.get(i))
            return i;
      }
      return 0;
   }

   /**
    * Calculate the sum of all elements in the array. And compare it with 1+2+...N
    * time: O(n); space: O(1)
    */
   public int findMissingInteger1(int[] A, int N) {
      if (A == null || A.length == 0)
         return 0;
      int sum = 0;
      for (int num : A)
         sum += num;
      return N * (N + 1) / 2 - sum;
   }

   /**
    * Use two properties of xor, that is: a^a = 0, a^0 = a
    * This sol is better than 1, in that, it doesn't has the risk of overflow (the sum process in 1
    * may produce overflow)
    * time: O(n); space: O(1)
    */
   public int findMissingInteger2(int[] A, int n) {
      if (A == null || A.length == 0)
         return 1;
      int xor = 0;
      for (int i = 0; i < A.length; i++)
         xor ^= A[i];
      for (int i = 1; i <= n; i++)
         xor ^= i;
      return xor;
   }

   @Test
   public void test() {
      int[] A = new int[] { 1, 2, 3, 4, 5, 6, 7, 9 };
      int n = 9;
      System.out.println(findMissingInteger(A, n));
      System.out.println(findMissingInteger1(A, n));
      System.out.println(findMissingInteger2(A, n));
   }

}
