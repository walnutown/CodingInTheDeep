/*
    Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

    You may assume no duplicates in the array.

    Here are few examples.
    [1,3,5,6], 5 → 2
    [1,3,5,6], 2 → 1
    [1,3,5,6], 7 → 4
    [1,3,5,6], 0 → 0
*/

// binary search
// The key observation is that: the last step in while loop is start==end==mid, 
// if A[mid]>target, mid is insertion position; if A[mid]<target, mid+1 is insertion position.
// time: O(lgn)
public class Solution {
    public int searchInsert(int[] A, int target) {
        if (A==null || A.length==0) return 0;
        int start=0, end=A.length-1;
        while (start <= end){
            int mid = start + ((end-start)>>1);
            if (A[mid] == target)   return mid;
            else if (A[mid] > target)   end=mid-1;
            else    start=mid+1;
        }
        return start;   // equals 'return end+1;'
    }
}