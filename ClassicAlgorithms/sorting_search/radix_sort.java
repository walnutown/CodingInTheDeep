package sorting_search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class radix_sort {

   /**
    * @param args
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      int[] arr = new int[]{20, 3, 10, 3234, 593};
      radixSort(arr);
      System.out.println(Arrays.toString(arr));
   }
   
   public static void radixSort(int[] arr){
      Map<Integer, Queue<Integer>> buckets = new HashMap<Integer, Queue<Integer>>();
      clearBuckets(buckets);
      boolean done = false;
      int divider = 1; 
      while (!done){
         done = true;
         // store into the buckets
         for (int num : arr){
            if (num/divider > 0)
               done = false;
            int key = num/divider % 10;
            buckets.get(key).add(num);
         }
         divider *= 10;
         // store back into the array
         for (int i = 0, index = 0; i < 10; i++){
            Queue<Integer> bucket = buckets.get(i);
            while (!bucket.isEmpty()){
               arr[index++] = bucket.poll(); 
            }
         }
         // clear the buckets
         clearBuckets(buckets);
      }
   }
   
   public static void clearBuckets(Map<Integer, Queue<Integer>> buckets){
      for (int i = 0; i < 10; i ++){
         buckets.put(i, new LinkedList<Integer>());
      }
   }

}
