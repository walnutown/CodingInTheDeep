/*
    Say you have an array for which the ith element is the price of a given stock on day i.

    If you were only permitted to complete at most one transaction 
    (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/
// time: O(n); space: O(1)
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