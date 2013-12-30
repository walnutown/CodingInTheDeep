// Accepted, Dec 29
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null)   return res;
        Stack<TreeNode> st = new Stack<TreeNode>();
        while (root != null || !st.isEmpty()){
            if (root == null)   root = st.pop();
            res.add(root.val);
            if (root.right != null) st.push(root.right);
            root = root.left;
        }
        return res;
    }
}


//http://n00tc0d3r.blogspot.com/2013/01/binary-tree-traversals-i.html
// logic is more clear than wiki

// Binary tree preorder traversal
public class Solution{
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        while (root != null){
            st.push(root);
            res.add(root.val);
            root = root.left;
        }
        while (st.size() > 0){
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