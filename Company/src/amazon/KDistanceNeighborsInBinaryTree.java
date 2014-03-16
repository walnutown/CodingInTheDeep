package amazon;

import java.util.ArrayList;

import lib.TreeNode;

import org.junit.Test;

public class KDistanceNeighborsInBinaryTree {
   /*
    * Given a node in the binary tree, find all neighbor nodes that are k distance from the node.
    * Distance is described as the number of edges between two nodes 
    */
   
   public ArrayList<TreeNode> getKDistanceNeighbors(TreeNode root, TreeNode node, int k){
      ArrayList<TreeNode> res = new ArrayList<TreeNode>();
      ArrayList<TreeNode> path = new ArrayList<TreeNode>();
      finder(root, node, 0, k, res, path);
      return res;
   }
   
   public void finder(TreeNode curr, TreeNode target, int distance, int k, ArrayList<TreeNode> res, ArrayList<TreeNode> path){
      if (curr==null)
         return;
      if (curr == target){
         res.addAll(getValidChildren(curr, k)); // target node's valid children
         for (int i=path.size()-1; i>=0; i--)    // path across target node's parent and grandparent ...
            res.addAll(getValidChildren(path.get(i), k-(path.size()-i)));
         if (path.size()>=k) // if there exist k distance neighbors in upper path
            res.add(path.get(path.size()-k));
         return;
      }
      path.add(curr);
      finder(curr.left, target, distance+1, k, res, path);
      finder(curr.right, target, distance+1, k, res, path);
   }
   
   public ArrayList<TreeNode> getValidChildren(TreeNode node, int k){
      ArrayList<TreeNode> children = new ArrayList<TreeNode>();
      if (node==null || node.right==null) 
         return children;
      getter(node.right, children, k-1);
      return children;
   }
   
   public void getter(TreeNode node, ArrayList<TreeNode> children, int k){
      if (node==null)
         return;
      if (k==0){
         children.add(node);
         return;
      }
      getter(node.left, children, k-1);
      getter(node.right, children, k-1);
   }
   
   @Test
   public void test(){
      //int[] A = new int[] { 4, 2, 5, 1, 6, 3, 7, 8, 9, 10, 11 };
      int[] A = new int[] { 4, 2, 5, 1, 6, 3 };
      TreeNode root = new TreeNode(A);
      System.out.println(root.printTree());
      TreeNode node = root.left.right;
      System.out.println(getKDistanceNeighbors(root, node, 4));
   }
}
