/*
    Given a binary tree, flatten it to a linked list in-place.

    For example,
    Given

             1
            / \
           2   5
          / \   \
         3   4   6
    The flattened tree should look like:
       1
        \
         2
          \
           3
            \
             4
              \
               5
                \
                 6
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
// [1] move left child to right, 
// [2] flat left, connect left tail with right head
// [3] return the tail of the list
// time: O(n); space: recursive stack
public class Solution {
    public void flatten(TreeNode root) {
        if (root==null)
            return;
        flat(root);
    }
    
    private TreeNode flat(TreeNode node){
        TreeNode left = node.left, right = node.right;
        TreeNode tail = node; // if has no left or right child, current node is the tail
        if (left!=null){
            node.left = null;
            node.right = left;
            tail = flat(left);
            tail.right = right;
        }
        if (right!=null)
            tail = flat(right);
        return tail;
    }
}

// Preorder traversal
// Use a prev pointer to connect
// time: O(n); space: recursive stack
public class Solution {
    TreeNode prev;
    public void flatten(TreeNode root) {
        if (root==null)
            return;
        if (prev!=null)
            prev.right = root;
        prev = root;
        TreeNode left = root.left, right = root.right;
        root.left = null; root.right=null;
        flatten(left);
        flatten(right);
    }
}

// Modified Morris Traversal
// In conenction step, connect prev.right with curr.right instead of curr.
// Besides, we also need to move left child to right in the conenction step
// time: O(n); space: O(1)
public class Solution {
    public void flatten(TreeNode root) {
        if (root==null) return;
        TreeNode curr = root; 
        while (curr!=null){
            if (curr.left==null)
                curr = curr.right;
            else{
                TreeNode prev = curr.left;
                while (prev.right!=null)
                    prev = prev.right;
                if (curr.right!=null)
                    prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
                curr = curr.right;
            }
        }
    }
}
