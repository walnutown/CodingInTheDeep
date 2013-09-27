
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





// #2 trial, use long to avoid overflow, if res > Integer.MAX_VALUE, return -1
// Leetcode OJ has no overflow cases
// Compile error: possible loss of precision, solved by adding cast
public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // actually no need to consider negative here, mod(%) will reserve the sign of the number
        if (x < 0){
            if ( x == Integer.MIN_VALUE)
                return -1;  // it's actually not good to return -1 here
            return 0-reverse(-x);
        }
        long num = x;
        int lastDigit = 0;
        long res = 0;
        int pos = 10; // no need pos here, just %10 every time
        while (num > 0){
            lastDigit = (int) num % pos;
            res = res * 10 + lastDigit;
            num /= 10;
        }
        if (res > Integer.MAX_VALUE)
            return -1;
        return (int)res;
    }
}