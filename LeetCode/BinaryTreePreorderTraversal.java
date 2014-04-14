/*
    Given a binary tree, return the preorder traversal of its nodes' values.

    For example:
    Given binary tree {1,#,2,3},
       1
        \
         2
        /
       3
    return [1,2,3].

    Note: Recursive solution is trivial, could you do it iteratively?
*/

// Stack Iterative traversal, 
// time: O(n); space: O(h), 
// Refer to BinaryTreeInorderTraversal, only position of 'res.add()'' changes
public class Solution{
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        while (root != null){
            st.push(root);
            res.add(root.val);
            root = root.left;
        }
        while (!st.isEmpty()){
            TreeNode curr = st.pop();
            curr = curr.right;
            while (curr != null){
                st.push(curr);
                res.add(curr.val);
                curr = curr.left;
            } 
        }
        return res;
    }
}

// Morris threaded tree pre-order traversal
// Great post from AnnieKim. http://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html
// time: O(n); space: O(1)
// Refer to BinaryTreeInorderTraversal, only position of 'res.add()'' changes
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null)   return res;
        TreeNode curr =root;
        while (curr != null){
            if (curr.left==null){
                res.add(curr.val);
                curr = curr.right;
            }
            else{
                // find predecessor 
                TreeNode prev = curr.left;
                while (prev.right!=null && prev.right!=curr)    prev = prev.right;
                if (prev.right ==null ){  // conenct the predecessor
                    res.add(curr.val);
                    prev.right = curr;
                    curr = curr.left;
                }else {    
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return res;
    }
}