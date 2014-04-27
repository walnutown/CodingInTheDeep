/*
    Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

    If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

    You may not alter the values in the nodes, only nodes itself may be changed.

    Only constant memory is allowed.

    For example,
    Given this linked list: 1->2->3->4->5

    For k = 2, you should return: 2->1->4->3->5

    For k = 3, you should return: 3->2->1->4->5
*/

// To all questions related to reverse a list, remember to maintain a previous pointer.
// time: O(n); space: O(1)
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null || head.next==null || k<=1)
            return head;
        ListNode sen = new ListNode(0); sen.next = head;
        ListNode prev = sen;
        while (prev.next!=null){
            ListNode p = prev.next;
            int count = 0;
            while (count<k && p!=null){ // check whether the group exist
                p = p.next;
                count++;
            }
            if (count<k)    break;
            p = prev.next;
            while (--count>0){      // reverse group. Note: to reverse a group of n nodes, we only need to move n-1 nodes
                ListNode node = p.next;
                p.next = node.next;
                node.next = prev.next;
                prev.next = node;
            }
            prev = p;
        }
        return sen.next;
    }
}