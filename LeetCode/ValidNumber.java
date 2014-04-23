/*
    Validate if a given string is numeric.

    Some examples:
    "0" => true
    " 0.1 " => true
    "abc" => false
    "1 a" => false
    "2e10" => true
    Note: It is intended for the problem statement to be ambiguous. 
    You should gather all requirements up front before implementing one.
*/

// mark the character appeared and do state check
// time: O(n)
public class Solution {
    public boolean isNumber(String s) {
        if (s==null || s.length()==0)
            return false;
        boolean sign = false, dot = false, exp = false, num = false;
        int N = s.length(), i = 0, j=N-1;
        while (i<j && s.charAt(i)==' ') i++;    // trim leading whitespace
        while (i<j && s.charAt(j)==' ') j--;    // trim trailing whitespace
        if (i>j)   return false;    // all whitespace
        while(i<=j){
            char ch = s.charAt(i);
            if (ch>='0' && ch<='9'){
                num = true;
                sign = true;        // no sign after num
            }else if (ch=='+' || ch=='-'){
                if (sign)   return false;
                sign = true;        
            }else if (ch=='.'){
                if (dot)    return false;
                dot = true;
                sign = true;        // no sign after num
            }else if (ch=='e' || ch=='E'){
                if (exp || !num)    return false;
                exp = true;         
                sign = false;       // allow sign after e
                num = false;        
                dot = true;         // no dot after e
            }else   return false;
            i++;
        }
        return num; // should have numeric characters
    }
}