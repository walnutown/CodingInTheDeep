package ch10_scalability_memorylimits;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.BitSet;
import java.util.Scanner;

import org.junit.Test;

public class ch10_3_GenerateInteger2 {

   // FOLLOW UP for ch10_3_GenerateInteger
   // what if you have only 10MB memory? Assume that all the values are distinct and we now have no
   // more than one billion non-negative integers
   /*
    * Divide the file into blocks and two passes the file
    * First pass to get the block containing the available numbers (count the unique numbers in the
    * range of the block)
    * Second pass to get the available number in the block
    */
   // the issue is that we have to choose a reasonable block size
   // <1> 10MB ~= 2^23Bytes
   // <2> 1 int = 4Bytes
   // <3> blockNumber = 2^31/blockSize, blockNumber< 2^21 (2^23/4), blockSize < 2^26bits (2^23*8)
   // <4> 2^10 <= blockSize <= 2^26

   int findAvailableNumber2() throws FileNotFoundException {
      int blockNum = (int) Math.pow(2, 12);
      int blockSize = (int) Math.pow(2, 20);
      byte[] avail = new byte[blockSize / 8];
      int[] blocks = new int[blockNum]; // hold the number of appeared integers in this block
      File file = new File("src/ch10_scalability_memorylimits/ch10_3_test.txt");

      Scanner in = new Scanner(file);
      while (in.hasNext()) {
         int num = in.nextInt();
         blocks[num / blockSize]++;
      }
      int start = -1;
      for (int i = 0; i < blocks.length; i++) {
         // if the number of appeared integers is smaller than the block size, there're available
         // integers in this range
         if (blocks[i] < blockSize) {
            start = i * blockSize;
            break;
         }
      }
      if (start == -1) // no available integers
         return -1;
      int end = start + blockSize;
      in = new Scanner(file);
      while (in.hasNext()) {
         int num = in.nextInt();
         if (num >= start && num < end) {
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

   // Use BitSet
   int findAvailableNumber2_2() throws FileNotFoundException {
      int blockSize = (int) Math.pow(2, 12);
      int blockNum = (int) Math.pow(2, 20);
      int[] numCounts = new int[blockNum];
      File file = new File("src/ch10_scalability_memorylimits/ch10_3_test.txt");
      Scanner in = new Scanner(file);
      while (in.hasNextInt()){
         numCounts[in.nextInt()/blockSize]++;
      }
      int blockIndex = -1;
      for (int i=0; i<blockNum; i++){
         if (numCounts[i]<blockSize){
            blockIndex = i;
            break;
         }
      }
      if (blockIndex==-1)
         return -1;
      int start = blockIndex*blockSize, end = (blockIndex+1)*blockSize;
      in = new Scanner(file);
      BitSet bs = new BitSet(blockSize); // use (0,blockSize] instead of (0,end] to save space
      while(in.hasNextInt()){
         int num = in.nextInt();
         if (num > start && num<=end){
            bs.set(num-start);
         }
      }
      for (int i=1; i<blockSize; i++){
         if (!bs.get(i))
            return i+start;
      }
      return -1;
   }

   @Test
   public void test() throws FileNotFoundException {
      System.out.println(findAvailableNumber2());
      System.out.println(findAvailableNumber2_2());
   }

}
