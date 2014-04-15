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

// Stack Iterative traversal, from Sophie. 2 while loops, logic is easier to understand.
// post-order: left -> right -> curr
// pre-order: curr -> left -> right
// mirror of pre-order: curr -> right -> left. Reverse to get the post-order
// And in this solution, we use Collections.reverse() instead of Stack to get the reversed result
public class Solution{
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Stack<TreeNode> st = new Stack<TreeNode>();
        while (root != null){
            st.push(root);
            res.add(root.val);
            root = root.right;
        }
        while (!st.isEmpty()){
            TreeNode curr = st.pop();
            curr = curr.left;
            while (curr != null){
                st.push(curr);
                res.add(curr.val);
                curr = curr.right;
            }
        }
        Collections.reverse(res);
        return res;
    }
} 

// Morris traversal
// mirror preorder morris traversal and finally reverse the result
public class Solution{
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        TreeNode curr = root;
        while (curr!=null){
            if (curr.right==null){
                res.add(curr.val);
                curr = curr.left;
            }else{
                TreeNode prev = curr.right;
                while (prev.left!=null && prev.left!=curr)
                    prev = prev.left;
                if (prev.left==null){
                    prev.left = curr;
                    res.add(curr.val);
                    curr = curr.right;
                }else{
                    prev.left = null;
                    curr = curr.left;
                }
            }
        }
        Collections.reverse(res);
        return res;
    }
}   

