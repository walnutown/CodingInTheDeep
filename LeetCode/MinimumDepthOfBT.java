// use arraylist to store paths
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
    ArrayList<Integer> pathLen;
    int count;
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        
        pathLen = new ArrayList<Integer>();
        count = 0;
        preorderTraversal(root);
        Collections.sort(pathLen);
        return pathLen.get(0);
        
    }
    
    public void preorderTraversal(TreeNode root){
        count++;
        if (root.left == null && root.right == null){
            pathLen.add(count);
        }
        if (root.left != null){
            preorderTraversal(root.left);
            count--;
        }
        if (root.right != null){
            preorderTraversal(root.right);
            count--;
        }
    }
    
}

// use one val to store the min value of path length
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
    int min;
    int count;
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        
        min = -1;
        count = 0;
        preorderTraversal(root);
        return min;
        
    }
    
    public void preorderTraversal(TreeNode root){
        if (root == null){
            return;
        }
        count++;
        if (root.left == null && root.right == null){
            if (min == -1){
                min = count;
            }
            else{
                min = Math.min(min, count);
            }
        }
        
            preorderTraversal(root.left);
            preorderTraversal(root.right);
            count--;
    }
    
}



// #2 Trial, 
// Submission Result: Wrong Answer
// Input:  {1,2}
// Output: 1
// Expected:   2

public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null)
            return 1;
        int[] a = new int[2];
        a[0] = Integer.MAX_VALUE;
        getDepth(root, a);
        return a[0];
    }
    
    public void getDepth(TreeNode root, int[] a){
        if (root == null){
            a[0] = Math.min(a[0], a[1]);
            return;
        }
        a[1]++;
        getDepth(root.left, a);
        getDepth(root.right, a);
        a[1]--;
    }
}
// Accepted
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null)
            return 1;
        int[] a = new int[2];
        a[0] = Integer.MAX_VALUE;
        getDepth(root, a);
        return a[0];
    }
    
    public void getDepth(TreeNode root, int[] a){
        if (root == null){
            return;
        }
        a[1]++;
        // just need to move the check here
        if (root.left == null && root.right == null)
            a[0] = Math.min(a[0], a[1]);
        getDepth(root.left, a);
        getDepth(root.right, a);
        a[1]--;
    }
}
