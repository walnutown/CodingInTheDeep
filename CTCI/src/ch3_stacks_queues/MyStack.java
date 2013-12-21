package ch3_stacks_queues;


public class MyStack {
   private Node top;
   
   public MyStack(){
      top = null;
   }
   
   public Object pop(){
      if (top == null)
         return null;
      Object value = top.value;
      top = top.next;
      return value;
   }
   
   public void push(Object value){
      Node tmp = new Node(value);
      tmp.next = top;
      top = tmp;
   }
   
   public Object peek(){
      return top.value;
   }

}
