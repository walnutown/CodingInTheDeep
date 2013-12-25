public class Solution {
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (str == null){
            return 0;
        }
        if (str.equals("")){
            return 0;
        }
        
        int i = 0;
        boolean neg = false;
        int res = 0;
        
        // remove whitespace
        while(str.charAt(i) == ' '){
            i++;
        }
        if (str.charAt(i) == '-'){
            neg = true;
            i++;
        }
        else if (str.charAt(i) == '+'){
            i++;
        }
         
        int len = str.length();
        while (i < len){
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                int digit = str.charAt(i) - '0';
                // check overflow
                if((Integer.MAX_VALUE/10 == res && Integer.MAX_VALUE%10 < digit) || Integer.MAX_VALUE/10 < res ){
                    return neg? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            
                res = res * 10 + digit;
                i++;
            }
            else{
                break;
            }
        }  
       
        if (neg){
            res = -res;
        }
        return res;
        
    }
}


// Accepted, Dec 24
public class Solution {
    public static int atoi(String str) {
      if (str == null || str.length() == 0)
         return 0;
      int i = 0, j = str.length() - 1;
      while (i < str.length() && str.charAt(i) == ' ')
         i++;
      while (j >= 0 && str.charAt(j) == ' ')
         j--;
      if (i > j)
         return 0;
      boolean positive = true;
      int value = 0;
      if (str.charAt(i) == '-') {
         i++;
         positive = false;
      } else if (str.charAt(i) == '+')
         i++;
      else if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9'))
         return 0;
      while (i <= j) {
         if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            int digit = str.charAt(i) - '0';
            // detect overflow here
            if ((value == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE%10) || value > Integer.MAX_VALUE/10)
               return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            value = digit + value * 10;
         } else
            break;
         i++;
      }
      return positive ? value : 0 - value;
   }
}