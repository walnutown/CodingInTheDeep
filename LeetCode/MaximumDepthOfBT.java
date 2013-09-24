/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int maxDepth;
    int depth;
    
    public int maxDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null){
            return 0;
        }
        
        maxDepth = 0;
        depth = 0;
        inorderTraversal(root);
        
        return maxDepth;
        
    }
    
    public void inorderTraversal(TreeNode root){
        depth++;
        if (depth > maxDepth){
            maxDepth = depth;
        }
        if (root.left != null){
            inorderTraversal(root.left);
            depth--;
        }
        
        
        
        if (root.right != null){
            inorderTraversal(root.right);
            depth--;
        }
        
    }
}


// recursive
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null){
            return 0;
        }
        
        return 1+ Math.max(maxDepth(root.left), maxDepth(root.right));
        
    }
}

// BFS, we can use a var to mark the number of next layer.


