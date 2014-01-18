package amazon;

public class CubeRoot {

   /********************************************************/
   /*                                                      */
   /* This program computes the cube root of a float       */
   /* number using Newton's method of successive           */
   /* approximations. The acceptable tolerance is computed */
   /* as a percentage of the correct answer.               */
   /*                                                      */
   /********************************************************/
   
   // http://www.cise.ufl.edu/~ddd/cis3020/summer-97/hw-7-sol.htm
   
   public static void main(String[] args) {
      System.out.println(getCubeRoot(0.3f));
      System.out.println(getCubeRoot(-9.3f));
   }
   
   public static float getCubeRoot(float x){
      return x<0 ? -cubeRoot(1, -x) : cubeRoot(1, x);
   }
   
   public static float cubeRoot(float guess, float x){
      if (Math.abs(cube(guess)-x)/x < 0.00001)  return guess;
      guess = (x/square(guess) + guess) / 2;
      return cubeRoot(guess, x);
   }
   
   public static float cube(float x){
      return x*x*x;
   }
   
   public static float square(float x){
      return x*x;
   }

}
