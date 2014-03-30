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
public class Solution {
    public boolean isPalindrome(String s) {
        if (s==null || s.length()==0)
            return true;
        String ss = parse(s);
        int i=0, j=ss.length()-1;
        while (i<j){
            if (ss.charAt(i)!=ss.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    
    private String parse(String s){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++){
            if (isLetter(s.charAt(i)))
                sb.append(Character.toLowerCase(s.charAt(i)));
        }
        return sb.toString();
    }
    
    private boolean isLetter(char ch){
        return ch>='0' && ch<='9' || ch>='a' && ch<='z' || ch>='A' && ch<='Z';
    }
}