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

// Same to Leetcode/ConstructBinaryTreeFromPostOrderAndInorderTraversal
// time: O(n^2); space: O(1)
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length==0 || postorder.length==0)
            return null;
        return builder(inorder, 0, inorder.length-1, postorder, postorder.length-1);
    }
    private TreeNode builder(int[] inorder, int l, int r, int[] postorder, int p){
        if (l>r || p<0)
            return null;
        int value = postorder[p];
        int mid = getIndexOfValue(inorder, value, l, r);
        TreeNode node = new TreeNode(value);
        node.left = builder(inorder, l, mid-1, postorder, p-1-(r-mid));
        node.right = builder(inorder, mid+1, r, postorder, p-1);
        return node;
    }
    
    private int getIndexOfValue(int[] A, int target, int start, int end){
        for (int i=start; i<=end; i++){
            if (A[i]==target)
                return i;
        }
        return -1;
    }  
}

// Recursion, space optimized version
// time: O(n); space: O(n) -- HashMap to store index
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