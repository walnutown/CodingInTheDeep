/*
    A message containing letters from A-Z is being encoded to numbers using the following mapping:

    'A' -> 1
    'B' -> 2
    ...
    'Z' -> 26
    Given an encoded message containing digits, determine the total number of ways to decode it.

    For example,
    Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

    The number of ways decoding "12" is 2.
*/

// Dynamic Programming
// check whether the single char is between 1-9, or the continuous two chars is betwen 10-26
// time: O(n); space: O(n)
public class Solution {
    public int numDecodings(String s) {
        if (s==null || s.length()==0)
            return 0;
        int N = s.length();
        int[] dp = new int[N+1];
        dp[0] = 1;      // Note the initialization step here, should be 1, not 0
        for (int i=1; i<=N; i++){
            if (s.charAt(i-1)>='1' && s.charAt(i-1)<='9')
                dp[i] += dp[i-1];
            if (i>=2 && (s.charAt(i-2)=='1' && s.charAt(i-1)>='0' && s.charAt(i-1)<='9'
                || s.charAt(i-2)=='2' && s.charAt(i-1)>='0' && s.charAt(i-1)<='6'))
                dp[i] += dp[i-2];
        }
        return dp[N];
    }
}