/*
    Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

    Return all such possible sentences.

    For example, given
    s = "catsanddog",
    dict = ["cat", "cats", "and", "sand", "dog"].

    A solution is ["cats and dog", "cat sand dog"].
*/
// TLE
public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        if (s==null || s.length()==0)   return null;
        ArrayList<String> res = new ArrayList<String>();
        finder(s, dict, 0, res, "");
        return res;
    }
    public void finder(String s, Set<String> dict, int index, ArrayList<String> res, String str){
        if (index==s.length() && str.length()>0){
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
}

// Need canWordBreak check to avoid TLE
// time: O(n!)
public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        if (s==null || s.length()==0)   return null;
        ArrayList<String> res = new ArrayList<String>();
        if (!canWordBreak(s, dict)) return res;
        finder(s, dict, 0, res, "");
        return res;
    }
    public void finder(String s, Set<String> dict, int index, ArrayList<String> res, String str){
        if (index==s.length() && str.length()>0){
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