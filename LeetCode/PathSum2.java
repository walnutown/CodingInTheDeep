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

// DFS, time: O(n)
public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
        if (root==null) return paths;
        finder(root, sum, paths, new ArrayList<Integer>());
        return paths;
    }
    public void finder(TreeNode root, int sum, ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> path){
        if (root==null)    return;
        path.add(root.val);
        if (root.left==null && root.right==null){                   // notice the logics here, easy to make mistake
            if (sum == root.val)   paths.add(new ArrayList<Integer>(path));
        }else{
            finder(root.left, sum-root.val, paths, path);
            finder(root.right, sum-root.val, paths, path);
        }
        path.remove(path.size()-1);
    }
}