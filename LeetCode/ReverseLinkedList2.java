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

// trial #2, 
// Last executed input: {3,5}, 1, 2
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // m, n is pre-validated, we use a reverse function here
        if (head == null || head.next == null || m == n)
            return head;
        ListNode dum = new ListNode(0); // need a dummy node here, cause the first node may be reversed
        dum.next = head;
        ListNode prev = dum;           // last node in list before reversed list
        int numReversed = n - m + 1;        // number of nodes to be reversed
        while ( m-- > 1 ){
            prev = prev.next;
        }
        ListNode start  = prev.next;     // start node in the original list to be reversed
        ListNode end = start;           // end node in the list has been reversed
        ListNode next = end.next;      // 
        while (numReversed > 1){        // missing numReversed-- here
            next = end.next;
            end.next = next.next;     
            prev.next = next;
            next.next = start;
            start = next;
        }
        return dum.next;
    }
}