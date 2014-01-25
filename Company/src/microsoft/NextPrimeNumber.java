package microsoft;

public class NextPrimeNumber {

   /**
    * Given a number, find the nearest prime number that is larger than the number 
    */
   public static void main(String[] args) {
      System.out.println(nextPrime(80));
   }
   
   public static int nextPrime(int num){
      if (num <=1)  return 2;
      if (num%2 == 0)   num++;
      while (true){
         if (isPrime(num))  break;
         num +=2;
      }
      return num;
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
