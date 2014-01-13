package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ReservoirSampleing {

   /**
    * Reservoir Sampling is a randomized algorithms for randomly choosing k samples from a list of n
    * items,
    * where n is either a very large or unknown number. Typically n is large enough that the list
    * doesn’t fit into main memory.
    * For example, a list of search queries in Google and Facebook.
    * 
    * "In application where we would like to select a large subset of the input list (say a third, i.e. k=n/3), 
    * other methods need to be adopted." -- wiki 
    * 
    * reference: http://www.geeksforgeeks.org/reservoir-sampling/
    * 
    * Sol: time O(n)
    */
   public static void main(String[] args) {
      int[] stream = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
      System.out.println(Arrays.toString(reservoirSampling(stream, 1)));
   }

   // efficiently select k random numbers from a large array 'stream'
   public static int[] reservoirSampling(int[] stream, int k) {
      if (k <= 0)
         return null;
      int[] reservoir = new int[k];
      int i = 0;
      for (; i < k; i++)
         reservoir[i] = stream[i];
      Random rd = new Random(System.currentTimeMillis());
      while (i < stream.length) {
         int j = rd.nextInt() % (i + 1);
         if (j < k && j >= 0)
            reservoir[j] = stream[i];
         i++;
      }
      return reservoir;
   }

   /*
    * simple proof:
    * for stream[n] to be selected, p = k/n
    * for stream[n-1] to be selected, p = k/(n-1) * (n-1)/n     
    *       -- stream[n-1] is in k numbers and it will not be replaced by stream[n]
    * ...
    * for stream[k] to be selected, p = k/(k+1) * (k+1)/(k+2) ... (n-1)/n  
    *       -- stream[k] is not replaced by later numbers
    */
}
