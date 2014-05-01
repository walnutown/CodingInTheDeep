package ch2_linkedlist;

import org.junit.Test;

public class FindMedianOfSortedList {

   /**
    * Given a singly sorted linked list, find the median of the list
    * In constant space
    */

   // Maintain fast/slow pointers
   // Note fast/slow have different initial position 
   // time: O(n); space: O(1)
   public double findMedianOfSortedList(ListNode head) {
      if (head == null)
         return 0;
      ListNode slow = head, fast = head.next.next;
      while (fast != null && fast.next != null) {
         slow = slow.next;
         fast = fast.next.next;
      }
      // fast is always in odd index (starting from 1), if (fast==null), the
      // length of the list should be an even number
      if (fast == null)
         return (slow.val + slow.next.val) / 2.0;
      // here 'fast.next == null', should check 'fast==null' first, otherwise, NullPointerException
      return slow.next.val;
   }

   // count length first, then get median
   // time: O(n); space: O(1)
   public double findMedianOfSortedList2(ListNode head) {
      if (head == null)
         return 0;
      int len = 0;
      ListNode p = head;
      while (p != null) {
         p = p.next;
         len++;
      }
      int mid = len / 2;
      ListNode q = head;
      while (mid-- > 1) {
         q = q.next;
      }
      return len % 2 == 0 ? (q.val + q.next.val) / 2.0 : q.next.val;
   }

   @Test
   public void test() {
      int[] A = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
      ListNode head = new ListNode(A);
      System.out.println(findMedianOfSortedList(head));
      System.out.println(findMedianOfSortedList2(head));
   }

}
