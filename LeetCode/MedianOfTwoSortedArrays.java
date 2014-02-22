/*
    There are two sorted arrays A and B of size m and n respectively. 
    Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
*/

// http://fisherlei.blogspot.com/2012/12/leetcode-median-of-two-sorted-arrays.html
// Binary search and prune, time: O(lg(m+n))
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