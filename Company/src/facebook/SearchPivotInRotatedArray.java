package facebook;

import org.junit.Test;

public class SearchPivotInRotatedArray {
   /**
    * Given an array [1,2,3,4,5,6], rotate it to [5,6,1,2,3,4]
    * Find the offset of the rotated array, in this example, is 2.
    * Note: the original array is in ascending order, there's no duplicates. 
    * offset 0 means there's no rotation.
    */
   
   // The pivot is the rightmost element that is larger than the last element in the array
   // Modified binary search, each time, compare the mid value with last value of the array
   // Note the edge case
   // [1] A.length==1
   // [2] A.length==2
   // time: O(lgn); space: O(1)
   public int getPivot(int[] A){
      if (A==null || A.length==0)
         return 0;
      if (A.length==1)  return 0;
      int start = 0, end = A.length-1;
      while (start<=end){
         int mid = start + (end-start)/2;
         if (A[mid]<=A[A.length-1])     // "<=" here, because the last element will never be the pivot
            end = mid-1;
         else
            start = mid+1;
      }
      return end;
   }
   
   @Test
   public void test(){
      int[] A = new int[]{5,6,1,2,3,4};
      int[] B = new int[]{3,4,5,6,1,2};
      int[] C = new int[]{3,1};
      int[] D = new int[]{1};
      System.out.println(getPivot(A));
      System.out.println(getPivot(B));
      System.out.println(getPivot(C));
      System.out.println(getPivot(D));
   }
}
