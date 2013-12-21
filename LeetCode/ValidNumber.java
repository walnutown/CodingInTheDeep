// didn't pass small judge, need deal with other cases
public class Solution {
    public boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null || s.equals("")){
            return false;
        }
        boolean hasNumber = false;
        int periodCon = 0;
        int eCon = 0;  
        
        int i =0;
        int len = s.length();
        // remove head ws
        while(s.charAt(i) == ' '){
            i++;
            if (i == len){
                return false;
            }
        }
        if ( s.charAt(i) == '+' || s.charAt(i) == '-'){
            i++;
        }
        
        // remove trailing ws
        while(s.charAt(len - 1) == ' '){
            len--;
        }
        
        // no number
       /* if (i >= len){
            return false;
        }
        */
        
        
        
        while (i < len){
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                i++;
                if (!hasNumber){
                    hasNumber = true;
                }
            }
            else if (s.charAt(i) == 'e' ){
                i++;
                eCon++;
                if (i == len){
                    return false;
                }
            }
            else if (s.charAt(i) == '.'){
                i++;
                periodCon++;
            }
            else{
                return false;
            }
        }
        if (!hasNumber || eCon > 1 || periodCon > 1){
            return false;
        }
        
        
        return true;
    }
}




// from Internet, pass large judge
class Solution {
public:
    bool isNumber(const char *s) {
        if (s == NULL || s[0] == '\0') return false;
        bool cansign = true;
        bool cane = false;
        bool havee = false;
        bool candot = true;
        bool onlyspace = false;
        bool havenum = false;
        bool numbegin = false;
        while(*s != '\0') {
            char c = *(s++);
            if (c == ' '){
                if (numbegin)
                    onlyspace = true;
                continue;//skip space
            } else if (onlyspace) {
                return false;
            }
            if (c == '+' || c == '-') {
                if(!cansign) return false;
                cansign = false;
                numbegin = true;
                continue;
            }
            if (c == 'e') {
                if(!cane) return false;
                cane = false;
                havenum = false;
                numbegin = true;
                cansign = true;
                havee = true;
                candot = false;
                continue;
            }
            if (c == '.') {
                if(!candot) return false;
                candot = false;
                numbegin = true;
                cansign = false;
                continue;
            }
            if (c >= '0' && c <= '9') {
                havenum = true;
                numbegin = true;
                cansign = false;
                if(!havee) cane = true;
            } else {
                return false;
            }
        }
        return havenum;
    }
};



public class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0)   return false;
        // false here means the character is allowed to be used
        // true means has been used
        boolean sign = false;
        boolean dot = false;
        boolean num = false;
        boolean exp = false;
        int len = s.length();
        int i = 0;
        // deal with leading 
        while (i < len && s.charAt(i) == ' ')  i++;
        while (i < len){
            char curr = s.charAt(i);
            if (curr == ' '){
                // deal with trailing
                while (i < len && s.charAt(i) == ' ') i++;
                if (i == s.length()) return num;
                else return false;
            }
            else if (curr == '-' || curr == '+'){
                if (sign || num)    return false; // sign must before num
                sign = true;
            }else if (curr >= '0' && curr <= '9')
                num = true;
            else if (curr == '.'){
                if (dot)    return false;
                dot = true;
                sign = true;                    // sign cannot after dot
            }else if (curr == 'e' || curr == 'E'){
                if (exp || !num)    return false;   // exp must after num
                exp = true;
                num = false;
                sign = false;
                dot = true;
            }else   return false;
            i++;
        }
        return num;
    }
}

// trial 3, refactor code
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