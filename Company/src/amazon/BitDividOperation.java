package amazon;

public class BitDividOperation {

   /**
    * @param args
    */
   public static void main(String[] args) {
      System.out.println(bitDivide(10,2));
   }
   // minus y^(2^31), y^(2^30),...y^2, y^1, if possible
   public static int bitDivide(int a, int b){
      int divider = a < 0 ? negative(a) : a;
      int divident = b < 0 ? negative(b) : b;
      int res = 0, i =31;
    //比较x是否大于y的(1<<i)次方，避免将x与(y<<i)比较，因为不确定y的(1<<i)次方是否溢出  
      while (i>=0){
         if ((divider>>i) >= divident){
            res += (1<<i);
            divider -= (divident<<i);
         }else i--;
      }
      return res;
   }
   
   public static int negative(int num) {
      return bitAdd(~num, 1);
   }
   
   public static int bitAdd(int a, int b) {
      return b == 0 ? a : bitAdd(a ^ b, (a & b) << 1); // (a&b)<<1 is the carry
   }

   public static int bitMinus(int a, int b){
      return bitAdd(a, negative(b));
   }

}
