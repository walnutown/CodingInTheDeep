/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
   
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null){
            return true;
        }
        
        return getHeight(root) >= 0;   
          
    }
    
    public int getHeight(TreeNode root){
        if (root == null){
            return 0;
        }
        int lHeight = getHeight(root.left);
        int rHeight = getHeight(root.right);
        if (lHeight < 0 || rHeight < 0 || Math.abs(lHeight - rHeight) > 1){
            return -1;
        }
        return Math.max(rHeight, lHeight) + 1;
    }
}



// At the first glance, it's easy to have the idea of recursively checking the left sub-tree and right sub-tree, plus the
// requirements that the diff between the height of left and right sub-tree is no more than one.
// that's:
//       isBalanced(root.left) && isBalanced(root.right) && lHeight- rHeight <= 1
// in this case, we have to do a DFS on the subtree to get the height of the subtree, the total time complexity is O(n^2)
// Yet, actually, we can check whether the subtree is balanced when we recurse through the subtree. Then, we ca nreduce the
// big O to O(n), and the space complexity is O(H), where H is the height of the tree.

// Accepted, Jan 1
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;
        return getHeight(root) > -1;
    }
    public int getHeight(TreeNode node){
        if (node==null)  return 0;
        int l = getHeight(node.left), r = getHeight(node.right);
        return Math.abs(l-r)>1 || l<0 || r<0 ? -1 : Math.max(l, r) + 1 ;
    }
}
