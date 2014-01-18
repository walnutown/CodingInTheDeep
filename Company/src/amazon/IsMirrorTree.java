package amazon;

import lib.TreeNode;

public class IsMirrorTree {

   /**
    * Check whether two input trees are mirror to each other
    */
   public static void main(String[] args) {
      TreeNode a = new TreeNode(new int[]{2,3,1});
      TreeNode b = CreateMirrorTree.mirror2(a);
      System.out.println(a.printTree());
      System.out.println(b.printTree());
      System.out.println(isMirrorTree(a,b));
   }
   
   public static boolean isMirrorTree(TreeNode a, TreeNode b){
      if (a==null || b==null)   return a==null && b==null;
      if (a.val != b.val)   return false;
      return isMirrorTree(a.left, b.right) && isMirrorTree(a.right, b.left);
   }

}
