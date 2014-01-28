/*
	Given a linked list, determine if it has a cycle in it.

	Follow up:
	Can you solve it without using extra space?
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// remember two key points:
//		<1> when slow is at the entry of the loop, fast is k stpes away from the entry
// 				which means that, entry is k steps away from the head.
//		<2>	when slow meets fast in loop, fast is cyc_len-k steps away from the entry
//				and it will takes fast k steps to get to entry again.
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head==null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow==fast) return true;
        }
        return false;
    }
}