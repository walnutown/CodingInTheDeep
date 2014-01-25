package microsoft;

public class IsPrimeNumber {

   /**
    * Check Whether a given number is prime
    */
   public static void main(String[] args) {
      for (int i=0; i<100; i++){
         if (isPrime(i))
            System.out.println(i);
      }
   }
   
   public static boolean isPrime(int num){
      if (num <=1)  return false;
      if (num%2 == 0)   return false;
      // num is odd number
      for (int i=3; i*i<num; i=i+2){
         if (num%i == 0)    return false;
      }
      return true;
   }

}
