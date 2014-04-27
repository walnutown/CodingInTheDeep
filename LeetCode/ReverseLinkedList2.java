/*
    Reverse a linked list from position m to n. Do it in-place and in one-pass.

    For example:
    Given 1->2->3->4->5->NULL, m = 2 and n = 4,

    return 1->4->3->2->5->NULL.

    Note:
    Given m, n satisfy the following condition:
    1 ≤ m ≤ n ≤ length of list.
*/

// Find starting node to reverse and then do normal reverseLinkedList
// time: O(n); space: O(1)
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head==null || head.next==null)
            return head;
        ListNode sen = new ListNode(0); sen.next = head;
        ListNode prev = sen, curr = sen.next;
        int k = n-m;
        while (--m>0){
            prev = prev.next;
            curr = curr.next;
        }
        while (k-->0){
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return sen.next;
    }
}