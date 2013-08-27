// TLE, Integer.MAX_VALUE/1, brute force
public class Solution {
    public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (divisor == 0 ){
            return -1;
        }
        
        if (dividend == 0){
            return 0;
        }
        
        int res = 0;
        if (dividend < 0 && divisor > 0){
            return  negDiv(dividend, 0-divisor);
        
        }
        
        else if (dividend > 0 && divisor < 0){
            return negDiv(0-dividend, divisor);
        }
        else if (dividend < 0 && divisor < 0){
            return div(dividend, divisor);
        }
        else{
            return div(0-dividend, 0-divisor);    
        }
         
        
    }
    
    public int div(int dividend, int divisor){
        int res = 0;
        while (dividend < 0){
            dividend -= divisor;
            res++;
            if (res == Integer.MAX_VALUE){
                return res;
            }
            if (res < 0){
                return Integer.MAX_VALUE;
            }
        }
        
        return res;
    }
    
     public int negDiv(int dividend, int divisor){
        int res = 0;
        while (dividend < 0){
            dividend -= divisor;
            res++;
            if (res == Integer.MAX_VALUE){
                return -res;
            }
            if (res < 0){
                return Integer.MIN_VALUE;
            }
        }
        
        return -res;
    }
}

// bit manipulation, pass both
public class Solution {
    public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (dividend == 0 || divisor == 1){
            return dividend;
        }
        
        if (divisor == -1){
            return -dividend;
        }
        
        // (long) dividend, cast here is important to avoid overflow
        long divd = Math.abs((long)dividend);
        long divs = Math.abs((long)divisor);
        ArrayList<Long> divsArr = new ArrayList<Long>();
        
        while (divs <= divd){
            divsArr.add(divs);
            divs = divs <<1;
        }
        
        int pow = divsArr.size() -1;
        int res = 0;
        while (divd > 0 && pow >= 0){
            while ( divsArr.get(pow) <= divd){
                divd -= divsArr.get(pow);
                res += 1 << pow;
            }
            pow--;
        }
        
        return (dividend > 0) ^ (divisor > 0) ? -res: res;
        
    }
}