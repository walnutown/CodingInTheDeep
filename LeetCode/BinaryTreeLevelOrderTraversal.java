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

// use a tmp arraylist, don't have to count number of nodes in a level
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root ==null)
            return res;
        ArrayList<TreeNode> r = new ArrayList<TreeNode>();
        r.add(root);
        while (!r.isEmpty()){
            ArrayList<TreeNode> tmp = new ArrayList<TreeNode>();
            ArrayList<Integer> nums = new ArrayList<Integer>(); 
            for (TreeNode curr:r){
                nums.add(curr.val);
                if (curr.left!=null)
                    tmp.add(curr.left);
                if (curr.right!=null)
                    tmp.add(curr.right);
            }
            res.add(nums);
            r = tmp;
        }
        return res;
    }
}

// DFS, when traverse the tree, put node into corresponding level's arraylist
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        traversal(root, 0, res);
        return res;
    }
    
    public void traversal(TreeNode root, int level, ArrayList<ArrayList<Integer>> res){
        if (root==null)
            return;
        if (level >= res.size()){
            ArrayList<Integer> r = new ArrayList<Integer>();
            r.add(root.val);
            res.add(r);
        }else
            res.get(level).add(root.val);
        traversal(root.left, level+1, res);
        traversal(root.right, level+1, res);
    }
}