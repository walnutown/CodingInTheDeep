package yahoo;

import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;

import org.junit.Test;

public class KHighestStocks {

   /**
    * Given a stream of stocks, find the top k stocks in recent 10 mins
    */

   // http://www.careercup.com/question?id=4791465146318848

   // The basic idea is same to highest stock in recent 10 mins
   // The difference lies in that we always maintain k elements in deque
   // The stocks in deque are stored in time order from front to end. In this way,
   // it'll take O(m) time to get the min stock in deque and O(m) time. (m is no less than k and no
   // larger than n)
   // We also need a minHeap to print top k in deque
   public void printStocks(int[] prices, int k, int n) {
      int i = 0;
      Deque<Integer> deque = new LinkedList<Integer>();
      for (; i < n; i++) {
         while (deque.size() > k && prices[i] > getMin(prices, deque))
            popMin(prices, deque);
         deque.addLast(i);
      }
      printTopK(prices, deque, k);
      for (; i < prices.length; i++) {
         if (deque.peekFirst() + k <= i)
            deque.pollFirst();
         while (deque.size() > k && prices[i] > getMin(prices, deque))
            popMin(prices, deque);
         deque.addLast(i);
         printTopK(prices, deque, k);
      }
   }

   private void printTopK(int[] prices, Deque<Integer> deque, int k) {
      PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k + 1);
      Iterator<Integer> itr = deque.iterator();
      while (itr.hasNext()) {
         minHeap.add(prices[itr.next()]);
         if (minHeap.size() == k + 1)
            minHeap.poll();
      }
      while (k-- > 0)
         System.out.print(minHeap.poll());
      System.out.println("");
   }

   private int getMin(int[] prices, Deque<Integer> deque) {
      Iterator<Integer> itr = deque.iterator();
      int min = Integer.MAX_VALUE;
      while (itr.hasNext())
         min = Math.min(min, prices[itr.next()]);
      return min;
   }

   // pop the first min in deque from front to end
   private void popMin(int[] prices, Deque<Integer> deque) {
      int min = getMin(prices, deque);
      Iterator<Integer> itr = deque.iterator();
      while (itr.hasNext()) {
         if (prices[itr.next()] == min) {
            itr.remove();
            return;
         }
      }
   }

   @Test
   public void test() {
      Random r = new Random(System.currentTimeMillis());
      int[] A = new int[50];
      for (int i = 0; i < A.length; i++)
         A[i] = r.nextInt(10);
      System.out.println(Arrays.toString(A));
      int k = 2, n = 3;
      printStocks(A, k, n);
   }
}
