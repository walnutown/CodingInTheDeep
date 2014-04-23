/*
    Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

    For example:
    Given the below binary tree and sum = 22,
                  5
                 / \
                4   8
               /   / \
              11  13  4
             /  \    / \
            7    2  5   1
    return
    [
       [5,4,11,2],
       [5,8,4,5]
    ]
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


// Backtracking
// The core algorithm of this question is easy, the difficulty lies in the termination condition of dfs
// Note that it should be a root ot leaf path with the given sum (sum may be negative)
// time: O(n); sapce: recursive stack
public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root==null)   return res;
        dfs(root, res, new ArrayList<Integer>(), sum);
        return res;
    }
    
    private void dfs(TreeNode node, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> r, int sum){
        if (node==null)   return;
        sum -= node.val;
        r.add(node.val);
        if (node.left==null && node.right==null){
            if (sum==0)   res.add(new ArrayList<Integer>(r));
            r.remove(r.size()-1);   // Remember to remove last node from the path before return
            return;
        }
        dfs(node.left, res, r, sum);
        dfs(node.right, res, r, sum);
        r.remove(r.size()-1);
    }
   
}