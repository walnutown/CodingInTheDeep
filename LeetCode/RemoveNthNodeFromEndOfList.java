/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
*/

// Accepted, time: O(n), one pass, in position
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // n is always valid
        if (head==null) return null;
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode p = head, q = dum;
        while (n-- > 0) p = p.next;
        while (p!=null){
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return dum.next;
    }
}