
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


// Submission Result: Wrong Answer

// Input:  {1,#,2}
// Output: [2,2]
// Expected:   [2,1]
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null)   return res;
        Stack<TreeNode> st = new Stack<TreeNode>();
        while (root != null){
            st.push(root);
            root = root.left;
        }
        Stack<Integer> rtree = new Stack<Integer>();
        while (!st.isEmpty()){
            TreeNode curr = st.pop();
            if (curr.right == null){
                while (!rtree.isEmpty())    res.add(rtree.pop());
                res.add(curr.val);
            }else{
                curr = curr.right;
                while (curr != null){
                    st.push(curr);
                    rtree.push(curr.val);
                    curr = curr.left;
                }
            }
        }
        return res;
    }
}

// Accepted, mirrored preorder, use a reverse stack
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
