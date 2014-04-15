package amazon;

import org.junit.Test;

public class BitMultiplyOperation {

   /**
    * Implement multiplication without using '+', '-', '*' operators
    */
  
   // add multiplicand iteratively by multiplier times
   // time: O(m), m is the value of multiplier
   public int bitMultiply1(int a, int b) {
      int multiplier = a < 0 ? negative(a) : a;
      int multiplicand = b < 0 ? negative(b) : b;
      int count = 0, res = 0;
      while (count < multiplicand) {
         res = bitAdd(res, multiplier);
         count = bitAdd(count, 1);
      }
      return (a ^ b) < 0 ? negative(res) : res;
   }

   // peasant/ binary multiplication
   // refer to http://en.wikipedia.org/wiki/Multiplication_algorithm#Peasant_or_binary_multiplication
   // time: O(32)
   public int bitMultiply2(int a, int b) {
      // Note, we need to convert all to positive integers first, because (-1)>>1 remains -1
      // which will cause a endless loop
      int multiplier = a < 0 ? negative(a) : a; 
      int multiplicand = b < 0 ? negative(b) : b;
      int res = 0;
      while (multiplicand > 0) {
         if ((multiplicand & 1) > 0)
            res = bitAdd(res, multiplier);
         multiplier = (multiplier << 1);
         multiplicand = (multiplicand >> 1);
      }
      return (a ^ b) < 0 ? negative(res) : res;
   }
   
   public int negative(int num) {
      return bitAdd(~num, 1);
   }

   public int bitAdd(int a, int b) {
      return b == 0 ? a : bitAdd(a ^ b, (a & b) << 1); // (a&b)<<1 is the carry
   }
   
   @Test
   public void test() {
      System.out.println(bitMultiply1(10, -8));
      System.out.println(bitMultiply2(10, -8));
   }


}
