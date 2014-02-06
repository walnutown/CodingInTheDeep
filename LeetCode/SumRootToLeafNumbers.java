/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
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
    public int sumNumbers(TreeNode root) {
        if (root == null)   return 0;
        // mem[0] -> sum
        int[] mem = new int[1];
        findPath(root, mem, 0);
        return mem[0];
    }
    
    public void findPath(TreeNode root, int[] mem, int value){
        value = 10 * value + root.val;
        if (root.left == null && root.right == null){
            mem[0] += value;
            return;
        }
        if (root.left != null)  findPath(root.left, mem, value);
        if (root.right != null) findPath(root.right, mem, value);
    }
}

// iterative version, need additional space to store the sum vlaue at each node