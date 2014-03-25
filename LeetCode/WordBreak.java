/*
    Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

    For example, given
    s = "leetcode",
    dict = ["leet", "code"].

    Return true because "leetcode" can be segmented as "leet code".
*/

// 2d DP, similar to LongestIncreasingSubsequence, for each index, backtrack the possible result
// time: O(n^2); space: O(n), n is the length of the string s
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s==null || s.length()==0)   return true;
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i=1; i<=s.length(); i++){
            for (int j=i-1; j>=0; j--){
                if (dict.contains(s.substring(j,i)) && dp[j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}