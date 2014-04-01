package amazon;

import org.junit.Test;

public class BitDividOperation {

   /**
    * Implement multiplication without using '/', '%', '*', '+', '-' operators
    */

   // minus y^(2^31), y^(2^30),...y^2, y^1, if possible
   // binary division by shift and subtract, actually the reverse of multiplication
   // http://courses.cs.vt.edu/~cs1104/BuildingBlocks/divide.030.html
   public int bitDivide(int a, int b) {
      int dividend = a < 0 ? negative(a) : a;
      int divisor = b < 0 ? negative(b) : b;
      int res = 0, i = 31;
      while (i >= 0) {
         // use (dividend>>i)>= divisor here, instead of dividend >= (divisor<<i), to avoid overflow
         if ((dividend >> i) >= divisor) {
            res = bitAdd(res, (1 << i));
            dividend = bitMinus(dividend, (divisor << i));
         } else
            i--;
      }
      return (a ^ b) < 0 ? negative(res) : res;
   }

   public int negative(int num) {
      return bitAdd(~num, 1);
   }

   public int bitAdd(int a, int b) {
      return b == 0 ? a : bitAdd(a ^ b, (a & b) << 1); // (a&b)<<1 is the carry
   }

   public int bitMinus(int a, int b) {
      return bitAdd(a, negative(b));
   }

   @Test
   public void test() {
      for (int i = -100; i < 0; i++) {
         for (int j = 1; j < 100; j++) {
            int sol1 = bitDivide(i, j);
               System.out.println(i + "/" + j + ": " + sol1);
         }
      }

   }

}
