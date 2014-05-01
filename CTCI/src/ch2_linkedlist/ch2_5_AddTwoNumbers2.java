package ch2_linkedlist;

import org.junit.Test;

public class ch2_5_AddTwoNumbers2 {

   /**
    * Two numbers represented by a linked list in forward order
    * Add the two numbers and return the sum as a linked list
    * eg, A = 1->3->2, B = 8->2
    * Sum = 2->1->4
    */

   // Sol1
   // reverse both lists -> Leetcode/AddTwoNumbers-> reverse the result
   // time: O(n); space:O(n), n is the length of the result list

   // Sol2
   // Recursion, add two nodes from the end of the list, need to pad two lists to same length
   // need a wrapper class to return two parameters(previous node and carry)
   // time: O(n); space: O(n + n-m), n is the length of the longer list, m is the length of another
   // list
   public ListNode addListNumberInForwardOrder(ListNode num1, ListNode num2) {
      int len1 = getLength(num1), len2 = getLength(num2);
      if (len1 < len2)
         num1 = padList(num1, len2 - len1);
      if (len2 < len1)
         num2 = padList(num2, len1 - len2);
      Sum s = add(num1, num2);
      if (s.carry == 0)
         return s.node;
      else {
         return insertBefore(s.node, s.carry);
      }
   }

   // num1 and num2 have the same length
   private Sum add(ListNode num1, ListNode num2) {
      if (num1 == null && num2 == null)
         return new Sum();
      Sum s = add(num1.next, num2.next);
      int val = s.carry + num1.val + num2.val;
      s.node = insertBefore(s.node, val % 10);
      s.carry = val / 10;
      return s;
   }

   private class Sum {
      ListNode node;
      int carry;

      public Sum() {
         node = null;
         carry = 0;
      }
   }

   private int getLength(ListNode num) {
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

   private ListNode padList(ListNode num, int k) {
      ListNode res = num;
      while (k-- > 0) {
         ListNode node = new ListNode(0);
         node.next = num;
         res = node;
      }
      return res;
   }

   private ListNode insertBefore(ListNode node, int num) {
      ListNode res = new ListNode(num);
      res.next = node;
      return res;
   }

   @Test
   public void test() {
      int[] arr1 = new int[] { 1, 6, 2 };
      int[] arr2 = new int[] { 2, 8 };
      ListNode num1 = new ListNode(arr1);
      ListNode num2 = new ListNode(arr2);
      System.out.println(num1.printList());
      System.out.println(num2.printList());
      System.out.println(addListNumberInForwardOrder(num1, num2).printList());
   }

}
