package amazon;

public class CountBitOne {

   /**
    * Count the number of bit 1 in binary expression of given integer
    */
   public static void main(String[] args) {
      int num = 2^32-1;
      System.out.println(Integer.bitCount(num));
      System.out.println(countOne(num));
   }
   
   public static int countOne(int num){
      int count = 0;
      while (num != 0){
         count += (num&1)>0? 1 : 0;
         num = (num>>1);
      }
      return count;
   }

}
