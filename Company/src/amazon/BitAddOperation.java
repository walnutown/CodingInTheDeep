package amazon;

public class BitAddOperation {

   /**
    * Implement addition without using '+' operators
    */
  
   // a^b add each bit without carry, (a&b<<1) is the carry (has been shifted)
   // e.g. a=010, b=011, a^b = 001, a&b = 010
   public static int bitAdd1(int a, int b) {
      return b == 0 ? a : bitAdd1(a ^ b, (a & b) << 1);
   }

   public static int bitAdd2(int a, int b) {
      int res = 0;
      while (b != 0) {  // until there's no carry
         res = a ^ b;
         b = ((a & b) << 1);
         a = res;
      }
      return res;
   }
   
   public static void main(String[] args) {
      System.out.println(bitAdd1(-8, 10));
      System.out.println(bitAdd2(-8, 10));
   }

}
