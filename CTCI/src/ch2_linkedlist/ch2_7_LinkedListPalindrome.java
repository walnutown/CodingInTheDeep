package ch2_linkedlist;

import java.util.Stack;

public class ch2_7_LinkedListPalindrome {

   /*
    * Implement a function to check if a linked list is a palindrome
    */
   public static void main(String[] args) {
      //int[] arr = new int[] { 5, 4, 5, 4, 5 };
      int[] arr = new int[] { 5, 4, 5, 4, 5 };
      ListNode head = new ListNode(arr);
      System.out.println(head.printList());
      System.out.println(isPalindrome2(head));
   }

   // reverse and compare, only need to check the first half
   public static boolean isPalindrome(ListNode head) {
      return false;
   }

   // stack first half and compare, use fast/slow pointer.
   public static boolean isPalindrome2(ListNode head) {
      if (head == null || head.next == null)
         return true;
      ListNode slow = head, fast = head.next.next;
      Stack<Integer> st = new Stack<Integer>();
      st.push(slow.val);
      while (fast != null && fast.next != null) {
         slow = slow.next;
         st.push(slow.val);
         fast = fast.next.next;
      }
      if (fast == null)
         slow = slow.next;
      else
         slow = slow.next.next;
      while (slow != null) {
         if (slow.val != st.pop())
            return false;
         slow = slow.next;
      }
      return true;
   }

}
