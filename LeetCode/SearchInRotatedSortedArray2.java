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