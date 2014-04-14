/*
    Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

    For example:
    Given binary tree {3,9,20,#,#,15,7},
        3
       / \
      9  20
        /  \
       15   7
    return its bottom-up level order traversal as:
    [
      [15,7]
      [9,20],
      [3],
    ]

*/

// same as binaryTreeLevelOrderTraversal, plus reverse step
// time: O(n); space: O(b^d)
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root==null)
            return res;
        ArrayList<TreeNode> prev = new ArrayList<TreeNode>();
        prev.add(root);
        while (!prev.isEmpty()){
            ArrayList<TreeNode> curr = new ArrayList<TreeNode>();
            ArrayList<Integer> nums = new ArrayList<Integer>();
            for (TreeNode node : prev){
                nums.add(node.val);
                if (node.left!=null)
                    curr.add(node.left);
                if (node.right!=null)
                    curr.add(node.right);
            }
            res.add(nums);
            prev = curr;
        }
        Collections.reverse(res);
        return res;
    }
}