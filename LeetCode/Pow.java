/*
    Implement pow(x, n).
*/

// Divide and Conquer, time: O(lgn), sapce: O(1)
public class Solution {
    public double pow(double x, int n) {
        return power(x, (long) n);  // cast here to avoid n overflow
    }
    public double power(double x, long n){
        if (n == 0)
            return 1.0; // 0^0 is 1
        if (n < 0)
            return 1.0/ power(x, -n);
        double val = power(x,n/2); 
        x = n%2 == 0? val * val : val * val * x;
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