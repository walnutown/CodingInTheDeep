// http://n00tc0d3r.blogspot.com/2013/05/regular-expression-matching.html
// TLE in large judge
public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
       if (s == null || p == null){
           return false;
       }
       
       if (s.isEmpty() && (p.isEmpty() || p.length() == 2 && p.charAt(1) == '*')){
           return true;
       }
       
       if (s.isEmpty() && !p.isEmpty() || !s.isEmpty() && p.isEmpty()){
           return false;
       }
       
       if (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)){
           if (p.length() >= 2 && p.charAt(1) == '*'){
               return isMatch(s.substring(1), p)           // more than one char match
               || isMatch(s.substring(1), p.substring(2))  // one match
               || isMatch(s, p.substring(2));               // no match
           }
           else{
               return isMatch(s.substring(1), p.substring(1));
           }
       }
       else if (p.length() >= 2 && p.charAt(1) == '*'){    // current char not match
           return isMatch(s, p.substring(2));
       }
        
        return false;
    }
}


// Submission Result: Time Limit Exceeded

// Last executed input:  "aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c"
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s==null || p==null) return s==null && p==null;
        if (s.length()==0 && p.length()==0) return true;
        if (s.length()==0 && p.length()>0)  return p.length()>=2 && p.charAt(1)=='*' && isMatch(s, p.substring(2));
        if (s.length()>0 && p.length()==0)  return false;
        if (p.length()>1 && p.charAt(1)=='*'){
            if (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0))
                return isMatch(s.substring(1), p.substring(2)) || isMatch(s, p.substring(2)) || isMatch(s.substring(1), p);
            else return isMatch(s, p.substring(2));
        }
        if (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.')   return isMatch(s.substring(1), p.substring(1));
        return false;
    }
}

// Accepted, http://discuss.leetcode.com/questions/175/regular-expression-matching
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s==null || p==null) return s==null && p==null;
        return m(s, p, 0, 0);
    }
    public boolean m(String s, String p, int i, int j){
        if(j == p.length()) return i == s.length();   
        if(j == p.length() - 1 || p.charAt(j + 1) != '*'){
            if(i == s.length()) return false;   
            return (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) && m(s, p, ++i, ++j);
        }                               
        while(i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)))  
            if (m(s, p, i++, j + 2)) return true;
        return m(s, p, i, j + 2);   
    }
}
