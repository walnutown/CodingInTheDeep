package linkedin;

import java.util.ArrayList;
import java.util.Stack;

public class InfixToRPN {

   /**
    * Shunting-yard algorithm is a method for parsing mathematical expressions specified in infix notation.
    * It can be used to produce output in Reverse Polish notation (RPN)
    */
   public static void main(String[] args) {
      System.out.println(infixToRPN(new String[]{"(", "1", "+", "2",")", "*", "3"}));
     // System.out.println(infixToRPN(new String[]{"1", "+", "2",")", "*", "3"}));
      System.out.println(infixToRPN(new String[]{"(", "1", "+", "2",")", "*", "3", "/", "(", "5","-", "2", ")"}));
   }
   // include: +, -, *, /, (, )
   public static ArrayList<String> infixToRPN(String[] in){
      ArrayList<String> post = new ArrayList<String>();
      if (in==null || in.length==0)   return post;
      Stack<String> st = new Stack<String>();
      for (String op : in){
         if (isNumber(op))   post.add(op);
         else if (!isParenthesis(op)){
            if (st.empty()) st.push(op);
            else if (hasPrecedence(op, st.peek())){
               post.add(st.pop());
               st.push(op);
            }else
               st.push(op);
         }else if (op.equals("("))  st.push(op);
         else{
            while(!st.isEmpty() && !st.peek().equals("("))
               post.add(st.pop());
            if (st.isEmpty())   throw new IllegalArgumentException();
            st.pop();
         }
      }
      while (!st.isEmpty()){
         if (isParenthesis(st.peek()))  throw new IllegalArgumentException();
         post.add(st.pop());
      }
      return post;
   }
   
   public static boolean isNumber(String op){
      return !(op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/") || op.equals("(") || op.equals(")"));
   }
   
   public static boolean isParenthesis(String op){
      return op.equals("(") || op.equals(")");
   }
   // op2 has precedence over op1
   public static boolean hasPrecedence(String op1, String op2){
      if (op2.equals("(") || op2.equals(""))    return false;
      return (op1.equals("+") || op1.equals("-")) && (op2.equals("*") || op2.equals("/"));
   }

}
