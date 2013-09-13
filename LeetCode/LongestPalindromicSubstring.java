public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length();
        if (len <= 1){
            return s;
        }
        String res = "";
        for (int i = 1; i < len; i++){
            for (int j = 0; j <i; j++){
                String p = s.substring(j, i+1);
                if (p.length() > res.length()){
                    if (isPalindrome(p)){
                        res = p;
                    }
                }
                else{
                    break;
                }
            }
        }
        
        return res;
        
        
    }
    
    public boolean isPalindrome(String s){
        int i = 0;
        int j = s.length()-1;
        while (i < j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

