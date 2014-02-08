package ch4_trees_graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ch4_4 {

   /*
    * Given a binary tree, design an algorithm which creates a
    * linked list of all the nodes at each depth
    */
   public static void main(String[] args) {
      int[] arr = new int[] { 1, 3, 5, 7, 9, 14, 23, 32 };
      TreeNode root = new TreeNode(arr);
      for (ArrayList<Integer> list : createLinkedList(root)) {
         System.out.println(list);
      }
      System.out.println("");
      for (ArrayList<TreeNode> list : createLinkedList2(root)) {
         System.out.println(list.toString());
      }
      System.out.println("");
      for (ArrayList<TreeNode> list : createLinkedList3(root)) {
         System.out.println(list.toString());
      }
   }

   public static ArrayList<ArrayList<Integer>> createLinkedList(TreeNode root) {
      ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
      if (root == null)
         return res;
      Queue<TreeNode> qu = new LinkedList<TreeNode>();
      qu.add(root);
      int curr_num = 1;
      int next_num = 0;
      ArrayList<Integer> r = new ArrayList<Integer>();
      while (!qu.isEmpty()) {
         TreeNode curr = qu.poll();
         curr_num--;
         r.add(curr.val);
         if (curr.left != null) {
            qu.add(curr.left);
            next_num++;
         }
         if (curr.right != null) {
            qu.add(curr.right);
            next_num++;
         }
         if (curr_num == 0) {
            res.add(new ArrayList<Integer>(r));
            r.clear();
            curr_num = next_num;
            next_num = 0;
         }
      }
      return res;
   }

   // refactor createLinkedList, no use of curr_num / next_num
   public static ArrayList<ArrayList<TreeNode>> createLinkedList2(TreeNode root) {
      ArrayList<ArrayList<TreeNode>> res = new ArrayList<ArrayList<TreeNode>>();
      if (root == null)
         return res;
      ArrayList<TreeNode> r_prev = new ArrayList<TreeNode>();
      r_prev.add(root);
      while (!r_prev.isEmpty()) {
         res.add(new ArrayList<TreeNode>(r_prev));
         ArrayList<TreeNode> r_curr = new ArrayList<TreeNode>();
         for (TreeNode n : r_prev) {
            if (n.left != null) {
               r_curr.add(n.left);
            }
            if (n.right != null) {
               r_curr.add(n.right);
            }
         }
         r_prev = r_curr;
      }
      return res;
   }
   
   // DFS,
   public static ArrayList<ArrayList<TreeNode>> createLinkedList3(TreeNode root){
      ArrayList<ArrayList<TreeNode>> res = new ArrayList<ArrayList<TreeNode>>();
      DFS(root, 0, res);
      return res;
   }
   public static void DFS(TreeNode root, int level, ArrayList<ArrayList<TreeNode>> res){
      if (root == null)
         return;
      if (level >= res.size()){
         ArrayList<TreeNode> r = new ArrayList<TreeNode>();
         r.add(root);
         res.add(r);
      }else
         res.get(level).add(root);
      DFS(root.left, level +1, res);
      DFS(root.right, level +1, res);
   }
}
