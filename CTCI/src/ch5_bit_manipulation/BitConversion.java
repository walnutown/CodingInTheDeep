package ch5_bit_manipulation;

public class BitConversion {

   /**
    * calculate the number of bits that will need to be changed in order to convert an integer X
    * into another integer Y.
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      System.out.println(bitConversion2(12, 16));
   }
   
   public static int bitConversion(int a, int b){
      int count =0;
      if (a==b) return 0;
      for (int i=0; i<32; i++){
         int mask = 1<<i;
         if (((a&mask)>0) != ((b&mask)>0))  count++;
      }
      return count;
   }
   
   public static int bitConversion2(int a, int b){
      int count=0;
      int z = a^b;
      while (z!=0){
         count += z&1;
         z = z>>1;
      }
      return count;
   }

}
