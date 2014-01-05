
// #2 trial
public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null || s.length() == 0){
            return 0;
        }
        int endIndex = s.length()-1;
        for (int i = s.length() -1 ; i >= 0; i--){
            if (s.charAt(i) == ' '){
                endIndex--;
            }
            else
                break;
        }
        if (endIndex == -1){
            return 0;
        }
        int len = 0;
        for (int i = endIndex; i >= 0; i--){
            if (s.charAt(i) != ' '){
                len++;
            }
            else
                break;
        }
        
        return len;
    }
}
// Accepted
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s==null || s.length()==0)   return 0;
        int i=s.length()-1;
        while (i>=0 && s.charAt(i)==' ') i--;
        if (i==-1)   return 0;
        int len=0;
        while (i>=0 && s.charAt(i)!=' '){
            len++;
            i--;
        }
        return len;
    }
}
// Accepted, from AnnieKim, more elegant
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s==null || s.length()==0)   return 0;
        int len=0;
        for (int i=s.length()-1; i>=0; i--){
            if (s.charAt(i) != ' ') len++;
            else if (len>0) break;
        }
        return len;
    }
}