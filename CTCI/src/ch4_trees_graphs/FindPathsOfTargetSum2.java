package ch4_trees_graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class FindPathsOfTargetSum2 {

   /**
    * Given a binary tree, to print all paths which sum to a given value.
    * The path does not need to start or end at the root or a leaf. The value of a path is described
    * as the sum of node values on the path
    */

   // http://stackoverflow.com/questions/4591763/find-paths-in-a-binary-search-tree-summing-to-a-target-value

   // Brute force, find all paths and check.
   // Basic idea is same to Leetcode/MaximumPathSum
   // We use a bottom-up way to find all paths.
   // getPathsStartingAtNode() returns all paths starting at the root
   // during the recursive calls, we also record paths not starting from root in 'paths'
   // Besides, we use a map to store paths and its sum. In this case, we can skip calculating path sum
   Map<ArrayList<TreeNode>, Integer> paths = new HashMap<ArrayList<TreeNode>, Integer>();

   public ArrayList<ArrayList<TreeNode>> getPaths(TreeNode root, int target) {
      ArrayList<ArrayList<TreeNode>> res = new ArrayList<ArrayList<TreeNode>>();
      if (root == null)
         return res;
      getPathsStartingAtNode(root);
      for (Map.Entry<ArrayList<TreeNode>, Integer> entry : paths.entrySet()) {
         if (entry.getValue() == target)
            res.add(new ArrayList<TreeNode>(entry.getKey()));
      }
      return res;
   }

   // use path as key (instead of integer) here to ensure unique
   // return all paths (top-down) starting at node
   private Map<ArrayList<TreeNode>, Integer> getPathsStartingAtNode(TreeNode node) {
      if (node == null)
         return null;
      if (node.left == null && node.right == null) {
         Map<ArrayList<TreeNode>, Integer> map = new HashMap<ArrayList<TreeNode>, Integer>();
         ArrayList<TreeNode> path = new ArrayList<TreeNode>();
         path.add(node);
         map.put(path, node.val);
         return map;
      }
      Map<ArrayList<TreeNode>, Integer> map = new HashMap<ArrayList<TreeNode>, Integer>();
      Map<ArrayList<TreeNode>, Integer> lmap = getPathsStartingAtNode(node.left);
      Map<ArrayList<TreeNode>, Integer> rmap = getPathsStartingAtNode(node.right);
      if (lmap != null) {
         for (Map.Entry<ArrayList<TreeNode>, Integer> entry : lmap.entrySet()) {
            ArrayList<TreeNode> path = new ArrayList<TreeNode>(entry.getKey());
            path.add(0, node);
            map.put(path, entry.getValue() + node.val);
         }
      }
      if (rmap != null) {
         for (Map.Entry<ArrayList<TreeNode>, Integer> entry : rmap.entrySet()) {
            ArrayList<TreeNode> path = new ArrayList<TreeNode>(entry.getKey());
            path.add(0, node);
            map.put(path, entry.getValue() + node.val);
         }
      }
      // add the path with only current node
      ArrayList<TreeNode> p = new ArrayList<TreeNode>();
      p.add(node);
      map.put(p, node.val);
      paths.putAll(map);
      // the following paths will be cached, but will not be returned
      if (lmap != null && rmap != null) {
         for (Map.Entry<ArrayList<TreeNode>, Integer> l : lmap.entrySet()) {
            for (Map.Entry<ArrayList<TreeNode>, Integer> r : rmap.entrySet()) {
               ArrayList<TreeNode> lp = l.getKey();
               ArrayList<TreeNode> rp = r.getKey();
               ArrayList<TreeNode> np = new ArrayList<TreeNode>();
               for (TreeNode n : lp)
                  np.add(0, n);
               np.add(node);
               np.addAll(rp);
               paths.put(np, l.getValue() + node.val + r.getValue());
            }
         }
      }
      return map;
   }

   @Test
   public void test() {
      int[] in = new int[] { 4, 2, 5, 1, 6, 3 };
      int[] pre = new int[] { 1, 2, 4, 5, 3, 6 };
      TreeNode root = new TreeNode(in, pre);
      System.out.println(root.printTree());
      for (ArrayList<TreeNode> list : getPaths(root, 12)) {
         System.out.println(list.toString());
      }
   }
}
