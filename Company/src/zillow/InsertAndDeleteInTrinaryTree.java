package zillow;

import static org.junit.Assert.*;

import org.junit.Test;

public class InsertAndDeleteInTrinaryTree {

   /*
    * Implement insert and delete in a tri-nary tree. A tri-nary tree is much like a binary tree but
    * with three child nodes for each parent instead of two -- with the left node being values less
    * than the parent, the right node values greater than the parent, and the middle nodes values
    * equal to the parent.
    */

   public enum Type {
      LEFT, MIDDLE, RIGHT,
   }

   public class TrinaryTreeNode {
      public int value;
      public TrinaryTreeNode left;
      public TrinaryTreeNode right;
      public TrinaryTreeNode middle;

      public TrinaryTreeNode(int value) {
         this.value = value;
         left = null;
         right = null;
         middle = null;
      }

      public String toString() {
         return String.valueOf(value);
      }
   }

   public class TrinaryTree {
      public TrinaryTreeNode root;

      public TrinaryTree() {
         root = null;
      }

      public TrinaryTree(int value) {
         this.root = new TrinaryTreeNode(value);
      }

      public TrinaryTree(TrinaryTreeNode root) {
         this.root = root;
      }

      public void insert(int value) {
         if (root == null)
            root = new TrinaryTreeNode(value);
         else {
            TrinaryTreeNode curr = root;
            while (true) {
               if (curr.value == value) {
                  if (curr.middle == null) {
                     curr.middle = new TrinaryTreeNode(value);
                     return;
                  } else
                     curr = curr.middle;
               } else if (curr.value < value) {
                  if (curr.right == null) {
                     curr.right = new TrinaryTreeNode(value);
                     return;
                  } else
                     curr = curr.right;
               } else {
                  if (curr.left == null) {
                     curr.left = new TrinaryTreeNode(value);
                     return;
                  } else
                     curr = curr.left;
               }
            }
         }
      }

      /**
       * Delete the 'value' in TrinaryTree.
       * if the node doesn't exist, return false,
       * otherwise, return true.
       */
      public boolean delete(int value) {
         if (root == null)
            return false;
         TrinaryTreeNode curr = root, parent = null;
         Type type = Type.MIDDLE;
         while (curr.value != value) {
            parent = curr;
            if (curr.value > value) {
               curr = curr.left;
               type = Type.LEFT;
            } else {
               curr = curr.right;
               type = Type.RIGHT;
            }
            if (curr == null)
               return false;    // node not found
         }
         while (curr.middle != null) {
            parent = curr;
            curr = curr.middle;
            type = Type.MIDDLE;
         }  // curr.middle == null && curr.value == value
         if (curr.left == null && curr.right == null) {
            resetChildNode(parent, curr, null, type);
            return true;
         } else if (curr.left != null && curr.right == null) {
            resetChildNode(parent, curr, curr.left, type);
            return true;
         } else if (curr.left == null && curr.right != null) {
            resetChildNode(parent, curr, curr.right, type);
            return true;
         } else {
            TrinaryTreeNode successor = getSuccessor(curr);
            successor.left = curr.left;
            resetChildNode(parent, curr, successor, type);
            return true;
         }
      }

      public void resetChildNode(TrinaryTreeNode parent, TrinaryTreeNode oldChild, TrinaryTreeNode newChild, Type type) {
         if (oldChild == root) {
            root = newChild;
            return;
         }
         if (type == Type.MIDDLE)
            parent.middle = newChild;
         else if (type == Type.LEFT)
            parent.left = newChild;
         else
            parent.right = newChild;  
      }

      /**
       * Get the in-order successor node of target node
       * 
       * @param target!=null && target.right!=null
       */
      public TrinaryTreeNode getSuccessor(TrinaryTreeNode target) {
         TrinaryTreeNode curr = target.right, parent = target;
         while (curr.left != null) {
            parent = curr;
            curr = curr.left;
         }
         if (curr == target.right)
            return curr;
         if (curr.middle == null && curr.right == null)
            parent.left = null;
         else if (curr.middle != null)
            parent.left = curr.middle;
         else
            parent.left = curr.right;
         curr.right = target.right;
         return curr;
      }
   }

   /*--------------------------Test Cases-------------------------------*/
   @Test
   public void testInsertInTrinaryTree() {
      TrinaryTree t1 = getSampleTree();
      TrinaryTree t2 = new TrinaryTree();
      t2.insert(5);
      t2.insert(5);
      t2.insert(4);
      t2.insert(9);
      t2.insert(7);
      assertTrue(isSameTree(t1, t2));
   }

   @Test
   public void testDeleteNodeNotInTrinaryTree() {
      TrinaryTree t = getSampleTree();
      assertTrue(t.delete(500) == false);
   }

   @Test
   public void testDeleteNodeInTrinaryTree() {
      TrinaryTree t = getSampleTree();
      TrinaryTree t2 = getSampleTree();

      assertTrue(t.delete(5) == true);
      t2.root.middle = null;
      assertTrue(isSameTree(t, t2));

      assertTrue(t.delete(5) == true);
      t2.root.value = 7;
      t2.root.right.left = null;
      assertTrue(isSameTree(t, t2));

      assertTrue(t.delete(9) == true);
      t2.root.right = null;
      assertTrue(isSameTree(t, t2));

      assertTrue(t.delete(7) == true);
      t2.root.value = 4; t2.root.left = null;
      assertTrue(isSameTree(t, t2));

      assertTrue(t.delete(4) == true);
      t2.root = null;
      assertTrue(isSameTree(t, t2));

      assertTrue(t.delete(7) == false);
   }

   public TrinaryTree getSampleTree() {
      TrinaryTreeNode root = new TrinaryTreeNode(5);
      root.left = new TrinaryTreeNode(4);
      root.middle = new TrinaryTreeNode(5);
      root.right = new TrinaryTreeNode(9);
      root.right.left = new TrinaryTreeNode(7);
      TrinaryTree t = new TrinaryTree(root);
      return t;
   }

   public boolean isSameTree(TrinaryTree a, TrinaryTree b) {
      if (a == null || a == null)
         return a == null && b == null;
      return isSameTreeNode(a.root, b.root);

   }

   public boolean isSameTreeNode(TrinaryTreeNode a, TrinaryTreeNode b) {
      if (a == null || a == null)
         return a == null && b == null;
      if (a.value != b.value)
         return false;
      return isSameTreeNode(a.left, b.left) && isSameTreeNode(a.right, b.right) && isSameTreeNode(a.middle, b.middle);
   }

}
