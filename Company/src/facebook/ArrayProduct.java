package facebook;

import java.util.Arrays;

import org.junit.Test;

public class ArrayProduct {
   /*
    * input [2,3,1,4]
    * output [12,8,24,6]
    * Multiply all fields except it's own position.
    * Restrictions:
    * 1. no use of division
    * 2. complexity in O(n)
    */
   public int[] getProducts(int[] A) {
      if (A == null || A.length == 0)
         return null;
      int N = A.length;
      int[] P = new int[N];
      P[0] = A[0];
      for (int i = 1; i < N; i++)
         P[i] = P[i - 1] * A[i];
      int rP = 1;
      for (int i = N - 1; i > 0; i--) {
         P[i] = rP * P[i - 1];
         rP = A[i] * rP;
      }
      P[0] = rP;
      return P;
   }
   
   @Test
   public void test(){
      int[] A = new int[]{2,3,1,4};
      System.out.println(Arrays.toString(getProducts(A)));
   }
}