/*
    Given a linked list, swap every two adjacent nodes and return its head.

    For example,
    Given 1->2->3->4, you should return the list as 2->1->4->3.

    Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
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
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head==null || head.next==null)
            return head;
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode p = head, pp = dum;
        while (p!=null && p.next!=null){
            ListNode first = p, second = p.next, next = second.next;
            pp.next =second;
            second.next = first;
            first.next = next;
            pp = first;
            p = next;
        }
        return dum.next;
    }
}