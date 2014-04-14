/*
    Given a number represented as an array of digits, plus one to the number.
*/

// Maintain a varialble to hold the carry
// Traverse from the least significant digit to the most significant digit
// Finally, we have to check 'carry' to know whether we have to resize the array
// One interesting thing is that if we have to resize the array, actually we don't have
// to copy vlaues from original array to new array, because all the values are zero
// time: O(n); space: O(n)
public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits==null || digits.length==0)   return digits;
        int carry =1;
        for (int i=digits.length-1; i>=0; i--){
            int val = digits[i];
            digits[i] = (carry+val)%10;
            carry = (carry+val)/10;
        }
        if (carry==0)   return digits;
        // if we're here, the digits should be 9999..9, and the res is 10000..0
        int[] res = new int[digits.length+1];
        res[0] =1;
        return res;
    }
}