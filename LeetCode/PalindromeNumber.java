/*
    Determine whether an integer is a palindrome. Do this without extra space.
*/

// This is an easy question, but threr's a lot of points to talk about.
// Basic idea is to reverse the number first and compare the original and reversed one.
// There're two points to take care of:
// [1] what if reversed number is overflow?
// [2] Remember to make a copy of the original number
// time: O(lgx); space: O(1)
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)  return false;
        long reversed = 0, original=x;          
        while (x > 0){
            reversed = reversed*10 + x%10;
            x /= 10;
        }
        return reversed == original;
    }
}