package google;

import java.util.ArrayList;

import org.junit.Test;

public class DecimalDivision {
   /*
    * Given a divisor and dividend, get the decimal division result
    * If the result has infinite decimal expansion, parentheses the recurring part.
    * The final result is returned as string. The limit of decimal expansion length is 10.
    * eg,
    * 5/1, 5
    * 125/12, 10.41(6)
    * 8/235 0.0340425531914
    * 235/8 29.375
    * 10/3 2.(3)
    */

   // http://blog.csdn.net/lilypp/article/details/6549204
   // There're two points in this question:
   // [1] how to get decimal expansion of the result?
   // each time, we get the remainder, if remainder is not zero, multiplies 10 to be the new divisor
   // [2] how to find the recurring part in the decimal expansion
   //  maintain a list to store all the remainders, two same remainders indicate the recurring part
   final static int PRECISE = 10;   // used to terminate endless calculation

   public String divide(int a, int b) {
      if (b == 0)
         throw new ArithmeticException("Division by zero");
      StringBuilder sb = new StringBuilder();
      ArrayList<Integer> remainders = new ArrayList<Integer>();
      int res = a / b, remainder = a % b;
      sb.append(res);
      if (remainder == 0)   // if no remainder, return the result
         return sb.toString();
      sb.append(".");       // start adding decimal expansion
      remainders.add(remainder);
      while (remainder != 0 && remainders.size() <= PRECISE) {
         a = remainder * 10;
         res = a / b;
         sb.append(res);
         int len = getLengthOfRecurringPart(remainders, a % b);
         if (len > 0) {
            sb.insert(sb.length() - len + 1, "(");
            sb.append(")");
            return sb.toString();
         }
         remainder = a % b;
         remainders.add(remainder);
      }
      return sb.toString();
   }

   private int getLengthOfRecurringPart(ArrayList<Integer> remainders, int curr) {
      int i = remainders.size() - 1;
      while (i >= 0) {
         if (remainders.get(i--) == curr)
            return remainders.size() - i;
      }
      return 0;
   }

   @Test
   public void test() {
      for (int i = 0; i < 20; i++) {
         for (int j = 1; j < 20; j++) {
            System.out.println(i + "/" + j + ": " + divide(i, j));
            System.out.println(i + "/" + j + ": " + (double) i / (double) j);
         }
      }
   }

}
