// partial works
public class Solution {
    
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = A.length;
        if (A == null && len == 0){
            return 0;
        }
        if (len == 1){
            return A[0];
        }
        int disSum = 0;
        int[] mem = new int[len];
        mem[0] = A[0];
        for (int i = 1; i < len; i++){
                int left = mem[i-1];
                int right = A[i];
                int both = left + disSum + right;
                mem[i] = Math.max(both, Math.max(left, right));
                if (mem[i] == left){
                    disSum += A[i];
                }
                else if (mem[i] == right){
                    disSum = 0;
                }
                else{
                    disSum = 0;
                }
        }
        
        return mem[len-1];  
    }  
}

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
// use master method
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

// we can have a DP solution with O(n) extra space
public class Solution {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) return 0;
        int[] mem = new int[A.length + 1];
        mem[1] = A[0];
        int max = mem[1];
        for (int i = 2; i <= A.length; i++){
            mem[i] = Math.max(mem[i-1] + A[i-1], A[i-1]);
            max = Math.max(max, mem[i]);
        }
        return max;
    }
}


// Maximum Subarray Problem can be transformed to Stock Problem,
// but need O(n) extra space and pass the array two times (one time to create array, another time to get the max increment)
public class Solution {
    public int maxSubArray(int[] A) {
        // use transformation
        if (A == null || A.length == 0) return 0;
        if (A.length == 1) return A[0];
        int[] B = new int[A.length+1];
        B[0] = 0;
        for (int i = 1; i <= A.length; i++){
            B[i] = B[i-1] + A[i-1];
        }
        int min = B[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < B.length; i++){
            max = Math.max(B[i] - min, max);
            min = Math.min(min, B[i]);
        }
        return max;
    }
}

