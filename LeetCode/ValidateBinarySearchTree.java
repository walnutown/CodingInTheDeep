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
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        // inorder DFS to an array, check whether the array is ascending
        if (root == null || root.left == null && root.right == null){
            return true;
        }
        
        ArrayList<Integer> treeArr = new ArrayList<Integer>();
        inorderTraversal(root, treeArr);
        
        for (int i =1; i < treeArr.size(); i++){
            if (treeArr.get(i-1) >= treeArr.get(i)){
                return false;
            }
        }
        
        return true;
    }
    
    public void inorderTraversal(TreeNode node, ArrayList<Integer> treeArr){
        if (node == null){
            return;
        }
        // need to check if node.left is null here? leetcode assumes that it has been initialized here
        inorderTraversal(node.left, treeArr);
        treeArr.add(node.val);
        inorderTraversal(node.right, treeArr);
    }
}


// min-max, Accepted, Dec 24
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return checker(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean checker(TreeNode root, int min, int max){
        if (root == null)
            return true;
        if (root.val <= min || root.val >= max)
            return false;
        return checker(root.left, min, root.val) && checker(root.right, root.val, max);
    }
}