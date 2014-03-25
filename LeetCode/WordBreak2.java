/*
    Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

    Return all such possible sentences.

    For example, given
    s = "catsanddog",
    dict = ["cat", "cats", "and", "sand", "dog"].

    A solution is ["cats and dog", "cat sand dog"].
*/

// read this interesting post, http://thenoisychannel.com/2011/08/08/retiring-a-great-interview-problem/
// notice that, in the post, we're only required to provide a vlid word break. Memoization is used to
// avoid duplicate calculation. We also has to mem the invalid substring 
// running time analyze: there're totally n suffixes, each will be calculated once, 1+2+3+..+n = n^2


// Need canWordBreak check to avoid TLE
// DFS
// time: O(2^n) (why? at each index, we can break or not break, that's 2^n) 
public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        if (s==null || s.length()==0)   return null;
        ArrayList<String> res = new ArrayList<String>();
        if (!canWordBreak(s, dict)) return res;
        finder(s, dict, 0, res, "");
        return res;
    }
    public void finder(String s, Set<String> dict, int index, ArrayList<String> res, String str){
        if (index==s.length() && str.length()>0){ // note if str.length()==0, no valid break here
            res.add(str.substring(0, str.length()-1));
            return;
        }
        for (int i=index; i<s.length(); i++){
            String word = s.substring(index,i+1);
            if (dict.contains(word)){
                finder(s, dict, i+1, res, str+word+" ");
            }
        }
    } 
    public boolean canWordBreak(String s, Set<String> dict) {
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