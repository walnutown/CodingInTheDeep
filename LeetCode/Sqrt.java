public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x == 0){
            return 0;
        }
        if (x == 1){
            return 1;
        }
        
       int start = 0;
       //int end = x;
       int end =  x/2 < Math.sqrt(Integer.MAX_VALUE)? x/2 + 1 : (int)Math.sqrt(Integer.MAX_VALUE);
       while (start <= end){
           int mid = start + (end - start)/2;
           int sqr = mid * mid;
           if (sqr < x){
               start = mid +1;
           }
           else if (sqr > x){
               end = mid -1;
           }
           else{
               return mid;
           }
           
       }
       
       return (start+end)/2;
    }
}


// no nned to judge mid < sqrt(INT_MAX), use mid < x/mid, instead of mid * mid < x, to avoid overflows
public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x == 0){
            return 0;
        }
        // avoid mid == 0
        if (x == 1){
            return 1;
        }
        
       int start = 0;
       int end = x;
       while (start <= end){
           int mid = start + (end - start)/2;
           int temp = x/mid;
           if (mid < temp){
               start = mid +1;
           }
           else if (mid > temp){
               end = mid -1;
           }
           else{
               return mid;
           }
           
       }
       return (start+end)/2;
    }
}

// Submission Result: Time Limit Exceeded

// Last executed input:  2147395599
public class Solution {
    public int sqrt(int x) {
        if (x == 0)
            return 0;
        int start = 1, end = x;
        while (start <= end){
            int mid = (start + end) >>1;
            long value = mid * mid;
            if (value > x)  end = mid-1;
            else if (value < x)  start = mid+1;
            else return mid;
        }
        return start;
    }
}


// Accepted, Dec 24
public class Solution {
    public int sqrt(int x) {
        if (x < 2)  return x;
        int start = 0, end = x;
        while (end - start > 1){            // end - start > 1 => mid is different from start and end
            int mid = (start + end) >>1;
            int tmp = x/mid;                // use division here to avoid overflow
            if (tmp > mid)  start = mid;
            else if (tmp < mid)  end = mid;
            else return mid;
        }
        return start;
    }
}