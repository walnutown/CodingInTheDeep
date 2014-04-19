/*
    Implement pow(x, n).
*/

// recursion, the terminate condition of the recursion is n==0
// Note to handle positive and negative x
// time: O(lgn)
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