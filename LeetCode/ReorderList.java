/*
    Given a singly linked list L: L0→L1→…→Ln-1→Ln,
    reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

    You must do this in-place without altering the nodes' values.

    For example,
    Given {1,2,3,4}, reorder it to {1,4,2,3}.
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// get right half, reverse it, and then merge two halves
// time: O(n); space: O(1)
public class Solution {
    public void reorderList(ListNode head) {
        if (head==null || head.next==null)
            return;
        ListNode le = getLeftEndNode(head);
        ListNode r = reverse(le.next);
        le.next = null;
        merge(head, r);
    }
    
    // get the end node of left sub-list
    private ListNode getLeftEndNode(ListNode head){
        ListNode slow = head, fast = head.next.next;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast!=null) // length of list is odd;
            slow = slow.next;
        return slow;
    }
    
    // merge two lists, and return the head
    private ListNode merge(ListNode left, ListNode right){
        ListNode l = left, r = right;
        while (l!=null && r!=null){
            ListNode ln = l.next, rn = r.next;
            l.next = r;
            r.next = ln;
            l = ln;
            r = rn;
        }
        return left;
    }
    
    private ListNode reverse(ListNode head){
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode curr = head;
        while (curr.next!=null){
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = dum.next;
            dum.next = next;
            next = curr.next;
        }
        return dum.next;
    }
}

// recursion, relocate the last node in each recursive call
// time: O(n^2); space: recursive stack
public class Solution {
    public void reorderList(ListNode head) {
        if (head==null || head.next==null)
            return;
        ListNode pp = head, p = head.next;
        while (p.next!=null){
            pp = pp.next;
            p = p.next;
        }
        pp.next = null;
        p.next = head.next;
        head.next = p;
        reorderList(p.next);
    }   
}