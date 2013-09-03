public class Solution {
    int[] ways;
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length();
        if (len == 0){
            return 0;
        }
        ways = new int[len+1];
        ways[0] = 1; // cannot init ways[0] = 0 here, notice case 10
        if (isValid(s.substring(0,1))){
            ways[1] = 1;
        }
        else{
            return 0;
        }
        
        for (int i=2; i <= len; i++){
            char curr = s.charAt(i-1);
            char prev = s.charAt(i-2);
            if (curr == '0'){
                if (prev == '1' || prev == '2'){
                    ways[i] = ways[i-2];
                }
                else{
                    return 0;
                }
            }
            else{
                if (prev == '1' || prev == '2' && curr <= '6'){
                    ways[i] = ways[i-1] + ways[i-2];
                }
                else{
                    ways[i] = ways[i-1];
                }
                
            }  
        }
        
        
        return ways[len];
    }
    
    public boolean isValid(String s){
        int num = Integer.parseInt(s);
        // avoid "0" in string
        if (num >=1 && num <= 26 && !s.startsWith("0")){
            return true;
        }
        return false;
    }
}