package ch17_moderate;

import org.junit.Test;

public class ch17_3_TrailingZerosInFactorial {

   /**
    * Write an algorithm which computes the number of trailing zeros in n factorial
    */
   
   // Sol1
   // the number of trailing zeros is decided by 10 (2*5)
   // we need to count the number of multiples of 2 and 5, more concisely, the number of multiples
   // of 5 (because the number of 2 is always larger than 5)
   // time: O(nlgn); space: O(1)
   public int trailingZeros(int n) {
      int count = 0;
      for (int i = 2; i <= n; i++)
         count += factorOfFive(i);
      return count;
   }

   private int factorOfFive(int num) {
      int count = 0;
      while (num % 5 == 0) {
         count++;
         num /= 5;
      }
      return count;
   }

   // Sol2
   // count number of multiples of 5, multiples of 25
   // e.g. n=25, we have 5=5*1,10=5*2,15=5*3,20=5*4,25=5*5, total 4+2 = 6 'five's
   // 25/5 + 25/25 = 5+1 =6 (25 has been counted twice because it has two 5s, once in 4, once in 25)
   // time: O(lgn); space: O(1)
   public int trailingZeros2(int n) {
      int count = 0;
      for (int i = 5; n / i > 0; i *= 5) {
         count += n / i;
      }
      return count;
   }

   @Test
   public void test() {
      int num = 24;
      System.out.println(trailingZeros(num));
      System.out.println(trailingZeros2(num));
   }

}
