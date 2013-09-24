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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Start typing your Java solution below
        // DO NOT write main() function

        // we can use one simple statement here
        //if (p == null || q == null){
        //    return p == null && q == null;
        //}

        if (p == null && q == null){
            return true;
        }
        else if (p == null && q != null){
            return false;
        }
        else if (p != null && q == null){
            return false;
        }
        else{
            if (p.val == q.val){
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
            else{
                return false;
            }
        }
        
    }
}