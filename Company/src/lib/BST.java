package lib;
/**
 * Implement a binary search tree
 * 
 * Ref:
 *  http://pages.cs.wisc.edu/~vernon/cs367/notes/9.BST.html
 */
public class BST {
   private TreeNode root;
   
   public BST(){
      root = null;
   }
   
   public BST(int val){
      root = new TreeNode(val);
   }
   
   public BST(int[] arr){
      for (int num : arr)   this.add(num);
   }
   
   public TreeNode getRoot(){
      return root;
   }
   
   public void setRoot(TreeNode root){
      this.root = root;
   }
   
   public boolean has(int val){
      if (root==null)   return false;
      return hasNode(root, val);
   }
   
   public boolean hasNode(TreeNode node, int val){
      if (node.val == val)  return true;
      else if (node.val>val){
         if (node.left==null)   return false;
         return hasNode(node.left, val);
      }
      else {
         if (node.right==null)  return false;
         return hasNode(node.right, val);
      }
   }
   
   public void add(int val){
      if (root == null){
         root = new TreeNode(val);
         return;
      }
      addNode(root, val);
   }
   
   public void addNode(TreeNode node, int val){
      if (node.val == val)  return;
      else if (node.val>val){
         if (node.left==null)   node.left = new TreeNode(val);
         else   addNode(node.left, val);
      } else{
         if (node.right==null)  node.right = new TreeNode(val);
         else   addNode(node.right, val);
      }
   }
   // deletion is the most difficult part of BST. The node to be deleted has 3 cases:
   //   <1> leaf node
   //   <2> with one child
   //   <3> with two children
   public void delete(int val){
      if (root == null) return;
      root = deleteNode(root, val);
   }
   public TreeNode deleteNode(TreeNode node, int val){
      if (node==null)   return null;
      if (node.val == val){
         if (node.left==null && node.right==null)   return null;
         else if (node.left==null)  return node.right;
         else if (node.right==null) return node.left;
         int next_val = findMin(node.right);
         node.val = next_val;
         node.right = deleteNode(node.right, next_val);
         return node;
      }else if (node.val > val){
         node.left = deleteNode(node.left, val);
         return node;
      }else{
         node.right = deleteNode(node.right, val);
         return node;
      }  
   }
   public int findMin(TreeNode node){
      // assert node != null
      if (node.left==null)  return node.val;
      else  return findMin(node.left);
   }
}
