/*
    Given a sorted linked list, delete all duplicates such that each element appear only once.

    For example,
    Given 1->1->2, return 1->2.
    Given 1->1->2->3->3, return 1->2->3.
*/
// Accepted
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null)  return head;
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode p = head;
        ListNode p_prev = dum;
        while (p.next != null){
            if (p.val != p.next.val)    p_prev=p_prev.next;
            else    p_prev.next = p.next;
            p = p.next;
        }
        return dum.next;
    }
}