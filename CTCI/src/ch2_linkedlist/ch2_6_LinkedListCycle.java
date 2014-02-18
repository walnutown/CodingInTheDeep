package ch2_linkedlist;

public class ch2_6_LinkedListCycle {

   /*
    * Given a circular linked list, returns the node at the beginning of the loop
    */
   public static void main(String[] args) {
      int[] arr = new int[]{5,2,5,4,5,6,2};
      ListNode head = new ListNode(arr);
      ListNode end = head;
      while (end.next != null){
         end = end.next;
      }
      end.next = head.next;
      System.out.println(findLoop(head));  
   }
   
   public static ListNode findLoop(ListNode head){
      if (head == null)
         return null;
      ListNode slow = head;
      ListNode fast = head;
      while(fast != null && fast.next != null){
         slow = slow.next;
         fast = fast.next.next;
         if (slow == fast)
            break;
      }
      // no cycle detected
      if (fast == null || fast.next == null)
         return null;
      slow = head;
      while (slow != fast){
         slow = slow.next;
         fast = fast.next;
      }
      return slow;
   }

}
