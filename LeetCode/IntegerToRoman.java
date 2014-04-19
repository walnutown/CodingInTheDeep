/*
    Given an integer, convert it to a roman numeral.

    Input is guaranteed to be within the range from 1 to 3999.
    I, V, X, L,  C,  D,   M
    1, 5, 10,50,100,500, 1000
*/

// similar to 'DivideTwoIntegers'
// time: O(5m); space: O(5m), m is the number of digits in num
// why? index will stop at each digit for at most 5 times
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


// no use of map, constant space
public class Solution {
    public String getRomanBase(int num) {
        String romanBase = "";
        switch(num) {
            case 1:
                romanBase = "I";
                break;
            case 5:
                romanBase = "V";
                break;
            case 10:
                romanBase = "X";
                break;
            case 50:
                romanBase = "L";
                break;
            case 100:
                romanBase = "C";
                break;
            case 500:
                romanBase = "D";
                break;
            case 1000:
                romanBase = "M";
                break;
        }
        return romanBase;
    }
    
    public String intToRoman(int num) {
        int romanBase = 1000;
        StringBuilder roman = new StringBuilder();
        while(romanBase > 0) {
            int digit = num / romanBase;
            if(digit == 9) {
                roman.append(getRomanBase(romanBase));
                roman.append(getRomanBase(romanBase * 10));
            }
            else if(digit >= 5) {
                roman.append(getRomanBase(romanBase * 5));
                for(int i = 0; i < digit - 5; i++)
                    roman.append(getRomanBase(romanBase));
            }
            else if(digit == 4) {
                roman.append(getRomanBase(romanBase));
                roman.append(getRomanBase(romanBase * 5));
            }
            else {
                for(int i = 0; i < digit; i++)
                    roman.append(getRomanBase(romanBase));
            }
            num = num % romanBase;
            romanBase /= 10;
        }
        return roman.toString();
    }
}