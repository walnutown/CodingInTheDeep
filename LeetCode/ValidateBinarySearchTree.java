/*
    Given a binary tree, determine if it is a valid binary search tree (BST).

    Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
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

// http://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
// Note:
// left < curr < right

// inorder traversal with prev value, always meet the prereq: curr > prev
// time: O(n); space: recursion stack
public class Solution {
    int prev = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null)   return true;
        if (!isValidBST(root.left)) return false;
        if (root.val <= prev)    return false;
        prev = root.val;
        return isValidBST(root.right);
    }
}

// record the upper and lower bound
// time: O(n); space: recursion stack
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return checker(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean checker(TreeNode root, int min, int max){
        if (root == null)
            return true;
        if (root.val <= min || root.val >= max)
            return false;
        return checker(root.left, min, root.val) && checker(root.right, root.val, max);
    }
}

// The following code is less efficient than the above, understand why
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return checker(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean checker(TreeNode root, int min, int max){
        if (root.val <= min || root.val >= max)
            return false;
        boolean isValid = true;
        if (root.left!=null)
            isValid = isValid && checker(root.left, min, root.val); // this can be optimized
        if (root.right!=null)
            isValid = isValid && checker(root.right, root.val, max);
        return  isValid; 
    }
}
