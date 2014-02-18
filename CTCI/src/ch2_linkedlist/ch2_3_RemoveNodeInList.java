package ch2_linkedlist;

public class ch2_3_RemoveNodeInList {

   /*
    * Delete a node in the middle of a singly linked list, given only access to that node
    */
   public static void main(String[] args) {
      int[] arr = new int[]{5,2,5,4,5,6,2};
      ListNode head = new ListNode(arr);
      ListNode node = head.next.next.next;
      System.out.println(node.printList());
      System.out.println(deleteNode(node).printList());
   }
   // copy the value of next node to current node
   // time: O(1), space: O(1)
   public static ListNode deleteNode(ListNode node){
      if (node == null || node.next == null)
         return null;
      node.val = node.next.val;
      node.next = node.next.next;
      return node;
   }

}
