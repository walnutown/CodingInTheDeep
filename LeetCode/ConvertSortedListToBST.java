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

// To deserialize a list to binary tree. We can use pre-order traversal to build the tree.
// Each time, we get the middle elemnt of the list and build the parent node, then we build
// the left-subtree using left-half list, and right-subtree using right-half list.
// refer to Comapny/amazon/SerializationOfBinaryTree
// time: O(n^2); space: O(n)
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)   return null;
        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        return builder(head, 0, len-1);
    }
    
    public TreeNode builder(ListNode head, int start, int end){
        if (start > end)    return null;
        int mid = start + ((end-start) >> 1);
        ListNode p = head;
        int i = mid;
        while (--i >= 0)    p = p.next;
        TreeNode root = new TreeNode(p.val);
        root.left = builder(head, start, mid-1);
        root.right = builder(head, mid+1, end);
        return root;
    }
}

// This solution deserialize the binary tree using inorderTraversal.
// The most difficult part is hwo to create the left-most node when
// its parent node hasn't been created, and then connect them. The key is
// to maintain two variables: start and end. When start<end, we go down
// the left-subtree, until start==end, which means that we gets to the
// level of left-most node. We create the leftmost node and then go back to the parent
// level to create the parent node, and then conenct the two. After the parent
// node is created, right-subtree is trivial to create.
// time: O(n); space: O(n), each node is visited twice
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