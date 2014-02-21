package zillow;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringToLong {

   /*
    * Given a string, write a routine that converts the string to a long, without using the built in
    * functions that would do this. Describe what (if any) limitations the code has.
    */

   /**
    * Note:
    * <1> can include the sign of '+' or '-'
    * <2> can include leading and trailing white spaces
    * <3> 'res' is in range [Long.MIN_VALUE, Long.MAX_VALUE]. If the 'res' overflows
    * during the conversion, 'res' will be truncated to Long.MAX_VALUE or
    * Long.MIN_VALUE
    * <4> if there's a non-digit character in the string (except '+' and '-'), the non-digit
    * character and its trailing characters will be abandoned.
    */
   public long stringToLong(String s) {
      if (s == null)
         return 0;
      char[] ss = s.toCharArray();
      int N = s.length(), i = 0, j = N - 1;
      while (i < N && ss[i] == ' ')
         i++;
      while (j >= 0 && ss[j] == ' ')
         j--;
      if (i > j)
         return 0;
      boolean neg = ss[i] == '-' ? true : false;
      if (ss[i] == '-' || ss[i] == '+')
         i++;
      long res = 0;
      while (i <= j && ss[i] >= '0' && ss[i] <= '9') {
         int digit = ss[i++] - '0';
         if (res == Long.MAX_VALUE / 10 && digit >= Long.MAX_VALUE % 10 || res > Long.MAX_VALUE)
            return neg == true ? Long.MIN_VALUE : Long.MAX_VALUE;
         res = res * 10 + digit;
      }
      return neg == true ? -res : res;
   }
   
   /*--------------------------Test Cases-------------------------------*/
   @Test
   public void testStringToNegativeLong() {
      long num = Long.MIN_VALUE;
      String s = String.valueOf(num);
      assertTrue(stringToLong(s) == num);
   }

   @Test
   public void testStringToPositiveLong() {
      long num = Long.MAX_VALUE;
      String s = String.valueOf(num);
      assertTrue(stringToLong(s) == num);
   }

   @Test
   public void testStringToPositiveLongOverflow() {
      long num = Long.MAX_VALUE;
      String s = String.valueOf(num);
      s += "12345";
      assertTrue(stringToLong(s) == Long.MAX_VALUE);
   }

   @Test
   public void testStringToNegativeLongOverflow() {
      long num = Long.MIN_VALUE;
      String s = String.valueOf(num);
      s += "12345";
      assertTrue(stringToLong(s) == Long.MIN_VALUE);
   }

   @Test
   public void testStringWithWhitespaceToLong() {
      long num = Long.MIN_VALUE;
      String s = String.valueOf(num);
      s = "     " + s + "      ";
      assertTrue(stringToLong(s) == num);
   }

   @Test
   public void testEmptyStringToLong() {
      String s = "      ";
      assertTrue(stringToLong(s) == 0);
   }

   @Test
   public void testStringWithTrailingCharactersToLong() {
      long num = 100;
      String s = String.valueOf(num);
      s += "abc";
      assertTrue(stringToLong(s) == num);
   }

   @Test
   public void testStringWithLeadingCharactersToLong() {
      long num = 100;
      String s = String.valueOf(num);
      s = "abc" + s;
      assertTrue(stringToLong(s) == 0);
   }

}
