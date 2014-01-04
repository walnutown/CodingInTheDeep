// Accepted
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null || q==null) return p==null && q==null;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}