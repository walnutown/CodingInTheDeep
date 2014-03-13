package ch17_moderate;

public class ch17_7_DescribeInteger {

   /**
    * Given any integer, print an English phase that describes the integer
    * (e.g. 1234, "One Thousand, Two Hundred Thirty Four")
    */
   public static void main(String[] args) {
      int num = -103406389;
      System.out.println(describeInteger(num));
      System.out.println(describeInteger2(num));
   }

   // consider 0 and negative numbers
   public static String describeInteger(int num) {
      if (num == 0)
         return "Zero";
      else if (num < 0)
         return "Negative " + describeInteger(-num);
      StringBuilder res = new StringBuilder();
      String[][] map = new String[][] {
            { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" },
            { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                  "Eighteen", "Nineteen" },
            { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" },
            { "", "Thousand", "Million", "Billion" }, };
      int digit = 0;
      while (num > 0) {
         int value = num % 10;
         if (digit % 3 == 0) {
            res.insert(0, map[3][digit / 3] + ", ");
            if ((num / 10) % 10 != 1 && value > 0)
               res.insert(0, map[0][value] + " ");
            else if ((num / 10) % 10 == 1)
               res.insert(0, map[1][value] + " ");
            if ((num / 10) % 10 > 1)
               res.insert(0, map[2][(num / 10) % 10] + " ");
            num /= 100;
            digit += 2;
         } else if (digit % 3 == 2) {
            if (num % 10 > 0)
               res.insert(0, map[0][value] + " Hundred ");
            num /= 10;
            digit++;
         }
      }
      res.delete(res.length() - 2, res.length());
      return res.toString();
   }

   // convert(19,323,984) = convert(19) + " million, " + convert(323) + " thousand " + convert(984)
   public static String describeInteger2(int num) {
      if (num == 0)
         return "Zero";
      else if (num < 0)
         return "Negative " + describeInteger2(-num);
      StringBuilder res = new StringBuilder();
      String[][] map = new String[][] {
            { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" },
            { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                  "Eighteen", "Nineteen" },
            { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" },
            { "", "Thousand", "Million", "Billion" }, };
      int count = 0;
      while (num > 0) {
         // StringBuilder.insert() takes O(n). To optimize running time, we can
         // store the block string separately and finally combine them.
         if (num % 1000 > 0)
            res.insert(0, convert(num % 1000, map) + map[3][count] + ", ");
         num /= 1000;
         count++;
      }
      res.delete(res.length() - 2, res.length());
      return res.toString();
   }

   public static String convert(int num, String[][] map) {
      StringBuilder sb = new StringBuilder();
      if (num > 100) {
         sb.append(map[0][num / 100] + " ");
         sb.append("Hundred ");
      }
      num %= 100;
      if (num / 10 == 1)
         sb.append(map[1][num % 10] + " ");
      else {
         if (num / 10 > 1)
            sb.append(map[2][num / 10] + " ");
         if (num % 10 > 0)
            sb.append(map[0][num % 10] + " ");
      }
      return sb.toString();
   }

}
