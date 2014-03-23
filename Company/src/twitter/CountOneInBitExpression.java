package twitter;

import org.junit.Test;

public class CountOneInBitExpression {
   /*
    * Given a number, tell how many '1's are there in the binary format of this number
    */
   
   // time: O(lgN), N is the value of input integer
   public int countBit2(int N){
      int count = 0;
      while (N>0){
         if ((N&1)!=0)
            count++;
         N >>= 1;
      }
      return count;
   }
   
     
   // optimized version, refer to CTCI- EvaluateExpression
   // time: O(k), k is the number of 1s in bit format
   public int countBit(int N){
      int count = 0;
      while (N>0){
         count++;
         N &= N-1;
      }
      return count;
   }
   
   @Test
   public void test(){
      for (int i=0; i<=50; i++){
         System.out.println(i + ": " + Integer.toBinaryString(i) + " " + countBit(i));
      }
   }
}
