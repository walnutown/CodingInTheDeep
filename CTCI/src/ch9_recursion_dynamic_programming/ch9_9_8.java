package ch9_recursion_dynamic_programming;

public class ch9_9_8 {

   /*
    * Given an infinite number of quarters (20 cents), dimes(10 cents), nickels(5 cents)
    * and pennies (1 cent), write code to calculate the number of ways of representing n cents 
    */
   public static void main(String[] args) {
      System.out.println(charge(50));
      System.out.println(change(50, 20));
      System.out.println(coinChange2(new int[]{1, 5, 10, 20}, 50));
   }
   /*-----------------------------------------------------------*/
   // This is WRONG
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
   /*-----------------------------------------------------------*/
   public static int change(int n, int denom){
      int next_denom = 0;
      switch(denom){
      case 20:
         next_denom = 10;   break;
      case 10:
         next_denom = 5;    break;
      case  5:
         next_denom = 1;    break;
      case  1:
         return 1;
      }
      int ways = 0;
      for (int i=0; i*denom <=n; i++)   ways += change(n-i*denom, next_denom);
      return ways;
   }
   /*-----------------------------------------------------------*/
   public static int coinChange2(int[] A, int target){
      if (A==null || A.length ==0)  return 0;
      return makeChange(A, target, 0);
   }
   public static int makeChange(int[] A, int target, int index){
      if (target < 0) return 0;
      if (target == 0)  return 1;
      int count = 0;
      for (int i=index; i<A.length; i++){
         count += makeChange(A, target-A[i], i);    // in next recursion, index should be no less than the previous one, to avoid duplicates
      }
      return count;
   }

}
