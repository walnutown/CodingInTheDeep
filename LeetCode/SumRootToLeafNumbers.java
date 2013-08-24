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
    int sum;
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null){
            return 0;
        }
        
        if (root.left == null && root.right == null){
            return root.val;
        }
        
        sum = 0;
        
        DFS(root, 0);
        return sum;
        
        
    }
    
    public void DFS(TreeNode root, int num){
        if (root == null){
            return;
        }
        num = num* 10 + root.val;
        if (root.left == null && root.right == null){
            sum+= num;
        }
       
        DFS(root.left, num);
        DFS(root.right, num);
        
        num = (num - root.val)/10;
        
    }
    
}