/*
    Given two binary strings, return their sum (also a binary string).

    For example,
    a = "11"
    b = "1"
    Return "100".
*/

// time: O(Math.max(m, n))
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        if (a == null || b == null) return a == null ? b : a;
        if (a.length() == 0 || b.length() == 0) return a.length() == 0 ? b : a;
        int carry=0;
        int i = a.length()-1, j = b.length()-1;
        while (i>=0 && j>=0){
            int num1 = a.charAt(i--) - '0';
            int num2 = b.charAt(j--) - '0';
            sb.insert(0, (num1+num2+carry)%2);
            carry = (num1+num2+carry)/2;
        }
        while(i>=0){
            int num1 = a.charAt(i--) - '0';
            sb.insert(0, (num1+carry)%2);
            carry = (num1+carry)/2;
        }
        while(j>=0){
            int num2 = b.charAt(j--) - '0';
            sb.insert(0, (num2+carry)%2);
            carry = (num2+carry)/2;
        }
        if (carry > 0)  sb.insert(0, 1);
        return sb.toString();
    }
}

// AnnieKim, combine the 3 while loops into 1
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        if (a == null || b == null) return a == null ? b : a;
        if (a.length() == 0 || b.length() == 0) return a.length() == 0 ? b : a;
        int carry=0;
        int i = a.length()-1, j = b.length()-1;
        while (i>=0 || j>=0){
            int num1=0, num2=0;
            if (i>=0) num1 = a.charAt(i--) - '0';
            if (j>=0) num2 = b.charAt(j--) - '0';
            sb.insert(0, (num1+num2+carry)%2);
            carry = (num1+num2+carry)/2;
        }
        if (carry > 0)  sb.insert(0, 1);
        return sb.toString();
    }
}


