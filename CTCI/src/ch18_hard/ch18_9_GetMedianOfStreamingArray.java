package ch18_hard;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;

public class ch18_9_GetMedianOfStreamingArray {

   /**
    * Numbers are generated randomly and passed to a method. Write a program to find and maintain
    * the median value as new values are generated
    */

   // [1] Maintain two heaps, maxHeap and minHeap
   // ensure maxHeap.size() >= minHeap.size(), and maxHeap.peek() < minHeap.peek()
   // [2] if the number of elements is even, maxHeap.size() == minHeap.size()
   // the median is (maxHeap.top() + minHeap.top())/2
   // [3] if the number of elements is odd, maxHeap.size() > minHeap.size()
   // the median is maxHeap.top()

   class Analyzer {
      private PriorityQueue<Integer> maxHeap, minHeap;

      public Analyzer() {
         maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
               return o2 - o1;
            }
         });
         minHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
               return o1 - o2;
            }
         });
      }

      public void addNewNumber(int num) {
         if (maxHeap.size() == minHeap.size()) {
            if (minHeap.peek() != null && num > minHeap.peek()) {
               maxHeap.add(minHeap.poll());
               minHeap.add(num);
            } else
               maxHeap.add(num);
         } else {
            if (num < maxHeap.peek()) {
               minHeap.add(maxHeap.poll());
               maxHeap.add(num);
            } else
               minHeap.add(num);
         }
      }

      public double getMedian() {
         if (maxHeap.isEmpty()) // if maxHeap.isEmpty(), minHeap.isEmpty()
            return 0;
         if (maxHeap.size() == minHeap.size())
            return ((double) minHeap.peek() + maxHeap.peek()) / 2.0;
         else
            return maxHeap.peek();
      }
   }

   @Test
   public void test() {
      Analyzer analyzer = new Analyzer();
      int[] A = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
      for (int i = 0; i < A.length; i++) {
         analyzer.addNewNumber(A[i]);
         System.out.println(analyzer.getMedian());
      }
   }

}
