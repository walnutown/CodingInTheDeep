package ch17_moderate;

import org.junit.Test;

public class ch17_4_FindMaxOfTwoNumbers {

   /**
    * Write a method which finds the maximum of two numbers. You should not use if-else or any other
    * comparison operator.
    */

   // <1> avoid comparison, check sign bit of a-b
   // <2> avoid if-else, use a*x+b*(~x), x=1 or x=0
   // <3> avoid overflow
   public int findMaxOfTwoNumbers(int a, int b) {
      int c = a - b;
      int sa = sign(a), sb = sign(b), sc = sign(c);
      int differentSign = sa ^ sb;      // if a,b have different signs, differentSign=1
      // There're two cases max is B
      // [1] a,b different in signs, a is negative
      // [2] a,b same in signs, c is negative
      int maxIsB = differentSign * sa + flip(differentSign) * sc; 
      return flip(maxIsB) * a + maxIsB * b;
   }

   // return the most significant bit of num
   private int sign(int num) {
      return (num >> 31) & 1;
   }

   // flip one bit
   private int flip(int num) {
      return num ^ 1;
   }

   @Test
   public void test() {
      int a = Integer.MAX_VALUE, b = Integer.MIN_VALUE;
      System.out.println(findMaxOfTwoNumbers(a, b));
   }

}
