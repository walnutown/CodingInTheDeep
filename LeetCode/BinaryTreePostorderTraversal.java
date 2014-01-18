/*
    Given a binary tree, return the postorder traversal of its nodes' values.

    For example:
    Given binary tree {1,#,2,3},
       1
        \
         2
        /
       3
    return [3,2,1].
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


// Stack Iterative traversal. From Sophie, 2 while loops, logic is easier to understand.
// post-order: left -> right -> curr
// pre-order: curr -> left -> right
// mirror of pre-order: curr -> right -> left. Reverse to get the post-order
public class Solution{
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Stack<TreeNode> st = new Stack<TreeNode>();
        Stack<Integer> reverse = new Stack<Integer>();
        while (root != null){
            st.push(root);
            reverse.push(root.val);
            root = root.right;
        }
        while (!st.isEmpty()){
            TreeNode curr = st.pop();
            curr = curr.left;
            while (curr != null){
                st.push(curr);
                reverse.push(curr.val);
                curr = curr.right;
            }
        }
        while (reverse.size() > 0)  res.add(reverse.pop());
        return res;
    }
}   

// Stack Iterative traversal.
// time: O(n); space: O(h), h is the maximum height of the tree
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null)   return res;
        Stack<TreeNode> st = new Stack<TreeNode>();
        Stack<Integer> reverse = new Stack<Integer>();
        while (root != null || !st.isEmpty()){
            if (root == null)   root = st.pop();
            reverse.push(root.val);
            if (root.left != null) st.push(root.left);
            root = root.right;
        }
        while (!reverse.isEmpty())  res.add(reverse.pop());
        return res;
    }
}
