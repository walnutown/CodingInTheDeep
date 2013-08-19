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
    int sumVal;
    boolean exist;
    
    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if (root == null){
            return false;
        }
        
        sumVal = 0;
        exist = false;
        
        preorderTraversal(root, sum);
        
        return exist;
    }
    
    public void preorderTraversal(TreeNode root, int sum){
        sumVal += root.val;
        if (root.left != null){
            preorderTraversal(root.left, sum);
            sumVal -= root.left.val;
        }
           
        if (root.right != null){
            preorderTraversal(root.right, sum);
            sumVal -= root.right.val;
        }
        if (root.right == null && root.left == null){
            if (sumVal == sum){
                exist = true;
            }
        }
    }
}