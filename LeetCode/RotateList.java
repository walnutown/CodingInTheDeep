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