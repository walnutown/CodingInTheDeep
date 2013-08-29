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