/*
    There are two sorted arrays A and B of size m and n respectively. 
    Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
*/

// http://fisherlei.blogspot.com/2012/12/leetcode-median-of-two-sorted-arrays.html
// Binary search and prune, recursion.
// time: O(lg(m+n))
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length, n = B.length;
        if (((m+n)&0x01) > 0)   return finder(A, 0, m-1, B, 0, n-1, (m+n)/2);
        else    return (finder(A, 0, m-1, B, 0, n-1, (m+n)/2) + finder(A, 0, m-1, B, 0, n-1, (m+n)/2-1))/2.0;
    }
    
    public double finder(int A[], int as, int ae, int[] B, int bs, int be, int target){
        if (as > ae)    return B[bs + target];
        if (bs > be)    return A[as + target];
        int am = (as + ae) >>1;
        int bm = (bs + be) >>1;
        if (A[am] > B[bm]){
            if ((am-as + bm-bs + 1) > target)  return finder(A, as, am-1, B, bs, be, target);
            else return finder(A, as, ae, B, bm+1, be, target-(bm-bs+1));
        }else{
            if ((am-as + bm-bs + 1) > target)   return finder(A, as, ae, B, bs, bm-1, target);
            else return finder(A, am+1, ae, B, bs, be, target-(am-as+1));
        }
    }
}

// iterative version
// time: O(lg(m+n))
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length, n = B.length;
        if (((m+n)&0x01) > 0)   return finder(A, B, (m+n)/2+1);
        else    return (finder(A, B, (m+n)/2) + finder(A, B, (m+n)/2+1))/2.0;
    }
    
    public double finder(int A[], int[] B, int k){
        // assume k is always valid
      if (A == null || A.length == 0)
         return B[k - 1];
      if (B == null || B.length == 0)
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
}