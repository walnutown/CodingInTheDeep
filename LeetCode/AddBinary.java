public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        StringBuilder res = new StringBuilder();
        if (a == null && b == null){
            return "";
        }
        if (a.length() == 0 && b.length() == 0){
            return "";
        }
        
        if (a.length() == 0 && b.length() > 0){
            return b;
        }
        if (a.length() > 0 && b.length() == 0){
            return a;
        }
        
        int i = a.length() -1;
        int j = b.length() -1;
        int sum = 0;
        int carry = 0;
        while (i >= 0 && j >= 0){
            int A = a.charAt(i) - '0';
            int B = b.charAt(j) - '0';
            sum = A^B^carry;
            res.insert(0, sum);
            carry = A & B + A & (B^carry);
            i--;
            j--;
        }
        if (i >= 0 && j == -1){
            while (i >= 0){
                int A = a.charAt(i) - '0';
                sum = A ^ carry;
                res.insert(0, sum);
                carry = (A + carry) /2;
                i--;
            }
            if (carry > 0){
                res.insert(0, carry);
            }
        }
        
        if (i == -1 && j >= 0){
            while (j >= 0){
                int B = b.charAt(i) - '0';
                sum = B ^ carry;
                res.insert(0, sum);
                carry = (B + carry) /2;
                j--;
            }
            if (carry > 0){
                res.insert(0, carry);
            }
        }
        
        return res.toString();
        
    }
}