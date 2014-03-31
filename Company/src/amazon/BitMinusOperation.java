package amazon;

public class BitMinusOperation {

   /**
    * Implement minus without using '-' operators
    */
   public static void main(String[] args) {
      
      System.out.println(bitMinus(10, -8));
   }
   
   public static int bitMinus(int a, int b){
      return bitAdd(a, negative(b));
   }
   
   // Get arithmetic negative number
   // The two's complement operation is the additive inverse operation
   public static int negative(int num){
      return bitAdd(~num, 1);
   }
   
   public static int bitAdd(int a, int b){
      return b==0? a : bitAdd(a^b, (a&b)<<1); // (a&b)<<1 is the carry
   }

}
