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
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if (head == null || head.next == null){
            return head;
        }
        
        int len = 0;
        ListNode ln = head;
        ListNode tail = ln;
        while (ln != null){
            len++;
            tail = ln;
            ln = ln.next;
        }
        
        n = n%len;
        
        if (n == 0){
            return head;
        }
        
        ListNode newHead = head;
        ListNode newTail = newHead;
        int count = len - n ;
        while(count > 0){
            newTail = newHead;
            newHead = newHead.next;
            count--;
        }
        
        newTail.next = null;
        tail.next = head;
        
        return newHead;
    }
}

// Accepted
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if (head==null || head.next==null || n==0)  return head;
        int len = getLength(head);
        n = n % len;
        if (n==0)   return head;
        ListNode dum = new ListNode(0); dum.next = head;
        ListNode l=head, r=head;
        while (n-->0) r=r.next;
        while (r.next!=null){
            r=r.next; l=l.next;
        }
        r.next = dum.next;
        dum.next = l.next;
        l.next=null;
        return dum.next;
    }
    public int getLength(ListNode head){
        int len=0;
        while (head!=null){
            head=head.next;
            len++;
        }
        return len;
    }
}