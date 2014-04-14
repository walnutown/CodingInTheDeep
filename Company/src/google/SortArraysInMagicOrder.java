package google;

import java.util.Arrays;

import org.junit.Test;

public class SortArraysInMagicOrder {
   /*
    * Given an unordered array, sort it so that
    * a1 <= a2 >= a3 <= a4
    */
   
   // Sort the array in ascending order, and then merge left and right half to 
   // form the target array
   // time: O(nlgn); space: O(1)
   public int[] sortArraysInMagicOrder(int[] A){
      Arrays.sort(A);
      int N = A.length;
      int[] res = new int[N]; 
      int end = N-1, mid = (N-1)/2;
      int i= 0, j = mid+1, r = 0;
      while (i<=mid && j<=end){
         res[r++] = A[i++];
         res[r++] = A[j++];
      }
      if (i<=mid) // if odd length, need to add the middle element
         res[r++] = A[i++];
      return res;
   }
   
   // Traverse the array, if the two adjacent values are not in magic order, swap them
   // eg, 1,2,3,4
   // 1: 1,2,3,4
   // 2: 1,3,2,4
   // 3: 1,3,2,4
   // Use the transitive relation
   // time: O(n); space: O(1)
   public int[] sortArraysInMagicOrder2(int[] A){
      int N = A.length;
      for (int i=0; i<N-1; i++){
         if ((i&1)==0 && A[i]>A[i+1])
            swap(A, i, i+1);
         else if ((i&1)!=0 && A[i]<A[i+1])
            swap(A, i, i+1);
      }
      return A;
   } 
   
   private void swap(int[] A, int i, int j){
      int tmp = A[i];
      A[i] = A[j];
      A[j] = tmp;
   }
   
   @Test
   public void test(){
      int[] A = new int[]{1,2,3,4};
      int[] B = new int[]{1,2,3};
      System.out.println(Arrays.toString(sortArraysInMagicOrder(A)));
      System.out.println(Arrays.toString(sortArraysInMagicOrder2(A)));
      System.out.println(Arrays.toString(sortArraysInMagicOrder(B)));
      System.out.println(Arrays.toString(sortArraysInMagicOrder2(B)));
   }
   
}
