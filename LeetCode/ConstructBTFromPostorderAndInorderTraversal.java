/*
    Given inorder and postorder traversal of a tree, construct the binary tree.

    Note:
    You may assume that duplicates do not exist in the tree.
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

// Recursion, time: O(n); space: O(n) -- HashMap to store index
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i =0; i<inorder.length; i++)
            map.put(inorder[i], i);
        return builder(postorder, postorder.length-1, 0, inorder.length-1, map);
    }
    public TreeNode builder(int[] postorder, int curr, int start, int end, Map<Integer, Integer> map){
        if (start > end)    return null;
        TreeNode root = new TreeNode(postorder[curr]);
        int mid = map.get(postorder[curr]);
        root.right = builder(postorder, curr-1, mid+1, end, map);
        root.left = builder(postorder, curr-(end-mid+1), start, mid-1, map);
        return root;
    }
}