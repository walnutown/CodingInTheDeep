/*
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

    For example, given n = 3, a solution set is:

    "((()))", "(()())", "(())()", "()(())", "()()()"
*/

// Recursion
// Maintain two variables to track the number of left and right parenthesis so far
// prune the invalid string if r>l || r<0 || l<0
// time: O(2^(2n)); 
public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        if (n == 0)
            return res;
        finder(n, n, res, new String());
        return res;
    }
    
    public void finder(int l, int r, ArrayList<String> res, String s){
        if (l <0 || r <0 || r > l)  // r>l is also invalid
            return; 
        if (l == 0 && r == 0){
            res.add(s);
            return;
        }
        finder(l-1, r, n, res, s+"(");
        finder(l, r-1, n, res, s+")");
    }
}