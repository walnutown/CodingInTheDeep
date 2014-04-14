/*
    Given a binary tree

        struct TreeLinkNode {
          TreeLinkNode *left;
          TreeLinkNode *right;
          TreeLinkNode *next;
        }
    Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

    Initially, all next pointers are set to NULL.

    Note:

    You may only use constant extra space.
    You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
    For example,
    Given the following perfect binary tree,
             1
           /  \
          2    3
         / \  / \
        4  5  6  7
    After calling your function, the tree should look like:
             1 -> NULL
           /  \
          2 -> 3 -> NULL
         / \  / \
        4->5->6->7 -> NULL
*/

// Recursion
// time: O(n); space: recursive stack
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null || root.left==null && root.right==null)   return;
        root.left.next = root.right;
        if (root.next != null)  root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
    }
}

// Iterative version
// time: O(n); space: O(1) 
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode first = root;
        while (first != null && first.left != null){
            TreeLinkNode p = first;
            while (p != null){
                p.left.next = p.right;
                if (p.next != null) p.right.next = p.next.left;
                p = p.next;
            }
            first = first.left;
        }
    }   
}
