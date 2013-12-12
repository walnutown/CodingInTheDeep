package ch4_trees_graphs;

public class ch4_7 {

   /*
    * Design an algorithm to find the first common ancestor of two nodes in a binary tree
    * Avoid sorting additional nodes in a data structure
    */
   public static void main(String[] args) {
      int[] arr = new int[]{50,3,5,7, 9, 14, 23, 32};
      TreeNode root = buildTree(arr, 0, arr.length-1);
      System.out.println(root.printTree());
      System.out.println(findFirstCommonAncestor(root, new TreeNode(3), new TreeNode(23)));
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
   // here, we assume that all node values are unique
   // we find a node if its value is equal to the target
   public static TreeNode findFirstCommonAncestor(TreeNode root, TreeNode a, TreeNode b){
      if (root == null)
         return null;
      if (root.val == a.val || root.val == b.val)
         return root;
      TreeNode left = findFirstCommonAncestor(root.left, a, b);
      TreeNode right = findFirstCommonAncestor(root.right, a, b);
      if (left != null && right != null)
         return root;
      if (left != null)
         return left;
      if (right != null)
         return right;
      return null;
   }
}
