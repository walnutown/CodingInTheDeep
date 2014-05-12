package facebook;

import org.junit.Test;

public class ConvertExcelColumnNumber {
   
   /**
    * Microsoft Excel numbers cells as A...Z and after that AA, AB.... AAA, AAB...ZZZ and so on.
    * Given a number, convert it to that format and vice versa.
    */

   // Basically, is convert base10 to base26.
   // The challenge is that not zero-indexed, the first number starts from 1 
   // So, we have 1-A, 26-Z, 27-AA
   public String intToStr(int N) {
      if (N <= 0)
         throw new IllegalArgumentException("N should be a positive integer");
      StringBuilder sb = new StringBuilder();
      while (N > 0) {
         N--;
         int r = N % 26;
         char ch = (char) (r + 'A');
         sb.append(ch);
         N = N / 26;
      }
      return sb.reverse().toString();
   }

   public int strToInt(String s) {
      int num = 0;
      for (int i = 0; i < s.length(); i++) {
         num = num * 26 + (s.charAt(i) - 'A' + 1);
      }
      return num;
   }

   @Test
   public void test() {
      for (int i = 1; i < 1000; i++) {
         System.out.println(intToStr(i) + " : " + strToInt(intToStr(i)));
      }
   }
}
