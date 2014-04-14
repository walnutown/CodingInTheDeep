/*
  Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
// binary search the array to build tree
// time: O(n); sapce: recursive stack
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) return null;
        return builder(num, 0, num.length-1);
    }
    
    public TreeNode builder(int[] num, int start, int end){
        if (start > end)    return null;
        int mid = (start + end) >> 1;
        TreeNode root = new TreeNode(num[mid]);
        root.left = builder(num, start, mid-1);
        root.right = builder(num, mid+1, end);
        return root;
    }
}