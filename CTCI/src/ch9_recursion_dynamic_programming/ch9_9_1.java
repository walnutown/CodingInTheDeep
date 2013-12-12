package ch9_recursion_dynamic_programming;

public class ch9_9_1 {

   /*
    * Climbing stairs. 1/2/3 steps each time
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      int num = 30;
      System.out.println(num);
      System.out.println(climbingStairs(num));
   }
   
   public static int climbingStairs(int n){
      int[] mem = new int[n+1];
      mem[0] = 0;
      mem[1] = 1;
      mem[2] = 2;
      mem[3] = 4;
      for (int i = 4; i <= n; i++){
         mem[i] = mem[i-1] + mem[i-2] + mem[i-3];
      }
      return mem[n];
   }

}
