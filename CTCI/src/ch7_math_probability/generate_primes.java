package ch7_math_probability;

import java.util.ArrayList;

public class generate_primes {

   /**
    * The Sieve of Eratosthenes is a highly efficient way to generate a list of 
    * primes. It works by recognizing that all non-prime numbers are divisible by a prime number
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      System.out.println(sieveOfEratosthenes(20));
   }
   
   public static ArrayList<Integer> sieveOfEratosthenes (int max){
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
