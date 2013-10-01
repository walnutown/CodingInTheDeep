public class Solution {
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (str == null){
            return 0;
        }
        if (str.equals("")){
            return 0;
        }
        
        int i = 0;
        boolean neg = false;
        int res = 0;
        
        // remove whitespace
        while(str.charAt(i) == ' '){
            i++;
        }
        if (str.charAt(i) == '-'){
            neg = true;
            i++;
        }
        else if (str.charAt(i) == '+'){
            i++;
        }
         
        int len = str.length();
        while (i < len){
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                int digit = str.charAt(i) - '0';
                // check overflow
                if((Integer.MAX_VALUE/10 == res && Integer.MAX_VALUE%10 < digit) || Integer.MAX_VALUE/10 < res ){
                    return neg? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            
                res = res * 10 + digit;
                i++;
            }
            else{
                break;
            }
        }  
       
        if (neg){
            res = -res;
        }
        return res;
        
    }
}