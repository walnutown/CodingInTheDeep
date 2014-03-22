/*
  Implement atoi to convert a string to an integer.

  Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

  Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.


  Requirements for atoi:
  The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

  The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

  If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

  If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
*/

// move leading and trailing zeros, check sign, avoid overflow. 
// time: O(n); space: O(n)
public class Solution {
    public static int atoi(String str) {
      if (str == null || str.length() == 0)
         return 0;
      char[] s = str.toCharArray();
      int i = 0, j = s.length - 1;
      while (i < s.length && s[i] == ' ') 
         i++;
      while (j >= 0 && s[j] == ' ')
         j--;
      if (i > j)
         return 0;
      boolean positive = true;
      int value = 0;
      if (s[i] == '-') {
         i++;
         positive = false;
      } else if (s[i] == '+')
         i++;
      else if (!(s[i] >= '0' && s[i] <= '9'))
         return 0;
      while (i <= j && s[i] >= '0' && s[i] <= '9') {
            int digit = s[i] - '0';
            // detect overflow here
            if ((value == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE%10) || value > Integer.MAX_VALUE/10)
               return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            value = digit + value * 10;
         i++;
      }
      return positive ? value : 0 - value;
   }
}

// use long to avoid overflow, and ood style code
// time: O(n)
public class Solution {
    public int atoi(String str) {
        if (str==null || str.length()==0)
            return 0;
        String s = trim(str);
        if (s.length()==0)
            return 0;
        boolean isNeg = false;
        if (s.charAt(0)=='-'){
            s = s.substring(1);
            isNeg = true;
        }
        if (s.charAt(0)=='+')
            s = s.substring(1);
        long value=0;
        for (int i=0; i<s.length(); i++){
            if (!isNumeric(s.charAt(i)))
                break;
            int digit = s.charAt(i)-'0';
            value = value*10 + digit;
        }
        if (!isNeg && value >Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (isNeg && (value-1) > Integer.MAX_VALUE)
            return Integer.MIN_VALUE;
        int res = (int) value;
        return isNeg? 0-res : res;
    }
    
    public boolean isNumeric(char ch){
        return ch>='0' && ch<='9';
    }
   
    public String trim(String str){
        int N = str.length();
        int i=0, j=N-1;
        while (i<N && str.charAt(i)==' ')
            i++;
        while (j>i && str.charAt(j)==' ')
            j--;
        return str.substring(i,j+1);
    }
}