package ch2_linkedlist;

import org.junit.Test;

public class ch2_3_RemoveNodeFromList {

   /**
    * Delete a node in the middle of a singly linked list, given only access to that node
    */
   
   // copy the value of next node to current node
   // time: O(1), space: O(1)
   public ListNode deleteNode(ListNode node) {
      if (node == null || node.next == null)
         return null;
      node.val = node.next.val;
      node.next = node.next.next;
      return node;
   }
   
   @Test
   public void test() {
      int[] arr = new int[] { 5, 2, 5, 4, 5, 6, 2 };
      ListNode head = new ListNode(arr);
      ListNode node = head.next.next.next;
      System.out.println(node.printList());
      System.out.println(deleteNode(node).printList());
   }


}
