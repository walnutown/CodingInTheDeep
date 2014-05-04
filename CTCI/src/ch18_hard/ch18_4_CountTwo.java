package ch18_hard;

import org.junit.Test;

public class ch18_4_CountTwo {

   /**
    * Write a method to count the number of 2s between 0 and n
    */

   // Sol1
   // brute force, count 2s in each number
   // time: O(n*m); space:(1), n is the number of integer, m is the length of the largest number
   public int countTwo(int n) {
      int count = 0;
      for (int i = 0; i <= n; i++) {
         int num = i;
         while (num > 0) {
            int digit = num % 10;
            num /= 10;
            if (digit == 2)
               count++;
         }
      }
      return count;
   }

   // Sol2
   // optimized, count the 2s in all numbers at each digit
   // 2 provide 1 two, 2x provide 10 two, 2xx provide 100 two
   // e.g. countTwo(182) = (18+1) + 20 =39
   // The challenge is that in 123, '2' contributes only 5 two (20,21,22,23, 4+1)
   public int countTwo2(int n) {
      int count = 0;
      int len = String.valueOf(n).length();
      for (int i = 0; i < len; i++) {
         count += count2sInRangeAtDigit(n, i);
      }
      return count;
   }

   private int count2sInRangeAtDigit(int num, int i) {
      int powerOf10 = (int) Math.pow(10, i);
      int nextPowerOf10 = powerOf10 * 10;
      int right = num % powerOf10;  // right is the partial number from i to the end
      // roundDown here means clear all digits from i to the end
      int roundDown = num - num % nextPowerOf10;
      // roundUp here means clear all digits from i to the end, and increase the previous digit by 1
      int roundUp = roundDown + nextPowerOf10;
      int digit = (num / powerOf10) % 10; // get the number at i-th digit
      if (digit < 2)
         return roundDown / 10;
      else if (digit == 2)
         return roundDown / 10 + right + 1;
      else
         return roundUp / 10;
   }

   

   @Test
   public void test() {
      for (int i = 2; i <= 2000; i++) {
         System.out.println(i + " " + countTwo(i) + " " + countTwo2(i));
      }
   }

}
