package lib;

/**
 * Implement a binary search tree (without duplicates)
 * 
 * Ref:
 * http://pages.cs.wisc.edu/~vernon/cs367/notes/9.BST.html
 */
public class BST {
   private TreeNode root;

   public BST() {
      root = null;
   }

   public BST(int val) {
      root = new TreeNode(val);
   }

   public BST(int[] arr) {
      for (int num : arr)
         this.add(num);
   }

   public TreeNode getRoot() {
      return root;
   }

   public void setRoot(TreeNode root) {
      this.root = root;
   }

   public boolean has(int val) {
      if (root == null)
         return false;
      TreeNode curr = root;
      while (curr != null) {
         if (curr.val == val)
            return true;
         else if (curr.val < val)
            curr = curr.right;
         else
            curr = curr.left;
      }
      return false;
   }

   public void add(int val) {
      if (root == null) {
         root = new TreeNode(val);
         return;
      }
      TreeNode curr = root;
      while (true) {
         if (curr.val == val)
            return;
         else if (curr.val > val) {
            if (curr.left != null)
               curr = curr.left;
            else {
               curr.left = new TreeNode(val);
               return;
            }
         } else {
            if (curr.right != null)
               curr = curr.right;
            else {
               curr.right = new TreeNode(val);
               return;
            }
         }
      }
   }

   // deletion is the most difficult part of BST. The node to be deleted has 3 cases:
   // <1> leaf node
   // <2> with one child
   // <3> with two children
   public void delete(int val) {
      if (!this.has(val))
         return;
      root = deleteNode(root, val);
   }

   private TreeNode deleteNode(TreeNode node, int val) {
      if (node == null)
         return null;
      if (node.val == val) {
         if (node.left == null && node.right == null)
            return null;
         else if (node.left == null || node.right == null)
            return node.left == null ? node.right : node.left;
         // replace current value with successor's value, then delete the successor node
         int sucValue = getSuccessor(node);
         node.val = sucValue;
         node.right = deleteNode(node.right, sucValue);
         return node;
      } else if (node.val > val) {
         node.left = deleteNode(node.left, val);
         return node;
      } else {
         node.right = deleteNode(node.right, val);
         return node;
      }
   }

   private int getSuccessor(TreeNode node) {
      assert (node != null);
      TreeNode curr = node.right;
      while (curr.left != null)
         curr = curr.left;
      return curr.val;
   }
}
