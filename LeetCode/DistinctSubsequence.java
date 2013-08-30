// TLE in large judge
public class Solution {
    
    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if (S == null && T != null){
            return 0;
        }
        
        if (S.length() < T.length()){
            return 0;
        }
        
        int sum = 0;
        char ch; 
        if (T.length() == 1){
            ch = T.charAt(0);
            for (int i = 0; i < S.length(); i++){
                if (S.charAt(i) == ch){
                    sum++;
                }
            }
        }
        else{
            ch = T.charAt(T.length() -1);
            for (int i = 0; i < S.length(); i++){
                if (S.charAt(i) == ch){
                    sum += numDistinct(S.substring(0,i), T.substring(0,T.length()-1));
                }
            }
        }
        
        return sum;
        
    }
}