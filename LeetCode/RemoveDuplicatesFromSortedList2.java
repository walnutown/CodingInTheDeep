/*
    Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

    For example,
    Given 1->2->3->3->4->4->5, return 1->2->5.
    Given 1->1->1->2->3, return 2->3.
*/
    
// keep a prev pointer, if the following nodes are duplicates, remove them; 
// otherwise, move the prev pointer forwrd
// time: O(n); space: O(1)
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null)
            return head;
        ListNode dum = new ListNode(0); dum.next = head;
        ListNode pprev = dum;
        while (pprev.next!=null){
            ListNode p = pprev.next;
            boolean isDup = false;
            while (p.next!=null && p.val==p.next.val){
                p = p.next;
                isDup = true;
            }
            if (isDup)
                pprev.next = p.next;
            else{
                pprev.next = p;
                pprev = pprev.next;
            }
        }  
        return dum.next;
    }
}