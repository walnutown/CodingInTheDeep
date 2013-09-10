// not in position, create a new linked list
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
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || head.next == null){
            return head;
        }
        
        ListNode less = new ListNode(0);
        ListNode bigger = new ListNode(0);
        ListNode p = head;
        ListNode lp = less;
        ListNode bp = bigger;
        while (p != null){
            if (p.val < x){
                lp.next = new ListNode(p.val);
                lp = lp.next;
            }
            else{
                bp.next = new ListNode(p.val);
                bp = bp.next;
            }
            p = p.next;
        }
        
        lp.next = bigger.next;
        return less.next;
    }
}


// need debug
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
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || head.next == null){
            return head;
        }
        int len =1;
        
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode end = head;
        while(end.next != null){
            end = end.next;
            len++;
        }
        
        ListNode curr = head;
        ListNode prev = res;
        ListNode next = null;
        if (curr != null && len > 0){
            if (curr.val < x){
                prev = curr;
                curr = curr.next;
            }
            else{
                next = curr.next;
                prev.next = curr.next;
                curr.next = null;
                end.next = curr;
                end = end.next;
                curr = next;
            }
            len--;
        }
        return res.next;
    }
}