package ch4_trees_graphs;

import java.util.ArrayList;

import org.junit.Test;

public class ch4_9_FindPathsOfTargetSum {

   /**
    * Given a binary tree, to print all paths which sum to a given value.
    * The path does not need to start or end at the root or a leaf
    */

   // Note: the following solution doesn't consider all the cases. It only consider all the
   // sub-paths starting from root. For the solution covers all paths, see FindPathsOfTargetSum2

   // record the path from root to current node, and trace back from the current node,
   // through the path to check if path sum meets goal
   // time: O(nlgn); space: O(lgn)
   public ArrayList<ArrayList<TreeNode>> getPaths(TreeNode root, int sum) {
      ArrayList<ArrayList<TreeNode>> paths = new ArrayList<ArrayList<TreeNode>>();
      if (root == null)
         return paths;
      finder(root, sum, paths, new ArrayList<TreeNode>(), 0);
      return paths;
   }

   private void finder(TreeNode root, int sum, ArrayList<ArrayList<TreeNode>> paths, ArrayList<TreeNode> path, int dep) {
      if (root == null)
         return;
      path.add(root);
      int path_sum = 0;
      for (int i = dep; i >= 0; i--) {
         path_sum += path.get(i).val;
         if (path_sum == sum) {
            ArrayList<TreeNode> tmp = new ArrayList<TreeNode>();
            for (int j = i; j <= dep; j++)
               tmp.add(path.get(j));
            paths.add(tmp);
         }
      }
      finder(root.left, sum, paths, path, dep + 1);
      finder(root.right, sum, paths, path, dep + 1);
      path.remove(path.size() - 1);
   }

   @Test
   public void test() {
      int[] in = new int[] { 4, 2, 5, 1, 6, 3 };
      int[] pre = new int[] { 1, 2, 4, 5, 3, 6 };
      TreeNode root = new TreeNode(in, pre);
      System.out.println(root.printTree());
      for (ArrayList<TreeNode> list : getPaths(root, 7)) {
         System.out.println(list.toString());
      }
   }

}
