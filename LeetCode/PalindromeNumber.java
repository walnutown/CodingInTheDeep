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
// this is an easy question, but threr's a lot of points to talk about.
// #2 trail, reverse the number first and compare the original and reversed one, use long to avoid overflow
/*  did you consider the possibility that the reversed number might overflow? 
*   If it overflows, the behavior is language specific (For Java the number 
*   wraps around on overflow, but in C/C++ its behavior is undefined). Yuck.
*/
// http://discuss.leetcode.com/questions/181/palindrome-number
// Some hints:
// Could negative integers be palindromes? (ie, -1)
// If you are thinking of converting the integer to string, note the restriction of using extra space.
// You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
// There is a more generic way of solving this problem.
public class Solution {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x < 0)
            return false;
        long num = x;
        long rev = reverse(num);
        return rev == num;
    }
    
    public long reverse(long num){
        long res = 0;
        while (num > 0){
            res = res * 10 + num%10;
            num /= 10;
        }
        return res;
    }
}