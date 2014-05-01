package ch2_linkedlist;

import java.util.Stack;

import org.junit.Test;

public class ch2_7_PalindromeList {

   /**
    * Implement a function to check if a linked list is a palindrome
    */

   // reverse and compare, only need to check the first half
   // time: O(n); space:O(1)
   public boolean isPalindrome(ListNode head) {
      return false;
   }

   // Maintain fast/slow pointers to find the middle of the list
   // stack first half and compare
   // time: O(n); space: O(n)
   public boolean isPalindrome2(ListNode head) {
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
      // adjust 'slow' according to list length
      if (fast == null) // list length is even
         slow = slow.next;
      else {  // list length is odd
         slow = slow.next.next;
      }
      while (slow != null) {
         if (slow.val != st.pop())
            return false;
         slow = slow.next;
      }
      return true;
   }

   @Test
   public void test() {
      int[] arr = new int[] { 5, 4, 5, 4, 5 };
      ListNode head = new ListNode(arr);
      System.out.println(head.printList());
      System.out.println(isPalindrome2(head));
   }

}
