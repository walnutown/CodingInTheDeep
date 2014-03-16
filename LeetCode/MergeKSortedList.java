/*
    Merge k sorted linked lists and return it as one sorted list. 
    Analyze and describe its complexity.
*/

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

// heap sort, 
// time: O(nlgk), space: O(k) (k is the number of lists, n is the number of nodes)
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // heap sort, O (nlgk)
        if (lists == null || lists.size() == 0) return null;
        Comparator<ListNode> com = new Comparator<ListNode>(){
            public int compare(ListNode n1, ListNode n2){
                return n1.val - n2.val;
            }
        };
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), com);
        for (ListNode node : lists){
            if (node != null)   heap.add(node);
        }
        ListNode dum = new ListNode(0);
        ListNode r = dum;
        while (!heap.isEmpty()){
            ListNode curr = heap.poll();
            if (curr.next != null)  heap.add(curr.next);
            r.next = curr;
            r = r.next;
        }
        return dum.next;
    }
}