/*
    Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

    For example:
    Given binary tree {3,9,20,#,#,15,7},
        3
       / \
      9  20
        /  \
       15   7
    return its zigzag level order traversal as:
    [
      [3],
      [20,9],
      [15,7]
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

// Basically BFS.
// Maintain level counter to check whether we need to reverse the elements in the level
// time: O(n); space: O(n)
public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root==null)     return res;
        ArrayList<TreeNode> prev = new ArrayList<TreeNode>();
        prev.add(root);
        int lineNum = 1;
        while (prev.size()>0){
            ArrayList<TreeNode> curr = new ArrayList<TreeNode>();
            ArrayList<Integer> nums = new ArrayList<Integer>();
            for (TreeNode node:prev){
                nums.add(node.val);
                if (node.left!=null)    curr.add(node.left);
                if (node.right!=null)   curr.add(node.right);
            }
            if (lineNum%2==0)
                Collections.reverse(nums);
            res.add(nums);
            lineNum++;
            prev = curr;
        }
        return res;
    }
}