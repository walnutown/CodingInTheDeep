public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = prices.length;
        if (len <= 1){
            return 0;
        }
        
        int sum = 0;
        for (int i = 0; i < len-1 ; i++){
            int curr = prices[i];
            int next = prices[i+1];
            if (curr < next){
                sum += next - curr;
            }
        }
        
        
        return sum;
    }
}

// Accepted
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length==0)   return 0;
        int sum=0;
        for (int i=1; i<prices.length; i++){
            if (prices[i]>prices[i-1])    sum += prices[i]-prices[i-1];
        }
        return sum;
    }
}