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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int count = 0;
        if (head == null){
            return null;
        }
        
        if (m == n){
            return head;
        }
        
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode prev= newHead;
        ListNode curr = prev;
        ListNode beforeInsert = newHead;
        ListNode afterInsert = newHead.next;
        while (prev.next != null){
            count++;
            curr = prev.next;
            if (count < m){
                 prev = curr;
            }
            if (count == m){
                beforeInsert = prev;
                afterInsert = curr;
                prev = curr;
            }
            if (count <= n && count > m){
                prev.next =curr.next;
                beforeInsert.next = curr;
                curr.next = afterInsert;
                afterInsert = curr;
            }
            if (count == n){
                break;
            }
           
            
        }
        
        return newHead.next;
    }
}