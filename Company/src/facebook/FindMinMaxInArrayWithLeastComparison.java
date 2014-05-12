package facebook;

import java.util.Arrays;

import org.junit.Test;

public class FindMinMaxInArrayWithLeastComparison {
   /**
    * Find the min and max in an array. Do it in less than 2n comparisons. (Finds both max and min
    * in about 3/2n comparisons)
    */

   // The basic idea is to divide the array into n/2 pairs.
   // We can get the min and max of each pair by one comparison.
   // Then get minist form mins by n/2 comparisons and the same as max.
   // Note the length of the array may be odd, which means the last element is not in any pair
   // Thus, we always initialize the min/max initial value with last element's value
   // time: O(3/2n); space: O(1)

   public int[] getMinMax(int[] A){
      int[] res = new int[2];
      if (A==null || A.length==0)
         return res;
      int N = A.length;
      res[0] = A[N-1];  // min
      res[1] = A[N-1];  // max
      for (int i=0; i<N; i+=2){ // 3 comparison in each step
         if (A[i]>A[i+1])   
            swap(A, i, i+1);
         if (A[i]<res[0])
            res[0] = A[i];
         if (A[i+1]>res[1])
            res[1] = A[i+1];
      }
      return res;
   }
   
   private void swap(int[] A, int i, int j){
      int tmp = A[i];
      A[i] = A[j];
      A[j] = tmp;
   }
   
   @Test
   public void test(){
      int[] A = new int[]{1,4,5,2,7,9,5,3,6,89,0,54};
      System.out.println(Arrays.toString(getMinMax(A)));
   }
}
