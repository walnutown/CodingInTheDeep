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

// Maintain two pointers to traverse the list
// Each time, slow pointer moves one step, fast pointer moves two steps
// remember key points:
//      <1> assume slow is k steps away from the head when it arrives entrance of the loop
//          ,then fast is k steps ahead of the slow (or L-k steps behind the slow, 
//          L is the length of the cycle).
//      <2> fast can catch up with slow in L-k steps
//      <3> when fast catches slow, slow is L-k steps ahead of the entrance (so as fast).
//          This means that it will take fast k steps to get to the entrance again.
// Another explaination:
//      <1> when slow meets fast, fast is k steps away from slow, which is also the length of the cycle
//      <2> L = A+B, K = C + B, if L==K, A==C
// time: O(n); space: O(1)
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