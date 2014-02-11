/*
    Given a binary tree, find its maximum depth.

    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*/

// recursive
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)   return 0;
        return 1+ Math.max(maxDepth(root.left), maxDepth(root.right));   
    }
}

// DFS
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        int[] max = new int[1];
        finder(root, 1, max);       // notice the initial len is 1
        return max[0];
    }
    public void finder(TreeNode root, int len, int[] max){
        if (root.left==null && root.right==null){
            max[0] = Math.max(len, max[0]);
            return;
        }
        if (root.left != null)  finder(root.left, len+1, max);
        if (root.right != null) finder(root.right, len+1, max);
    }
}


