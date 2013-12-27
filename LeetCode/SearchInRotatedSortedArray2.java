// O(n), totally wrong
public class Solution {
    public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null || A.length == 0){
            return false;
        }
        
        int start = 0;
        int end = A.length -1;
        
        return searchHelper(A, start, end, target);  
    }
    
    public boolean searchHelper(int[] A, int start, int end, int target){
        if (start > end){
            return false;
        }
        
        if (target > A[end] && A[end] > A[start]){
            return false;
        }
        
        if (target < A[start] && A[start] < A[end]){
            return false;
        }
        
        int mid = start + (end - start)/ 2;
        if (target == A[mid]){
            return true;
        }
         
        return  searchHelper(A, start, mid-1, target) || searchHelper(A, mid+1, end, target);  
    }
}

// Accepted, O(lgn), worst case O(n)
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