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
    
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        if (root == null){
            return res;
        }
        
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        TreeNode curr = root.left;
        // curr != null is used when the root is popped, at that thime, st.empty == true
        while (!st.empty() || curr != null){
            if (curr != null){
                st.push(curr);
                curr = curr.left;
            }
            else{
                curr = st.pop();
                res.add(curr.val);
                curr = curr.right;
            }
        }
        
        return res;
    }
}