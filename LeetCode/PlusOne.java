// plus one to each digit
public class Solution {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] res = new int[digits.length + 1];
        if (digits == null || digits.length == 0){
            return res;
        }
        
        int carry = 0;
        for (int i = digits.length -1; i >= 0; i--){
            res[i+1] = (digits[i] + carry + 1) % 10;
            carry = (digits[i] + carry + 1) / 10;
        }
        res[0] = carry;
        
        int[] newRes = new int[digits.length];
        if (carry == 0){
            for (int i = 1; i < res.length ; i++){
                newRes[i-1] = res[i];
            }
            return newRes;
        }
        
        return res;
    }
}


public class Solution {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] res = new int[digits.length + 1];
        if (digits == null || digits.length == 0){
            return res;
        }
        
        int carry = 1;
        for (int i = digits.length -1; i >= 0; i--){
            res[i+1] = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
        }
        res[0] = carry;
        
        int[] newRes = new int[digits.length];
        if (carry == 0){
            for (int i = 1; i < res.length ; i++){
                newRes[i-1] = res[i];
            }
            return newRes;
        }
        
        return res;
    }
}

// Accepted
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
        // if we're here, the digits should be 9999..9, and the rer is 10000..0
        int[] res = new int[digits.length+1];
        res[0] =1;
        return res;
    }
}