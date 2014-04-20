package google;

import lib.TreeNode;

import org.junit.Test;

public class JavaPassByValue {
   /*
    * This is a test to show that Java manipulates objects 'by reference,' but it passes object
    * references to methods 'by value.
    */

   @Test
   public void testManipulateObjectByReference() {
      TreeNode root = new TreeNode(0);
      root.left = new TreeNode(1);
      root.right = new TreeNode(2);
      setLeftChildToNull(root);
      System.out.println(root.left);
   }

   private void setLeftChildToNull(TreeNode root) {
      root.left = null;
   }
   
   @Test
   public void testPassReferenceByValue(){
      TreeNode root = new TreeNode(0);
      root.left = new TreeNode(1);
      root.right = new TreeNode(2);
      changeRefernce(root);
      System.out.println(root); // if pass by reference, should return 1, otherwise, return 0
   }
   
   private void changeRefernce(TreeNode root){
      root = root.left;
   }
}
