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

// check whether the single char is between 1-9, or the continuous two chars is betwen 10-26
// time: O(n); space: O(n)
public class Solution {
    public int numDecodings(String s) {
        if (s==null || s.length()==0)
            return 0;
        int N = s.length();
        int[] dp = new int[N+1];
        char[] ss = s.toCharArray();
        dp[0] = 1;
        dp[1] = ss[0]=='0'? 0:1;
        for (int i=2; i<=N; i++){
            if (ss[i-1]=='0'){
                if (ss[i-2]!='1' && ss[i-2]!='2')   // cannot be decoded
                    return 0;
                else
                    dp[i] = dp[i-2];
            }else{
                dp[i] = dp[i-1];
                if (ss[i-2]=='1' || (ss[i-2]=='2' && ss[i-1]>='0' && ss[i-1]<='6'))
                    dp[i] += dp[i-2];
            }
        }
        return dp[N];
    }
}