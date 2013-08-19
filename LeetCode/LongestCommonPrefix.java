public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
         String res = "";
    if (strs == null || strs.length == 0){
        return res;
    }
    
    for (int i = 0; i < strs.length; i++){
        if (strs[i] == null){
            return res;
        }    
    }
    
    if(strs.length == 1){
        return strs[0];
    }
    
    for (int i = 0; i < strs[0].length(); i++){
        char ch = strs[0].charAt(i);
        for (int j = 1; j < strs.length; j++){
            if (strs[j].length() < i+1 || strs[j].charAt(i) != ch){
                return res;
            }
        }
        res += ch;
    }
    
    return res;
    }
}