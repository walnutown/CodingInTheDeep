// O(n) solution
public class Solution {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = A.length;
        if (A == null || len == 0 ){
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i = 0; i < len; i++){
            sum += A[i];
            max = Math.max(max, sum);
            // if sum < 0, neg plus A[i], equals that A[i] is reduced
            // so, we just need to throw away the previous sum
            if (sum < 0){
                sum = 0;
            }
        }
        
        return max;
    }
}


// divide and conquer
public class Solution {
    int len;
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        len = A.length;
        if (A == null || len == 0){
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        return findMax(A, 0, len -1, max);
        
    }
    
    public int findMax(int[] A, int start, int end, int max){
        if (start > end){
            return Integer.MIN_VALUE;
        }
        int mid = start + (end - start) /2;
        int lMax = findMax(A, start, mid-1, max);
        int rMax = findMax(A, mid+1, end, max);
        max = Math.max(Math.max(lMax, rMax), max);
        int sum = 0;
        int lmaxSum = 0;
        for (int i = mid-1; i >= start; i--){
            sum += A[i];
            lmaxSum = Math.max(lmaxSum, sum);
            
        }
        
        sum = 0;
        int rmaxSum = 0;
        for (int i = mid + 1; i <= end; i++){
            sum += A[i];
            rmaxSum = Math.max(rmaxSum, sum);
        }
        
        max = Math.max(max, rmaxSum + lmaxSum + A[mid]);
        return max;
    }
    
}


// Maximum Subarray Problem can be transformed to Stock Problem,
// but need O(n) extra space and pass the array two times (one time to create array, another time to get the max increment)






// Submission Result: Wrong Answer
// Input:  [-1]
// Output: 0
// Expected:   -1
public class Solution {
    public int maxSubArray(int[] A) {
        if (A==null || A.length==0) return 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i=0; i<A.length; i++){
            sum = sum+A[i] <= 0 ? 0 : sum+A[i];
            max = Math.max(sum, max);
        }
        return max;
    }
}
// Accepted
public class Solution {
    public int maxSubArray(int[] A) {
        if (A==null || A.length==0) return 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i=0; i<A.length; i++){
            sum += A[i];
            max = Math.max(sum, max);
            sum = sum<0 ? 0 : sum;
        }
        return max;
    }
}
// Accepted, Divide and Conquer
public class Solution {
    public int maxSubArray(int[] A) {
        if (A==null || A.length==0) return 0;
        return finder(A, 0, A.length-1);
    }
    
    public int finder(int[] A, int start, int end){
        if (start > end)    return Integer.MIN_VALUE;
        int mid = start + ((end - start)>>1);           // notice here, cannot omit the out-nested brackets
        int left=Integer.MIN_VALUE, right=Integer.MIN_VALUE, sum=0;
        for (int i=mid+1; i<=end; i++){
            sum += A[i];
            right = Math.max(sum,right);
        }
        sum = 0;
        for (int i=mid-1; i>=start; i--){
            sum += A[i];
            left = Math.max(sum, left);
        }
        int mmax = A[mid] + Math.max(left, 0) + Math.max(right, 0);
        return Math.max(mmax, Math.max(finder(A, start, mid-1), finder(A, mid+1, end)));
    }
}
