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

   public String divide(int a, int b) {
      if (b == 0)
         throw new ArithmeticException("Division by zero");
      StringBuilder sb = new StringBuilder();
      int count = 10;
      ArrayList<Integer> remainders = new ArrayList<Integer>();
      int res = a / b, remainder = a % b;
      sb.append(res);
      if (remainder == 0)
         return sb.toString();
      sb.append(".");
      remainders.add(remainder);
      while (remainder != 0 && count-->=0) {
         a = remainder * 10;
         res = a / b;
         sb.append(res);
         int rStart = getRecurringStartIndex(remainders, a%b);
         if (rStart>=0){
            sb.insert(rStart-1, "(");
            sb.append(")");
            return sb.toString();
         }
         remainder = a % b;
         remainders.add(remainder);
      }
      return sb.toString();
   }
   
   private int getRecurringStartIndex(ArrayList<Integer> remainders, int curr){
      int i=remainders.size()-1;
      while (i>=0){
         if (remainders.get(i--)==curr)
            return i;
      }
      return -1;
   }

   @Test
   public void test() {
      for (int i = 0; i < 20; i++) {
         for (int j = 1; j < 20; j++)
            System.out.println(i + "/" + j + ": " + divide(i, j));
      }
   }

}
