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