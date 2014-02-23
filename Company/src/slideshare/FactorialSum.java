package slideshare;

import java.math.BigInteger;
import java.util.ArrayList;

public class FactorialSum {

   /**
    * Given a numebr N in [1...2000], get the sum of digits in N!
    * e.g., N=4, N!=24, sum = 2+4 = 6
    * 
    * Time: O(N^2); Space: O(N)
    */
   // sol1:
   //    use MultiplyStrings
   // sol2:
   //    use Java BigInteger 
   // sol3:
   //    use arraylist to represent the big integer
   // sol4:
   //    use array to represent the big integer
   public static void main(String[] args) {
      // System.out.println(Integer.MAX_VALUE);
      long start = System.currentTimeMillis();
      System.out.println(solution1(2000));
      long end1 = System.currentTimeMillis();
      System.out.println("String time: " + (end1 - start));
      System.out.println(solution2(2000));
      long end2 = System.currentTimeMillis();
      System.out.println("BigInteger time: " + (end2 - end1));
      System.out.println(solution3(2000));
      long end3 = System.currentTimeMillis();
      System.out.println("ArrayList time: " + (end3 - end2));
      System.out.println(solution4(2000));
      long end4 = System.currentTimeMillis();
      System.out.println("Array time: " + (end4 - end3));
   }

   public static int solution1(int N) {
      String fact = "1";
      for (int i = 1; i <= N; i++)
         fact = multiply(fact, "" + i);
      long res = 0;
      for (int i = 0; i < fact.length(); i++)
         res += fact.charAt(i) - '0';
      if (res > 100000000)
         return -1;
      return (int) res;
   }

   public static String multiply(String num1, String num2) {
      if (num1 == null || num2 == null)
         return null;
      int l1 = num1.length(), l2 = num2.length();
      if (l1 == 0 || l2 == 0)
         return "";
      if (num1.equals("0") || num2.equals("0"))
         return "0";     // add "0" check here
      int[] res = new int[l1 + l2 - 1];
      for (int i = l1 - 1; i >= 0; i--) {
         for (int j = l2 - 1; j >= 0; j--) {
            res[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
         }
      }
      StringBuilder sb = new StringBuilder();
      int carry = 0;
      for (int i = res.length - 1; i >= 0; i--) {
         sb.insert(0, (res[i] + carry) % 10);
         carry = (res[i] + carry) / 10;
      }
      if (carry > 0)
         sb.insert(0, carry);
      return sb.toString();
   }

   /*-----------------------------------------------------------------*/
   public static int solution2(int N) {
      BigInteger fact = BigInteger.ONE;
      for (int i = 2; i <= N; i++) {
         fact = fact.multiply(BigInteger.valueOf(i)); // should assign the returned value to fact 
      }
      long res = 0;
      String num = fact.toString();
      for (int i = 0; i < num.length(); i++)
         res += num.charAt(i) - '0';
      if (res > 100000000)
         return -1;
      return (int) res;
   }

   /*-----------------------------------------------------------------*/
   // use arraylist directly here, avoid the string operation
   public static int solution3(int N) {
      ArrayList<Integer> res = new ArrayList<Integer>();
      res.add(1);
      for (int i = 2; i <= N; i++)  res = multiply3(res, toArray3(i)); 
      int sum = 0;
      for (int i = 0; i < res.size(); i++)
         sum += res.get(i);
      if (sum > 100000000)
         return -1;
      return sum;
   }

   public static ArrayList<Integer> toArray3(int N) {
      ArrayList<Integer> arr = new ArrayList<Integer>();
      while (N > 0) {
         arr.add(0, N % 10);
         N /= 10;
      }
      return arr;
   }

   public static ArrayList<Integer> multiply3(ArrayList<Integer> num1, ArrayList<Integer> num2) {
      int l1 = num1.size(), l2 = num2.size();
      ArrayList<Integer> tmp = new ArrayList<Integer>();
      for (int i = 0; i < l1; i++) {
         for (int j = 0; j < l2; j++) {
            int mul = num1.get(i) * num2.get(j);
            if (i+j < tmp.size())   
               tmp.set(i + j, mul + tmp.get(i+j)); // max 9*9=81
            else
               tmp.add(mul);
         }
      }
      int carry = 0;
      for (int i = tmp.size() - 1; i >= 0; i--) {
         int value = (tmp.get(i) + carry) % 10;
         carry = (tmp.get(i) + carry) / 10;
         tmp.set(i, value);
      }
      if (carry != 0) {
        tmp.add(0, carry);
      }
      return tmp;
   }

   /*-----------------------------------------------------------------*/
   // use array here, array is more efficient than arrayList
   public static int solution4(int N) {
      int[] res = new int[1];
      res[0] = 1;
      for (int n = 2; n <= N; n++) res = multiply4(res, toArray4(n));
      int sum = 0;
      for (int i = 0; i < res.length; i++)
         sum += res[i];
      if (sum > 100000000)
         return -1;
      return sum;
   }
   
   public static int[] multiply4(int[] num1, int[] num2){
      int l1 = num1.length, l2 = num2.length;
      int[] tmp = new int[l1+l2-1];
      for (int i=0; i<l1; i++){
         for (int j=0; j<l2; j++){
            tmp[i+j] += num1[i]*num2[j];
         }
      }
      int carry = 0;
      for (int i = tmp.length - 1; i >= 0; i--) {
         int value = (tmp[i] + carry) % 10;
         carry = (tmp[i] + carry) / 10;
         tmp[i] = value;
      }
      if (carry != 0) {
        int[] tmp2 = new int[tmp.length+1];
        tmp2[0] = carry;
        for (int i=0; i<tmp.length; i++)    tmp2[i+1] = tmp[i];
        return tmp2;
      }
      return tmp;
   }
   
   public static int[] toArray4(int N) {
      ArrayList<Integer> arr = new ArrayList<Integer>();
      while (N > 0) {
         arr.add(N % 10);
         N /= 10;
      }
      int[] A = new int[arr.size()];
      for (int i=0; i<arr.size(); i++)  A[arr.size()-1-i] = arr.get(i);
      return A;
   }
}
