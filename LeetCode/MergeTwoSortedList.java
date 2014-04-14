/*
    Merge two sorted linked lists and return it as a new list. 
    The new list should be made by splicing together the nodes of the first two lists.
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

// Maintain two pointers on two lists
// In each step, compare the two vlaues and move forward the corresponding pointer
// time: O(n)
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 == null? l2 : l1;
        ListNode p1 = l1, p2 = l2;
        ListNode dum = new ListNode(0), r = dum;
        while (p1 != null && p2 != null){
            if (p1.val < p2.val){
                r.next = p1;
                p1 = p1.next;
            }
            else{
                r.next = p2;
                p2 = p2.next;
            }
            r = r.next;
        }
        if(p1 != null)
            r.next = p1;
        if(p2 != null)
            r.next = p2;
        return dum.next;
    }
}