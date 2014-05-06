package facebook;

import org.junit.Test;

public class ImplementLog2 {
   
   /**
    * Implement log2(x), using sqrt(x)
    */

   final static double epsilon = 0.0001;

   // Basically, binary search
   // Use the formula: if 2^x = y, 2^(x/2) = sqrt(y).
   // time: O(lgn); space: O(1)
   public double log2(int x) {
      int a = 0, b = 1;
      while (b <= x) {
         b <<= 1;
         a++;
      }
      double bs = b >> 1, be = b;
      double as = a - 1, ae = a;
      while (as <= ae) {
         double am = as + (ae - as) / 2;
         double bm = Math.sqrt(bs * be);
         if (Math.abs(bm - x) < epsilon)
            return am;
         else if (bm < x) {
            as = am + epsilon;
            bs = bm + epsilon;
         } else {
            ae = am - epsilon;
            be = bm - epsilon;
         }
      }
      return ae;
   }

   @Test
   public void test() {
      for (int i = 1; i < 10; i++) {
         System.out.println(i + ": " + log2(i) + "; " + Math.log(i) / Math.log(2));
      }
   }
}
