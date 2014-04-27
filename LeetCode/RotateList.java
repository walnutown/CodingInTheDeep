/*
    Given a list, rotate the list to the right by k places, where k is non-negative.

    For example:
    Given 1->2->3->4->5->NULL and k = 2,
    return 4->5->1->2->3->NULL.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


// Maintain two poointers to track the start and end of the sub-list to be rotated
// time: O(n); space: O(1)
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if (head==null || head.next==null || n==0)  return head;
        int len = getLength(head);
        n = n % len;    // Note modulo here
        if (n==0)   return head;
        ListNode dum = new ListNode(0); dum.next = head;
        ListNode l=head, r=head;
        while (n-->0) r=r.next;
        while (r.next!=null){
            r=r.next; l=l.next;
        }
        r.next = dum.next;
        dum.next = l.next;
        l.next=null;
        return dum.next;
    }
    public int getLength(ListNode head){
        int len=0;
        while (head!=null){
            head=head.next;
            len++;
        }
        return len;
    }
}