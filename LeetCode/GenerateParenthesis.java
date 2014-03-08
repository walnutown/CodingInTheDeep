/*
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

    For example, given n = 3, a solution set is:

    "((()))", "(()())", "(())()", "()(())", "()()()"
*/

// DFS, use two counters to prune invalid combinations quickly
public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        if (n == 0)
            return res;
        finder(0, 0, n, res, new String());
        return res;
    }
    
    public void finder(int l, int r, int n, ArrayList<String> res, String s){
        if (l > n || r > n || r > l)  return;           // r > l is important here
        if (l == n && r == n){
            res.add(s);
            return;
        }
        finder(l+1, r, n, res, s+"(");
        finder(l, r+1, n, res, s+")");
    }
}