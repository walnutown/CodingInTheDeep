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

