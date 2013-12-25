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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if (l1 == null && l2 == null){
            return null;    
        }
        
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        
        ListNode p = l1;
        ListNode q = l2;
        ListNode head = new ListNode(0);
        ListNode k = head;
        while(p != null && q != null){
            if (p.val <= q.val){
                k.next = new ListNode(p.val);
                p = p.next;
            }
            else {
                k.next = new ListNode(q.val);
                q = q.next;
            }
            k = k.next;
        }
        
        while(p != null){
            k.next = new ListNode(p.val);
            p = p.next;
            k = k.next;
        }
        
        while(q != null){
            k.next = new ListNode(q.val);
            q = q.next;
            k = k.next;
        }
        
        return head.next;
    }
}


// Accepted, Dec 24
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 == null? l2 : l1;
        ListNode p1 = l1, p2 = l2;
        ListNode res = new ListNode(0);
        ListNode r = res;
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
        while (p1 != null){
            r.next = p1;
            p1 = p1.next;
            r = r.next;
        }
        while (p2 != null){
            r.next = p2;
            p2 = p2.next;
            r = r.next;
        }
        return res.next;
    }
}