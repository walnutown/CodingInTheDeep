/*
    Given preorder and inorder traversal of a tree, construct the binary tree.

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0)   return null;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<inorder.length; i++)
            map.put(inorder[i], i);
        return builder(preorder, 0, 0, inorder.length-1, map);
    }
    
    public TreeNode builder(int[] preorder, int curr, int start, int end, Map<Integer, Integer> map){
        if (start > end)    return null;
        TreeNode root = new TreeNode(preorder[curr]);
        int mid = map.get(preorder[curr]);
        root.left = builder(preorder, curr+1, start, mid-1, map);
        root.right = builder(preorder, curr+(mid-start+1), mid+1, end, map);
        return root;
    }
}