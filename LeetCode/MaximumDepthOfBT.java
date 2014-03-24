/*
    Given a binary tree, find its maximum depth.

    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*/

// recursive
// time: O(n)
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)   return 0;
        return 1+ Math.max(maxDepth(root.left), maxDepth(root.right));   
    }
}

// DFS, traverse all the leaf nodes and find the max
// time: O(n)
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

// BFS, level order traversal
// time: O(n)
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)   return 0;
        ArrayList<TreeNode> prev = new ArrayList<TreeNode>();
        prev.add(root);
        int dep = 1;
        while (!prev.isEmpty()){
            ArrayList<TreeNode> curr = new ArrayList<TreeNode>();
            for (TreeNode node:prev){
                if (node.left!=null)
                    curr.add(node.left);
                if (node.right!=null)
                    curr.add(node.right);
            }
            if (curr.isEmpty())
                break;
            prev = curr;
            dep++;
        }
        return dep;
    }
}


