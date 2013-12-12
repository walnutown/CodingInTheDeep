package ch4_trees_graphs;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
   public int val;
   public TreeNode left, right;

   public TreeNode(int val) {
      this.val = val;
      left = null;
      right = null;
   }
   // create a minimal height BST with the given array
   public TreeNode(int[] arr){
      if (arr == null){
         try {
            throw new Exception("Initializaiton Failed");
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
      TreeNode node = buildTree(arr, 0, arr.length-1);
      this.val = node.val;
      this.left = node.left;
      this.right = node.right;
   }
   
   public static TreeNode buildTree(int[] arr, int start, int end){
      if (start > end)
         return null;
      int mid = (start + end) >> 1;
      TreeNode root = new TreeNode(arr[mid]);
      root.left = buildTree(arr, start, mid-1);
      root.right = buildTree(arr, mid+1, end);
      return root;
   }

   public String printTree() {
      StringBuilder sb = new StringBuilder();
      Queue<TreeNode> qu = new LinkedList<TreeNode>();
      qu.add(this);
      int curr_num = 1;
      int next_num = 0;
      while (!qu.isEmpty()) {
         TreeNode curr = qu.poll();
         if (curr != null){
            sb.append(curr.val);
            qu.add(curr.left);
            next_num++;
            qu.add(curr.right);
            next_num++;
         }else
            sb.append("*");
         sb.append(" ");
         curr_num--; 
         if (curr_num == 0) {
            sb.append("\n");
            curr_num = next_num;
            next_num = 0;
         }
      }
      return sb.toString();
   }
   
   public String toString(){
      return val+"";
   }
}
