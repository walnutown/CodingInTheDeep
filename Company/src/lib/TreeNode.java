package lib;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
   public int val;
   public TreeNode left, right;
   public TreeNode parent;
   private static int pre_index;

   public TreeNode(int val) {
      this.val = val;
      left = null;
      right = null;
      parent = null;    
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
      this.parent = null;
   }
   // construct a tree from in-order and pre-order traversal arrays
   public TreeNode(int[] in, int[] pre){
      // skip valid check for arrays here
      pre_index = 0;
      TreeNode node = buildTree (in, pre, 0, in.length-1);
      this.val = node.val;
      this.left = node.left;
      this.right = node.right;
      this.parent = null;
   }
   // create a minimal height BST with the given array
   public TreeNode buildTree(int[] arr, int start, int end){
      if (start > end)
         return null;
      int mid = (start + end) >> 1;
      TreeNode root = new TreeNode(arr[mid]);
      root.left = buildTree(arr, start, mid-1);
      root.right = buildTree(arr, mid+1, end);
      if (root.left != null)
         root.left.parent = root;
      if (root.right != null)
         root.right.parent = root;
      return root;
   }
   // construct a tree from in-order and pre-order traversal arrays
   public TreeNode buildTree(int[] in, int[] pre, int in_start, int in_end){
      if (in_start > in_end || pre_index >= pre.length) // notice 'pre_index >= pre.length'
         return null;
      TreeNode root = new TreeNode(pre[pre_index++]);
      int in_root_index = 0;
      for (int i = in_start; i <= in_end; i++){
         if (in[i] == root.val){
            in_root_index = i;
            break;
         }
      }
      root.left = buildTree(in, pre, in_start, in_root_index-1);
      root.right = buildTree(in, pre, in_root_index+1, in_end);
      if (root.left != null)
         root.left.parent = root;
      if (root.right != null)
         root.right.parent = root;
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
