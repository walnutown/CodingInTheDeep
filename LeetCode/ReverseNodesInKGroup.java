// Accepted, one pass, O(n)
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null || head.next==null || k<=1)  return head;
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode prev = dum, p = head;
        int count = 0;
        while (p != null){
            // count a group
            while (count < k && p != null){
                p = p.next;
                count++;
            }
            if (count < k)  break;
            // reverse the group
            ListNode end = prev.next;
            while (end.next != p){
                ListNode curr = end.next;
                end.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            prev = end;
            count=0;
        }
        return dum.next;
    }
}