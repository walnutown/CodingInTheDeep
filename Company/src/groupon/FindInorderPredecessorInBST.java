package groupon;

import lib.TreeNode;

public class FindInorderPredecessorInBST {

   /**
    * Given a binary search tree and current node, find the in-order previous node of current node
    */
   public static void main(String[] args) {
      int[] A = new int[]{1,2,3,4,5,6,7};
      TreeNode root = new TreeNode(A);
      //TreeNode curr = root.left.left;
      TreeNode curr = root;
      System.out.println(root.printTree());
      System.out.println("root: "+ root + " curr: " + curr);
      System.out.println(getPrevious(root, curr));
   }
   // time: O(lgn); space: O(1)
   static TreeNode getPrevious(TreeNode root, TreeNode curr){
      if (curr.left!=null){
          TreeNode p = curr.left;
          while (p.right!=null)
              p = p.right;
          return p;
      }else{
          TreeNode p = curr.parent, pp = curr;
          while (p!=null){
             if (p.right.equals(pp))
                return pp;
             p = p.parent;
             pp = pp.parent;
          }
          return null;
      }
  }

}
