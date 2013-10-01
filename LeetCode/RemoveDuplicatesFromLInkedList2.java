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



// #2 trial, 3 pointers
// Last executed input: {1,1}
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode end = dummy;
        ListNode prev = head;
        ListNode curr = prev.next;
        boolean dup = false;
        while (curr != null){
            while(curr.val == prev.val){
                dup = true;
                curr = curr.next;
            }
            if (dup == true){
                end.next = curr;
                end = end.next;
                prev = end.next;
                curr =prev.next;
                dup = false;
            }
            else{
                end = end.next;
                prev = prev.next;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
// Accepted
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode end = dummy;
        ListNode prev = head;
        ListNode curr = prev.next;
        boolean dup = false;
        while (curr != null){
            while(curr != null && curr.val == prev.val){
                dup = true;
                curr = curr.next;
            }
            if (dup == true){
                end.next = curr;
                if (curr == null)
                    break;
                prev = end.next;
                curr =prev.next;
                dup = false;
            }
            else{
                if (curr == null)
                    break;
                end = end.next;
                prev = prev.next;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}

// refactor the code, 2 pointers
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode end = dummy;
        ListNode curr = head;
        while (curr != null && curr.next != null){
            if (curr.val != curr.next.val){
                end = curr;
                curr =curr.next;
            }
            else{
                while(curr.next != null && curr.val == curr.next.val){
                    curr = curr.next;
                }
                end.next = curr.next;
                curr = end.next;
            }
        }
        return dummy.next;
    }
}