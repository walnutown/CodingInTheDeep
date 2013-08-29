// note the index of char should be in the range
public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null || s.length() == 0){
            return 0;
        }
        
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() > 0){
            if (sb.charAt(sb.length()-1) == ' '){
                sb.deleteCharAt(sb.length()-1);
            }
            else{
                break;
            }
        }
        
        // if the string is all space
        if (sb.length() == 0){
            return 0;
        }
     
        int len = 0;
        int i = sb.length()-1;
        while (i >= 0){
            char ch = sb.charAt(i);
            if ( ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z'){
                len++;
                i--;
               
            }else{
                break;
            }
        }
        
        return len;
    }
}