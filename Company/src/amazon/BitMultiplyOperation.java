package amazon;

public class BitMultiplyOperation {

   /**
    * @param args
    */
   public static void main(String[] args) {
      System.out.println(bitMultiply1(10, -8));
      System.out.println(bitMultiply2(10, -8));
   }

   public static int bitMultiply1(int a, int b) {
      int multiplier = a < 0 ? negative(a) : a;
      int multiplicand = b < 0 ? negative(b) : b;
      int count = 0, res = 0;
      while (count < multiplicand) {
         res = bitAdd(res, multiplier);
         count = bitAdd(count, 1);
      }
      return (a ^ b) < 0 ? negative(res) : res;
   }

   public static int bitMultiply2(int a, int b) {
      int multiplier = a < 0 ? negative(a) : a;
      int multiplicand = b < 0 ? negative(b) : b;
      int res = 0;
      while (multiplicand > 0) {
         if ((multiplicand & 1) > 0)
            res = bitAdd(res, multiplier);
         multiplier = (multiplier << 1);
         multiplicand = (multiplicand >> 1);
      }
      return (a ^ b) < 0 ? negative(res) : res;
   }

   public static int negative(int num) {
      return bitAdd(~num, 1);
   }

   public static int bitAdd(int a, int b) {
      return b == 0 ? a : bitAdd(a ^ b, (a & b) << 1); // (a&b)<<1 is the carry
   }

}
