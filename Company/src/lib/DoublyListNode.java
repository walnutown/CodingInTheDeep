package lib;

public class DoublyListNode {
   public DoublyListNode prev;
   public DoublyListNode next;
   public int val;

   public DoublyListNode(int val) {
      this.val = val;
   }

   public DoublyListNode(int[] arr) {
      // assert arr.length > 0
      DoublyListNode node = buildList(arr);
      this.val = node.val;
      this.next = node.next;
   }

   public static DoublyListNode buildList(int[] arr) {
      DoublyListNode head = new DoublyListNode(arr[0]);
      DoublyListNode p = head;
      for (int i = 1; i < arr.length; i++) {
         p.next = new DoublyListNode(arr[i]);
         p.next.prev = p;
         p = p.next;
      }
      return head;
   }

   public String printList() {
      StringBuilder sb = new StringBuilder();
      sb.append(val);
      sb.append("-> ");
      DoublyListNode p = this.next;
      while (p != null) {
         sb.append(p.val);
         sb.append("-> ");
         p = p.next;
      }
      sb.append("null");
      return sb.toString();
   }

   public String toString() {
      return val + "";
   }
}
