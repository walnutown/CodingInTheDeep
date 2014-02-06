/*
    Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

    For example:
    Given binary tree {3,9,20,#,#,15,7},
        3
       / \
      9  20
        /  \
       15   7
    return its level order traversal as:
    [
      [3],
      [9,20],
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

// same as CTCI ch4_4
// count the number of nodes in a level, time: O(n); space: O(b^d)
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return res;
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.add(root);
        int curr_num = 1, next_num = 0;
        ArrayList<Integer> r = new ArrayList<Integer>();
        while (!qu.isEmpty()){
            TreeNode curr = qu.poll();
            r.add(curr.val);
            if (curr.left != null){
                qu.add(curr.left);
                next_num++;
            }
            if (curr.right != null){
                qu.add(curr.right);
                next_num++;
            }
            if (--curr_num == 0){    
                curr_num = next_num;
                next_num = 0;
                res.add(new ArrayList<Integer>(r));
                r.clear();
            }
        }
        return res;
    }
}