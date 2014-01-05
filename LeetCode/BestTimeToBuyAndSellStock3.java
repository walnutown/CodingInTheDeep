// choose the largest and then second largest doesn't work
// e.g. [8, 11, 10, 12, 10, 15], should be 8-12, 10-15, instead of 8-15

// Divide and Conquer, TLE in large judge
public class Solution {
    int maxProfit;
    int[] max;
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
       maxProfit = 0;
       max = new int[2];
       int len = prices.length;
       if (len <= 1){
           return 0;
       }
       
       for (int i = 0; i < len; i++){
           max[0] = findMax(prices, 0 ,i);
           max[1] = findMax(prices, i, len-1);
           maxProfit = Math.max(maxProfit, max[0] + max[1]);
       }
       
       return maxProfit;
    }
    
    public int findMax(int[] prices, int start, int end){
        if (start >= end){
            return 0;
        }
        int min = prices[start];
        int maxDiff = 0;
        for (int i = start+1; i <= end; i++){
            int curr = prices[i];
            if (curr < min){
                min = curr;
            }
            maxDiff = Math.max(maxDiff, curr-min);
        }
        return maxDiff;
    }
}

// DP, see http://blog.unieagle.net/2012/12/05/leetcode%E9%A2%98%E7%9B%AE%EF%BC%9Abest-time-to-buy-and-sell-stock-iii%EF%BC%8C%E4%B8%80%E7%BB%B4%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92/
public class Solution {
    int maxProfit;
    int[] maxLeft;
    int[] maxRight;
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
       maxProfit = 0;
       
       int len = prices.length;
       maxLeft = new int[len];
       maxRight = new int[len];
       if (len <= 1){
           return 0;
       }
       
       // traverse from left to right and get the maxLeft
       maxLeft[0] = 0;
       int minLeft = prices[0];
       for (int i = 1; i < len; i++){
           int curr = prices[i];
           if (curr < minLeft){
               minLeft = curr;
           }
           maxLeft[i] = Math.max(maxLeft[i-1], curr-minLeft);
       }
       // traverse from right to left, get the maxright and combine the two max
       maxRight[len-1] = 0;
       int maxR = prices[len-1];
       for (int i = len-2; i >= 0; i--){
           int curr = prices[i];
           if (curr > maxR){
               maxR = curr;
           }
           maxRight[i] = Math.max(maxRight[i+1], maxR-curr);
           maxProfit = Math.max(maxLeft[i] + maxRight[i], maxProfit);
       }
       
       
        return maxProfit;
    }
}

// Accepted
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length==0)   return 0;
        int m=prices.length;
        int[] left = new int[m];
        int[] right = new int[m];
        int lmin=prices[0], rmax=prices[m-1], sum=0;
        for (int i=1; i<prices.length; i++){
            left[i] = Math.max(left[i-1], prices[i]-lmin);
            lmin = Math.min(lmin, prices[i]);
        }
        for (int i=m-2; i>=0; i--){
            right[i] = Math.max(right[i+1], rmax-prices[i]);
            rmax = Math.max(rmax, prices[i]);
        }
        for (int i=0; i<m; i++){
            sum = Math.max(sum, left[i] + right[i]);
        }
        return sum;
    }
}