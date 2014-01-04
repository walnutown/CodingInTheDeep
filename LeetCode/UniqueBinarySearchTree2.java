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


// Accepted, DP
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        Map<Integer, ArrayList<TreeNode>> dp = new HashMap<Integer, ArrayList<TreeNode>>();
        dp.put(0, new ArrayList<TreeNode>()); dp.get(0).add(null);
        if (n<=0)   return dp.get(0);
        dp.put(1, new ArrayList<TreeNode>()); dp.get(1).add(new TreeNode(1));
        for (int i=2; i<=n; i++){
            dp.put(i, new ArrayList<TreeNode>());
            for (int j=1; j<=i; j++){
                for (TreeNode left : dp.get(j-1)){
                    for (TreeNode right : dp.get(i-j)){
                        TreeNode root = new TreeNode(j);
                        root.left = genNode(left, 0);
                        root.right = genNode(right, j);     // if right subtree, need to add increment to ndoe val
                        dp.get(i).add(root);
                    }
                }
            }
        }
        return dp.get(n);
    }
    public TreeNode genNode(TreeNode n, int inc){
        if (n==null)    return null;
        TreeNode res = new TreeNode(n.val+inc);
        res.left = genNode(n.left, inc);
        res.right = genNode(n.right, inc);
        return res;
    }
    
}