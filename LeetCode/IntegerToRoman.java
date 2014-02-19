/*
    Given an integer, convert it to a roman numeral.

    Input is guaranteed to be within the range from 1 to 3999.
*/

// time: O(5m); space: O(5m), m is the number of digits in num
// similar to 'DivideTwoIntegers'
public class Solution {
    public String intToRoman(int num) {
        if (num == 0)   return "";
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder res = new StringBuilder();
        int index = 0;
        while (num > 0){
           if (num < nums[index]) index++;
           else{
               num -= nums[index];
               res.append(romans[index]);
           }
        }
        return res.toString();
    }
}

// AnnieKim, time: O(m); space: O(10m), m is the number of digits in num
public class Solution {
    public String intToRoman(int num) {
        if (num <=0)    return "";
        StringBuilder sb = new StringBuilder();
        String[][] roman = new String[][]{  {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                                            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                                            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                                            {"", "M", "MM", "MMM"}};
        int i=3;
        while (num > 0){
            int divisor = (int) Math.pow(10, i);
            sb.append(roman[i][num/divisor]);
            num %= divisor;
            i--;
        }
        return sb.toString();
    }
}