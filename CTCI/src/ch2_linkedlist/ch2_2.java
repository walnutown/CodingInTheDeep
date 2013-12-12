package ch2_linkedlist;

public class ch2_2 {

   /*
    * Implement an algorithm to find the kth to last element of a singly linked list
    */
   public static void main(String[] args) {
      int[] arr = new int[]{5,2,5,4,5,6,2};
      ListNode head = new ListNode(arr);
      System.out.println(head.printList());
      System.out.println(findKthToLast(head, 6));
   }
   
   public static ListNode findKthToLast(ListNode head, int k){
      if (head == null)
         return head;
      if(k < 0)
         return null;
      ListNode r_start = head;
      ListNode r_end = head;
      int count = 0;
      while (count < k-1){
         if (r_end == null)
            return null;
         r_end = r_end.next;
         count++;
      }
      while (r_end.next != null){
         r_start = r_start.next;
         r_end = r_end.next;
      }
      return r_start;
   }

}
