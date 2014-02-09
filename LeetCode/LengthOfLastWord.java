/*
    Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

    If the last word does not exist, return 0.

    Note: A word is defined as a character sequence consists of non-space characters only.

    For example, 
    Given s = "Hello World",
    return 5.
*/

// time: O(n)
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
// From AnnieKim, more elegant
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s==null || s.length()==0)   return 0;
        int len=0;
        for (int i=s.length()-1; i>=0; i--){
            if (s.charAt(i) != ' ') len++;
            else if (s.charAt(i)==' ' && len>0) break;
        }
        return len;
    }
}