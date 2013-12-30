// Submission Result: Time Limit Exceeded

// Last executed input:	"aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s==null || p==null) return s==null && p==null;
        if (s.length()==0 && p.length()==0) return true;
        if (s.length()>0 && p.length()==0)  return false;
        if (s.length()==0 && p.length()>0)  return p.charAt(0)=='*' && isMatch(s, p.substring(1));
        if (s.charAt(0)==p.charAt(0) || p.charAt(0)=='?')   return isMatch(s.substring(1), p.substring(1));
        if (p.charAt(0)=='*')   return isMatch(s, p.substring(1)) || isMatch(s.substring(1), p);
        return false;
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

// devised from c0mm3nt
public class Solution {
    public boolean isMatch(String s, String p) {
	    if (s==null || p==null)  return s==null && p==null;
	    int m=s.length(), n=p.length(), chars = 0;
	    for (Character c : p.toCharArray())
	        if (c!='*' && m<++chars)    return false;
	    boolean[] matches = new boolean[m+1];
	    matches[0] = true;
	    int i=0, j, firstMatch=0;
	    while (i < p.length()) {
	        if (i>0 && p.charAt(i)=='*' && p.charAt(i-1)=='*'){
	            i++;
	            continue;
	        }
	        if (p.charAt(i) == '*')
	            for (j=firstMatch+1; j<=s.length(); j++)  matches[j] = true;
	        else{
	            int match = -1;
	            for (j=s.length(); j>firstMatch; j--) {
	                matches[j] = (p.charAt(i)==s.charAt(j-1) || p.charAt(i)=='?') && matches[j-1];
	                if (matches[j])  match = j;
	            }
	            if (match < 0)  return false;
	            firstMatch = match;
	        }
	        i++;
	    }
	    return matches[s.length()];
	}
}


















