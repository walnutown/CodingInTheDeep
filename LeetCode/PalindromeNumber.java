public class Solution {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x < 0){
            return false;
        }
        
        if (0 <= x && x <= 9){
            return true;
        }
        // get the length of the number
        int len = 1;
        while ( x/len >= 10){
            len *= 10;
        }
        
        while (x >= 10){
            int headNum = x/len;
            int tailNum = x%10;
            if (headNum == tailNum){
                // remove the head and tail of the original number
                x = (x - (x/len) * len ) /10;
                //update length
                len /= 100;
            }
            else{
                return false;
            }
        }
        return true;
        
    }
}