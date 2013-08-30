public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = prices.length;
        if (len <= 1){
            return 0;
        }
        
        int min = prices[0];
        int maxProfit = 0;
        int profit = 0;
        for(int i = 0; i < len; i++){
            int curr = prices[i];
            if (curr > min){
                profit = curr- min;
                maxProfit = Math.max(profit, maxProfit);
            }
            else if (curr < min){
                min = curr;
            }
        }
        
        return maxProfit;
        
    }
}