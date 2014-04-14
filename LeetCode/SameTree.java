/*
	Given two binary trees, write a function to check if they are equal or not.

	Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
*/




// Accepted
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null || q==null) return p==null && q==null;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

// Serialize the tree and compare
// time: 
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        String sp = getSerialization(p), sq = getSerialization(q);
        if (sp.length()!=sq.length())
            return false;
        for (int i=0; i<sp.length(); i++){
            if (sp.charAt(i)!=sq.charAt(i))
                return false;
        }
        return true;
    }
    StringBuilder sb;
    private String getSerialization(TreeNode root){
        sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }
    private void preorder(TreeNode node, StringBuilder sb){
        if (node==null){
            sb.append("#");
            return;
        }
        sb.append(node.val);
        preorder(node.left, sb);
        preorder(node.right, sb);
    }
}


// Tree serialization using level order traversal
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        LinkedList<TreeNode> level1 = new LinkedList<TreeNode>(), level2 = new LinkedList<TreeNode>();
        level1.add(p); level2.add(q);
        while(!level1.isEmpty() && !level2.isEmpty()) {
            LinkedList<TreeNode> temp1 = new LinkedList<TreeNode>(), temp2 = new LinkedList<TreeNode>();
            while(!level1.isEmpty() && !level2.isEmpty()) {
                TreeNode n1 = level1.poll(), n2 = level2.poll();
                if(n1 == null && n2 == null);
                else if(n1 == null || n2 == null) return false;
                else if(n1.val != n2.val) return false;
                if(n1 != null && n2 != null) {
                    temp1.add(n1.left); temp1.add(n1.right);
                    temp2.add(n2.left); temp2.add(n2.right);
                }
            }
            if(!level1.isEmpty() || !level2.isEmpty()) return false;
            level1 = temp1; level2 = temp2;
        }
        if(!level1.isEmpty() || !level2.isEmpty()) return false;
        return true;
    }
}
