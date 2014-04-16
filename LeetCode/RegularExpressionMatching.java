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

// Recursion, note following cases
// [1] p==""
// [2] s==""
// [3] s=="aXXXX", p=="aXXXX" or p==".XXXX"
// [4] s=="aXXXX", p=="bXXX", (X here represents a random character)
// use char array to save sapce
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s==null || p==null)
            return s==null && p==null;
        return m(s.toCharArray(), p.toCharArray(), 0, 0);
    }
    
    private boolean m(char[] s, char[] p, int i, int j){
        if (j==p.length)
            return i==s.length;
        if (i==s.length)
            return j+1<p.length && p[j+1]=='*' && m(s,p,i,j+2);
        if (s[i]==p[j] || p[j]=='.'){
            boolean isMatch = false;
            if (j+1<p.length && p[j+1]=='*')
                isMatch = isMatch || m(s,p,i+1,j) || m(s,p,i,j+2); // Note m(s,p, i+1, j+2), understand why skip it here
            return isMatch || m(s,p,i+1,j+1);
        }else
            return j+1<p.length && p[j+1]=='*' && m(s,p,i,j+2);
    }
    
}


