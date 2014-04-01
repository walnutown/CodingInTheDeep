/*
    A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

    The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

    How many possible unique paths are there?
*/


// 2d DP, time: O(m*n); space: O(m*n)
public class Solution {
    public int uniquePaths(int m, int n) {
        if (m==0 || n==0)   return 0;
        int[][] mem = new int[m][n];
        for (int i=0; i<m; i++)   mem[i][0] = 1;
        for (int j=1; j<n; j++)   mem[0][j] = 1;
        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                mem[i][j] = mem[i-1][j] + mem[i][j-1];
            }
        }
        return mem[m-1][n-1];
    }
}

// 2d DP, optimize space. time: O(m*n); space: O(n)
public class Solution {
    public int uniquePaths(int m, int n) {
        if (m==0 || n==0)   return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i=1; i<n; i++)    dp[i] = 1;
        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[n-1];
    }
}

// transform the problem to the following:
// How many different strings of size m+n, consisting of m Rs and n Ds, are there?
// use Combination formula, time: O(m+n); space: O(m+n)
// yet, may cause overflow when m or n is big
// refer: http://joaoff.com/2008/01/20/a-square-grid-path-problem/
public class Solution {
    public int uniquePaths(int m, int n) {
        if (m==0 || n==0)   return 0;
        long[] F = new long[m+n+1];
        F[1] = 1;
        for (int i=2; i<=m+n; i++)
            F[i] = F[i-1] * i;
        return (int)(F[m+n]/F[m]/F[n]);
    }
}