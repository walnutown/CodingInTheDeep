public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = prices.length;
        if (len <= 1){
            return 0;
        }
        
        int max = 0;
        int secondMax = 0;
        int min = prices[0];
        int sum = 0;
        for (int i = 1 ; i < len; i++){
            int curr = prices[i];
            if (curr >= min){
                sum = curr -min;
                if (sum > max){
                    secondMax = max;
                    max = sum;
                }
                else if (sum < max && sum > secondMax){
                    secondMax = sum;
                }
            }
            else{
                min = curr;
            }
        }
        
        return max + secondMax;
    }
}