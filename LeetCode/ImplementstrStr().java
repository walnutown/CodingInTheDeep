public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (haystack == null || needle == null){
            return null;
        }
        
        if (needle.length() == 0){
            return haystack;
        }
        if (haystack.length() < needle.length()){
            return null;
        }
         
        for ( int i = 0; i <= haystack.length() - needle.length(); i++){
            int indexH = i;
            int indexN = 0;
                while (haystack.charAt(indexH) == needle.charAt(indexN)){
                    indexN++;
                    if (indexN == needle.length()){
                        return haystack.substring(i);
                    }
                    indexH++;
                    if (indexH == haystack.length()){
                        break;
                    }
                   
                }
        }   
        return null;     
    }
}

