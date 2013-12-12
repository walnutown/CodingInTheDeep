package recursion_dynamic_programming;

public class fibonacci_dp {

   /**
    * @param args
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      long start = System.currentTimeMillis();
      System.out.println(fibonacci(50));
      System.out.println("Time: "+ (System.currentTimeMillis() - start) + " ms");
   }
   
   public static long fibonacci (int index){
      long[] mem = new long[index+1];
      mem[0] = 0;
      mem[1] = 1;
      mem[2] = 2;
      for (int i = 3; i <= index; i++){
         mem[i] = mem[i-1] + mem[i-2];
      }
      return mem[index];
   }

}
