/*
    Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

    You should preserve the original relative order of the nodes in each of the two partitions.

    For example,
    Given 1->4->3->2->5->2 and x = 3,
    return 1->2->2->4->3->5.
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

// Maintain two sentinel nodes as head of two lists, one with values less than target, ont with values equal or larger than target
// The algorithm of this quesiton is easy, similar to merge sort. Yet, there's a easy-to-make bug. Note line 42.
// time: O(n); space: O(1)
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head==null || head.next==null)
            return head;
        ListNode left = new ListNode(0), right = new ListNode(0);
        ListNode l = left, r = right, p = head;
        while (p!=null){
            if (p.val<x){
                l.next = p;
                l = l.next;
            }else{
                r.next = p;
                r = r.next;
            }
            p = p.next;
        }
        r.next = null;  // Remember to cut the list here, otherwise, we may build a list with cycle.
        l.next = right.next;
        return left.next;
    }
}