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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n <= 0){
            return head;
        }
        
        Stack<ListNode> s = new Stack<ListNode>();
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p = newHead;
        int len = -1;
        while(p != null){
            ListNode curr = p;
            s.push(curr);
            p = p.next;
            len++;
        }
        int i = 0;
        while(!s.isEmpty()){
            ListNode curr = s.pop();
            i++;
            if (i > len){
                break;
            }
            if (i == n){
                ListNode prev = s.peek();
                prev.next = curr.next;
                break;
            }
        }
        
        return newHead.next;
    }
}


// #2 trial, in position
// Input:  {1,2}, 1
// Output: {}
// Expected:   {1}

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // n is always valid
        if (head == null)
            return null;
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode prev = dum;
        ListNode target = prev.next;
        ListNode p = head;
        while (p != null){
            n--;
            if (n < 0)
                target = target.next;
            p = p.next;
        }
        prev.next = target.next;
        return dum.next;
    }
}
// Accepted
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // n is always valid
        if (head == null)
            return null;
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode prev = dum;
        ListNode target = prev.next;
        ListNode p = head;
        while (p != null){
            n--;
            if (n < 0){
                prev =prev.next;  // missing here
                target = target.next;
            }
            p = p.next;
        }
        prev.next = target.next;
        return dum.next;
    }
}