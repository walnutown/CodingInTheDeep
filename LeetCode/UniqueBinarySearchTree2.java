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
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        res.add(null);
        if (n == 0){
            return new ArrayList<TreeNode>(res);
        }
        res.clear();
        res.add(new TreeNode(1));
        if (n == 1){
            return res;
        }
        return helper(1, n);
    }
    
    public ArrayList<TreeNode> helper(int start, int end){
        ArrayList<TreeNode> sub = new ArrayList<TreeNode>();
        if (start > end){
            sub.add(null);
            return sub;
        }
        
        for (int i = start; i<= end; i++){
            ArrayList<TreeNode> right = helper(i+1, end);
            ArrayList<TreeNode> left = helper(start, i-1);
            for(int k = 0; k < right.size(); k++){
                for(int j = 0; j < left.size(); j++){
                    TreeNode curr = new TreeNode(i);
                    TreeNode l = left.get(j);
                    TreeNode r = right.get(k);
                    curr.left = l;
                    curr.right = r;
                    sub.add(curr);
                }
            }
            
        }
        return sub;
    }
}