package ch2_linkedlist;

import org.junit.Test;

public class ReverseLinkedList {
   /**
    * Reverse a LinkedList
    */

   // Sol1, iterative version
   // Maintain two pointers, one for the new head of the reversed list, here we create a sentinel
   // to ease the border cases; and one for the old head of the list
   // In each step, we insert oldHead.next before the newHead (which is sentinel.next)
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

   // Sol2, recursive version
   // Each time, we reverse the list after current node
   // append current node to the end of the reversed list
   // and always return new head of the reversed list
   // time: O(n); space: recursive stack
   public ListNode reverse2(ListNode head) {
      if (head == null || head.next == null)
         return head;
      ListNode r = reverse2(head.next);
      head.next.next = head;
      head.next = null;
      return r; // r is always pointing to the new head of the reversed list
   }

   // Sol3, recursion + sentinel node
   private ListNode s;

   public ListNode reverse3(ListNode head) {
      ListNode sen = new ListNode(0);
      s = sen;
      reverseList(head);
      return sen.next;
   }

   public void reverseList(ListNode node) {
      if (node.next == null) {
         s.next = node;
         s = s.next;
         return;
      }
      reverseList(node.next);
      node.next = null;
      s.next = node;
      s = s.next;
   }

   @Test
   public void testReverseLinkedList() {
      int[] A = new int[] { 2, 3, 4, 5, 1, 6 };
      ListNode head = new ListNode(A);
      // System.out.println(reverse(head).printList());
      // System.out.println(reverse2(head).printList());
      System.out.println(reverse3(head).printList());
   }
}
