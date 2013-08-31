public class Solution {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null || A.length == 0){
            return -1;
        }
        
        int start = 0;
        int end = A.length -1;
        
        return searchHelper(A, start, end, target);
        
    }
    
    public int searchHelper(int[] A, int start, int end, int target){
        if (start > end){
            return -1;
        }
        
        if (target > A[end] && A[end] > A[start]){
            return -1;
        }
        
        if (target < A[start] && A[start] < A[end]){
            return -1;
        }
        
        int mid = start + (end - start)/ 2;
        if (target == A[mid]){
            return mid;
        }
        
        int lSearch = searchHelper(A, start, mid-1, target);
        int rSearch = searchHelper(A, mid+1, end, target); 
        
        return  Math.max(lSearch, rSearch);
        
    }
}