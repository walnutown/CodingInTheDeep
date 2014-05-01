package ch3_stacks_queues;

import org.junit.Test;

public class ImplementStack {

   /**
    * Implement the stack
    */
   
   // Use LinkedList
   // Maintain top poniter
   class MyStack {
      private Node top;

      public MyStack() {
         top = null;
      }

      public Object pop() {
         if (top == null)
            throw new NullPointerException();
         Object value = top.value;
         top = top.next;
         return value;
      }

      public void push(Object value) {
         Node tmp = new Node(value);
         tmp.next = top;
         top = tmp;
      }

      public Object peek() {
         return top.value;
      }
      
      public boolean isEmpty(){
         return top==null;
      }
      
      public String toString(){
         Node p = top;
         StringBuilder sb = new StringBuilder();
         while (p!=null){
            sb.append(p.value);
            p = p.next;
         }
         return sb.reverse().toString();
      }
   }
   
   @Test
   public void test(){
      MyStack st = new MyStack();
      for (int i=0; i<10; i++){
         st.push(i);
         System.out.println(st);
      }
      for (int i=0; i<10; i++){
         st.pop();
         System.out.println(st);
      }
   }

}
