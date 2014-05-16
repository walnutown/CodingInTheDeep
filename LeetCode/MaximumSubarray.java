/*
    Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

    For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
    the contiguous subarray [4,−1,2,1] has the largest sum = 6.

    More practice:
    If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

// http://en.wikipedia.org/wiki/Maximum_subarray_problem
// Kadane's Algorithm (1984)

// Dynamic Programming
// sum -- the max subarray sum ending at current value
// max -- the max subarray sum found so far
// In each day, we check the previous max, if max>0, we add current value to the subarray
// if max<0, we choose current day as a new starting point for subarray
// time: O(n); space: O(1)
public class Solution {
    public int maxSubArray(int[] A) {
        if (A==null || A.length==0) return 0;
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i=0; i<A.length; i++){
            // if sum+A[i] < A[i], we start a new subarray
            sum = Math.max(A[i], sum+A[i]); 
            max = Math.max(sum, max);
        }
        return max;
    }
}
// Divide and Conquer
// time: O(nlgn); space: O(1)
public class Solution {
    public int maxSubArray(int[] A) {
        if (A==null || A.length==0) return 0;
        return finder(A, 0, A.length-1);
    }
    
    public int finder(int[] A, int start, int end){
        if (start > end)    return Integer.MIN_VALUE;
        int mid = start + ((end - start)>>1);           // notice here, cannot omit the out-nested brackets
        int left=Integer.MIN_VALUE, right=Integer.MIN_VALUE, sum=0;
        for (int i=mid+1; i<=end; i++){
            sum += A[i];
            right = Math.max(sum,right);
        }
        sum = 0;
        for (int i=mid-1; i>=start; i--){
            sum += A[i];
            left = Math.max(sum, left);
        }
        int mmax = A[mid] + Math.max(left, 0) + Math.max(right, 0);
        return Math.max(mmax, Math.max(finder(A, start, mid-1), finder(A, mid+1, end)));
    }
}
