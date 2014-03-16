package ch17_moderate;

public class ch17_3_TrailingZerosInFactorial {

   /**
    * Write an algorithm which computes the number of trailing zeros in n factorial
    */
  
   // the number of trailing zeros is decided by 10 (2*5)
   // we need to count the number of multiples of 2 and 5, more concisely, the number of multiples
   // of 5 (because the number of 2 is always larger than 5)
   // time: O(nlgn); space: O(1)
   public static int trailingZeros(int n) {
      int count = 0;
      for (int i=2; i<=n; i++)
         count += factorOfFive(i);
      return count;
   }
   
   public static int factorOfFive(int num){
      int count=0;
      while (num%5 == 0){
         count++;
         num /=5;
      }
      return count;
   }
   
   // count number of multiples of 5, multiples of 25 
   // e.g. n=25, 25/5 + 25/25 = 5+1 =6 (25 has been counted twice because it has two 5s, once in 4, once in 25)
   // time: O(lgn); space: O(1)
   public static int trailingZeros2(int n) {
      int count = 0;
      for (int i=5; n/i > 0; i*=5){
         count += n/i;
      }
      return count;
   }
   
   public static void main(String[] args) {
      int num = 24;
      System.out.println(trailingZeros(num));
      System.out.println(trailingZeros2(num));
   }

   

}
