// #2
public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (prices == null || prices.length <= 1)
            return 0;
        int min = prices[0];
        int maxProf = 0;
        // error in case [2,1]: int maxProf = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] > min)
                maxProf = Math.max(maxProf, prices[i] - min);
            else
                min = prices[i];
        }
        return maxProf;
    }
}
// Accepted
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length==0)   return 0;
        int min = Integer.MAX_VALUE, prof = 0;
        for (int i=0; i<prices.length; i++){
            prof = Math.max(prof, prices[i]-min);
            min = Math.min(min, prices[i]);
        }
        return prof;
    }
}