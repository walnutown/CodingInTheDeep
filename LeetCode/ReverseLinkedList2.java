/*
    Reverse a linked list from position m to n. Do it in-place and in one-pass.

    For example:
    Given 1->2->3->4->5->NULL, m = 2 and n = 4,

    return 1->4->3->2->5->NULL.

    Note:
    Given m, n satisfy the following condition:
    1 ≤ m ≤ n ≤ length of list.
*/

// get the head and tail of the sublist to be reversed, and then reverse the sublist.
// time: O(n); space: in place
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head==null || head.next==null || m==n)  return head;
        ListNode dum = new ListNode(0); dum.next=head;
        int index = 0;
        ListNode l=dum, r=dum;
        while (n-->=m)   r=r.next;
        while (m-->1){
            l=l.next; r=r.next;
        }
        ListNode prev=l, curr=prev.next, end=r.next;
        while (curr.next != end){
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dum.next;
    }
}

// AnnieKim, count reverse times
// time: O(n); space: in place
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head==null || head.next==null || m==n)  return head;
        ListNode dum = new ListNode(0); dum.next=head;
        ListNode prev = dum;
        for (int i=0; i<m-1; i++)   prev=prev.next;
        ListNode curr = prev.next;
        for (int i=0; i<n-m; i++){
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dum.next;
    }
}