/*
    Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

    For example,
    Given 1->2->3->3->4->4->5, return 1->2->5.
    Given 1->1->1->2->3, return 2->3.
*/

// time: O(n)
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)   return head;
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode p = head;
        ListNode p_prev = dum;
        while (p != null && p.next != null){
            if (p.val != p.next.val)    p_prev = p_prev.next;
            else{
                while (p.next!=null && p.val == p.next.val) p=p.next;       // once find dups, remove all dups
                p_prev.next = p.next;
            }
            p = p.next;
        }
        return dum.next;
    }
}