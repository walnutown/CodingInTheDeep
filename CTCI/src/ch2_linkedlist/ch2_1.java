package ch2_linkedlist;

public class ch2_1 {

   /*
    * Write code to remove duplicates from an unsorted linked list
    */
   public static void main(String[] args) {
      int[] arr = new int[]{5,2,5,4,5,6,2};
      ListNode head = new ListNode(arr);
      System.out.println(head.printList());
      System.out.println(removeDuplicates(head).printList());
   }
   
   // solve without extra space
   public static ListNode removeDuplicates(ListNode head){
      if (head == null || head.next == null)
         return head;
      ListNode p = head;
      ListNode q_prev = null;
      ListNode q = null;
      while (p.next != null){
         q_prev = p;
         q = p.next;
         while (q != null){
            if (p.val == q.val)
               q_prev.next = q.next;
            else
               q_prev = q;
            q = q.next;
         }
         p = p.next;
      }
      return head;
   }
   

}
