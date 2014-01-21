package microsoft;

import java.util.Arrays;

public class InterleavingArray2 {

   /**
    * Given an array: [a1, a2, a3,..., an, b1, b2, b3,...,bn, c1,c2,c3,...cn]
    * convert it into:
    *   [a1,b1,c1,a2,b2,c2,...,an,bn,cn] 
    */
   public static void main(String[] args) {
      int[] A = new int[]{1,1,1,2,2,2,3,3,3};
      System.out.println(Arrays.toString(interleavingArray1(A)));
      interleavingArray2(A);
      System.out.println(Arrays.toString(A));
   }
   
   // create a new array, map index directly
   // time: O(n), space: O(n)
   public static int[] interleavingArray1(int[] A){
      if (A==null || A.length==0)    return null;
      int len = A.length;
      int[] res = new int[len];
      int N = len/3;
      for (int i=0; i<len; i++){
         res[i] = A[(i%3) * N + i/3]; 
      }
      return res;
   }
   
   // in place swap
   // time: O(n^2), space: O(1)
   public static void interleavingArray2(int[] A){
      if (A==null || A.length==0)    return;
      int len = A.length, N = len/3;
      for (int i=0; i<len; i++){
         int swap_index = getIndex(i, N);
         while (swap_index < i)
            swap_index = getIndex(swap_index, N);
         int tmp=A[i]; A[i] = A[swap_index]; A[swap_index] = tmp;
      }
   }
   
   public static int getIndex(int i, int N){
      return i%3 * N + i/3;  // i/3 is the index in the target sub-array, i%3 is the number of sub-arrays before the target sub-array
   }

}
