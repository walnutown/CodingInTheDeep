package google;

import java.util.Arrays;

import org.junit.Test;

public class ShuffleArraysInMagicOrder {
   /*
    * Given an unordered array, sort it so that
    * a1 <= a2 >= a3 <= a4
    */
   
   // Sol1
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
   
   // Sol2
   // Actually we don't need to sort the array, we only need to find partition the first
   // n/2 elements to left, this can be done using quick select in O(n)
   // Then we can merge the two parts
   // time: O(n); space: O(1)
   
   // Sol3
   // Traverse the array,
   // if index is odd, we should have A[i]<=A[i+1], otherwise swap the two
   // if index is even, we should have A[i]>=A[i+1], otherwise swap the two
   // eg, 1,2,3,4
   // 1: 1,2,3,4
   // 2: 1,3,2,4
   // 3: 1,3,2,4
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
   
   // Proof of Sol3, use induction
   // if i is odd, we should already have A[i-1]>=A[i], 
   //    if A[i]<=A[i+1], just move to next element
   //    if A[i]>A[i+1], use transitive relation, we have A[i-1]>A[i+1],
   //       after swap, we have A[i-1]>A[i+1]<A[i]
   // if i is even, the same
   
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
