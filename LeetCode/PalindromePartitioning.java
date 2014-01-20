/*
  Given a string s, partition s such that every substring of the partition is a palindrome.

  Return all possible palindrome partitioning of s.

  For example, given s = "aab",
  Return

    [
      ["aa","b"],
      ["a","a","b"]
    ]
*/

// DFS, time: O(n^2); space: recursive stack
public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if (s == null || s.length() == 0)   return res;
        finder(s, 0, res, new ArrayList<String>());
        return res;
    }
    
    public void finder(String s, int index, ArrayList<ArrayList<String>> res, ArrayList<String> r){
        if (index == s.length()){
            res.add(new ArrayList<String>(r));
            return;
        }
        for (int i = index; i < s.length(); i++){
            String w = s.substring(index, i+1);
            if (isPalindrome(w)){
                r.add(w);
                finder(s, i+1, res, r);
                r.remove(r.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String w){
        if (w == null || w.length() == 0)   return false;
        int i = 0, j = w.length()-1;
        while (i < j)
            if (w.charAt(i++) != w.charAt(j--)) return false;
        return true;
    }
}