package twitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Test;

public class InfixNotationEvaluation {
   /*
    * Evaluate an infix notation expression
    * include operators: +, -, *, /, ^, and parenthesis
    * e.g. 1*(2+3)-6^2
    */

   /**
    * Use Dijkstra's Shunting Yard algorithm to convert infix notation to postfix notation
    * then, evaluate the postfix notation
    * time: O(n)
    * 
    * @param s is the infix notation, use whitespace as delimiter
    */
   public int evalInfixNotation(String s) {
      String[] tokens = s.split(" ");
      String[] postfix = infixToRPN(tokens);
      return evalRPN(postfix);
   }
   
   public String[] infixToRPN(String[] in) {
      ArrayList<String> post = new ArrayList<String>();
      if (in == null || in.length == 0)
         return null;
      Stack<String> st = new Stack<String>();
      for (String s : in) {
         if (!(isOperator(s) || isParenthesis(s)))
            post.add(s);
         else if (isOperator(s)) {
            // if the operator at the top of the stack(op2) has higher priority, should deal with op2 first
            // higher priority has two cases: 1. higher precedence; 2, same precedence and left-associative
            while (!st.isEmpty() && (isLeftAssociative(s) && compare(s, st.peek()) == 0 || compare(s, st.peek()) < 0))
               post.add(st.pop());
            st.push(s);
         } else if (s.equals("(")) {
            st.push(s);
         } else {
            while (!st.isEmpty() && !st.peek().equals("("))
               post.add(st.pop());
            if (st.isEmpty())
               throw new IllegalArgumentException();
            st.pop(); // not add left parenthesis into the result
         }
      }
      while (!st.isEmpty()) {
         if (isParenthesis(st.peek()))
            throw new IllegalArgumentException();
         post.add(st.pop());
      }
      return post.toArray(new String[] {});
   }

   private int evalRPN(String[] tokens) {
      if (tokens == null || tokens.length == 0)
         return 0;
      Stack<Integer> st = new Stack<Integer>();
      for (int i = 0; i < tokens.length; i++) {
         String s = tokens[i];
         if (!isOperator(s))
            st.push(Integer.parseInt(s));
         else {
            int b = st.pop(), a = st.pop();
            int res = applyOperator(s, a, b);
            st.push(res);
         }
      }
      return st.pop();
   }

   private int applyOperator(String op, int a, int b) {
      int res = 0;
      if (op.equals("+"))
         res = a + b;
      else if (op.equals("-"))
         res = a - b;
      else if (op.equals("*"))
         res = a * b;
      else if (op.equals("^"))
         res = (int) Math.pow(a, b);
      else {
         if (b == 0)
            throw new ArithmeticException("Cannot divide by zero");
         res = a / b;
      }
      return res;
   }

   private boolean isOperator(String s) {
      if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^"))
         return true;
      return false;
   }

   private boolean isParenthesis(String op) {
      return op.equals("(") || op.equals(")");
   }

   private boolean isLeftAssociative(String op) {
      return !op.equals("^");
   }

   Map<String, Integer> precedence;

   private int compare(String op1, String op2) {
      if (precedence == null) {
         precedence = new HashMap<String, Integer>();
         precedence.put("(", 0);
         precedence.put(")", 0);
         precedence.put("+", 1);
         precedence.put("-", 1);
         precedence.put("*", 2);
         precedence.put("/", 2);
         precedence.put("^", 3);
      }
      return precedence.get(op1) - precedence.get(op2);
   }

   @Test
   public void test() {
      String s = "1 * ( 2 + 23 ) - 6 ^ 2";
      System.out.println(evalInfixNotation(s));
   }
}
