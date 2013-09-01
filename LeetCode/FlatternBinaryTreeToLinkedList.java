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
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null){
            return;
        }
        if (root.left != null){
            DFS(root.left, root.right);
            root.right = root.left;
        }
        
        
    }
    
    public void DFS(TreeNode root, TreeNode pRight){
        
        if (root.left != null){
            //TreeNode right = root.right;
            //root.right = null;
            DFS(root.left, root.right);
            root.right = root.left;
            
        }
        if (root.right != null){
            DFS(root.right, pRight);
        }
        
        root.right = pRight;
        
    }
}


// Preorder DFS
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
    TreeNode prev;
    
    void dfs(TreeNode root){
        if(root==null) return;
        
        TreeNode left=root.left;
        TreeNode right=root.right;
        
        if(prev!=null)
            prev.right=root;
        
        root.left=null;
        root.right=null;
        prev=root;
        
        dfs(left);
        dfs(right);
    }
    public void flatten(TreeNode root) {
        dfs(root);
    }
}