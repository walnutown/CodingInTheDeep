/*
    Implement wildcard pattern matching with support for '?' and '*'.

    '?' Matches any single character.
    '*' Matches any sequence of characters (including the empty sequence).

    The matching should cover the entire input string (not partial).

    The function prototype should be:
    bool isMatch(const char *s, const char *p)

    Some examples:
    isMatch("aa","a") → false
    isMatch("aa","aa") → true
    isMatch("aaa","aa") → false
    isMatch("aa", "*") → true
    isMatch("aa", "a*") → true
    isMatch("ab", "?*") → true
    isMatch("aab", "c*a*b") → false
*/


// Sol1
// Recursion
// TLE
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s==null || p==null) return false;
        int M = s.length(), N = p.length();
        if (M==0 && N==0)   return true;
        if (M==0)   return p.charAt(0)=='*' && isMatch(s, p.substring(1));
        if (N==0)   return false;
        if (s.charAt(0)==p.charAt(0) || p.charAt(0)=='?'){
            if (isMatch(s.substring(1), p.substring(1)))    return true;
        }
        return p.charAt(0)=='*' && (isMatch(s, p.substring(1)) || isMatch(s.substring(1), p));
    }
}

// from sophie,
public class Solution {
    public boolean isMatch(String s, String p) {
    if (s == null || p == null)  return false;
    // calculate count for non-wildcard char
    int count = 0;
    for (Character c : p.toCharArray()) {
        if (c != '*')  ++count;
    }
    // the count should not be larger than that of s
    if (count > s.length())  return false;
    boolean[] matches = new boolean[s.length()+1];
    matches[0] = true;
    int pid = 0, firstMatch = 0;
    while (pid < p.length()) {
        // skip duplicate '*'
        if (pid > 0 && p.charAt(pid) == '*' && p.charAt(pid-1) == '*') {
            ++pid;
            continue;
        }
        // if '*', fill up the rest of row
        if (p.charAt(pid) == '*') {
            // fill up the rest of row with true, up to the first match in previous row
            for (int i = firstMatch+1; i <= s.length(); ++i)  matches[i] = true;
        } else {
            // fill up backwards:
            // - set to true if match current char and previous diagnal also match
            // - otherwise, set to false
            int match = -1;
            for (int i=s.length(); i>firstMatch; --i) {
                matches[i] = (p.charAt(pid) == s.charAt(i-1) || p.charAt(pid) == '?')
                            && matches[i-1];
                if (matches[i])  match = i;
            }
            if (match < 0)  return false;
            firstMatch = match;
        }
        ++pid;
    }
    return matches[s.length()];
    }
}

// The difficulty mainly lies in that '*' can match with a sequence of characters
// The trick here is to maintain two pointers to hold the backup positions for pointers i,j in s,p
// Once we find that s.substring(i, j) can not be replaced by '*', we try s.subtring(i+1,j).

public class Solution {
    public boolean isMatch(String s, String p) {
        if (s==null || p==null) return false;
        int M = s.length(), N = p.length();
        int sb = -1, pb = -1, i=0, j=0;
        while (i<M ){
            if (j<N && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')){
                i++; j++;
            }else if (j<N && p.charAt(j)=='*'){
                while (j<N && p.charAt(j)=='*') j++;    // ignore duplicate '*'
                if (j==N)   return true;
                sb = i; pb = j;
            }else{  // mistach, if there's backup, move to backup position;otherwise, return false;
                if (sb==-1) return false;   // No backup found
                i = ++sb;
                j = pb;
            }
        }
        while (j<N && p.charAt(j)=='*') j++;
        return j==N;
    }
}
