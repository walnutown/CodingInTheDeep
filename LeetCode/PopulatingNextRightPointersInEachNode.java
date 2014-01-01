// Recursion, Accepted
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null || root.left==null && root.right==null)   return;
        root.left.next = root.right;
        if (root.next != null)  root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
    }
}

// While loop, const extra sapce, Accepted
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode first = root;
        while (first != null && first.left != null){
            TreeLinkNode p = first;
            while (p != null){
                p.left.next = p.right;
                if (p.next != null) p.right.next = p.next.left;
                p = p.next;
            }
            first = first.left;
        }
    }
   
}
