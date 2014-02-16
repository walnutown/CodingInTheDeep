/*
    Merge k sorted linked lists and return it as one sorted list. 
    Analyze and describe its complexity.
*/

// #2 trial, merge list one by one
// runtime error
// Last executed input:    [{0},{1}]

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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if (lists == null || lists.size() == 0)
            return null;
        if (lists.size() == 1)
            return lists.get(0);
        int i = 1;
        ListNode curr = lists.get(0);
        while (i < lists.size()){
            ListNode next = lists.get(i);
            curr = mergeTwoLists(curr, next);
            i++;
        }
        return curr;
    }
    
    public ListNode mergeTwoLists(ListNode curr, ListNode next){
        ListNode result = new ListNode(0);
        ListNode res = result;
        ListNode p = curr;
        ListNode q = next;
        while (p != null && q != null){
            if (p.val < q.val){
                res.next = new ListNode(p.val);
                p = p.next;
                res = res.next;
            }
            if (p.val > q.val){
                res.next = new ListNode(q.val);
                q = q.next;
                res = res.next;
            }
        }
        while (p != null){
            res.next = new ListNode(p.val);
            p = p.next;
            res = res.next;
        }
        while (q != null){
            res.next = new ListNode(q.val);
            q = q.next;
            res = res.next;
        }
        return result.next;
    }
}

// Accepted
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if (lists == null || lists.size() == 0)
            return null;
        if (lists.size() == 1)
            return lists.get(0);
        int i = 1;
        ListNode curr = lists.get(0);
        while (i < lists.size()){
            ListNode next = lists.get(i);
            curr = mergeTwoLists(curr, next);
            i++;
        }
        return curr;
    }
    
    public ListNode mergeTwoLists(ListNode curr, ListNode next){
        ListNode result = new ListNode(0);
        ListNode res = result;
        ListNode p = curr;
        ListNode q = next;
        while (p != null && q != null){
            if (p.val <= q.val){
                res.next = new ListNode(p.val);
                p = p.next;
                res = res.next;
            }
            else{  // change here
                res.next = new ListNode(q.val);
                q = q.next;
                res = res.next;
            }
        }
        while (p != null){
            res.next = new ListNode(p.val);
            p = p.next;
            res = res.next;
        }
        while (q != null){
            res.next = new ListNode(q.val);
            q = q.next;
            res = res.next;
        }
        return result.next;
    }
}

// we can also use heap sort here
// http://discuss.leetcode.com/questions/204/merge-k-sorted-lists

// Last executed input:    [{},{}]

public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if (lists == null || lists.size() == 0)
            return null;
        if (lists.size() == 1)
            return lists.get(0);
        Comparator<ListNode> comp = new Comparator<ListNode>(){
          public int compare(ListNode p, ListNode q){
              if (p.val < q.val)    return -1;
              if (p.val > q.val)    return 1;
              if (p.val == q.val)   return 0; // missing return statement
          }  
        };
        PriorityQueue<ListNode> qu = new PriorityQueue<ListNode>(lists.size(), comp);
        for (ListNode n: lists)
            qu.add(n);
        ListNode result =new ListNode(0);
        ListNode res = result.next;
        while (qu.size() > 0){
            ListNode curr = qu.poll();
            res = new ListNode(curr.val);
            res = res.next;
            ListNode next = curr.next;
            if (next != null)
                qu.add(next);
        }
        return result.next;
    }
}
// Accepted
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if (lists == null || lists.size() == 0)
            return null;
        if (lists.size() == 1)
            return lists.get(0);
        Comparator<ListNode> comp = new Comparator<ListNode>(){
          public int compare(ListNode p, ListNode q){
              if (p.val < q.val)    return -1;
              if (p.val > q.val)    return 1;
              return 0;
          }  
        };
        PriorityQueue<ListNode> qu = new PriorityQueue<ListNode>(lists.size(), comp);
        for (ListNode n: lists){
            if (n != null)
                qu.add(n);
        }
        ListNode result =new ListNode(0);
        ListNode res = result;
        while (qu.size() > 0){
            ListNode curr = qu.poll();
            if (curr != null){
                res.next = new ListNode(curr.val);              // notice that we don't have to create new ListNode here
                res = res.next;
                ListNode next = curr.next;
                if (next != null)
                    qu.add(next);   
            }
        }
        return result.next;
    }
}


// Accepted, Dec 25
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
        ListNode res = new ListNode(0);
        ListNode r = res;
        while (!heap.isEmpty()){
            r.next = heap.poll();
            r = r.next;
            if (r.next != null)  heap.add(r.next);
        }
        return res.next;
    }
}