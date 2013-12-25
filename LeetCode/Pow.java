// not pass large judge
public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n == 0){
            return 1;
        }
        
        boolean neg = x < 0 && n%2 != 0 ? true: false;
        x = Math.abs(x);
        double res = 1;
        if (n > 0){
            res = x;
            for (int i = 1; i < n; i++){
                res *= x;
            }
        }
        if (n < 0){
            res = 1/x;
            for (int i = -1; i > n; i--){
                res /= x;
            }
        }
        
        return neg? -res : res;
        
    }
}


public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() functio
        
        if (n < 0){
            return 1.0 / power(x, -n);
        }      
        else if (n > 0){
            return  power(x, n);
        } 
        else{
            return 1.0;
        }
        
    }
    
    public double power(double x, int n){
        if (n == 0){
            return 1;
        }
        double v = power(x, n/2);
        if (n % 2 == 0){
            return v * v;
        }
        else{
            return v * v * x;
        }
    }
}

// #2 trial
// error 1
// Last executed input:    1.00000, -2147483648
// error 2
// Input:  8.95371, -1
// Output: 0.01247
// Expected:   0.11169

// see bit manipulation here http://discuss.leetcode.com/questions/228/powx-n

public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // don't consider overflow here
        if (n == 0)
            return x == 0.0? 0.0 : 1.0;
        if (n < 0)
            return n == Integer.MIN_VALUE? 1/pow(x, Integer.MAX_VALUE) : 1/ pow(x, -n);
        if (n == 1)
            return x;
        int p = n;
        double res = x;
        while (p/2 > 0){
            res = res * res;
            p = p/2;
        }
        return n%2 == 0 ? res: res*x;
    }
}

// Accepted
public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return power(x, (long) n);  // cast here t oavoid n overflow
    }
    public double power(double x, long n){
        if (n == 0)
            return 1.0; // 0^0 is 1
        if (n < 0)
            return 1/ power(x, -n);
        double val = power(x,n/2); 
        x = n%2 == 0? val * val : val * val * x;
        n = n/2;
        return x;
    }
}

// refactor, Dec 21
public class Solution {
    public double pow(double x, int n) {
        return power(x, (long) n);
    }
    public double power(double x, long n){
        if (n == 0)
            return 1.0;
        double val = power(x,n/2); 
        if (n%2 == 0)   return val * val;
        if (n > 0)  return val * val * x;
        return val * val / x;           // notice not 1/(val*val*x) here, understand why
    }
}