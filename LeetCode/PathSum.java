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
    int sumVal;
    boolean exist;
    
    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if (root == null){
            return false;
        }
        
        sumVal = 0;
        exist = false;
        
        preorderTraversal(root, sum);
        
        return exist;
    }
    
    public void preorderTraversal(TreeNode root, int sum){
        sumVal += root.val;
        if (root.left != null){
            preorderTraversal(root.left, sum);
            sumVal -= root.left.val;
        }
           
        if (root.right != null){
            preorderTraversal(root.right, sum);
            sumVal -= root.right.val;
        }
        if (root.right == null && root.left == null){
            if (sumVal == sum){
                exist = true;
            }
        }
    }
}


// Submission Result: Wrong Answer

// Input:  {1}, 1
// Output: false
// Expected:   true
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null || sum < 0)   return false;    // sum<0 fails here, root.val can be positive or negative
        if (sum == 0)   return true;
        if (hasPathSum(root.left, sum-root.val))    return true;
        if (hasPathSum(root.right, sum-root.val))   return true;
        return false;
    }
}


// Accepted
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)   return false;
        return finder(root, sum);
    }
    
    public boolean finder(TreeNode root, int sum){
        sum -= root.val;
        if (root.left == null && root.right==null){
            if (sum==0) return true;
            else return false;
        }
        boolean hasSum = false;
        if (root.left != null) hasSum = hasSum || finder(root.left, sum);
        if (root.right != null) hasSum = hasSum || finder(root.right, sum);
        return hasSum;
    }
}
// Refactor, Accepted
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)   return false;
        if (root.left==null && root.right==null)    return sum == root.val;
        return hasPathSum(root.left, sum- root.val) || hasPathSum(root.right, sum-root.val);
    }
}