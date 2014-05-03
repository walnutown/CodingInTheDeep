package ch9_recursion_dynamic_programming;

import java.util.HashMap;

import org.junit.Test;

public class ch9_9_11_EvaluateBooleanExpression {

   /**
    * Given a boolean expression and a desired boolean result value
    * Implement a function to count the number of ways of parenthesizing
    * the expression such that it evaluates to result
    */

   // Recursion
   public int getEvaluateWays(String s, boolean target) {
      if (s == null || s.length() == 0)
         return 0;
      if (s.length() == 1) {
         if (s.charAt(0) == '1' && target || s.charAt(0) == '0' && !target)
            return 1;
         return 0;
      }
      int count = 0;
      for (int i = 1; i < s.length(); i += 2) {
         char op = s.charAt(i);
         if (target) {
            if (op == '|') {
               count += getEvaluateWays(s.substring(0, i), true) * getEvaluateWays(s.substring(i + 1), true);
               count += getEvaluateWays(s.substring(0, i), false) * getEvaluateWays(s.substring(i + 1), true);
               count += getEvaluateWays(s.substring(0, i), true) * getEvaluateWays(s.substring(i + 1), false);
            } else if (op == '&') {
               count += getEvaluateWays(s.substring(0, i), true) * getEvaluateWays(s.substring(i + 1), true);
            } else if (op == '^') {
               count += getEvaluateWays(s.substring(0, i), true) * getEvaluateWays(s.substring(i + 1), false);
               count += getEvaluateWays(s.substring(0, i), false) * getEvaluateWays(s.substring(i + 1), true);
            }
         } else {
            if (op == '&') {
               count += getEvaluateWays(s.substring(0, i), false) * getEvaluateWays(s.substring(i + 1), true);
               count += getEvaluateWays(s.substring(0, i), false) * getEvaluateWays(s.substring(i + 1), false);
               count += getEvaluateWays(s.substring(0, i), true) * getEvaluateWays(s.substring(i + 1), false);
            } else if (op == '|') {
               count += getEvaluateWays(s.substring(0, i), false) * getEvaluateWays(s.substring(i + 1), false);
            } else if (op == '^') {
               count += getEvaluateWays(s.substring(0, i), true) * getEvaluateWays(s.substring(i + 1), true);
               count += getEvaluateWays(s.substring(0, i), true) * getEvaluateWays(s.substring(i + 1), false);
            }
         }
      }
      return count;
   }

   // Recursion + memoization
   public int getEvaluateWays2(String s, boolean target) {
      if (s == null || s.length() == 0)
         return 0;
      return finder(s, target, new HashMap<String, Integer>());
   }

   private int finder(String s, boolean target, HashMap<String, Integer> map) {
      String key = s + target;      // Note the special key used here
      if (map.containsKey(key)) return map.get(key);
      if (s.length() == 1) {
         if (s.charAt(0) == '1' && target || s.charAt(0) == '0' && !target)
            return 1;
         return 0;
      }
      int count = 0;
      for (int i = 1; i < s.length(); i += 2) {
         char op = s.charAt(i);
         if (target) {
            if (op == '|') {
               count += getEvaluateWays(s.substring(0, i), true) * getEvaluateWays(s.substring(i + 1), true);
               count += getEvaluateWays(s.substring(0, i), false) * getEvaluateWays(s.substring(i + 1), true);
               count += getEvaluateWays(s.substring(0, i), true) * getEvaluateWays(s.substring(i + 1), false);
            } else if (op == '&') {
               count += getEvaluateWays(s.substring(0, i), true) * getEvaluateWays(s.substring(i + 1), true);
            } else if (op == '^') {
               count += getEvaluateWays(s.substring(0, i), true) * getEvaluateWays(s.substring(i + 1), false);
               count += getEvaluateWays(s.substring(0, i), false) * getEvaluateWays(s.substring(i + 1), true);
            }
         } else {
            if (op == '&') {
               count += getEvaluateWays(s.substring(0, i), false) * getEvaluateWays(s.substring(i + 1), true);
               count += getEvaluateWays(s.substring(0, i), false) * getEvaluateWays(s.substring(i + 1), false);
               count += getEvaluateWays(s.substring(0, i), true) * getEvaluateWays(s.substring(i + 1), false);
            } else if (op == '|') {
               count += getEvaluateWays(s.substring(0, i), false) * getEvaluateWays(s.substring(i + 1), false);
            } else if (op == '^') {
               count += getEvaluateWays(s.substring(0, i), true) * getEvaluateWays(s.substring(i + 1), true);
               count += getEvaluateWays(s.substring(0, i), true) * getEvaluateWays(s.substring(i + 1), false);
            }
         }
      }
      map.put(key, count);
      return count;
   }

   @Test
   public void test() {
      String s = "1^0|0";
      boolean target = true;
      System.out.println(getEvaluateWays(s, target));
      System.out.println(getEvaluateWays2(s, target));
   }
}
