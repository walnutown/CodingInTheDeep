/*
    Reverse digits of an integer.

    Example1: x = 123, return 321
    Example2: x = -123, return -321

    Have you thought about this?
    Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

    If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

    Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, 
    then the reverse of 1000000003 overflows. How should you handle such cases?

    Throw an exception? Good, but what if throwing an exception is not an option? You would then have to re-design 
    the function (ie, add an extra parameter).
*/

// cast int to long to avoid overflow
public class Solution {
    public int reverse(int x) {
        int num = Math.abs(x);
        long res = 0;
        while (num > 0){
            res = res*10 + num%10;
            num /= 10;
        }
        if (res>Integer.MAX_VALUE)   return x>0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        return x>0 ? (int)res : (int)-res;          // need cast here, otherwise, precision loss warning
    }
}



public class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x!=0){
            int digit = x%10;
            if (digit>Integer.MAX_VALUE%10 && res==Integer.MAX_VALUE/10 || res>Integer.MAX_VALUE/10)
                return Integer.MAX_VALUE;
            if (digit < Integer.MIN_VALUE%10 && res==Integer.MIN_VALUE/10 || res<Integer.MIN_VALUE/10)
                return Integer.MIN_VALUE;
            res = res*10 + digit;
            x /= 10;
        }
        return res;
    }
}