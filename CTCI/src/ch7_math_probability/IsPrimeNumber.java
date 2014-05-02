package ch7_math_probability;

import org.junit.Test;

public class IsPrimeNumber {

   /**
    * Given an integer, check whether it's a prime number
    */

   // Sol1
   // Check whether num has a factor in [2...num-1]
   // time: O(n); space: O(1)
   public boolean isPrime(int num) {
      if (num < 2)
         return false;
      for (int i = 2; i < num; i++)
         if (num % i == 0)
            return false;
      return true;
   }

   // Sol2, narrow down the search space for factors from two perspectives
   // [1] all the even numbers can be omitted after we check num%2
   // [2] The sqrt would be sufficient, because for every number A which divides N evenly, there is
   // a complement B, where A*B=N. If A>sqrt, then B<sqrt (since sqrt*sqrt=n). We therefore don't
   // need A to check n's primality, since we would have already checked with B.
   // time: O(sqrt(n)); space: O(1)
   public boolean isPrime2(int num) {
      if (num <= 1)
         return false;
      if (num % 2 == 0)
         return false;
      // num is odd number
      for (int i = 3; i * i < num; i = i + 2) {
         if (num % i == 0)
            return false;
      }
      return true;
   }

   @Test
   public void test() {
      for (int i = 0; i < 100; i++) {
         if (isPrime2(i))
            System.out.println(i);
      }
   }

}
