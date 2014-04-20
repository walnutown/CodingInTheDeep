package google;

import java.util.Random;

import org.junit.Test;

public class WeightedRandomGenerator {
   /*
    * Design and implement a class to generate random numbers in an weighted probability
    * distribution given by an array of integer weights. An existing random number generator with
    * a uniform distribution is permitted.
    * i.e. for int[] weights and number n,
    * return a random number from 0 - n-1, each with weighted probability of w[n] / sum(w)
    * 
    * for n = 5, 
    * Example distribution:
    * w = 1, 2, 3, 2, 1
    * Example probabilities:
    * w / sum = 1/9, 2/9, 1/3, 2/9, 1/9
    * Example results:
    * n = 0, 3, 1, 3, 4
    * 
    * Using Documentation:
    * Class java.util.Random
    * public int nextInt(int n)
    */
   
   // http://www.careercup.com/question?id=17433662
   
   Random r;
   public int nextInt(int n){
      if (r==null)
         r = new Random(System.currentTimeMillis());
      return r.nextInt(n);
   }
   
   // [1] create prefixSum array, get the prefix sum of each index in weights array
   // [2] get a number x through nextInt()
   // [3] get the index of first value that is larger than x in prefixSum array 
   // time: O(n); space: O(1)
   public int next(int[] weights, int N){
      int[] prefixSums = new int[N];
      prefixSums[0] = weights[0];
      for (int i=1; i<N; i++)
         prefixSums[i] = prefixSums[i-1] + weights[i];
      int x = nextInt(prefixSums[N-1])+1; // get random from [1,totalWeight]
      for (int i=0; i<N; i++){
         if (x<=prefixSums[i])
            return i;
      }
      return -1;
   }
   
   @Test
   public void test(){
      int N = 5;
      int[] weights = new int[]{3,1,2,1,3};
      int[] count = new int[N];
      for (int i=0; i<100000; i++)
         count[next(weights, N)]++;
      for (int i=0; i<N; i++)
         System.out.println(count[i]);
   }
}
