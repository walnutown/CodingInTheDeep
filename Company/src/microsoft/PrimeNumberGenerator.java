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

}
