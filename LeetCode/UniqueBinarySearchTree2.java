/*
    Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

    For example,
    Given n = 3, your program should return all 5 unique BST's shown below.

       1         3     3      2      1
        \       /     /      / \      \
         3     2     1      1   3      2
        /     /       \                 \
       2     1         2                 3
    confused what "{1,#,2,3}" means?
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */

// DP, memoization
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
    // generate nodes using DFS
    public TreeNode genNode(TreeNode n, int inc){
        if (n==null)    return null;
        TreeNode res = new TreeNode(n.val+inc);
        res.left = genNode(n.left, inc);
        res.right = genNode(n.right, inc);
        return res;
    }
    
}