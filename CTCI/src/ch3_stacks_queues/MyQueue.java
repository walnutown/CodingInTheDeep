package ch3_stacks_queues;

public class MyQueue {
   private Node first, last;
   
   public MyQueue(){
      first = null;
      last = null;
   }
   
   public void enqueue(Object value){
      if (last == null){
         last = new Node(value);
         first = last;
      }else{
         last.next = new Node(value);
         last = last.next;
      }
   }
   
   public Object dequeue(){
      if (first == null)
         return null;
      Object value = first.value;
      first = first.next;
      return value;
   }
}
