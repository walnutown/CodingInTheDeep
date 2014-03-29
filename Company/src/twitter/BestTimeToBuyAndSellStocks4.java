package twitter;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;

public class BestTimeToBuyAndSellStocks4 {
   /*
    * Say you have an array for which the ith element is the price of a given stock on day i.
    * If you were permitted to buy the same stock at different time and hold multiple
    * transactions, design an algorithm to find the maximum profit.
    * e.g. [2,5,7,4,3] the max profit is 7-5+7-2 = 7
    */

   // brute force
   // time: O(n^2); space: O(1)
   public int findMaxProfit(int[] A) {
      if (A == null || A.length == 0)
         return 0;
      int N = A.length, maxProfit = 0;
      for (int i = 0; i < N; i++) {
         int max = A[i];
         for (int j = i + 1; j < N; j++) {
            max = Math.max(A[j], max);
         }
         maxProfit += max - A[i];
      }
      return maxProfit;
   }

   // we can use segment tree to query the range maximal
   // time: O(nlgn); sapce: O(n)

   // If there's later price that is higher than the current price, we can buy a transaction.
   // And in order to max this transaction, we have to sell it at the highest price in later time.
   // The trick is that we maintain a maxHeap to track the highest price after the current
   // time: O(nlgn); space: O(n), heap sort takes O(nlgn), traversal on the original array takes O(n)
   public int findMaxProfit2(int[] A){
      if (A==null || A.length==0)
         return 0;
      int N = A.length, maxProfit = 0;
      PriorityQueue<Price> maxHeap = new PriorityQueue<Price>(N, new Comparator<Price>(){
         public int compare(Price a, Price b){
            return b.value-a.value;
         }
      });
      for (int i=0; i<N; i++)
         maxHeap.add(new Price(A[i], i));
      int i=0;
      while (i<N){
         while (i<N && !maxHeap.isEmpty() && i>=maxHeap.peek().index){
            maxHeap.poll();
         }
         if (i<N && !maxHeap.isEmpty() && A[i] < maxHeap.peek().value)
            maxProfit += maxHeap.peek().value-A[i];
         i++;
      }
      return maxProfit;
   }
   
   public class Price{
      int value;
      int index;
      public Price(int value, int index){
         this.value = value;
         this.index = index;
      }
      public String toString(){
         return "["+ value + "," + index+"]";
      }
   }

   @Test
   public void test() {
      int[] A = new int[] { 2, 5, 7, 9, 3 };
      System.out.println(findMaxProfit(A));
      System.out.println(findMaxProfit2(A));
   }
}
