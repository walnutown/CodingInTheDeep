package google;

import java.util.Stack;

import org.junit.Test;

public class ReverseStackUsingRecursion {
   /*
    * Reverse a stack using recursion
    * Given the following API
    * isEmpty(), push(), pop()
    * http://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
    */

   // In fact, we can not reverse a stack without using extra space. The trick is that
   // we can use the native recursive stack of the JVM to store temporary values
   // eg, given stack[1,2,3,4], 4 is the top element
   // when we pop the top, we have [1,2,3], 4. The target we want to get is [4,3,2,1], which can be
   // arrived through two steps, one is to reverse [1,2,3] -> [3,2,1], another is
   // to push 4 to the bottom of the stack. And finally we have [4,3,2,1].

   public Stack<Integer> reverse(Stack<Integer> st) {
      if (st.isEmpty())
         return st;
      int top = st.pop();
      reverse(st);
      pushToBottom(top, st);
      return st;
   }

   private void pushToBottom(int value, Stack<Integer> st) {
      if (st.isEmpty()) {
         st.push(value);
         return;
      }
      int top = st.pop();
      pushToBottom(value, st);
      st.push(top);
   }
   
   @Test
   public void test(){
      Stack<Integer> st = new Stack<Integer>();
      for (int i=0; i<5; i++)
         st.push(i);
      System.out.println(st.toString());
      System.out.println(reverse(st).toString());
   }

}
