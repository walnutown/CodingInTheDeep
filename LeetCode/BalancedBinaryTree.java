/*
    Given a binary tree, determine if it is height-balanced.

    For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
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

// At the first glance, it's easy to have the idea of recursively checking the left sub-tree and right sub-tree, plus the
// requirements that the diff between the height of left and right sub-tree is no more than one.
// that's:
//       isBalanced(root.left) && isBalanced(root.right) && lHeight- rHeight <= 1
// in this case, we have to do a DFS on the subtree to get the height of the subtree, the total time complexity is O(n^2)
// Yet, actually, we can check whether the subtree is balanced when we recurse through the subtree. Then, we can reduce the
// big O to O(n), and the space complexity is O(H), where H is the height of the tree.

// Recursion
// time: O(n); space: O(h), h is the largest height of the tree
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;
        return getHeight(root) > -1;
    }
    public int getHeight(TreeNode node){
        if (node==null)  return 0;
        int l = getHeight(node.left), r = getHeight(node.right);
        return Math.abs(l-r)>1 || l<0 || r<0 ? -1 : Math.max(l, r) + 1 ;
    }
}

// time optimize the above solution
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;
        return getHeight(root) > -1;
    }
    public int getHeight(TreeNode node){
        if (node==null)  return 0;
        int l = getHeight(node.left);
        if (l<0)  return -1;            // can skip checking of right child here
        int r = getHeight(node.right);
        return Math.abs(l-r)>1 || r<0 ? -1 : Math.max(l, r) + 1 ;
    }
}

