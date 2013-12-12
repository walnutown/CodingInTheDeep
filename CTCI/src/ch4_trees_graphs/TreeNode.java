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
      return val+" ";
   }
}
