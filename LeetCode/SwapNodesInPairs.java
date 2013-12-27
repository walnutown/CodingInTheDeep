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


// Runtime error
// Last executed input: {1,2}

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // at least one node here
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode prev = dum;
        ListNode curr = head;
        int i = 1;                                  // no need to use count here, seee the code below
        while (curr.next != null){
            if ((i & 0x01) > 0){
                // swap here
                ListNode next = curr.next;
                curr.next = next.next;
                prev.next = next;
                next.next = curr;
            }
            i++;
            prev = curr;            // prev = prev.next
            curr = curr.next;       // curr =prev.next
        }
        return dum.next;
    }
}


// Accepted, Dec26
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)  return head;
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode p = head, p_prev = dum, p_next = null;
        while (p != null && p.next != null){
            p_next = p.next;
            p.next = p_next.next;
            p_next.next = p;
            p_prev.next = p_next;
            p_prev = p;
            p = p.next;
        }
        return dum.next;
    }
}