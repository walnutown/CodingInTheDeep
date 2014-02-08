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
public class Solution {
    public TreeNode flatten(TreeNode root) {  
        if (root == null) return root;  
        TreeNode r = root.right;  
        if (root.left != null) {  
            root.right = root.left;  
            root.left = null;  
            root = flatten(root.right);  
        }  
        if (r != null) {  
            root.right = r;  
            root = flatten(root.right);  
        }  
        return root;  
    }        
}
// Preorder traversal
public class Solution {
    TreeNode prev;
    public TreeNode flatten(TreeNode root) {  
        flat(root);
        return root;
    }
    public void flat(TreeNode root){
        if (root == null)   return;
        TreeNode l = root.left, r = root.right;
        if (prev != null)   prev.right = root;
        root.left = null;
        root.right = null;
        prev = root;
        flat(l);
        flat(r);
    }
}
