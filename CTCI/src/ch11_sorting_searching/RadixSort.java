package ch11_sorting_searching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.junit.Test;

public class RadixSort {

   /**
    * radix sort is a non-comparative integer sorting algorithm that sorts data with integer keys by
    * grouping keys by the individual digits which share the same significant position and value
    */
   
   // http://www.geeksforgeeks.org/radix-sort/
   // time: O(n*lgb(k)), n is the length of array, b is the base of number, k is the max value of number
   private final int BUCKET_NUM = 10;

   public void radixSort(int[] arr) {
      Map<Integer, Queue<Integer>> buckets = new HashMap<Integer, Queue<Integer>>();
      boolean done = false;
      int divider = 1;
      while (!done) {
         done = true;
         // clear the buckets
         clearBuckets(buckets);
         // store into the buckets
         for (int num : arr) {
            if (num / divider > 0)
               done = false;
            int key = num / divider % 10;
            buckets.get(key).add(num);
         }
         divider *= 10;
         // store back into the array
         for (int i = 0, index = 0; i < BUCKET_NUM; i++) {
            Queue<Integer> bucket = buckets.get(i);
            while (!bucket.isEmpty()) {
               arr[index++] = bucket.poll();
            }
         }
      }
   }

   private void clearBuckets(Map<Integer, Queue<Integer>> buckets) {
      for (int i = 0; i < BUCKET_NUM; i++) {
         buckets.put(i, new LinkedList<Integer>());
      }
   }

   @Test
   public void test() {
      int[] arr = new int[] { 20, 3, 10, 3234, 593 };
      radixSort(arr);
      System.out.println(Arrays.toString(arr));
   }

}
