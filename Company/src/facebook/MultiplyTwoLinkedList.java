package facebook;

import lib.DoublyListNode;
import lib.ListNode;

import org.junit.Test;

public class MultiplyTwoLinkedList {

   // use a doubly linked list here to facilitate the adding carry step
   // time: O(m*n); space: O(m+n)
   public DoublyListNode multiplyTwoLinkedList(ListNode a, ListNode b) {
      DoublyListNode dum = new DoublyListNode(0);
      DoublyListNode pr = dum;
      ListNode pa = a, pb = b;
      while (pa != null) {
         DoublyListNode h = pr;
         pb = b;
         while (pb != null) {
            if (h.next == null) {
               h.next = new DoublyListNode(pa.val * pb.val);
               h.next.prev = h;
            } else
               h.next.val += pa.val * pb.val;
            h = h.next;
            pb = pb.next;
         }
         pr = pr.next;
         pa = pa.next;
      }
      return buildList(dum);
   }

   // time: O(n)
   private DoublyListNode buildList(DoublyListNode node) {
      while (node.next!=null)
         node = node.next;
      int carry = 0;
      while (node != null) {
         int val = (node.val + carry) % 10;
         carry = (node.val + carry) / 10;
         node.val = val;
         if (node.prev != null)
            node = node.prev;
         else {
            if (carry > 0) {
               node.prev = new DoublyListNode(carry);
               node = node.prev;
            } else
               break;
         }
      }
      return node.val==0? node.next:node;
   }

   @Test
   public void test() {
      int[] A = new int[] { 1, 2,3,4 };
      int[] B = new int[] { 4,9,7 };
      ListNode a = new ListNode(A);
      ListNode b = new ListNode(B);
      System.out.println(a.printList());
      System.out.println(b.printList());
      System.out.println((1234*497)+": " + multiplyTwoLinkedList(a, b).printList());
   }

}