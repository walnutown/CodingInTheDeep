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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (l1 == null && l2 == null){
            return null;
        }
      
        ListNode p = l1;
        ListNode q = l2;
        ListNode res = new ListNode(0);// the head node
        ListNode k = res;
        int carry = 0;
        int sum = 0;
        
         while (p != null && q != null){
            sum = (p.val + q.val + carry) % 10;
            carry = (p.val + q.val + carry) >= 10 ? 1 : 0;
            ListNode n = new ListNode(sum);
            k.next = n;
            k = k.next;
            p = p.next;
            q = q.next;
        }
        
        while (p != null){
           sum = (p.val + carry) % 10;
                carry = (p.val + carry) >= 10 ? 1 : 0;
                ListNode n = new ListNode(sum);
                k.next = n;
                k = k.next;
                p = p.next;
        }
        
        while (q != null){
            sum = (q.val + carry) % 10;
                carry = (q.val + carry) >= 10 ? 1 : 0;
                ListNode n = new ListNode(sum);
                k.next = n;
                k = k.next;
                q = q.next;
        }
       
        if (carry > 0){
            ListNode n = new ListNode(1);
            k.next = n;
        }
        
        return res.next;
        
    }
    // reverse the list
    public ListNode reverse(ListNode n){
        if (n == null || n.next == null){
            return n;
        }
        
        ListNode head = n;
        ListNode res = n;
        ListNode curr = n.next;
        ListNode next;
        while (curr != null){
            next = curr.next;
            head.next = next;
            curr.next = res;
            res = curr;
            curr = next;
        }
        return res;
    }
    
    public int count(ListNode n){
        ListNode p = n;
        int count = 0;
        while(n != null){
            n = n.next;
            count++;
        }
        return count;
    }
}