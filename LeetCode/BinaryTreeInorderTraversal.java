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


// Binary tree postorder traversal
public class Solution{
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        Stack<Integer> reverse = new Stack<Integer>();
        while (root != null){
            st.push(root);
            reverse.push(root.val);
            root = root.right;
        }

        while (st.size() > 0){
            TreeNode curr = st.pop();
            curr = curr.left();
            while (curr != null){
                st.push(curr);
                reverse.push(curr.val);
                curr = curr.left;
            }
        }

        while (reverse.size() > 0){
            res.add(reverse.pop());
        }



    }
}   