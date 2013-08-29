/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    ArrayList<TreeNode> res;
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        res = new ArrayList<TreeNode>();
        res.add(null);
        if (n == 0){
            return new ArrayList<TreeNode>(res);
        }
        res.clear();
        res.add(new TreeNode(1));
        if (n == 1){
            return res;
        }
        res.clear();
        helper(1, n, 1);
        
        return res;
    }
    
    public TreeNode helper(int start, int end, int level){
        if (start > end){
            return null;
        }
        for (int i = start; i<= end; i++){
            TreeNode curr = new TreeNode(i);
            TreeNode right = helper(i+1, end, level+1);
            TreeNode left = helper(start, i-1, level+1);
            curr.left = left;
            curr.right = right;
            if (level ==1){
                res.add(curr);
            }
            
            return curr;
        }
        return null;
    }
}