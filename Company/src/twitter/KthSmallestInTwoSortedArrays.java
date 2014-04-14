package twitter;

import org.junit.Test;

public class KthSmallestInTwoSortedArrays {
   /*
    * Given two sorted arrays A, B of size m and n respectively. Find the k-th smallest element in
    * the union of A and B. You can assume that there are no duplicate elements.
    */

   // trivial way, merge two arrays and find the k-th smallest element
   // time: O(m+n); space: O(m+n)

   // use two pointers to traverse each array. Each time, we compare the two elements and move the
   // smaller pointer to next. To find the k-th smallest, we only need to move k steps in total
   // similar to Leetcode/IntersectionOfTwoSortedArrays
   // time: O(k); space: O(1)

   // use concurrent binary search, each time, prune the impossible half
   // similar to Leetcode/MedianOfTwoSortedArrays
   // time: O(lg(m+n)); space: O(1)
   public int findKthLargest(int[] A, int[] B, int k) {
      // assume k is always valid
      if (A == null)
         return B[k - 1];
      if (B == null)
         return A[k - 1];
      int as = 0, ae = A.length - 1, bs = 0, be = B.length - 1;
      while (as <= ae && bs <= be) {
         int am = (as + ae) >> 1, bm = (bs + be) >> 1;
         if (A[am] > B[bm]) {
            if (am - as + bm - bs + 2 > k)
               ae = am - 1;
            else {
               k -= (bm - bs+1);
               bs = bm + 1;
            }
         } else {
            if (am - as + bm - bs + 2 > k)
               be = bm - 1;
            else {
               k -= (am - as+1);
               as = am + 1;
            }
         }
      }
      return as > ae ? B[bs + k - 1] : A[as + k - 1];
   }
   
   @Test
   public void test(){
      int[] A = new int[]{1,2,3,5}, B = new int[]{4,6,7,8};
      for (int i=1; i<A.length+B.length-1; i++)
         System.out.println(findKthLargest(A, B, i));
   }
}
