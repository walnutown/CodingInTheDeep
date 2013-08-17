// no deal with the overflow

public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if ( -10 < x && x < 10){
            return x;
        }
        // mark the sign
        boolean isNeg = false;
        if (x < 0){
            isNeg = true;
            x = -x;
        }
        
        // get the length of the number
        int len = 1;
        while (x/len >= 10){
            len *= 10;
        }
        
        // create the new integer
        int res = 0;        
        while (x > 0){
            int tail = x%10;
            res += tail*len;
            len /= 10;
            x /= 10;
        }
        
        if (isNeg){
            res = -res;
        }
        return res;
    }
}