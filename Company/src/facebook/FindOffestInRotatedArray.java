package facebook;

import org.junit.Test;

public class FindOffestInRotatedArray {
   /*
    * Given an array [1,2,3,4,5,6], rotate it to [5,6,1,2,3,4]
    * Find the offset of the rotated array, in this example, is 2.
    * Note: the original array is in ascending order, there's no duplicates. 
    * offset 0 means there's no rotation.
    */
   
   
   // Modified binary search, each time, compare the mid value with last value of the array
   // time: O(lgn); space: O(1)
   public int getOffset(int[] A){
      if (A==null || A.length==0)
         return 0;
      int start = 0, end = A.length-1;
      while (start<=end){
         int mid = start + (end-start)/2;
         if (A[mid]<A[A.length-1])
            end = mid-1;
         else
            start = mid+1;
      }
      return end+1;
   }
   
   @Test
   public void test(){
      int[] A = new int[]{5,6,1,2,3,4};
      int[] B = new int[]{3,4,5,6,1,2};
      System.out.println(getOffset(A));
      System.out.println(getOffset(B));
   }
}
