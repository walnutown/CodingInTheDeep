package ch3_stacks_queues;

import java.util.Random;
import java.util.Stack;

public class ch3_2_ImplementStackWithMinValues {

   /**
    * How would you design a stack which, in addition to push and pop,
    * also has a function min which returns the minimum element?
    * push, pop and min should all operate in O(1)
    */

   public static void main(String[] args) {
      StackWithMin st = new StackWithMin();
      Random rd = new Random(System.currentTimeMillis());
      for (int i = 0; i < 10; i++) {
         st.push(rd.nextInt(10));
         System.out.println(st);
         System.out.println(st.min());
      }
   }

   // use a stack to store the possible min values
   // e.g. push 5,6,7,1 in order
   // the actual stack will store [5,6,7,1]
   // the min stack will store [5,1]. 6 and 7 will definitely not be min values 
   public static class StackWithMin extends Stack<Integer> {
      private Stack<Integer> min_stack;

      public StackWithMin() {
         super();
         min_stack = new Stack<Integer>();
      }

      public Integer push(Integer value) {
         if (value < this.min())           
            min_stack.push(value);
         return super.push(value);
      }

      // notice return type
      public Integer pop() {
         if (super.peek() == this.min())
            min_stack.pop();
         return super.pop();
      }

      public Integer peek() {
         return super.peek();
      }

      public Integer min() {
         return min_stack.isEmpty() ? Integer.MAX_VALUE : min_stack.peek();
      }
   }

}
