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
        ListNode sen = new ListNode(0); sen.next = head;
        ListNode pp = sen, p = head;
        while (p!=null && p.next!=null){
            ListNode q = p.next;
            while (q!=null && q.val==p.val)    q = q.next;
            if (q!=p.next)
                pp.next = q;
            else
                pp = p;
            p = q;
        }
        return sen.next;
    }
}