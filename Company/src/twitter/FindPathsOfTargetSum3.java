package twitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import lib.TreeNode;

import org.junit.Test;

public class FindPathsOfTargetSum3 {
   /*
    * Given a binary tree, all nodes are stored in an array. Each node only knows its parent.
    * Find all paths in the tree with the value of d. The value of a path is described as the number
    * of nodes in the path.
    */

   /**
    * Traverse all pairs of nodes in the tree. 2 cases:
    * [1] one node is the common ancestor
    * [2] none of the two nodes is the common ancestor. Find Lowest Common Ancestor of two nodes to
    * get the path sum
    * time: O(n^3); space: O(1)
    */
   // FOLLOWUP: we can optimize the sol by pre-process the common ancestors of any two nodes in the
   // tree. time: O(n^2); space: O(n^2)

   public ArrayList<ArrayList<TreeNode>> getPaths(TreeNode[] nodes, int sum) {
      ArrayList<ArrayList<TreeNode>> res = new ArrayList<ArrayList<TreeNode>>();
      for (int i = 0; i < nodes.length; i++) {
         for (int j = i + 1; j < nodes.length; j++) {
            TreeNode lca = getLCA(nodes[i], nodes[j]);
            if ((getDistance(lca, nodes[i]) + getDistance(lca, nodes[j]) + 1) == sum)
               addPair(nodes[i], nodes[j], res);
         }
      }
      return res;
   }

   // find lowest common ancestor of two nodes
   private TreeNode getLCA(TreeNode a, TreeNode b) {
      Set<TreeNode> set = new HashSet<TreeNode>();
      TreeNode p = a;
      while (p != null) {
         set.add(p);
         p = p.parent;
      }
      TreeNode q = b;
      while (q != null) {
         if (set.contains(q))
            return q;
         q = q.parent;
      }
      return null;
   }

   private int getDistance(TreeNode ancestor, TreeNode node) {
      int dis = 0;
      while (node != null && node != ancestor) {
         node = node.parent;
         dis++;
      }
      return dis;
   }

   private void addPair(TreeNode p, TreeNode q, ArrayList<ArrayList<TreeNode>> res) {
      ArrayList<TreeNode> r = new ArrayList<TreeNode>();
      r.add(p);
      r.add(q);
      res.add(r);
   }

   @Test
   public void test() {
      int[] in = new int[] { 4, 2, 5, 1, 6, 3 };
      int[] pre = new int[] { 1, 2, 4, 5, 3, 6 };
      TreeNode root = new TreeNode(in, pre);
      System.out.println(root.printTree());
      TreeNode[] nodes = getArrayOfNodes(root);
      for (ArrayList<TreeNode> pair : getPaths(nodes, 2)) {
         System.out.println(pair.toString());
      }
   }

   // inorder traversal to get the array of nodes
   private TreeNode[] getArrayOfNodes(TreeNode root) {
      ArrayList<TreeNode> res = new ArrayList<TreeNode>();
      Stack<TreeNode> st = new Stack<TreeNode>();
      st.push(root);
      TreeNode p = root;
      while (p.left != null) {
         st.push(p.left);
         p = p.left;
      }
      while (!st.isEmpty()) {
         p = st.pop();
         res.add(p);
         p = p.right;
         while (p != null) {
            st.push(p);
            p = p.left;
         }
      }
      return res.toArray(new TreeNode[] {});
   }

}
