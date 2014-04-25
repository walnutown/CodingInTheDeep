package amazon;

import org.junit.Test;

public class CubeRoot {

   /********************************************************/
   /*                                                      */
   /* This program computes the cube root of a float */
   /* number using Newton's method of successive */
   /* approximations. The acceptable tolerance is computed */
   /* as a percentage of the correct answer. */
   /*                                                      */
   /********************************************************/

   // http://www.cise.ufl.edu/~ddd/cis3020/summer-97/hw-7-sol.htm

   
   // Similar to Leetcode/sqrt, the difference lies in that we have to
   // note the case of negative float
   public float getCubeRoot(float x) {
      return x < 0 ? -cubeRoot(1, -x) : cubeRoot(1, x);
   }

   private float cubeRoot(float guess, float x) {
      while (true){
         guess = (x / square(guess) + guess) / 2;
         if (Math.abs(cube(guess) - x) / x < 0.00001)
            break;
      }
      return guess;
   }

   private  float cube(float x) {
      return x * x * x;
   }

   private float square(float x) {
      return x * x;
   }

   @Test
   public void test() {
      System.out.println(getCubeRoot(0.3f));
      System.out.println(getCubeRoot(-9.3f));
   }

}
