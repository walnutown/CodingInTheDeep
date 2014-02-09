/*
    Determine whether an integer is a palindrome. Do this without extra space.
*/

// this is an easy question, but threr's a lot of points to talk about.
// reverse the number first and compare the original and reversed one, use long to avoid overflow
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)  return false;
        long reversed = 0, original=x;          // notice overflow
        while (x > 0){
            reversed = reversed*10 + x%10;
            x /= 10;
        }
        return reversed == original;
    }
}