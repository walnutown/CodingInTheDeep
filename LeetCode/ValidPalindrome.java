// convert case and remove punctuation with native APIs
public class Solution {
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null || s.length() < 2){
            return true;
        }
        
        // write the regex by myself
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
            else{
                return false;
            }
        }
        
        return true;
    }
}

// #2 trial
public class Solution {
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null || s.length() == 0){
            return true;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() ; i++){
            char curr = s.charAt(i);
            if ('a' <= curr && curr <= 'z' || 'A' <= curr && curr <= 'Z' || '0' <= curr && curr <= '9')
                sb.append(Character.toLowerCase(curr));
        }
        
        if (sb.length() == 0)
            return true;
        int start =0, end = sb.length()-1;
        while (start < end){
            if (sb.charAt(start) != sb.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}

// Accepted, Dec 24
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