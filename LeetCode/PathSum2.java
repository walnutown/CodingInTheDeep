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
    ArrayList<ArrayList<Integer>> res;
    ArrayList<Integer> path;
    int depth;
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        res = new ArrayList<ArrayList<Integer>>();
        path = new ArrayList<Integer>();
        depth = 0;
        if (root == null){
            return res;
        }
        
        preorderTraversal(root, sum);
        return res;    
    }
    
    public void preorderTraversal(TreeNode root, int sum){
        depth += root.val;
        path.add(root.val);
        if (depth == sum && root.right == null && root.left == null){
            // the statement is very important here, avoid further change in 'path' influence the 'res'
            ArrayList<Integer> temp = new ArrayList<Integer>(path);
            res.add(temp);
        }  
        
        if (root.left != null){
            preorderTraversal(root.left, sum);
            depth -= root.left.val;
            path.remove(path.size() -1 );
        }
        if (root.right != null){
            preorderTraversal(root.right, sum);
            depth -= root.right.val;
            path.remove(path.size() -1 );
        }
           
    }
}