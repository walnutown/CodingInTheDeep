// didin't pass the large judge

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null ){
            return null;
        }
        if (head.next == null){
            return new TreeNode(head.val);
        }
        
        // get list length
        int len = 0;
        ListNode p = head;
        while(p != null){
            p = p.next;
            len++;
        }
        
        return convert(0, len - 1, head);
    }
    
    public TreeNode convert(int start, int end, ListNode head){
        if (start == end){
            return new TreeNode(getNodeByIndex(head, start).val);
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(getNodeByIndex(head, mid).val);
        if (start != mid){
            node.left = convert (start, mid-1, head);
        }
        if (mid != end){
            node.right = convert (mid+1, end, head);
        }
        
        return node;
    }
    
    public ListNode getNodeByIndex(ListNode head, int index){
        ListNode p = head;
        while(index > 0){
            p = p.next;
            index--;
        }
        return p;
    }
}


// convert to array first;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null ){
            return null;
        }
        if (head.next == null){
            return new TreeNode(head.val);
        }
        
        // get list length
        int len = 0;
        ListNode p = head;
        while(p != null){
            p = p.next;
            len++;
        }
        
        int[] num = new int[len];
        p = head;
        int i = 0;
        while(p != null){
            num[i] = p.val;
            i++;
            p = p.next;
        }
        
        return sortedArrayToBST(num);
    }
    
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
       if (num == null || num.length == 0){
           return null;
       }
       
       if (num.length == 1){
           return new TreeNode(num[0]);
       }
       
       int head = 0;
       int tail = num.length -1;
       
       return convert(head, tail, num);
       
        
    }
    
    public TreeNode convert(int head, int tail, int[] num){
        if (head == tail){
            return new TreeNode(num[head]);
        }
        int mid = (head + tail)/2;
        TreeNode tn = new TreeNode(num[mid]);
        if (head != mid  ){
            tn.left = convert(head, mid-1, num);
        }
        if (tail != mid  ){ 
            tn.right = convert(mid+1,tail, num);   
        }
        return tn;
    }
}


// #2 tiral, 
// Input: {0}
// Output: {}
// Expected:   {0}

public class Solution {
    ArrayList<Integer> num;
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        TreeNode res = null;
        if (head == null)
            return res;
        num = new ArrayList<Integer>();
        while(head != null){
            num.add(head.val);
            head = head.next;
        }
        BinarySearch(num, 0, num.size()-1, res);
        return res;
    }
    
    public void BinarySearch(ArrayList<Integer> num, int start, int end, TreeNode node){
        if (start > end)
            return;
        int mid = start + (end - start)/2;
        node = new TreeNode(num.get(mid));
        BinarySearch(num, start, mid-1, node.left);  // doesn't work here, wrong way of passing arguments
        BinarySearch(num, mid+1, end, node.right);
    }
}
// Accepted
public class Solution {
    ArrayList<Integer> num;
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null)
            return null;
        num = new ArrayList<Integer>();
        while(head != null){
            num.add(head.val);
            head = head.next;
        }
        return BinarySearch(num, 0, num.size()-1);
    }
    
    public TreeNode BinarySearch(ArrayList<Integer> num, int start, int end){
        if (start > end)
            return null;
        int mid = start + (end - start)/2;
        TreeNode node = new TreeNode(num.get(mid));
        node.left = BinarySearch(num, start, mid-1);
        node.right = BinarySearch(num, mid+1, end);
        return node;
    }
}