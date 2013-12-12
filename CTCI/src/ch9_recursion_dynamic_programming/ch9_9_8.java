package ch9_recursion_dynamic_programming;

public class ch9_9_8 {

   /*
    * Given an infinite number of quarters (25 cents), dimes(10 cents), nickels(5 cents)
    * and pennies (1 cent), write code to calculate the number of ways of representing n cents 
    */
   public static void main(String[] args) {
      System.out.println(charge(2));
   }
   
   public static int charge(int value){
      if (value == 0)
         return 0;
      int[] mem; 
      if (value <= 20) // Initialization is important here
         mem = new int[20];
      else
         mem = new int[value+1]; 
      mem[0] = 1;
      for (int i = 1; i < 4; i++)
         mem[i] = 1;
      for (int i = 5; i < 10; i++)
         mem[i] = mem[i-5] + mem[i-1];
      for (int i = 10; i < 20; i++)
         mem[i] = mem[i-5] + mem[i-1] + mem[i-10];
      for (int i = 20; i <= value; i++)
         mem[i] = mem[i-5] + mem[i-1] + mem[i-10] + mem[i-20];
      return mem[value];
   }

}
