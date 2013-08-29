public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null || s.length == 0){
            return 0;
        }
        
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while (sb.charAt(sb.length()-1) == " "){
            sb.deleteCharAt(sb.length()-1);
        }
        int len = 0;
        int i = sb.length()-1;
        char ch = sb.charAt(i);
        while( ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z'){
            len++;
            i--;
            ch = sb.charAt(i);
        }
        
        return len;
    }
}