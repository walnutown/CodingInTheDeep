package ch2_linkedlist;

public class ch2_4_PartitionList {

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
   
   // use two nodes to mark the start of left and right half of the list
   public static ListNode partitionList(ListNode head, int x){
      if (head == null || head.next == null)
         return head;
      ListNode left = new ListNode(0), right = new ListNode(0);
      ListNode l = left, r =right, p = head;
      while (p!=null){
         ListNode next = p.next;
         p.next = null;        // cut the list, otherwise may cause infinite loop
         if (p.val < x){
            l.next = p;
            l = l.next;
         }else{
            r.next = p;
            r = r.next;
         } 
         p = next;
      }
      l.next = right.next;
      return left.next;
   }

}
