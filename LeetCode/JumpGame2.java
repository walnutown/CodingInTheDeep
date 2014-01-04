// OJ 
public class Solution {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int step = 0;
        int currMax = 0;
        int nextMax = 0;
        for (int i = 0; i < A.length; i++){
            if (i > currMax){
                currMax = nextMax;
                step++;
            }
            nextMax = Math.max(A[i] + i, nextMax);
        }
        return step;
    }
} 


// 2d DP, TLE, O(n^2)
public class Solution {
    public int jump(int[] A) {
        if (A==null || A.length==0) return 0;
        int[] dp = new int[A.length+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i=1; i<A.length; i++){
            int range = A[i];
            for (int j=1; j<=range && ((i+j)<A.length); j++){ 
                if (dp[i+j] == 0)   dp[i+j] = dp[i] + 1;
                else dp[i+j] = Math.min(dp[i+j], dp[i]+1);
            }
        }
        return dp[A.length];
    }
}

// assume that final pos can always be reached, update the max range of next step using current range
public class Solution {
    public int jump(int[] A) {
        if (A==null || A.length==0) return 0;
        int step=0, curr_range=0, prev_range=0;
        for (int i=0; i<A.length; i++){
            if (i > prev_range){
                prev_range = curr_range;
                step++;
            }
            curr_range = Math.max(curr_range, A[i]+i);
        }
        return step;
    }
}
