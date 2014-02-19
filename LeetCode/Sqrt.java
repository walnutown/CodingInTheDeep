/*
  Implement int sqrt(int x).

  Compute and return the square root of x.
*/

// binary search
public class Solution {
    public int sqrt(int x) {
        if (x < 2)  return x;
        int start = 0, end = x;
        while (start <= end){            
            int mid = (start + end) >>1;
            int tmp = x/mid;                // use division here to avoid overflow
            if (tmp > mid)  start = mid+1;
            else if (tmp < mid)  end = mid-1;
            else return mid;
        } // 'start' > 'end' here
        return end;   // understand why 'end', instead of 'start'. 
    }
}