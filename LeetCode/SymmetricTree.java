/*
    Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

    For example, this binary tree is symmetric:

        1
       / \
      2   2
     / \ / \
    3  4 4  3
    But the following is not:
        1
       / \
      2   2
       \   \
       3    3
    Note:
    Bonus points if you could solve it both recursively and iteratively.
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

// recursion
// time: O(n); space: recursive stack
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)   return true;
        return isSymmetric(root.left, root.right);
    }
    public boolean isSymmetric(TreeNode l, TreeNode r){
        if (l==null || r==null) return l==null && r==null;
        if (l.val != r.val) return false;
        return isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);
    }
}

// AnnieKim, better iteration, more elegant, but has duplicate comparisons (in fact, only need to compare the half of one level)
// time: O(n); space: O(b^(d-1)), b is branching factor, d is the maximum depth of the tree
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.add(root.left);
        qu.add(root.right);
        while (!qu.isEmpty()){      // compare one pair each time
            TreeNode t1 = qu.poll();
            TreeNode t2 = qu.poll();
            if (t1==null && t2==null)  continue;
            if (t1==null || t2==null || t1.val != t2.val)   return false;
            qu.add(t1.left);
            qu.add(t2.right);
            qu.add(t1.right);
            qu.add(t2.left);
        }
        return true;
    }
}

// The inorder traversal array of the tree is symmetric
// time: O(n)
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)   return true;
        ArrayList<String> nodes = new ArrayList<String>();
        inorderTraversal(root, nodes);   
        int i = 0, j = nodes.size() -1;
        while (i < j){
            if (!nodes.get(i++).equals(nodes.get(j--))) return false;   
        }
        return true;          
    }
    public void inorderTraversal(TreeNode n, ArrayList<String> nodes){
        if (n == null){
            nodes.add("#");
            return;
        }
        if (n.left==null && n.right==null)  nodes.add(""+n.val);
        else{
            inorderTraversal(n.left, nodes);
            nodes.add(""+n.val);
            inorderTraversal(n.right, nodes);     
        }
    }
}