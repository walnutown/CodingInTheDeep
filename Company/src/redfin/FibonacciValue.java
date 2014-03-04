package redfin;

import java.util.Arrays;

import org.junit.Test;

public class FibonacciValue {

   /**
    * Calculate the Fibonnaci value of a number
    */
   @Test
   public void testFibonacci() {
      int num = 10;
      long start = System.currentTimeMillis(), end = start;
      System.out.println("fibRecursion: " + fibRecursion(num));
      end = System.currentTimeMillis();
      System.out.println(end - start);
      start = end;
      System.out.println("fibRecursionTimeOpt: " + fibRecursionTimeOpt(num));
      end = System.currentTimeMillis();
      System.out.println(end - start);
      start = end;
      System.out.println("fibDP: " + fibDP(num));
      end = System.currentTimeMillis();
      System.out.println(end - start);
      start = end;
      System.out.println("fibDpSpaceOpt: " + fibDpSpaceOpt(num));
      end = System.currentTimeMillis();
      System.out.println(end - start);
      start = end;
      System.out.println("fibMatrix: " + fibMatrix(num));
      end = System.currentTimeMillis();
      System.out.println(end - start);
      start = end;
   }

   // time: exponential; space: O(n)
   public int fibRecursion(int num) {
      if (num < 0)
         throw new ArithmeticException("Can not be smaller than 0");
      else if (num <= 1)
         return num;
      return fibRecursion(num - 1) + fibRecursion(num - 2);
   }

   // time: O(n); space: O(n)
   // optimized for calculating multiple Fibonacci numbers
   int[] A;

   public int fibRecursionTimeOpt(int num) {
      if (num < 0)
         throw new ArithmeticException("Can not be smaller than 0");
      else if (num <= 1)
         return num;
      if (A == null) {
         A = new int[num + 1];
         Arrays.fill(A, -1);
         fib(num);
         return A[num];
      } else if (num >= A.length) {
         int[] tmp = new int[num + 1];
         System.arraycopy(A, 0, tmp, 0, A.length);
         Arrays.fill(tmp, A.length, tmp.length, -1);
         fib(num);
         return A[num];
      } else
         return A[num];
   }

   public void fib(int num) {
      if (num == 0)
         A[0] = 0;
      else if (num == 1)
         A[1] = 1;
      else {
         if (A[num - 1] == -1)
            fib(num - 1);
         if (A[num - 2] == -1)
            fib(num - 2);
         A[num] = A[num - 1] + A[num - 2];
      }
   }

   // time: O(n); space: O(n)
   public int fibDP(int num) {
      if (num < 0)
         throw new ArithmeticException("Can not be smaller than 0");
      else if (num <= 1)
         return num;
      int[] dp = new int[num + 1];
      dp[0] = 0;
      dp[1] = 1;
      for (int i = 2; i <= num; i++)
         dp[i] = dp[i - 1] + dp[i - 2];
      return dp[num];
   }

   // time: O(n); space: O(1)
   public int fibDpSpaceOpt(int num) {
      if (num < 0)
         throw new ArithmeticException("Can not be smaller than 0");
      else if (num <= 1)
         return num;
      int a = 0, b = 1, c = 0;
      for (int i = 2; i <= num; i++) {
         c = a + b;
         a = b;
         b = c;
      }
      return c;
   }

   // time: O(n); space: O(1)
   // we can prove it by using induction
   // http://nayuki.eigenstate.org/page/fast-fibonacci-algorithms
   public int fibMatrix(int num) {
      if (num < 0)
         throw new ArithmeticException("Can not be smaller than 0");
      else if (num <= 1)
         return num;
      int[][] F = new int[][] { { 1, 1 }, { 1, 0 } };
      power(F, num - 1);
      return F[0][0];
   }

   // divide and conquer to calculate power of the matrix
   public void power(int[][] F, int num) {
      if (num<=1)
         return;
      int[][] M = new int[][] { { 1, 1 }, { 1, 0 } };
      power(F, num / 2);
      multiply(F, F);
      if (num % 2 != 0)
         multiply(F, M);
   }

   // multiply two matrices, and store the results in F
   public void multiply(int[][] F, int[][] M) {
      int x = F[0][0] * M[0][0] + F[0][1] * M[1][0];
      int y = F[0][0] * M[0][1] + F[0][1] * M[1][1];
      int z = F[1][0] * M[0][0] + F[1][1] * M[1][0];
      int w = F[1][0] * M[0][1] + F[1][1] * M[1][1];

      F[0][0] = x;
      F[0][1] = y;
      F[1][0] = z;
      F[1][1] = w;
   }

}
