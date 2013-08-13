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
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        // count used to count the freq of values in the list
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        ListNode n = head;
        if (n == null || n.next == null){
            return head;
        }
        
        // fill the count
        count.put(n.val, 1);
        
        while (n.next != null){
            if (count.containsKey(n.next.val)){
                //count.remove(n.next.val);
                count.put(n.next.val, (count.get(n.next.val)+1));
            }else{
                count.put(n.next.val, 1);
            }
            n = n.next;
        }
        
        // check the thumb of the list
        while (count.get(head.val) > 1){
            head = head.next;
            if (head == null){
                return head;
            }
        }
        
        // check other nodes in the list
        ListNode p = head;
            while (p.next != null){
                if (count.get(p.next.val) > 1){
                    p.next = p.next.next;
                }
                else{
                    p = p.next;
                }
            }
        return head;
    }
}