package ch2_linkedlist;

public class ch2_4 {

   /*
    * Partition a linked list around a value x, such that all 
    * nodes less than x come before all nodes greater than or equal to x 
    */
   public static void main(String[] args) {
      int[] arr = new int[]{5,2,5,4,5,6,2};
      ListNode head = new ListNode(arr);
      System.out.println(head.printList());
      System.out.println(partitionList(head, 5).printList());
   }
   
   public static ListNode partitionList(ListNode head, int x){
      if (head == null || head.next == null)
         return head;
      ListNode list_end = head;
      while (list_end.next != null){
         list_end = list_end.next;
      }
      ListNode dum = new ListNode(0);
      dum.next = head;
      ListNode p = head;
      ListNode p_prev = dum;
      ListNode q = list_end;
      while (p.next != list_end.next){
         if (p.val >= x){
            p_prev.next = p.next;
            q.next = p;
            q = q.next;
            q.next = null;
            p = p_prev.next;
         }else{
            p_prev = p_prev.next;
            p = p.next;
         }
      }
      return dum.next;
   }

}
