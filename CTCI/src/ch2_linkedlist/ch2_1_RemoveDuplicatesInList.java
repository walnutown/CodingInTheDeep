package ch2_linkedlist;

public class ch2_1_RemoveDuplicatesInList {

   /*
    * Write code to remove duplicates from an unsorted linked list
    * e.g.  [1,2,6,1,4,5,4] -> [1,2,6,4,5]
    * Note: use constant space
    */
   public static void main(String[] args) {
      int[] arr = new int[]{1,2,6,1,4,5,4};
      ListNode head = new ListNode(arr);
      System.out.println(head.printList());
      System.out.println(removeDuplicates(head).printList());
   }
   
   // time: O(n^2), space: O(1)
   public static ListNode removeDuplicates(ListNode head){
      if (head == null || head.next == null)
         return head;
      ListNode p = head;
      while (p != null){
         ListNode pp = p;
         while (pp.next != null){
            if (pp.next.val == p.val){
               pp.next = pp.next.next;
            }else
               pp = pp.next;
         }
         p = p.next;
      }
      return head;
   }
   

}
