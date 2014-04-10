package facebook;

import org.junit.Test;

public class SquareRootWithPrecision {
   /*
    * Write a function which returns the square root of a given number upto a precision of 0.0001.
    * Only arithmatic operations like addition, subtraction, division and multiplication are
    * allowed.
    */

   // Bianry Search
   // Find sqrt(num) is the same as solving the equation x^2-num==0
   // Binary search in [0...N] to find the valid x to solve above equation
   // [1] the precision of 0.0001 means abs(expectedSqrt-actualSqrt)<0.0001
   // [2] take care of the case: num<1
   // [3] compare x with num/x to avoid overflow
   final static double eps = 0.0001;

   public double sqrt(double N) {
      double start = 0, end = Math.max(1, N); // if num<1, take 1 as end
      while (Math.abs(start - end) > eps) {
         double mid = (start + end) / 2;
         if (Math.abs(mid - N / mid) <= eps)
            return mid;
         if (mid < N / mid)
            start = mid + eps;
         else
            end = mid - eps;
      }
      return Math.min(start, end);
   }

   // Newton's Method, faster and more precise (see test result) than binary search solution 
   // The basic idea is that if x is an overestimate of sqrt(num), num/x will be an underestimate
   // So, the average of x and num/x will reasonably provide a better approximation
   public double sqrt2(double N) {
      double x = 1;
      while (true){
         double x0 = (x + N/x)/2;
         if (Math.abs(x-x0)<eps)
            return x0;
         x = x0;
      }
   }

   @Test
   public void test() {
      for (double i = 0; i < 2.0; i = i + eps) {
         double r = sqrt(i), x = sqrt2(i);
         System.out.println("sol1: " + i + ", " + Math.sqrt(i) + " : " + r * r + ", " + r);
         System.out.println("sol2: " + i + ", " + Math.sqrt(i) + " : " + x * x + ", " + x);
         System.out.println("sol1: " + Math.abs(Math.sqrt(i) - r) + " ; "+ "sol2: " + Math.abs(Math.sqrt(i) - x));
      }
   }
}
