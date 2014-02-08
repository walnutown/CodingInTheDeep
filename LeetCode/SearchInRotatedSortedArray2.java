/*
    Follow up for "Search in Rotated Sorted Array":
    What if duplicates are allowed?

    Would this affect the run-time complexity? How and why?

    Write a function to determine if a given target is in the array.
*/

// time: average, O(lgn), worst case O(n)
public class Solution {
    public boolean search(int[] A, int target) {
        // allow duplicates
        if (A == null || A.length == 0) return false;
        int start = 0, end = A.length-1;
        while (start <= end){
            int mid = (start + end) >> 1;
            if (A[mid] == target)   return true;
            if (A[start] < A[mid]){
                if (A[start] <= target && target < A[mid])  end =mid-1;
                else start = mid+1;
            }else if (A[start] > A[mid]){
                if (A[mid] < target && target <= A[end])    start = mid+1;
                else end = mid-1;
            }else   start++;
        }
        return false;
    }
}