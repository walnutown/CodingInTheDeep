package slideshare;

public class FizzBuzz {

   /**
    * Write a program that prints the numbers from 1 to 100. 
    * But for multiples of three print "Fizz" instead of the number 
    * and for the multiples of five print "Buzz". 
    * For numbers which are multiples of both three and five print "FizzBuzz".
    */
   public static void main(String[] args) {
      System.out.println(fizzBuz1());
      System.out.println(fizzBuz2());
   }
   
   public static String fizzBuz1(){
      StringBuilder sb = new StringBuilder();
      for (int i=1; i<=100; i++){
         if (i%3 == 0)  sb.append("Fizz");
         if (i%5 == 0)  sb.append("Buzz");
         if (i%3!=0 && i%5!=0)  sb.append(i);
         sb.append(" ");
      }
      return sb.toString();
   }
   
   public static String fizzBuz2(){
      StringBuilder sb = new StringBuilder();
      for (int i=1; i<=100; i++){
         if (i%15 == 0)  sb.append("FizzBuzz");
         else if (i%5 == 0)  sb.append("Buzz");
         else if (i%3 == 0)  sb.append("Fizz");
         else sb.append(i);
         sb.append(" ");
      }
      return sb.toString();
   }

}
