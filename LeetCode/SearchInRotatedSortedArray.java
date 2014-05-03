/*
    Suppose a sorted array is rotated at some pivot unknown to you beforehand.

    (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

    You are given a target value to search. If found in the array return its index, otherwise return -1.

    You may assume no duplicate exists in the array.
*/

// Sol1
// Find the pivot, divide the arrray into two halves, then binary search in both halves
// time: O(lgn)

public class Solution {
    public int search(int[] A, int target) {
        if (A==null || A.length==0) return -1;
        int start = 0, end = A.length-1;
        int pivot = binarySearchPivot(A);
        return Math.max(binarySearch(A, target, 0, pivot), binarySearch(A, target, pivot+1, end));
    }
    
    private int binarySearchPivot(int[] A){
        if (A.length==1)    return 0;
        int start=0, end = A.length-1;
        while (start<=end){
            int mid = start + (end-start)/2;
            if (A[mid]<=A[A.length-1])  end = mid-1;
            else start = mid+1;
        }
        return end;
    }
    private int binarySearch(int[] A, int target, int start, int end){
        while (start<=end){
            int mid = start + (end-start)/2;
            if (A[mid]==target) return mid;
            else if (A[mid]<target) start = mid+1;
            else end = mid-1;
        }
        return -1;
    }
}


// Sol2
// Key observation: at least one of the two halves is ordered in each step of the search
// We find the ordered half first and then check whether the target is in the range, if yes,
// binary search in the half; otherwise, binary search in the unordered half
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