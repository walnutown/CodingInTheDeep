package lib;

public class ListNode {
   public int val;
   public ListNode next;
   
   public ListNode(int val){
      this.val = val;
      next = null;
   }
   
   public ListNode(int[] arr){
      // assert arr.length > 0
      ListNode node = buildList(arr);
      this.val = node.val;
      this.next = node.next;
   }
   
   public static ListNode buildList(int[] arr){
      ListNode head = new ListNode(arr[0]);
      ListNode p = head;
      for (int i = 1; i < arr.length; i++){
         p.next = new ListNode(arr[i]);
         p = p.next;
      }
      return head;
   }
   
   public String printList(){
      StringBuilder sb = new StringBuilder();
      sb.append(val);
      sb.append("-> ");
      ListNode p = this.next;
      while (p != null){
         sb.append(p.val);
         sb.append("-> ");
         p = p.next;
      }
      sb.append("null");
      return sb.toString();
   }
   
   public String toString(){
      return val+"";
   }
}
