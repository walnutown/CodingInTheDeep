/*
    Sort a linked list in O(n log n) time using constant space complexity.
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

// HeapSort and MergeSort provides O(nlgn) runnint time for data stored in array
// Yet, HeapSort requires random access, which is not suitable to a linkedlist
// So, we can only choose merge sort.
// time: O(nlgn); space: O(1)
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null)
            return head;
        ListNode fast = head.next.next, slow = head;    // use two pointers to find median
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode median = slow.next;
        slow.next = null;           // cut the list to two halves
        ListNode left = sortList(head), right = sortList(median);
        return merge(left, right);
    }
    
    private ListNode merge(ListNode left, ListNode right){
        ListNode sen = new ListNode(0), p = left, q = right, s = sen;
        while (p!=null && q!=null){
            if (p.val < q.val){
                s.next = p;
                p = p.next;
            }else{
                s.next = q;
                q = q.next;
            }
            s = s.next;
        }
        if (p!=null)
            s.next = p;
        if (q!=null)
            s.next = q;
        return sen.next;
    }
}

// Merge Sort, use a static variable to hold the current node in the list
// In this solution, division step takes O(1) time, while the above solution takes O(n/2) time
// time: O(nlgn); space: O(1)
public class Solution {
    private ListNode curr;
    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null)  return head;
        ListNode p = head;
        curr=head;
        int len = 0;
        while (p!=null){
            p=p.next;
            len++;
        }
        return mergeSortList(head, 0, len-1);
    }
    
    public ListNode mergeSortList(ListNode head, int start, int end){
        if (start>end)
            return null;
        if (start==end){
            ListNode tmp = curr;
            curr = curr.next;
            tmp.next = null;
            return tmp;
        }
        int mid = start + ((end-start)>>1);
        ListNode l = mergeSortList(head, start, mid);
        ListNode r = mergeSortList(head, mid + 1, end);
        return merge(l, r);
    }
    
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 == null? l2 : l1;
        ListNode p1 = l1, p2 = l2;
        ListNode dum = new ListNode(0), r = dum;
        while (p1 != null && p2 != null){
            if (p1.val < p2.val){
                r.next = p1;
                p1 = p1.next;
            }
            else{
                r.next = p2;
                p2 = p2.next;
            }
            r = r.next;
        }
        if(p1 != null)
            r.next = p1;
        if(p2 != null)
            r.next = p2;
        return dum.next;
    }
}