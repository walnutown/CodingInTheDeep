package yahoo;

import java.util.Random;
import java.util.Stack;

import org.junit.Test;

public class SortStackUsingRecursion {
   
   /**
    * Sort a stack suing recursion 
    */
   
   // This question is a variant of reverse a stack using recursion
   
   public Stack<Integer> sort(Stack<Integer> st){
      if (st==null || st.isEmpty())
         return st;
      int top = st.pop();
      sort(st);
      insert(top, st);
      return st;
   }
   
   private void insert(int val, Stack<Integer> st){
      if (st.isEmpty() || val<=st.peek()){
         st.push(val);
         return;
      }
      int top = st.pop();
      insert(val, st);
      st.push(top);
   }
   
   @Test
   public void test(){
      Stack<Integer> st = new Stack<Integer>();
      Random r = new Random(System.currentTimeMillis());
      for (int i=0; i<10; i++)
         st.push(r.nextInt(10));
      System.out.println(st.toString());
      System.out.println(sort(st).toString());
   }
}
