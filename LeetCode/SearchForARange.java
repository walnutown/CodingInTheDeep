public class Solution {
    int[] res;
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        res = new int[]{-1, -1};
        if (A == null || A.length == 0){
            return res;
        }
        searchHelper(A, 0, A.length -1 , target);
        return res;
    }
    
    public void searchHelper(int[] A, int start, int end, int target){
        if (start > end){
            return; 
        }
        int mid = start + (end-start)/2;
        if (A[mid] == target){
            if (res[0] == -1){
                res[0] = mid;
            }
            if (mid < res[0]){
                res[0] = mid;
            }
            if (mid > res[1]){
                res[1] = mid;
            }
        }
        searchHelper(A, start, mid-1, target);
        searchHelper(A, mid+1, end, target);
    }
}
