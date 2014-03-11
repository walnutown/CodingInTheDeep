package ch10_scalability_memorylimits;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

public class ch10_3_GenerateInteger2 {

   // FOLLOW UP for ch10_3_GenerateInteger
   /*
    * Divide the file into blocks and two passes the file
    * First pass to get the block including the available numbers (count the unique numbers in the
    * range of the block)
    * Second pass to get the available number in the block
    */
   // the issue is that we have to choose a reasonable block size
   // <1> 10MB ~= 2^23Bytes
   // <2> 1 int = 4bytes
   // <3> blockNumber = 2^31/blockSize, blockNumber< 2^21 (2^23/4), blockSize < 2^26bits (2^23*8)
   // <4> 2^10 <= blockSize <= 2^26
  
   int findAvailableNumber2() throws FileNotFoundException {
      int blockNum = (int) Math.pow(2, 12);
      int blockSize = (int) Math.pow(2, 20);
      byte[] avail = new byte[blockSize / 8];
      int[] blocks = new int[blockNum];
      File file = new File("src/ch10_scalability_memorylimits/ch10_3_test.txt");
      
      Scanner in = new Scanner(file);
      while (in.hasNext()) {
         int num = in.nextInt();
         blocks[num / blockSize]++;
      }
      int start = -1;
      for (int i = 0; i < blocks.length; i++) {
         if (blocks[i] < blockSize) {
            start = i * blockSize;
            break;
         }
      }
      if (start == -1)
         return -1;
      int end = start + blockSize;
      in = new Scanner(file);
      while (in.hasNext()) {
         int num = in.nextInt();
         if (num > start && num < end) {
            avail[(num - start) / 8] |= (1 << (num - start) % 8);
         }
      }

      for (int i = 0; i < avail.length; i++) {
         for (int j = 0; j < 8; j++) {
            if ((avail[i] & (1 << j)) == 0)
               return i * 8 + j + start;
         }
      }
      return -1;
   }

   @Test
   public void test() throws FileNotFoundException {
      System.out.println(findAvailableNumber2());
   }

}
