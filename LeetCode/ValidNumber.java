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
public class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0)   return false;
        boolean sign = false;
        boolean dot = false;
        boolean num = false;
        boolean exp = false;
        int len = s.length();
        int i = 0;
        while (i < len && s.charAt(i) == ' ')  i++;
        while (i < len){
            char curr = s.charAt(i);
            if (curr == ' '){
                while (i < len && s.charAt(i) == ' ') i++;
                if (i == s.length()) return num;
                else return false;
            }else if (curr == '-' || curr == '+'){
                if (sign)    return false;
                sign = true;
            }else if (curr >= '0' && curr <= '9'){
                num = true;
                sign = true;    // no sign after num
            }else if (curr == '.'){
                if (dot)    return false;
                dot = true;
                sign = true;    // no sign after dot
            }else if (curr == 'e' || curr == 'E'){
                if (exp || !num)    return false;
                exp = true;    
                num = false;
                sign = false;
                dot = true;     // no dot after exp
            }else   return false;
            i++;
        }
        return num;
    }
}