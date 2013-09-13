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