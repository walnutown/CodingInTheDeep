/*
    Given a binary tree, find its minimum depth.

    The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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

// recursion, notice the diff between maxDep and minDep
public class Solution {
    public int minDepth(TreeNode root) {
        if (root==null) return 0;
        else if (root.left==null)    return 1 + minDepth(root.right);
        else if (root.right==null)   return 1 + minDepth(root.left);
        else return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}