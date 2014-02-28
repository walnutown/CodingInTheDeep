package ch18_hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ch18_9_GetMedianOfStreamingArray {

   /**
    * Numbers are generated randomly and passed to a method. Write a program to find and maintain
    * the median value as new values are generated
    */
   public static void main(String[] args) {
      maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
         @Override
         public int compare(Integer o1, Integer o2) {
            return o2-o1;
         }
      });
      minHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
         @Override
         public int compare(Integer o1, Integer o2) {
            return o1-o2;
         }
      });
      int[] A = new int[]{1,2,3,4,5,6,7,8,9,10};
      for (int i=0; i<A.length; i++){
         addNewNumber(A[i]);
         System.out.println(getMedian());
      }

   }
   
   // maintain two heaps, maxHeap and minHeap, maxHeap.size() >= minHeap.size()
   // if the length of the array is odd, the median is maxHeap.top()
   // if the length of the array is even, the median is (maxHeap.top() + minHeap.top())/2
   private static PriorityQueue<Integer> maxHeap, minHeap;
   
   public static void addNewNumber(int num){
      if (maxHeap.size() == minHeap.size()){
         if (minHeap.peek()!= null && num > minHeap.peek()){
            maxHeap.add(minHeap.poll());
            minHeap.add(num);
         }else
            maxHeap.add(num);
      }else{
         if (num < maxHeap.peek()){
            minHeap.add(maxHeap.poll());
            maxHeap.add(num);
         }else
            minHeap.add(num);
      }
   }
   
   public static double getMedian(){
      if (maxHeap.isEmpty()) // if maxHeap.isEmpty(), minHeap.isEmpty()
         return 0;
      if (maxHeap.size() == minHeap.size())
         return ((double)minHeap.peek()+maxHeap.peek())/2.0;
      else
         return maxHeap.peek();
   }

}
