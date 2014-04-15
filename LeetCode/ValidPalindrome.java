/*
    Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

    For example,
    "A man, a plan, a canal: Panama" is a palindrome.
    "race a car" is not a palindrome.

    Note:
    Have you consider that the string might be empty? This is a good question to ask during an interview.

    For the purpose of this problem, we define empty string as valid palindrome.
*/

// Handle capitalization and punctuation with native APIs
public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 2)    return true; 
        // \w is word characer, \W is non-word character
        String newStr = s.replaceAll("\\W", "").toLowerCase();
        int i =0;
        int j = newStr.length() -1;
        while(i < j){
            if (newStr.charAt(i++) != newStr.charAt(j--)){
               return false;
        }
        return true;
    }
}

// Handle capitalization and punctuation by writing methods
// time: O(n), one pass; space: O(1)
public class Solution {
    public boolean isPalindrome(String s) {
        if (s==null || s.length()==0)
            return true;
        int i=0, j = s.length()-1;
        while (i<j){
            while (i<j && !isLetter(s.charAt(i)))
                i++;
            while (i<j && !isLetter(s.charAt(j)))
                j--;
            if (!isEqual(s.charAt(i), s.charAt(j)))
                return false;
            i++; j--;
        }
        return true;
    }
    
    private boolean isLetter(char ch){
        return ch>='A' && ch<='Z' || ch>='0' && ch<='9' || ch>='a' && ch<='z';
    }
    
    private boolean isEqual(char a, char b){
        return Character.toLowerCase(a) == Character.toLowerCase(b);
    }
}