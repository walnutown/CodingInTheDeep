/*
  Implement int sqrt(int x).

  Compute and return the square root of x.
*/

// binary search
// The square root of x will be smaller than x/2+1. Why? (x/2+1)*(x/2+1)> x
// time: O(lgn)
public class Solution {
    public int sqrt(int x) {
        if (x<=1)   return x;
        int start = 0, end = x/2+1; 
        while (start<=end){
            int mid = start + (end-start)/2;
            if (mid==x/mid) return mid;     // compare mid & x/mid, instead of mid*mid & x, to avoid overflow
            else if (mid < x/mid)   start = mid+1;
            else end = mid-1;
        }
        return end;     // choose the smaller one
    }
}

// Newton's Method, better than binary search
public class Solution {
    public int sqrt(int x) {
        if (x<=1)
            return x;
        double r = 1; // need to use double here, otherwise, sqrt(2) may fall in endless loop
        while (true){
            double r0 = (r+x/r)/2;
            if (Math.abs(r-r0)<0.1)
                return (int)r0; // remember to cast here
            r = r0;
        }
    }
}