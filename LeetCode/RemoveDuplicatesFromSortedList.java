/*
    Given a sorted linked list, delete all duplicates such that each element appear only once.

    For example,
    Given 1->1->2, return 1->2.
    Given 1->1->2->3->3, return 1->2->3.
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

// For each node, find the following duplicates and remove them
// time: O(n); space:O(1)
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null)
            return head;
        ListNode p = head;
        while (p!=null){
            ListNode pp = p.next;
            while (pp!=null && pp.val == p.val){
                pp = pp.next;
            }
            p.next = pp;
            p = pp;
        }
        return head;
    }
}