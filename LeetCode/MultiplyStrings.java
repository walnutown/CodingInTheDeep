/*
    Given two numbers represented as strings, return multiplication of the numbers as a string.

    Note: The numbers can be arbitrarily large and are non-negative.
*/

// [1] the length of digits in the result may be M+N-1, or M+N
// [2] Exception to he above formula: num1=="0" or num2=="0"
// time: O(m*n); space: O(m+n)
public class Solution {
    public String multiply(String num1, String num2) {
        if (num1==null || num2==null)
            return num1==null?num2:num1;
        int M = num1.length(), N = num2.length();
        if (num1.equals("0") || num2.equals("0"))   
            return "0";
        int[] res = new int[M+N-1];
        for (int i=0; i<M; i++){
            for (int j=0; j<N; j++){
                res[i+j] += (num1.charAt(i)-'0')*(num2.charAt(j)-'0'); // Note, += here, not =
            }
        }
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=res.length-1; i>=0; i--){
            sb.append((carry+res[i])%10);
            carry = (carry+res[i])/10;
        }
        if (carry>0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}