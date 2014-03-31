package facebook;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;

public class FlattenLinkedList {
   /*
    * Given a List structure where each node contains a Next node and optionally a pointer to
    * another list, flatten that list
    * e.g.
    * L1 --> L2 --> L3 --> L7 --> L8
    * |
    * v
    * L4 --> L5-->L6
    * WIll be flattened to
    * L1 --> L2 --> L3 -->L4 -->L5-->L6-->L7-->L8
    * the final list is sorted
    */
   
   public class ListNode {
      int val;
      ListNode next;
      ListNode child;

      public ListNode(int val) {
         this.val = val;
      }
      public String toString(){
         return val+"";
      }
      
   }
   
   // refer Leetcode/mergeSortedList
   // time: O(nlgk)
   public ListNode flattern(ListNode head) {
      if (head == null || head.next == null)
         return head;
      PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(10, new Comparator<ListNode>() {
         public int compare(ListNode a, ListNode b) {
            return a.val - b.val;
         }
      });
      while (head != null) {
         heap.add(head);
         head = head.next;
      }
      ListNode dum = new ListNode(0);
      ListNode p = dum;
      while (!heap.isEmpty()) {
         ListNode tmp = heap.poll();
         if (tmp.child != null)
            heap.add(tmp.child);
         p.next = tmp;
         p = p.next;
      }
      return dum.next;
   }

   /* Let us create the following linked list
   5 -> 10 -> 19 -> 28
   |    |     |     |
   V    V     V     V
   7    20    22    35
   |          |     |
   V          V     V
   8          50    40
   |                |
   V                V
   30               45
   */
   @Test
   public void test() {
      ListNode head = new ListNode(5);
      ListNode node7 = new ListNode(7);
      ListNode node8 = new ListNode(8);
      ListNode node10 = new ListNode(10);
      ListNode node19 = new ListNode(19);
      ListNode node28 = new ListNode(28);
      ListNode node30 = new ListNode(30);
      ListNode node20 = new ListNode(20);
      ListNode node22 = new ListNode(22);
      ListNode node50 = new ListNode(50);
      ListNode node35 = new ListNode(35);
      ListNode node40 = new ListNode(40);
      ListNode node45 = new ListNode(45);
      head.child = node7;
      node7.child = node8;
      node8.child = node30;
      head.next = node10;
      node10.next = node19;
      node10.child = node20;
      node19.next = node28;
      node19.child = node22;
      node22.child = node50;
      node28.child = node35;
      node35.child = node40;
      node40.child = node45;
      ListNode res = flattern(head);
      while (res!=null){
         System.out.print(res + " ");
         res = res.next;
      }
   }
}
