package ch7_math_probability;

import java.util.ArrayList;

import org.junit.Test;

public class ch7_4_MultiplyTwoIntegers {

   /**
    * Write methods to implement the multiply, subtract, and divide operations
    * for integers. Use only add operator
    */

   // [1] Double num1 lg(num2) times and cache the temporary values
   // [2] Take care of signs
   // time: O(lgm), m is the value of num2
   public long multiply(int num1, int num2) {
      if (num1 == 0 || num2 == 0)
         return 0;
      int a = Math.abs(num1);
      int b = Math.abs(num2);
      if (a < b)
         return multiply(num2, num1);         // algorithm is faster if a > b
      ArrayList<Integer> values = new ArrayList<Integer>();
      int index = 0;
      while ((1 << index) <= b) {
         values.add(a);
         a = a << 1;
         index++;
      }
      index--;
      long mul = 0;
      while (b > 0) {
         if (b - (1 << index) >= 0) {
            mul += values.get(index);
            b -= (1 << index);
         } else
            index--;
      }
      return (num1 > 0) ^ (num2 > 0) ? -mul : mul;
   }

   // subtract, add num1 + neg(num2)
   // divide, see Leetcode -- DivideTwoIntegers, similar to multiply
   
   @Test
   public void test() {
      System.out.println(multiply(10, -21));
   }

}
