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
    ArrayList<String> nodeArr;
    
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null){
            return true;
        }
        nodeArr = new ArrayList<String>();
        inorderTraversal(root);   
        
        int i = 0;
        int j = nodeArr.size() -1;
        while (i < j){
            if (!nodeArr.get(i).equals(nodeArr.get(j))){
                return false;
            }
            i++;
            j--;
        }
        
        return true;
               
    }
    
    public void inorderTraversal(TreeNode n){
        if (n == null){
            nodeArr.add("#");
            return;
        }
      
        inorderTraversal(n.left);
        nodeArr.add(""+n.val);
        inorderTraversal(n.right);     
    }
}