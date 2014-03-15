package ch10_scalability_memorylimits;

import org.junit.Test;

public class ch10_4_CheckDuplicatesInArray {
   /*
    * You have an array with all the numbers from 1 to N, where N is at most 32,000. The array may
    * have duplicate entries and you do not know what N is. With only 4 kilo-bytes of memory
    * available, how would you print all duplicate elements in the array?
    */

   // we have 4KB, which means that we can address up to 8*4*2^10 bits (Note that 32*2^10 is greater
   // than 32000). We can create a bit vector with 32000 bits, where each bit represents one integer.
   
   public void checkDuplicates(int[] A){
      BitSet s = new BitSet(32000+1); // BitSet starts from 0
      for (int i=0; i<A.length; i++){
         int num = A[i];
         if (s.get(num))
            System.out.println(num);
         else
            s.set(num);
      }
   }
   
   // implement BitSet by self
   public class BitSet{
      int[] bitset;
      public BitSet(int size){
         bitset = new int[size>>5]; // size/32
      }
      
      boolean get(int pos){
         int wordNum = pos>>5;
         int bitNum = (pos&0x1F); // mod 32
         return (bitset[wordNum] & (1<<bitNum))!=0;
      }
      
      void set(int pos){
         int wordNum = pos>>5;
         int bitNum = (pos&0x1F);
         bitset[wordNum] |= 1<<bitNum;
      }
   }
   
   @Test
   public void test(){
      int[] A = new int[]{1,2,2,3,3,4};
      checkDuplicates(A);
   }
}
