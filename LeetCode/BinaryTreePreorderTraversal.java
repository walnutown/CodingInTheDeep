// Wrong Answer
// [1, #, 2]
// [1]
// [1,2]
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return res;
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        while (!st.isEmpty()){
            TreeNode curr = st.pop();
            res.add(curr.val);
            while (curr.left != null){
                res.add(curr.left.val);
                if (curr.right != null){
                    st.push(curr.right);
                }
                curr = curr.left;
            }
            // easy to forget the following statements
            if (curr.right != null){
                st.push(curr.right);
            }
        }
        return res;
    }
}