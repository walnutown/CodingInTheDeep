/*
  Implement regular expression matching with support for '.' and '*'.

  '.' Matches any single character.
  '*' Matches zero or more of the preceding element.

  The matching should cover the entire input string (not partial).

  The function prototype should be:
  bool isMatch(const char *s, const char *p)

  Some examples:
  isMatch("aa","a") → false
  isMatch("aa","aa") → true
  isMatch("aaa","aa") → false
  isMatch("aa", "a*") → true
  isMatch("aa", ".*") → true
  isMatch("ab", ".*") → true
  isMatch("aab", "c*a*b") → true
*/

// Recursion
// http://discuss.leetcode.com/questions/175/regular-expression-matching
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s==null || p==null) return s==null && p==null;
        return m(s.toCharArray(), p.toCharArray(), 0, 0);
    }
    public boolean m(char[] s, char[] p, int i, int j){
        if(j == p.length) return i == s.length;   
        if(j == p.length - 1 || p[j + 1] != '*'){
            if(i == s.length) return false;   
            return (p[j] == '.' || s[i] == p[j]) && m(s, p, i+1, j+1);
        }
        while(i < s.length && (p[j] == '.' || s[i] == p[j]))  // p[j+1] == '*'
            if (m(s, p, i++, j + 2)) return true;
        return m(s, p, i, j + 2);   
    }
}