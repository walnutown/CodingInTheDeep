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
 // use fast/slow pointers to get mid of the list
 // median of ordered list
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
 // use fast/slow pointers to get mid of the list
 // median of ordered list
public class Solution {
    public void reorderList(ListNode head) {
        if (head==null || head.next==null)     return;
        ListNode slow = head, fast = head.next.next;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = fast==null? slow : slow.next;
        // reverse the right half
        ListNode prev = mid, curr = prev.next;
        while (curr.next!=null){
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        ListNode l = head, r=mid.next;
        mid.next = null;    // cut here for easy merge
        while (r!=null && l!=null){
            ListNode ll = l.next, rr= r.next;
            l.next = r;
            r.next = ll;
            l = ll;
            r = rr;
        }
    }
}