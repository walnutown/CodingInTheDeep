/*
    Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

    For example,
    "A man, a plan, a canal: Panama" is a palindrome.
    "race a car" is not a palindrome.

    Note:
    Have you consider that the string might be empty? This is a good question to ask during an interview.

    For the purpose of this problem, we define empty string as valid palindrome.
*/

// convert case and remove punctuation with native APIs
public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 2)    return true; 
        // write the regex
        // String newStr = s.toLowerCase();
        // newStr = newStr.replaceAll("[^a-z_0-9]", "");
        String newStr = s.replaceAll("\\W", "").toLowerCase();
        int i =0;
        int j = newStr.length() -1;
        while(i < j){
            if (newStr.charAt(i) == newStr.charAt(j)){
                i++;
                j--;
            }
            else    return false;
        }
        return true;
    }
}

public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch>='a' && ch<='z'|| ch>='0' && ch<='9')
                sb.append(ch);
            else if ( ch>='A' && ch<='Z' )
                sb.append(Character.toLowerCase(ch));
        }
        int i = 0, j = sb.length()-1;
        while (i < j){
            if (sb.charAt(i++) != sb.charAt(j--))
                return false;
        }
        return true;
    }
}