package lib;

import static org.junit.Assert.*;

import org.junit.Test;

public class BSTTests {

   @Test
   public void testConstructBSTFromArray() {
      int[] pre = new int[]{3,1,2,5,4,6};
      int[] in = new int[]{1,2,3,4,5,6};
      BST bst_actual = new BST(pre);
      BST bst_expected = new BST();
      TreeNode root = new TreeNode(in, pre);
      bst_expected.setRoot(root); 
      System.out.println(root.printTree());
      System.out.println(bst_actual.getRoot().printTree());
      assertTrue(isSameBST(bst_actual.getRoot(), bst_expected.getRoot()));
   }
   
   
   public boolean isSameBST(TreeNode a, TreeNode b){
      if (a==null || b==null) return a==null && b==null;
      return a.val==b.val && isSameBST(a.left, b.left) && isSameBST(a.right, b.right);
   }
   
   @Test
   public void testAddNodeToBST(){
      int[] pre = new int[]{3,1,2,5,4,6};
      int[] in = new int[]{1,2,3,4,5,6};
      BST bst_actual = new BST(new int[]{3,1,2,5,4});
      bst_actual.add(6);
      BST bst_expected = new BST();
      TreeNode root = new TreeNode(in, pre);
      bst_expected.setRoot(root); 
      System.out.println(root.printTree());
      System.out.println(bst_actual.getRoot().printTree());
      assertTrue(isSameBST(bst_actual.getRoot(), bst_expected.getRoot()));
   }
   
   @Test
   public void testBSTHasNode(){
      BST bst_actual = new BST(new int[]{3,1,2,5,4});
      bst_actual.add(6);
      assertTrue(bst_actual.has(6));
   }
   
   @Test
   public void testDeleteNodeFromBST(){
      int[] pre = new int[]{3,1,2,6,4};
      int[] in = new int[]{1,2,3,4,6};
      BST bst_actual = new BST(new int[]{3,1,2,5,4,6});
      bst_actual.delete(5);
      BST bst_expected = new BST();
      TreeNode root = new TreeNode(in, pre);
      bst_expected.setRoot(root); 
      System.out.println(root.printTree());
      System.out.println(bst_actual.getRoot().printTree());
      assertTrue(isSameBST(bst_actual.getRoot(), bst_expected.getRoot()));
   }
    
   

}
