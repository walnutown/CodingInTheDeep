package amazon;

import java.util.Arrays;

public class FindTwoMissingIntegers {

   /**
    * An array of integers from [1...n], there're two integers missing, find the missing integers
    */
   public static void main(String[] args) {
      int n = 9;
      int[] num = new int[] { 1, 2, 3, 4, 5, 6, 9 };
      System.out.println(Arrays.toString(findTwoMissingIntegers(num, n)));
   }

   // solve the formulas:
   // <1> x+y = a
   // <2> x*y = b
   // x*x - a*x + b = 0
   public static int[] findTwoMissingIntegers(int[] num, int n) {
      int[] res = new int[2];
      int a = 0, b = 1;
      for (int i = 1; i <= n; i++) {
         a += i;
         b *= i;
      }
      for (int i = 0; i < num.length; i++) {
         a -= num[i];
         b /= num[i];
      }
      solveQuadraticEquation(res, 1, -a, b);
      return res;
   }

   public static void solveQuadraticEquation(int[] res, int a, int b, int c) {
      res[0] = (int) (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
      res[1] = (int) (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
      Arrays.sort(res);
   }

}
