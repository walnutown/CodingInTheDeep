/*
    Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

    If the last word does not exist, return 0.

    Note: A word is defined as a character sequence consists of non-space characters only.

    For example, 
    Given s = "Hello World",
    return 5.
*/

// Trim trailing whitespace and then count the length
// time: O(n); space: O(1)
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s==null || s.length()==0)
            return 0;
        int len = 0, N = s.length(), i = N-1;
        while (i>=0 && s.charAt(i)==' ') // trim trailing whitespace
            i--;
        while (i>=0 && s.charAt(i)!=' '){
            i--;
            len++;
        }
        return len;
    }
}