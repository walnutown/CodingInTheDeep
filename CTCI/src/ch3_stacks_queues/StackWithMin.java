package ch3_stacks_queues;

import java.util.Stack;

// in order to support the "<" operator, use generic Integer, instead of T
public class StackWithMin extends Stack<Integer> {
   private Stack<Integer> min_stack;
   
   public StackWithMin(){
      super();
      min_stack = new Stack<Integer>();
   }

   public Integer push(Integer value){
      if (value < this.min())           // important here, notice min(), instead of min_stack.peek()
         min_stack.push(value);
      return super.push(value);
   }
   // notice return type
   public Integer pop(){
      if ( super.peek() == this.min())
         min_stack.pop();
      return super.pop();
   }
   
   public Integer peek(){
      return super.peek();
   }
   
   public Integer min(){
      return min_stack.isEmpty() ? Integer.MAX_VALUE : min_stack.peek();
   }
}
