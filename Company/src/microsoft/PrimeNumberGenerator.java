package microsoft;

import java.util.ArrayList;

public class PrimeNumberGenerator {

   /**
    * Sieve of Eratosthenes, one of a number of prime number sieves, 
    * is a simple, ancient algorithm for finding all prime numbers up to any given limit.
    * 
    * A prime number is a natural number which has exactly two distinct
    * natural number divisors: 1 and itself.
    */
   public static void main(String[] args) {
      System.out.println(generatePrimeNumber(1000));
   }
   
   // time: O(n + n/2 + n/3 + ... +1)
   public static ArrayList<Integer> generatePrimeNumber(int num){
      if (num<=1)   return null;
      ArrayList<Integer> primes = new ArrayList<Integer>();
      boolean[] marks= new boolean[num+1];
      for (int i=2; i<num; i++){
         for (int j=i; i*j<num; j++)
            marks[i*j] = true;
      }
      for (int i=2; i<num; i++){
         if (marks[i]==false)   primes.add(i);
      }
      return primes;
   }
   
   // optimize the for loop, note the getNextPrime(), which prunes invalid calculations
   public static ArrayList<Integer> generatePrimeNumber2 (int max){
      int[] flags = new int[max+1];
      int prime = 2;
      while (prime <= Math.sqrt(max)){
         // cross off remaining multiples of prime
         crossOff(flags, prime);
         // find next value which is true
         prime = getNextPrime(flags, prime);
         if (prime >= flags.length) break;
      }
      ArrayList<Integer> nums = new ArrayList<Integer>();
      for (int i=2; i<flags.length; i++){
         if (flags[i]==0)   nums.add(i);
      }
      return nums;
   }
   
   public static void crossOff(int[] flags, int prime){
      // Cross off remaining multiples of prime. We can start with (prime*prime),
      // because if we have a k*prime, where k<prime, this value would have already
      // been crossed off in a prior iteration
      for (int i=prime*prime; i<flags.length; i += prime){
         flags[i] = 1;
      }
   }
   
   public static int getNextPrime(int[] flags, int prime){
      int next = prime+1;
      while (next < flags.length && flags[next]==1)
         next++;
      return next;
   }

}
