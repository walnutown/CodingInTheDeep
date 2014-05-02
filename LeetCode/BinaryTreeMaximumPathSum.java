/*
    Given a binary tree, find the maximum path sum.

    The path may start and end at any node in the tree.

    For example:
    Given the below binary tree,

           1
          / \
         2   3

    Return 6.
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
// Maintain a global variable to track the max path sum during recursion
// The return value of getMax() is the max sum of path coantaining root node
// time: O(n); space: recursive stack
public class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root ==null)    return 0;
        getMax(root);
        return max;
    }
    
    public int getMax(TreeNode root){           
        if (root == null)   return 0;     
        int lmax = getMax(root.left);
        int rmax = getMax(root.right);
        int mmax = Math.max(Math.max(lmax+root.val, rmax+root.val), root.val);
        max = Math.max(Math.max(mmax, lmax+rmax+root.val), max);
        return mmax;
    }
}