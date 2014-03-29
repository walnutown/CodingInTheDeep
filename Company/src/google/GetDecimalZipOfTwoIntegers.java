package google;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GetDecimalZipOfTwoIntegers {
   /*
    * https://www.evernote.com/shard/s293/sh/e6238491-0856-4e27-80c3-3287b15fd1f6/957a37ffc8ecee74917167ba067582d0
    */
   
   public final static int MAX = 1000000000;

   public int getDecimalZipOfTwoIntegers(int A, int B) {
      if (A == 0 && B == 0)
         return 0;
      int i = getLength(A), j = getLength(B);
      int res = 0;
      while (i > 0 && j > 0) {
         int a = getKthDigit(A, i--);
         int b = getKthDigit(B, j--);
         res = res * 10 + a;
         res = res * 10 + b;
      }
      while (i > 0)
         res = res * 10 + getKthDigit(A, i--);
      while (j > 0)
         res = res * 10 + getKthDigit(B, j--);
      return res > MAX ? -1 : res;
   }

   private int getLength(int N) {
      if (N == 0)
         return 1;
      int len = 0;
      while (N > 0) {
         N /= 10;
         len++;
      }
      return len;
   }

   private int getKthDigit(int N, int k) {
      N = N / (int) Math.pow(10, k - 1);
      return N % 10;
   }

   // calculate how many digits does the integer have
   public int getZeros(int i) {
      int zeros = 1;
      while (i >= 10) {
         i /= 10;
         zeros *= 10;
      }
      return zeros;
   }

   public int getDecimalZipOfTwoIntegers2(int A, int B) {
      // write your code in Java SE 7
      if (A == 0)
         return B;
      int C = 0;
      int zerosA = getZeros(A), zerosB = getZeros(B);
      while (zerosA != 0 && zerosB != 0) {
         int dA = A / zerosA;    // most significat digit of A
         int dB = B / zerosB;    // most significat digit of B
         C = C * 10 + dA;
         C = C * 10 + dB;
         A %= zerosA;    // get rid of most significat digit of A
         B %= zerosB;    // get rid of most significat digit of B
         zerosA /= 10;   // reduce the number of digit of A
         zerosB /= 10;   // reduce the number of digit of B
      }
      if (zerosA != 0) {    // append A to end
         C *= zerosA * 10;
         C += A;
      }
      if (zerosB != 0) {    // append B to end
         C *= zerosB * 10;
         C += B;
      }
      if (C > 100000000)
         C = -1;
      return C;
   }

   @Test
   public void test() {
      for (int A = 0; A <= 1000; A++) {
         for (int B = 0; B <= 1000; B++) {
            assertTrue(getDecimalZipOfTwoIntegers(A, B)==getDecimalZipOfTwoIntegers2(A,B));
            int a = getDecimalZipOfTwoIntegers(A, B), b = getDecimalZipOfTwoIntegers2(A, B);
            if (a != b) {
               System.out.println(A + " " + B + ":" + a + " " + b);
               System.out.println();
            }
         }
      }

   }
}
