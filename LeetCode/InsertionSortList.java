/*
    Sort a linked list using insertion sort.
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

// Note to disconnect the node from the list when move its position
// time: O(n^2); space: O(1)
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head==null || head.next==null)
            return head;
        ListNode sen = new ListNode(Integer.MIN_VALUE); sen.next = head;
        ListNode p = head.next; 
        head.next = null;   // cut the list here to avoid endless loop
        while (p!=null){
            ListNode next = p.next;
            ListNode s = sen;
            while (s.next!=null && s.next.val < p.val)
                s = s.next;
            p.next = s.next;
            s.next = p;
            p = next;
        }
        return sen.next;
    }
}