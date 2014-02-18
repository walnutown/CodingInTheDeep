/*
    Given a linked list, remove the nth node from the end of list and return its head.

    For example,

       Given linked list: 1->2->3->4->5, and n = 2.

       After removing the second node from the end, the linked list becomes 1->2->3->5.
    Note:
    Given n will always be valid.
    Try to do this in one pass.
*/

// two pointers, time: O(n), one pass, in position
// find the N+1 node from end of list and remove the Nth node
// Note:
// Given n will always be valid.
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null) return null;
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode l = dum, r = head;
        while (n-- > 0) r = r.next;
        while (r!=null){
            r = r.next;
            l = l.next;
        }
        l.next = l.next.next;
        return dum.next;
    }
}