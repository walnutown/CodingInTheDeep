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

// #2, miss cases
// Input:  "aaa", "ab*a"
// Output: true
// Expected: false
public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null || p == null){
            if (s == null && p == null)
                return true;
            return false;
        }
        // ""
        if (s.length() == 0){
            if (p.length() == 0)
                return true;
            if (p.length() == 1)
                return false;
            if (p.charAt(1) == '*')
                return isMatch(s, p.substring(2));
            return false;
        }
        //"a"
        if (s.length() == 1){
            if (p.length() == 0)
                return false;
            if (p.length() == 1)
                return p.equals(s) || p.equals(".");
            if (p.charAt(1) == '*')
                return p.charAt(0) == '.'? isMatch(s.substring(1), p.substring(2)) : isMatch(s, p.substring(2));
            return false;
        }
        // "aa"
        if (s.charAt(0) == s.charAt(1)){
            if (p.length() <= 1)
                return false;
            if (p.charAt(1) == '*')
                return p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)? isMatch(s, p.substring(2)) || isMatch(s.substring(1), p.substring(2)) || isMatch(s.substring(2), p.substring(2)) : isMatch(s, p.substring(2));
            if (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'){
                return p.charAt(1) == s.charAt(1)|| p.charAt(1) == '.' ? isMatch(s.substring(2), p.substring(2)) : isMatch(s.substring(1), p.substring(1));
            }
            return false;
        }
        // "ab"
        if (p.length() <= 1)
            return false;
        if (p.charAt(1) == '*')
            return p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)? isMatch(s, p.substring(2)) || isMatch(s.substring(1), p.substring(2)) || isMatch(s.substring(2), p.substring(2)) : isMatch(s, p.substring(2)) || isMatch(s.substring(1), p.substring(2));
        if (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')
            return p.charAt(1) == s.charAt(1) || p.charAt(1) == '.'? isMatch(s.substring(2), p.substring(2)) : isMatch(s.substring(1), p.substring(1));
        return false;
    }
}
