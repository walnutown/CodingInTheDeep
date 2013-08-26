// TEL in large judge
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
    int maxSum;
    int sum;
    int s;
    int maxS;
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if ( root == null ){
            return 0;
        }
        
        maxSum = Integer.MIN_VALUE;
        sum = 0;
        
        BFS(root);
        
        return maxSum;
        
    }
    
    public void BFS(TreeNode root){
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.add(root);
        while(qu.size()>0){
            TreeNode curr = qu.poll();
            int sum = curr.val;
            int lSum = 0;
            int rSum = 0;
            maxSum = Math.max(sum, maxSum);
            if (curr.left != null){
                lSum = findMaxPath(curr.left); 
                maxSum = Math.max(lSum, maxSum);
                maxSum = Math.max(sum + lSum, maxSum);
                qu.add(curr.left);
            }
            if (curr.right != null){
                rSum = findMaxPath(curr.right);
                maxSum = Math.max(rSum, maxSum);
                maxSum = Math.max(sum + rSum, maxSum);
                qu.add(curr.right); 
            }
            maxSum = Math.max(sum + lSum + rSum, maxSum);
        }
    }
    
    public int findMaxPath(TreeNode root){
        if (root == null){
            return 0;
        }
        s = 0;
        maxS = root.val;
        DFS(root);
        return maxS;
          
    }
    
    public void DFS(TreeNode root){
        if (root == null){
            return;
        }
        
        s += root.val;
        maxS = Math.max(s, maxS);
        DFS(root.left);
        DFS(root.right);
        s -= root.val;
    }
    
    
}

// recursion, pass both
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
    int maxSum;
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if ( root == null ){
            return 0;
        }
        
        maxSum = Integer.MIN_VALUE;
        
        findMax(root);
        
        return maxSum;
        
    }
    
    public int findMax(TreeNode root){
        if (root == null){
            return 0;
        }
        int s = 0;
        int curr = root.val;
        int left = findMax(root.left);
        int right = findMax(root.right);
        s = Math.max(curr, Math.max(curr+ left, curr+ right));
        maxSum = Math.max(maxSum, Math.max(s, curr + left + right));
        
        return s;
    }
    
}