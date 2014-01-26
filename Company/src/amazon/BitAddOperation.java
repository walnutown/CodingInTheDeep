package amazon;

public class BitAddOperation {

   /**
    * Implement addition without using '+' operators
    */
   public static void main(String[] args) {
      System.out.println(bitAdd1(-8,10));
      System.out.println(bitAdd2(-8,10));
   }
   // recursion
   public static int bitAdd1(int a, int b){
      return b==0? a : bitAdd1(a^b, (a&b)<<1); // (a&b)<<1 is the carry
   }
   
   public static int bitAdd2(int a, int b){
      int res=0;
      while (b!=0){
         res = a^b; //不带进位加法
         b = ((a&b)<<1);
         a = res;
      }
      return res;
   }
}
