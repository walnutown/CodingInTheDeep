package ch2_linkedlist;

public class ch2_5_AddListNumber {

   /*
    * Two numbers represented by a linked list in reverse order
    * Add the two numbers and return the sum as a linked list
    */
   // merge two lists with carry
   // time: O(n); space(n)
   public static ListNode addListNumberInReversedOrder(ListNode num1, ListNode num2) {
      ListNode sum = new ListNode(0);
      ListNode s = sum, p = num1, q = num2;
      int carry = 0;
      while (p != null && q != null) {
         s.next = new ListNode((p.val + q.val + carry) % 10);
         s = s.next;
         carry = (p.val + q.val + carry) / 10;
         p = p.next;
         q = q.next;
      }
      while (p != null) {
         s.next = new ListNode((p.val + carry) % 10);
         s = s.next;
         carry = (p.val + carry) / 10;
         p = p.next;
      }
      while (q != null) {
         s.next = new ListNode((q.val + carry) % 10);
         s = s.next;
         carry = (q.val + carry) / 10;
         q = q.next;
      }
      if (carry > 0) {
         s.next = new ListNode(carry);
      }
      return sum.next;
   }

   // FOLLOW UP:
   // suppose the digits are stored in forward order

   // one solution is to reverse both lists,addListNumberInReversedOrder(), then reverse the result
   // time: O(n); space:O(n), n is the length of the result list

   // recursion, need a wrapper class to return two parameters(previous node and carry) in recursive call
   // time: O(n); sapce: O(n + n-m), n is the length of the longer list, m is the length of another list
   public static ListNode addListNumberInForwardOrder(ListNode num1, ListNode num2) {
      int len1 = getLength(num1), len2 = getLength(num2);
      if (len1 < len2)
         num1 = padList(num1, len2-len1);
      if (len2 < len1)
         num2 = padList(num2, len1-len2);
      Sum s = add(num1, num2);
      if (s.carry==0)
         return s.node;
      else{
         return insertBefore(s.node, s.carry);
      }
   }

   public static class Sum {
      ListNode node;
      int carry;

      public Sum() {
         node = null;
         carry = 0;
      }
   }

   public static int getLength(ListNode num) {
      if (num == null)
         return 0;
      ListNode p = num;
      int len = 0;
      while (p != null) {
         p = p.next;
         len++;
      }
      return len;
   }
   
   public static ListNode padList(ListNode num, int k){
      ListNode res = num;
      while (k-- > 0){
         ListNode node = new ListNode(0);
         node.next = num;
         res = node;
      }
      return res;
   }
   // num1 and num2 have the same length
   public static Sum add(ListNode num1, ListNode num2){
      if (num1==null && num2==null)
         return new Sum();
      Sum s = add(num1.next, num2.next);
      int val = s.carry + num1.val + num2.val;
      s.node = insertBefore(s.node, val%10);
      s.carry = val/10;
      return s;
   }
   
   public static ListNode insertBefore(ListNode node, int num){
      ListNode res = new ListNode(num);
      res.next = node;
      return res;
   }

   public static void main(String[] args) {
      int[] arr1 = new int[] { 1, 6, 2 };
      int[] arr2 = new int[] { 9, 2, 8 };
      ListNode num1 = new ListNode(arr1);
      ListNode num2 = new ListNode(arr2);
      System.out.println(num1.printList());
      System.out.println(num2.printList());
      System.out.println(addListNumberInReversedOrder(num1, num2).printList());
      System.out.println(addListNumberInForwardOrder(num1, num2).printList());
   }


}
