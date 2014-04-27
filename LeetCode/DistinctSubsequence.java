/*
    Given a string S and a string T, count the number of distinct subsequences of T in S.

    A subsequence of a string is a new string which is formed from the original string by
    deleting some (can be none) of the characters without disturbing the relative positions
    of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

    Here is an example:
    S = "rabbbit", T = "rabbit"

    Return 3.
*/

// This quesiton is actually a variant of Subset Sum

// Basic Backtracking
// For each character occurs in T, it can be counted into the subsequence or not.
// time: O(2^n); space: recursive stack
public class Solution {
    public int numDistinct(String S, String T) {
        if (S==null || T==null)
            return 0;
        return dfs(S, T, 0, 0);
    }
    private int dfs(String S, String T, int i, int j){
        if (j==T.length())
            return 1;
        if (i==S.length() && j<T.length())
            return 0;
        int count = 0;
        for (int k=i; k<S.length(); k++){
            if (S.charAt(i)!=T.charAt(j))
                continue;
            count += dfs(S, T, i+1, j+1) + dfs(S, T, i+1, j);
        }
        return count;
    }
}

// Dynamic Programming
// dp[i][j] -- number of subsequences for S[0,i-1] and T[0,j-1]
// time: O(m*n); space: O(m*n)
public class Solution {
    public int numDistinct(String S, String T) {
        if (S==null || T==null)
            return 0;
        int M = S.length(), N = T.length();
        int[][] dp = new int[M+1][N+1];
        dp[0][0] = 1;
        for (int i=1; i<=M; i++)
            dp[i][0] = 1;
        for (int i=1; i<=M; i++){
            for (int j=1; j<=N; j++){
                dp[i][j] = dp[i-1][j];
                if (S.charAt(i-1)==T.charAt(j-1))
                    dp[i][j] += dp[i-1][j-1];
            }
        }
        return dp[M][N];
    }
}
// 1d DP, remember the conditions of transform 2d DP to 1d DP, and how to transfrom 
public class Solution {
    public int numDistinct(String S, String T) {
        if (S==null || T==null) return 0;
        int m=T.length(), n=S.length();
        int[] dp = new int[n+1];
        for (int j=0; j<=n; j++)    dp[j] = 1;
        for (int i=1; i<=m; i++){
            int prev = dp[0];
            dp[0] = 0;
            for(int j=1; j<=n; j++){
                int tmp = dp[j];
                if (T.charAt(i-1) == S.charAt(j-1)) dp[j] = dp[j-1] + prev;
                else    dp[j] = dp[j-1];
                prev = tmp;
            }
        }
        return dp[n];
    }
}