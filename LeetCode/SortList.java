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

// TLE
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null)  return head;
        ListNode p = head;
        int len = 0;
        while (p!=null){
            p=p.next;
            len++;
        }
        return mergeSortList(head, 0, len-1);
    }
    
    public ListNode mergeSortList(ListNode head, int start, int end){
        if (start>end)
            return null;
        if (start==end){
            ListNode curr = getNodeAtIndex(head, start);
            curr.next = null;
            return curr;
        }
        int mid = start + ((end-start)>>1), i=0;
        ListNode r = mergeSortList(head, mid + 1, end);
        ListNode l = mergeSortList(head, start, mid);
        return merge(l, r);
    }
    
    public ListNode merge(ListNode l1, ListNode l2) {
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
    
    public ListNode getNodeAtIndex(ListNode head, int index){
        ListNode p = head;
        while (--index >= 0)
            p = p.next;
        return p;
    }
}


// Accepted
public class Solution {
    private ListNode curr;
    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null)  return head;
        ListNode p = head;
        curr=head;
        int len = 0;
        while (p!=null){
            p=p.next;
            len++;
        }
        return mergeSortList(head, 0, len-1);
    }
    
    public ListNode mergeSortList(ListNode head, int start, int end){
        if (start>end)
            return null;
        if (start==end){
            ListNode tmp = curr;
            curr = curr.next;
            tmp.next = null;
            return tmp;
        }
        int mid = start + ((end-start)>>1);
        ListNode l = mergeSortList(head, start, mid);
        ListNode r = mergeSortList(head, mid + 1, end);
        return merge(l, r);
    }
    
    public ListNode merge(ListNode l1, ListNode l2) {
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