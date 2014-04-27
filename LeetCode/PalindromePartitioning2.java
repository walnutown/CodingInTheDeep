/*
  Given a string s, partition s such that every substring of the partition is a palindrome.

  Return the minimum cuts needed for a palindrome partitioning of s.

  For example, given s = "aab",
  Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/

// Dynamic Programming
// dp[i] -- minimum cut of s.substring(0,i)
// time: O(n^3); space: O(n)
public class Solution {
    public int minCut(String s) {
        if (s==null || s.length()==0)
            return 0;
        int N = s.length();
        int[] dp = new int[N+1];
        dp[0] = -1;
        for (int i=1; i<=N; i++){
            dp[i] = i-1;
            for (int j=0; j<=i-1; j++){
                String sub = s.substring(j,i);
                if (isPalindrome(sub))
                    dp[i] = Math.min(dp[i], dp[j]+1);
            }
        }
        return dp[N];
    }
    private boolean isPalindrome(String s){
        if (s==null || s.length()==0)
            return false;
        for (int i=0, j=s.length()-1; i<j; i++,j--){
            if (s.charAt(i)!=s.charAt(j))
                return false;
        }
        return true;
    }
    
}

// Use a 2d matrix to reduce palindrome checking from O(n) to O(1)
// time: O(n^2); space: O(n^2)
public class Solution {
    public int minCut(String s) {
        if (s==null || s.length()==0)
            return 0;
        int N = s.length();
        int[] dp = new int[N+1];
        boolean[][] isP = new boolean[N][N];
        for (int i=0; i<N; i++)
            isP[i][i] = true;
        // if the whole string is a palindrome, we still increment by 1. So, we need to set initial value to -1
        dp[0] = -1;     
        for (int i=1; i<=N; i++){
            dp[i] = i-1;
            for (int j=0; j<=i-1; j++){
                if (s.charAt(j)==s.charAt(i-1) &&(j+1>i-2 || isP[j+1][i-2])){
                    isP[j][i-1] = true;
                    dp[i] = Math.min(dp[i], dp[j]+1);
                }
            }
        }
        return dp[N];
    }
}