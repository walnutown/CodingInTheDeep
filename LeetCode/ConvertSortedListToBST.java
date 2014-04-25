/*
    Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/

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

// Recursion
// Similar to Leetcode/sortList
// Each time, we choose the middle element from the list as root, divide the list into two halves
// and build left and right subtree through left and right halves of the list.
// time: O(nlgn) why? use master theorem, T(n) = 2T(n/2) + O(n/2); sapce: recursive stack
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head==null)
            return null;
        if (head.next==null)
            return new TreeNode(head.val);
        ListNode slow = head, fast = head.next.next;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode m = slow.next; slow.next = null;
        ListNode l = head, r = m.next; m.next = null;
        TreeNode root = new TreeNode(m.val);
        root.left = sortedListToBST(l);
        root.right = sortedListToBST(r);
        return root;
    }
}


// This solution deserialize the binary tree using inorderTraversal.
// The most difficult part is how to create the left-most node when
// its parent node hasn't been created, and then connect them. The key is
// to maintain two variables: start and end. When start<end, we go down
// the left-subtree, until start==end, which means that we gets to the
// level of left-most node. We create the leftmost node and then go back to the parent
// level to create the parent node, and then conenct the two. After the parent
// node is created, right-subtree is trivial to create.
// time: O(n), each node is visited twice; space: recursive stack
public class Solution {
    private ListNode h;
    public TreeNode sortedListToBST(ListNode head) {
        if (head==null)
            return null;
        int len = getLength(head);
        h = head;
        return inorderTraversal(0, len-1);
    }
    
    private TreeNode inorderTraversal(int start, int end){
        if (start>end)
            return null;
        int mid = (start+end)>>1;
        TreeNode left = inorderTraversal(start,mid-1);
        TreeNode node = new TreeNode(h.val);
        h = h.next;
        node.left = left;
        node.right = inorderTraversal(mid+1, end);
        return node;
    }
    
    private int getLength(ListNode head){
        int len = 0;
        ListNode p = head;
        while (p!=null){
            len++;
            p = p.next;
        }
        return len;
    }
}