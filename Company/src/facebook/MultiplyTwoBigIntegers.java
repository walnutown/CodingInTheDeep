package facebook;

import java.util.Arrays;

import org.junit.Test;

public class MultiplyTwoBigIntegers {
   /*
    * Given two big integers, how to multiply them without overflow?
    * You can use any format to represent the big integer
    */
   
   // Use array to represent the big integer
   // Take care of the case that A or B is 0
   // time: O(n*m), n and m is the length of A and B; space: O(m+n)
   public int[] multiplyTwoBigIntegers(int[] A, int[] B){
      if (A==null || B==null)
         return A==null ? B : A;
      if (A.length==0 || B.length==0)
         return A.length==0? B : A;
      if (A.length==1 && A[0] == 0 || B.length==1 && B[0]==0)
         return new int[]{0};
      int M = A.length, N = B.length;
      int[] res = new int[M+N-1];   // note the length of the result
      for (int i=0; i<M; i++){
         for (int j=0; j<N; j++){
            res[i+j] += A[i] * B[j]; // add all products on position of i+j
         }
      }
      int carry = 0;
      for (int i=res.length-1; i>=0; i--){
         int value = (carry + res[i])%10;
         carry = (res[i]+carry)/10;
         res[i] = value;
      }
      if (carry == 0)
         return res;
      int[] copy = new int[res.length+1];
      copy[0] = 1;
      System.arraycopy(res, 0, copy, 1, res.length);
      return copy;
   }
   
   
   @Test
   public void test(){
      int[] A = new int[]{1,6,5,4};
      int[] B = new int[]{2,4,5,3};
      int[] C = new int[]{0};
      System.out.println((1654*2453) +": "+ Arrays.toString(multiplyTwoBigIntegers(A, B)));
      System.out.println((1654*0) +": "+ Arrays.toString(multiplyTwoBigIntegers(A, C)));
   }
}
