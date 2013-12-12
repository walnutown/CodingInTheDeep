package ch9_recursion_dynamic_programming;

import java.util.ArrayList;

public class ch9_9_6 {

   /*
    * Implement an algorithm to print all valid combinations of n-pairs of parentheses
    */
   public static void main(String[] args) {
      System.out.println(getValidParentheses(2));
   }

   public static ArrayList<String> getValidParentheses(int num) {
      ArrayList<String> res = new ArrayList<String>();
      if (num == 0) {
         res.add("");
         return res;
      }
      finder(num, res, new StringBuilder(), 0, 0);
      return res;
   }

   public static void finder(int num, ArrayList<String> res, StringBuilder r, int left, int right) {
      if (right > num || left > num)
         return;
      if (right == num && left == num) {
         res.add(r.toString());
         return;
      }
      r.append("(");
      finder(num, res, r, left + 1, right);
      r.deleteCharAt(r.length() - 1);
      if (left > right) {
         r.append(")");
         finder(num, res, r, left, right + 1);
         r.deleteCharAt(r.length() - 1);
      }
   }

}
