public class Solution {
    int index;
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null || A.length == 0){
            return -1;
        }
        
        if (target < A[0]){
            return 0;
        }
        
        int len = A.length;
        if (target > A[len-1]){
            return len;
        }
        index = -1; // if not found the target and there's no palce for the target
        searchHelper(A, 0, len-1, target);
        return index;
    }
    
    public void searchHelper(int[] A, int start, int end, int target){
        if (start > end){
            return;
        }
        
        int mid = start + (end- start)/2;
        if (A[mid] == target){
            index = mid;
            return;
        }
        
        if ( mid -1 >= 0 && A[mid-1] < target && target < A[mid] && index == -1){
            index = mid;
            return;
        }
        if (mid +1 < A.length && A[mid] < target && target < A[mid+1] && index == -1){
            index = mid+1;
            return;
        }
        
        searchHelper(A, start, mid-1, target);
        searchHelper(A, mid+1, end, target);
        
    }
}