/*
    Given an array of non-negative integers, you are initially positioned at the first index of the array.

    Each element in the array represents your maximum jump length at that position.

    Your goal is to reach the last index in the minimum number of jumps.

    For example:
    Given array A = [2,3,1,1,4]

    The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
*/

// Dynamic Programming
// time: O(n^2), TLE in Leetcode OJ; space: O(n^2)
public class Solution {
    public int jump(int[] A) {
        if (A==null || A.length==0) return 0;
        int N = A.length;
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i=1; i<N; i++){
            int range = A[i];
            for (int j=1; j<=range && ((i+j)<N); j++){ 
                if (dp[i+j] == 0)   dp[i+j] = dp[i] + 1;
                else dp[i+j] = Math.min(dp[i+j], dp[i]+1);
            }
        }
        return dp[N];
    }
}

// Maintain two reaches, one is the previous max reach, another is the current max reach
// When we run out of the previous max reach, it's time to add one more step
// time: O(n); space: O(1)
public class Solution {
    public int jump(int[] A) {
        if (A==null || A.length==0)
            return 0;
        int N = A.length, step = 0, prevMax = 0, currMax = 0;
        for (int i=0; i<N; i++){
            if (i>prevMax){
                prevMax = currMax;
                step++;
            }
            currMax = Math.max(currMax, i+A[i]);
        }
        return step;
    }
}