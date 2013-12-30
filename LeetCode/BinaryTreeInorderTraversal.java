
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




// Submission Result: Time Limit Exceeded

// Last executed input:    {1,2}
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null)   return res;
        Stack<TreeNode> st = new Stack<TreeNode>();
        while (root != null){
            if (root.left != null){             // will go in loop here, need to mark whether a node has been visited
                st.push(root);
                root = root.left;
            }else{
                res.add(root.val);
                if (root.right != null) root = root.right;
                else    root = st.isEmpty() ? null : st.pop();
            }
        }
        return res;
    }
}
// Accepted, modified from Sophie
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null)   return res;
        Stack<TreeNode> st = new Stack<TreeNode>();
        while (root != null){
            st.push(root);
            root = root.left;
        }
        while (!st.isEmpty()){
            TreeNode curr = st.pop();
            res.add(curr.val);
            curr = curr.right;
            while (curr!=null){
                st.push(curr);
                curr = curr.left;
            }
        }
        return res;
    }
}