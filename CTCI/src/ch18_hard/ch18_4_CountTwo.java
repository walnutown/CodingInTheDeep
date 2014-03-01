package ch18_hard;

public class ch18_4_CountTwo {

   /**
    * Write a method to count the number of 2s between 0 and n
    */
   public static void main(String[] args) {
      for (int i = 2; i <= 200; i++) {
         System.out.println(i + " " + countTwo(i) + " " + countTwo2(i));
      }
   }

   // brute force
   public static int countTwo(int n) {
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

   // optimized
   public static int countTwo2(int n) {
      int count = 0;
      int len = String.valueOf(n).length();
      for (int i = 0; i < len; i++) {
         count += count2sInRangeAtDigit(n, i);
      }
      return count;
   }

   public static int count2sInRangeAtDigit(int num, int i) {
      int powerOf10 = (int) Math.pow(10, i);
      int nextPowerOf10 = powerOf10 * 10;
      int right = num % powerOf10;  // right is the partial number from i to the end
      // roundDown here means clear all digits from i to the end
      int roundDown = num - num % nextPowerOf10;
      // roundUp here means clear all digits from i to the end, and increase the previous digit by 1
      int roundUp = roundDown + nextPowerOf10;
      int digit = (num / powerOf10) % 10;
      if (digit < 2)
         return roundDown / 10;
      else if (digit == 2)
         return roundDown / 10 + right + 1;
      else
         return roundUp / 10;
   }

}
