package ch5_bit_manipulation;

import org.junit.Test;

public class ch5_2_BaseConversion2 {

   /**
    * Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double,
    * print the binary representation. If the number cannot be represented accurately
    * in binary with at most 32 characters, print "ERROR"
    */
   
   // See CTCI/ch7/BaseConversion
   
   // know how to convert the fractional part of a decimal number to binary number
   // http://en.wikipedia.org/wiki/Binary_number
   public String doubleToBinaryString(double d) {
      if (d >= 1 || d <= 0)
         return "ERROR";
      StringBuilder sb = new StringBuilder();
      sb.append(".");       // Remember to add '.'
      while (d > 0) {
         if (sb.length() >= 32)
            return "ERROR";
         double r = d * 2;
         if (r >= 1) {
            sb.append("1");
            d = r - 1;
         } else {
            sb.append("0");
            d = r;
         }
      }
      return sb.toString();
   }

   @Test
   public void test() {
      double d = 0.125;
      System.out.println(doubleToBinaryString(d));
   }

}
