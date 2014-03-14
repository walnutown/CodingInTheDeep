/*
    Suppose a sorted array is rotated at some pivot unknown to you beforehand.

    (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

    You are given a target value to search. If found in the array return its index, otherwise return -1.

    You may assume no duplicate exists in the array.
*/
// Assertion: no duplicates in the array
// Binary Search, at least one of the two halves is ordered in each dividing step of the search
// time: O(lgn); space: O(1)
public class Solution {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) return -1;
        int start = 0, end = A.length-1;
        while (start <= end){                   // notice "<=" here
            int mid = (start + end) >> 1;
            if (A[mid] == target)   return mid;
            if (A[start] <= A[mid]){
                if (A[start] <= target && target < A[mid])  end = mid-1;
                else start = mid + 1;
            }else{
                if (A[mid] < target && target <= A[end])    start = mid+1;
                else end = mid -1;
            }
        }
        return -1;
    }
}