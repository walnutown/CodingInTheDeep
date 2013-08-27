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



