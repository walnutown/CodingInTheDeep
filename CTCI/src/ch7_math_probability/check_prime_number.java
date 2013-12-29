package ch7_math_probability;

public class check_prime_number {

   /**
    * @param args
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      System.out.println(isPrime(11));
      System.out.println(isPrime2(11));
   }
   
   public static boolean isPrime(int num){
      if (num < 2)    return false;
      for (int i=2; i<num; i++)
         if (num%i == 0)    return false;
      return true;
   }
   // The sqrt would be sufficient because, for every number A which divides N evenly, there is
   // a complement B, where A*B=N. If A>sqrt, then B<sqrt (since sqrt*sqrt=n). We therefore don't
   // need A to check n's primality, since we would have already checked with b.
   public static boolean isPrime2(int num){
      if (num < 2)  return false;
      int sqrt = (int) Math.sqrt(num);
      for (int i=2; i<=sqrt; i++)
         if (num%i == 0)    return false;
      return true;
   }

}
