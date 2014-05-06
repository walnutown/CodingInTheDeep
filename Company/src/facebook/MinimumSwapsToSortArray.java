package facebook;

import java.util.Arrays;

import org.junit.Test;

public class MinimumSwapsToSortArray {

   /**
    * An operation "swap" means removing an element from the array and appending it at the back of
    * the same array. Find the minimum number of "swaps" needed to sort that array.
    */
   
   // The 'swap' can be decomposed into two steps
   // [1] delete from the array; [2] append to the end of the array
   // We only have to swap the elements that are not in its sorted position
   // In this case, the question can be converted into another one:
   // To find the LIS in the original array that is a prefix of the sorted array. The LIS can form
   // the prefix, and the remaining elements should be swapped
   // time: O(nlgn); space: O(n)
   public int getMinSwaps(int[] A){
      int[] old = Arrays.copyOfRange(A, 0, A.length);
      Arrays.sort(A);
      int j=0, N = A.length;
      for (int i=0; i<N; i++){
         if (old[i]==A[j])
            j++;
      }
      return N - j;
   }
   
   @Test
   public void test(){
      int[] A = new int[]{3,1,2,4};
      System.out.println(getMinSwaps(A));
   }
}
