/*
    Given two numbers represented as strings, return multiplication of the numbers as a string.

    Note: The numbers can be arbitrarily large and are non-negative.
*/

// time: O(m*n); space: O(m+n)
public class Solution {
    public String multiply(String num1, String num2) {
        // number can be arbitrarily large and non-negative
        if (num1==null || num2==null)   return null;
        int l1 = num1.length(), l2 = num2.length();
        if (l1==0 || l2==0)   return "";
        if (num1.equals("0") || num2.equals("0"))   return "0";     // add "0" check here
        int[] res = new int[l1+l2-1];
        for (int i=l1-1; i>=0; i--){
            for (int j=l2-1; j>=0; j--){
                res[i+j] += (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
            }
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i=res.length-1; i>=0; i--){
            sb.insert(0, (res[i]+carry)%10);
            carry = (res[i]+carry)/10;
        }
        if (carry>0)    sb.insert(0, carry);
        return sb.toString();
    }
}