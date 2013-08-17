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