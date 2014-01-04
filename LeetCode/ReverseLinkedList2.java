// Accepted
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head==null || head.next==null || m==n)  return head;
        ListNode dum = new ListNode(0); dum.next=head;
        int index = 0;
        ListNode l=dum, r=dum;
        while (n-->=m)   r=r.next;
        while (m-->1){
            l=l.next; r=r.next;
        }
        ListNode prev=l, curr=prev.next, end=r.next;
        while (curr.next != end){
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dum.next;
    }
}

// Accepted
// modified from AnnieKim
// use number of reverse times, instead of curr.next!=end as reverse condition
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head==null || head.next==null || m==n)  return head;
        ListNode dum = new ListNode(0); dum.next=head;
        ListNode prev = dum;
        for (int i=0; i<m-1; i++)   prev=prev.next;
        ListNode curr = prev.next;
        for (int i=0; i<n-m; i++){
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dum.next;
    }
}