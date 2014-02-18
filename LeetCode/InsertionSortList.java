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
    public ListNode insertionSortList(ListNode head) {
        if (head==null || head.next==null)      return head;
        ListNode dum = new ListNode(0); dum.next = head;
        ListNode curr = head.next;
        head.next = null; // cut the list here, the first half is sorted, the second is unsorted
        while (curr!=null){
            ListNode next = curr.next, pp = dum, p = pp.next;
            while (p!=null && p.val < curr.val){
                pp = pp.next;
                p = p.next;
            }
            pp.next = curr;
            curr.next = p;
            curr = next;
        }
        return dum.next;
    }
}