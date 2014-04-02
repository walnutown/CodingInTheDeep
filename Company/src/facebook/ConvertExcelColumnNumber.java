package facebook;

import org.junit.Test;

public class ConvertExcelColumnNumber {
   /*
    * Microsoft Excel numbers cells as A...Z and after that AA, AB.... AAA, AAB...ZZZ and so on.
    * Given a number, convert it to that format and vice versa.
    */

   // Basically, is convert base10 to base26.
   public String intToStr(int N) {
      if (N <= 0)
         throw new IllegalArgumentException("N should be a positive integer");
      StringBuilder sb = new StringBuilder();
      while (N > 0) {
         int r = (N - 1) % 26 + 1; // need to map 0-A,... 26-Z 
         char ch = (char) (r - 1 + 'A');
         sb.append(ch);
         N = (N - r) / 26;
      }
      return sb.reverse().toString();
   }
   
   public int strToInt(String s){
      int num = 0;
      for (int i=0; i<s.length(); i++){
         num = num*26 + (s.charAt(i)-'A'+1);
      }
      return num;
   }

   @Test
   public void test() {
      for (int i = 1; i < 100; i++){
         System.out.println(intToStr(i));
         System.out.println(strToInt(intToStr(i)));
      }
   }
}
