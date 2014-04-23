/*
    Given a sorted array of integers, find the starting and ending position of a given target value.

    Your algorithm's runtime complexity must be in the order of O(log n).

    If the target is not found in the array, return [-1, -1].

    For example,
    Given [5, 7, 7, 8, 8, 10] and target value 8,
    return [3, 4].
*/

// search lower and upper bounds seperately
// time: O(lgn)
public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] res = new int[]{-1,-1};
        if (A == null || A.length == 0) return res;
        int lower = getLowerBound(A, target);
        int upper = getUpperBound(A, target);
        if (lower>upper)    return res;
        res[0] = lower;
        res[1] = upper;
        return res;
    }
    
    private int getLowerBound(int[] A, double target){        
        int start = 0, end = A.length-1;
        while (start <= end){
            int mid = (start + end) >> 1;
            if (A[mid] >= target)   end = mid-1;
            else start = mid+1;
        }
        return end+1; // why? because end will decrement until A[mid]<target, which is one position left off
    }
    
    private int getUpperBound(int[] A, double target){        
        int start = 0, end = A.length-1;
        while (start <= end){
            int mid = (start + end) >> 1;
            if (A[mid] > target)   end = mid-1;
            else start = mid+1;
        }
        return start-1;
    }
}

// binary search target-0.5 and target+0.5
// time: O(lgn)
public class Solution {
    public int[] searchRange(int[] A, int target) {
       int[] res = new int[]{-1,-1};
       int left = binarySearch(A, target-0.5)+1, right = binarySearch(A, target+0.5);
       if (left>right)  return res; // invlid
       res[0] = left;
       res[1] = right;
       return res;
    }   
    private int binarySearch(int[] A, double target){   // Note target type here is double
        int start = 0, end = A.length-1;
        while (start<=end){
            int mid = start + (end-start)/2;
            if (A[mid] == target)
                return mid;
            else if (A[mid]>target)
                end = mid-1;
            else
                start = mid+1;
        }
        return end; 
    }   
}

