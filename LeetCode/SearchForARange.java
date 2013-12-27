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

// Not O(lgn), worst case O(n)
public class Solution {
    int[] res;
    public int[] searchRange(int[] A, int target) {
        int[] res = new int[]{-1,-1};
        if (A == null || A.length == 0) return res;
        finder(A, 0, A.length-1, target, res);
        return res;
    }
    
    public void finder(int[] A, int start, int end, int target, int[] res){
        if (start > end)    return;
        int mid = (start + end) >> 1;
        if (A[mid] < target)    finder(A, mid+1, end, target, res);
        else if (A[mid] > target)    finder(A, start, mid-1, target, res);
        else{
            if (res[0] == -1){
                res[0] = mid;
                res[1] = mid;
            }else{
                res[0] = Math.min(res[0], mid);
                res[1] = Math.max(res[1], mid);
            }
            finder(A, mid+1, end, target, res);
            finder(A, start, mid-1, target, res);
        }
    }
}

// Accepted, binary search target-0.5 and target+0.5
public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] res = new int[]{-1,-1};
        if (A == null || A.length == 0) return res;
        int low = binarySearch(A, target-0.5);
        if (low >= A.length || A[low] != target) return res;
        int high = binarySearch(A, target+0.5) - 1;
        res[0] = low;
        res[1] = high;
        return res;
    }
    
    public int binarySearch(int[] A, double target){        // the return value is the index of the number after the target
        int start = 0, end = A.length-1;
        while (start <= end){
            int mid = (start + end) >> 1;
            if (A[mid] == target)   return mid;
            else if (A[mid] > target)   end = mid-1;
            else start = mid+1;
        }
        return start;
    }
}
