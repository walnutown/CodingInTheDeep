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
     int[] arr = new int[]{1,3,5,7, 9, 14, 23, 32};
     TreeNode root = buildTree(arr, 0, arr.length-1);
     for (ArrayList<Integer> list : createLinkedList(root)){
        System.out.println(list);
     }
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
   
   public static ArrayList<ArrayList<Integer>> createLinkedList(TreeNode root){
      ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
      if (root == null)
         return res;
      Queue<TreeNode> qu = new LinkedList<TreeNode>();
      qu.add(root);
      int curr_num = 1;
      int next_num = 0;
      ArrayList<Integer> r = new ArrayList<Integer>();
      while (!qu.isEmpty()){
         TreeNode curr = qu.poll();
         curr_num--;
         r.add(curr.val);
         if (curr.left != null){
            qu.add(curr.left);
            next_num++;
         }
         if (curr.right != null){
            qu.add(curr.right);
            next_num++;
         }
         if (curr_num == 0){
            res.add(new ArrayList<Integer>(r));
            r.clear();
            curr_num = next_num;
            next_num = 0;
         }
      }
      return res;
   }
   
   

}
