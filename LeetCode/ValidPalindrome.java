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