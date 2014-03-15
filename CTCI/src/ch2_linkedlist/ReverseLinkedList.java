package ch2_linkedlist;

import org.junit.Test;

public class ReverseLinkedList {
   /*
    * Reverse a LinkedList
    */
   // iterative version
   // time: O(n); space: O(1)
   public ListNode reverse(ListNode head) {
      if (head == null || head.next == null)
         return head;
      // no need to connect dum with head here (which means we can skip dum.next = head)
      ListNode dum = new ListNode(0);
      ListNode curr = head;
      while (curr != null) {
         ListNode next = curr.next;
         curr.next = dum.next;
         dum.next = curr;
         curr = next;
      }
      return dum.next;
   }

   // recursive version, hard to imagine, better to draw the recursive process
   // O(n); space: O(n)
   public ListNode reverse2(ListNode head) {
      if (head == null || head.next == null)
         return head;
      ListNode r = reverse2(head.next);
      head.next.next = head;
      head.next = null;
      return r; // r is always pointing to the last node of the list
   }

   @Test
   public void testReverseLinkedList() {
      int[] A = new int[] { 2, 3, 4, 5, 1, 6 };
      ListNode head = new ListNode(A);
      // System.out.println(reverse(head).printList());
      System.out.println(reverse2(head).printList());
   }
}
