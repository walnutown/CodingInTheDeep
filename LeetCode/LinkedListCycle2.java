/*
    Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

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
//      <1> assume slow is k steps away from the head when it arrives entrance of the loop
//              , then fast is k steps away from the entrance.
//      <2> when slow meets fast in the cycle, fast is cycleLength-k steps away from the entrance,
//              and it will take fast k steps to get to the entrance again.

// fast/slow pointers, time: O(n); space: O(1)
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head==null) return null;
        ListNode fast = head, slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow==fast) break;
        }
        if (fast==null || fast.next==null)  return null;
        fast = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}