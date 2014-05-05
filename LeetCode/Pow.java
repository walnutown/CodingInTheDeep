/*
    Implement pow(x, n).
*/

// Divide and Conquer
// Note to handle positive and negative x
// time: O(lgn)
public class Solution {
    public double pow(double x, int n) {
        if (n==0)   return 1.0;
        double val = pow(x, n/2);
        if (n%2==0) return val*val;
        return n>0 ? val*val*x : val*val/x;  // notice not 1/(val*val*x) here, understand why
    }
}
