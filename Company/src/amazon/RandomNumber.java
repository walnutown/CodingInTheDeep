package amazon;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class RandomNumber {

   /**
    * rand7 from rand5
    * rand5 from rand7: if 6,7, redo
    * rand28 from rand5: get rand8 first, then use rand8 to construct the matrix
    */

   private Random r = new Random(System.currentTimeMillis());

   public int rand5() {
      return r.nextInt(5) + 1;
   }

   public int rand7() {
      int[][] matrix = new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 1, 2, 3 }, { 4, 5, 6, 7, 1 },
            { 2, 3, 4, 5, 6 }, { 7, 0, 0, 0, 0 } };
      int res = 0;
      while (res == 0) {
         int i = rand5(), j = rand5();
         res = matrix[i - 1][j - 1];
      }
      return res;
   }

   public int rand7_2() {
      int rowNum = rand5(), colNum = rand5();
      int val = (rowNum-1) * 5 + colNum;
      if (val >= 22 && val <= 25)
         return rand7_2();
      return val % 7 +1;
   }

   @Test
   public void test() {
      int[] counts1 = new int[8];
      int[] counts2 = new int[8];
      for (int i = 0; i < 10000; i++) {
         counts1[rand7()]++;
         counts2[rand7_2()]++;
      }
      System.out.println(Arrays.toString(counts1));
      System.out.println(Arrays.toString(counts2));
   }

}
