package ch10_scalability_memorylimits;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.BitSet;
import java.util.Scanner;

import org.junit.Test;

public class ch10_3_GenerateInteger {

   /**
    * Given an input file with four billion non-negative integers, provide an algorithm to generate
    * an integer which is not contained in the file. Assume you have 1GB of memory available for
    * this task.
    */
   

   /*
    * <1> There're a total of 2^32, or 4 billion, distinct integers (and 2^31 non-negative integers)
    * <2> 1GB = 1024MB, 1MB=1024KB, 1KB=1024Byte, 1GB = (2^10)^3Byte = 2^30Byte, 1TB = 2^40Byte
    * <3> 1Byte = 8bits
    * <4> 2^30 = 1073741824 ~= 1 billion, 2^20 ~= 1 million, 2^10 ~= 1 thousand
    * SOL:
    * with 8 billion bits, we can map all possible 4-billion integers to a distinct bit
    */
   long numberOfInts = (long) Integer.MAX_VALUE;
   
   int findAvailableNumber() throws FileNotFoundException {
      byte[] bitfield = new byte[(int) (numberOfInts / 8)];
      Scanner in = new Scanner(new File("src/ch10_scalability_memorylimits/ch10_3_test.txt"));
      while (in.hasNext()) {
         int num = in.nextInt();
         /*
          * Finds the corresponding number in the bitfield by using
          * the OR operator to set the nth bit of a byte
          * (e.g., 10 would correspond to the 2nd bit of index 2 in
          * the byte array).
          */
         bitfield[num / 8] |= (1 << (num % 8));
      }

      for (int i = 0; i < bitfield.length; i++) {
         for (int j = 0; j < 8; j++) {
            if ((bitfield[i] & (1 << j)) == 0)
               return i * 8 + j;
         }
      }
      return -1;
   }
   // we can use BitSet directly
   int findAvailableNumber2() throws FileNotFoundException {
      BitSet s = new BitSet(Integer.MAX_VALUE);
      Scanner in = new Scanner(new File("src/ch10_scalability_memorylimits/ch10_3_test.txt"));
      while (in.hasNext()) {
         int num = in.nextInt();
         s.set(num);
      }

      for (int i = 0; i < s.length(); i++) {
         if (s.get(i))
            return i;
      }
      return -1;
   }

    @Test
    // OutOfMemoryError due to limited heap space
    public void test() throws FileNotFoundException {
    System.out.println(findAvailableNumber());
    }

   
}
