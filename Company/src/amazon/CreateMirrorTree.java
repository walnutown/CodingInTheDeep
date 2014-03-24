package amazon;

import lib.TreeNode;

import org.junit.Test;


public class CreateMirrorTree {

   /**
    * Create the mirror tree of the original tree
    */
  
   // swap the left and child node in place
   // time: O(n); space: O(1)
   public void mirror1(TreeNode node){
      if(node == null)  return;
      mirror1(node.left);
      mirror1(node.right);
      TreeNode tmp = node.left; node.left = node.right; node.right = tmp;
   }
   
   // create a new tree
   // input the original node and return the mirrored node  
   // time: O(n); space: (n)
   public static TreeNode mirror2(TreeNode node){
      if (node == null) return null;
      TreeNode copy = new TreeNode(node.val);
      copy.left = mirror2(node.right);
      copy.right = mirror2(node.left);
      return copy;
   }
   
   @Test
   public void test() {
      TreeNode root = new TreeNode(new int[]{1,2,3,4,5});
      System.out.println(root.printTree());
      mirror1(root);
      System.out.println(root.printTree());
      System.out.println(mirror2(root).printTree());
   }

}
