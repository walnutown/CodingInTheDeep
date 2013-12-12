package ch2_linkedlist;

public class ch2_3 {

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
   public static ListNode deleteNode(ListNode node){
      if (node == null || node.next == null)
         return null;
      ListNode p_prev = node;
      ListNode p = node.next;
      p_prev.val = p.val;
      while (p.next != null){
         p.val = p.next.val;
         p = p.next;
         p_prev = p_prev.next;
      }
      p_prev.next = null;
      return node;
   }

}
