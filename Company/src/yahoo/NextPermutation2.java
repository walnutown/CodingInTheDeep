package yahoo;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class NextPermutation2 {
   /**
    * Given a number N, find the smallest even number E such that E > N and digits in N and E are
    * same.
    * Print NONE otherwise.
    * Sample:
    * Input
    * N = 34722641
    * Output
    * E = 34724126
    * Input
    * N = 8234961
    * Output
    * E = 8236194 (instead of 8236149)
    */

   // [1] get next permutation
   // [2] check even or odd. If odd, traverse from last digit to find the j-th digit that is even
   // and is smaller than the last digit, swap the two. Note if there is a digit D in [j, len-2]
   // that A[len-1]<D<A[j], we need to swap D and A[j] tp ensure smallest increment
   public int getNextPermutation(int N) {
      int[] A = getNext(N);
      int len = A.length, lastDigit = A[len - 1];
      if (lastDigit % 2 == 0)
         return getNumber(A);
      int i = len - 2;
      while (i >= 0 && (A[i] > lastDigit || A[i] % 2 != 0))
         i--;
      if (i == -1)
         return getNumber(A);
      swap(A, i, len - 1);
      for (int j = i + 1; j < len - 1; j++) {
         if (A[j] > A[len - 1] && A[j] < A[i])
            swap(A, i, j);
      }
      return getNumber(A);
   }

   private int getNumber(int[] A) {
      int res = 0;
      for (int i = 0; i <A.length; i++)
         res = res * 10 + A[i];
      return res;
   }

   private int[] getNext(int N) {
      ArrayList<Integer> num = new ArrayList<Integer>();
      while (N > 0) {
         num.add(N % 10);
         N /= 10;
      }
      int[] A = new int[num.size()];
      Collections.reverse(num);
      for (int i = 0; i < num.size(); i++) {
         A[i] = num.get(i);
      }
      int i = A.length - 1;
      while (i > 0 && A[i] <= A[i - 1]) {
         i--;
      }
      reverse(A, i, A.length - 1);
      if (i == 0)
         return A;
      int j = i;
      while (j < A.length && A[j] <= A[i-1]) {
         j++;
      }
      swap(A, i-1, j);
      return A;
   }

   private void reverse(int[] A, int start, int end) {
      while (start < end) {
         swap(A, start++, end--);
      }
   }

   private void swap(int[] A, int i, int j) {
      int tmp = A[i];
      A[i] = A[j];
      A[j] = tmp;
   }
   
   @Test
   public void test(){
      for (int i=1234; i<1499; i++){
         System.out.println(i + " : " + getNextPermutation(i));
      }
   }
}
