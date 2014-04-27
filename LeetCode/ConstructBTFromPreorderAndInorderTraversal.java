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

// Recursion
// Each time, cut the inorder array into 3 parts, left, root, right
// root is of the value of first element in preorder array
// time: O(n^2); space: O(1)
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==0 || inorder.length==0)
            return null;
       return builder(preorder, 0, inorder, 0, inorder.length-1); 
    }
    
    private TreeNode builder(int[] preorder, int p, int[] inorder, int l, int r){
        if (p>=preorder.length || l>r)
            return null;
        int value = preorder[p];
        int mid = getIndexOfValue(inorder, value, l, r);
        TreeNode node = new TreeNode(value);
        node.left = builder(preorder, p+1, inorder, l, mid-1);
        node.right = builder(preorder, p+(mid-l)+1, inorder, mid+1, r);
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

// Recursion, time optimized version
// use a map to facilitate quick index lookup (This works becuase there're no duplicates in the tree)
// time: O(n); space: O(n) -- HashMap to store index
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==0 || inorder.length==0)
            return null;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<inorder.length; i++)
            map.put(inorder[i], i);
        return builder(preorder, 0, map, 0, inorder.length-1); 
    }
    
    private TreeNode builder(int[] preorder, int p, Map<Integer, Integer> map, int l, int r){
        if (p>=preorder.length || l>r)
            return null;
        int value = preorder[p];
        int mid = map.get(value);
        TreeNode node = new TreeNode(value);
        node.left = builder(preorder, p+1, map, l, mid-1);
        node.right = builder(preorder, p+(mid-l)+1, map, mid+1, r);
        return node;
    }
}