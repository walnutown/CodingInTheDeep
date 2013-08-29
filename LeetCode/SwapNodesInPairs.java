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
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || head.next == null){
            return head;
        }
        
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        
        ListNode prev = newHead;
        ListNode curr = prev.next;
        ListNode next = curr.next;
        int count = 1;
        while (next != null){
            count++;
            if (count%2 == 0){
                prev.next = next;
                curr.next = next.next;
                next.next = curr;
            }
            
            prev = prev.next;
            curr = prev.next;
            next = curr.next;
        }
        
        return newHead.next;
        
    }
}