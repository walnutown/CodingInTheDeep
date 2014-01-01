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

// Submission Result: Time Limit Exceeded
// Last executed input:    {2,1}, 2
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head==null || head.next==null)  return head;
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode p = left, q = right, k = head;
        while (k != null){
            if (k.val < x){
                p.next = k;
                p = p.next;
            }
            else{
                q.next = k;
                q = q.next;
            }
            k = k.next;
        }
        p.next = right.next;
        return left.next;
    }
}

// Accepted, 
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head==null || head.next==null)  return head;
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode p = left, q = right, k = head;
        while (k != null){
            ListNode next = k.next;             // keep a reference for next node here
            if (k.val < x){
                p.next = k;
                p = p.next;
                p.next = null;                  // should nullify the next
            }
            else{
                q.next = k;
                q = q.next;
                q.next =null;
            }
            k = next;
        }
        p.next = right.next;
        return left.next;
    }
}