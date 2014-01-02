/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    ArrayList<String> nodeArr;
    
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null){
            return true;
        }
        nodeArr = new ArrayList<String>();
        inorderTraversal(root);   
        
        int i = 0;
        int j = nodeArr.size() -1;
        while (i < j){
            if (!nodeArr.get(i).equals(nodeArr.get(j))){
                return false;
            }
            i++;
            j--;
        }
        
        return true;
               
    }
    
    public void inorderTraversal(TreeNode n){
        if (n == null){
            nodeArr.add("#");
            return;
        }
      
        inorderTraversal(n.left);
        nodeArr.add(""+n.val);
        inorderTraversal(n.right);     
    }
}

// recursion
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)   return true;
        return isSymmetric(root.left, root.right);
    }
    public boolean isSymmetric(TreeNode l, TreeNode r){
        if (l==null || r==null) return l==null && r==null;
        if (l.val != r.val) return false;
        return isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);
    }
}

// inorder traversal, iterative
public class Solution {
    public boolean isSymmetric(TreeNode root) {
      if (root == null)
         return true;
      Stack<TreeNode> st = new Stack<TreeNode>();
      ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
      while (root != null) {
         st.push(root);
         root = root.left;
      }
      while (!st.isEmpty()) {
         TreeNode curr = st.pop();
         if (curr.left == null && curr.right != null) {
            nodes.add(null);
            nodes.add(curr);
         } else if (curr.left != null && curr.right == null) {
            nodes.add(curr);
            nodes.add(null);
         } else nodes.add(curr);
         curr = curr.right;
         while (curr != null) {
            st.push(curr);
            curr = curr.left;
         }
      }
      int i = 0, j = nodes.size() - 1;
      while (i < j){
         if (nodes.get(i)==null || nodes.get(j)==null){
             if (!(nodes.get(i)==null && nodes.get(j)==null))   return false;
         }else{
             if (nodes.get(i).val != nodes.get(j).val)   return false;
         }
         i++;
         j--;
     }
      return true;
   }
}

// better iteration, more clear and elegant, from AnnieKim
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.add(root.left);
        qu.add(root.right);
        while (!qu.isEmpty()){      // compare one pair each time
            TreeNode t1 = qu.poll();
            TreeNode t2 = qu.poll();
            if (t1==null && t2==null)  continue;
            if (t1==null || t2==null || t1.val != t2.val)   return false;
            qu.add(t1.left);
            qu.add(t2.right);
            qu.add(t1.right);
            qu.add(t2.left);
        }
        return true;
    }
}