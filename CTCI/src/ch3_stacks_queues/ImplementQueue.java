package ch3_stacks_queues;

import org.junit.Test;

public class ImplementQueue {
   /**
    * Implement the queue
    */

   // Use LinkedList
   // Maintain first/last pointer
   class MyQueue {
      private Node first, last;

      public MyQueue() {
         first = null;
         last = null;
      }

      public void enqueue(Object value) {
         if (last == null) {
            last = new Node(value);
            first = last;   // Remember to set first
         } else {
            last.next = new Node(value);
            last = last.next;
         }
      }

      public Object dequeue() {
         if (first == null) {
            last = null;    // Remember to set last to null
            return null;
         }
         Object value = first.value;
         first = first.next;
         return value;
      }

      public boolean isEmpty() {
         return first == null && last == null;
      }

      public String toString() {
         Node head = first;
         StringBuilder sb = new StringBuilder();
         while (head != null) {
            sb.append(head.value);
            head = head.next;
         }
         return sb.toString();
      }
   }

   @Test
   public void test() {
      MyQueue qu = new MyQueue();
      for (int i = 0; i < 10; i++) {
         qu.enqueue(i);
         System.out.println(qu);
      }

      while (!qu.isEmpty()) {
         qu.dequeue();
         System.out.println(qu);
      }
   }
}