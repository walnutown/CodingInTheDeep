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
// time: O(n); space: recursive stack
public class Solution {
    public int minDepth(TreeNode root) {
        if (root==null) return 0;
        else if (root.left==null)    return 1 + minDepth(root.right);
        else if (root.right==null)   return 1 + minDepth(root.left);
        else return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}

// BFS, level order traversal, terminate when find one node without children
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)   return 0;
        ArrayList<TreeNode> prev = new ArrayList<TreeNode>();
        prev.add(root);
        int dep = 1;
        while (!prev.isEmpty()){
            ArrayList<TreeNode> curr = new ArrayList<TreeNode>();
            for (TreeNode node:prev){
                if (node.left==null && node.right==null)
                    return dep;
                if (node.left!=null)
                    curr.add(node.left);
                if (node.right!=null)
                    curr.add(node.right);
            }
            prev = curr;
            dep++;
        }
        return dep;
    }
}