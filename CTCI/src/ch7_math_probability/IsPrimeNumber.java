package ch7_math_probability;

public class IsPrimeNumber {

   /**
    * Given an integer, check whether it's a prime number
    */
   public static void main(String[] args) {
      for (int i=0; i<100; i++){
         if (isPrime2(i))
            System.out.println(i);
      }
   }
   
   // time: O(n)
   public static boolean isPrime(int num){
      if (num < 2)    return false;
      for (int i=2; i<num; i++)
         if (num%i == 0)    return false;
      return true;
   }
   // The sqrt would be sufficient, because for every number A which divides N evenly, there is
   // a complement B, where A*B=N. If A>sqrt, then B<sqrt (since sqrt*sqrt=n). We therefore don't
   // need A to check n's primality, since we would have already checked with B.
   // time: O(sqrt(n))
   public static boolean isPrime2(int num){
      if (num <=1)  return false;
      if (num%2 == 0)   return false;
      // num is odd number
      for (int i=3; i*i<num; i=i+2){
         if (num%i == 0)    return false;
      }
      return true;
   }

}
