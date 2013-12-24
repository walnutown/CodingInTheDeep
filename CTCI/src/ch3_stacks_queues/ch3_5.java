package ch3_stacks_queues;

public class ch3_5 {

   /**
    * Implement a MyQueue class which implements a queue using two stacks
    */
   // see StackQueue.java
   public static void main(String[] args) {
      StackQueue<Integer> qu = new StackQueue<Integer>();
      System.out.println(qu);
      qu.add(1);
      qu.add(2);
      System.out.println(qu);
      System.out.println(qu.peek());
      qu.remove();
      System.out.println(qu);
      qu.add(4);
      System.out.println(qu);
      System.out.println(qu.peek());
   }

}
