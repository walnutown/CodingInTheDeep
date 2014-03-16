package ch17_moderate;

public class ch17_4_FindMaxOfTwoNumbers {

   /**
    * Write a method which finds the maximum of two numbers. You should not use if-else or any other
    * comparison operator.
    */

   // <1> avoid comparison, check sign bit of a-b
   // <2> avoid if-else, use a*x+b*(~x)
   // <3> avoid overflow
   public static int findMaxOfTwoNumbers(int a, int b) {
      int c = a - b;
      int sa = sign(a), sb = sign(b), sc = sign(c);
      int differentSign = sa ^ sb;
      int maxIsB = differentSign * sa + flip(differentSign) * sc; // get all cases where max is B
      return flip(maxIsB) * a + maxIsB * b;
   }
   // return the most significant bit of num
   public static int sign(int num) {
      return (num >> 31) & 1;
   }
   // flip one bit
   public static int flip(int num) {
      return num ^ 1;
   }

   public static void main(String[] args) {
      int a = Integer.MAX_VALUE, b = Integer.MIN_VALUE;
      System.out.println(findMaxOfTwoNumbers(a, b));
   }

}
