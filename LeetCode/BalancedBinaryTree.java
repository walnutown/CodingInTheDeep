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
   
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null){
            return true;
        }
        
        return getHeight(root) >= 0;   
          
    }
    
    public int getHeight(TreeNode root){
        if (root == null){
            return 0;
        }
        int lHeight = getHeight(root.left);
        int rHeight = getHeight(root.right);
        if (lHeight < 0 || rHeight < 0 || Math.abs(lHeight - rHeight) > 1){
            return -1;
        }
        return Math.max(rHeight, lHeight) + 1;
    }
    
    
}