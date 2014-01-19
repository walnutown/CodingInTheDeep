package linkedin;

import java.util.Stack;

public class ReversePolishNotation {

   /**
    * Reverse Polish notation (RPN) is a mathematical notation in which every operator follows all
    * of its operands,
    * in contrast to Polish notation, which puts the operator in the prefix position. It is also
    * known as postfix
    * notation and is parenthesis-free as long as operator arities are fixed
    */

   public static void main(String[] args) {
      System.out.println(reversePolish(new String[]{"4", "1", "+", "2.5", "*"}));
      System.out.println(reversePolish(new String[]{"5", "80", "40", "/", "+"}));
      //System.out.println(reversePolish(new String[]{"4", "1", "+", "2.5", "*", "1"}));
      System.out.println(reversePolish(new String[]{"5", "80", "0", "/", "+"}));
   }

   /*
    * @param ops a sequence of numbers and operators, in Reverse Polish order
    * @return the result of the computation
    * @throws IllegalArgumentException ops don't represent a well-formed RPN
    * expression
    * @throws ArithmeticException the computation generates an arithmetic error
    * , such as dividing by zero
    */
   // only consider '+', '-', '*', '/' operator
   public static double reversePolish(String[] ops) {
      if (ops == null || ops.length == 0)
         return 0;
      Stack<Double> st = new Stack<Double>();
      for (String op: ops){
         if (!isOperator(op)) st.push(Double.parseDouble(op));
         else{
            if (st.isEmpty())   throw new IllegalArgumentException();
            double right = st.pop();
            if (st.isEmpty())   throw new IllegalArgumentException();
            double left = st.pop();
            if (op.equals("+")) st.push(left+right);
            else if (op.equals("-")) st.push(left-right);
            else if (op.equals("*")) st.push(left*right);
            else if (op.equals("/")){
               if (right == 0)  throw new ArithmeticException();
               st.push(left/right);
            }
         }
      }
      if (st.isEmpty()) throw new IllegalArgumentException();
      double res = st.pop();
      if (!st.isEmpty()) throw new IllegalArgumentException();
      return res;
   }
   
   public static boolean isOperator(String op){
      return (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/"));
   }

}
