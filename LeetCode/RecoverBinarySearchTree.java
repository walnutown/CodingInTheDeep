/*
  Two elements of a binary search tree (BST) are swapped by mistake.

  Recover the tree without changing its structure.

  Note:
  A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
*/

// E.g. Given [1, 4, 3, 2, 5], which two shall we swap to fix the array?
// One way is starting from the second element in the list and comparing it with its
// previous one. If it is smaller than its previous one, then we know at least one of
// the two is in wrong spot. So, the larger one in the first pair and the smaller one
// in the second pair are the ones we are looking for.
// But, how about [1, 3, 2, 4, 5]?
// This tells us that if there is only one such pair where the latter one is greater
// than the previous one. That pair is actually the two element we are looking for.


// Iterative DFS, the two wsapped nodes are the first and last node in the arraylsit
// no matter there're two pairs or just one pair of swapped nodes
// time: O(n); space: O(b^d)
public class Solution {
    public void recoverTree(TreeNode root) {
       if (root==null)  return;
       ArrayList<TreeNode>  nodes = new ArrayList<TreeNode>();
       Stack<TreeNode>  st = new Stack<TreeNode>();
       TreeNode prev = null;
       while (root != null){
           st.push(root);
           root = root.left;
       }
       while (!st.isEmpty()){
           TreeNode curr = st.pop();
           if (prev != null && prev.val > curr.val){
               nodes.add(prev);
               nodes.add(curr);
           }
           prev = curr;
           curr = curr.right;
           while (curr != null){
               st.push(curr);
               curr = curr.left;
           }
       }
       int tmp = nodes.get(0).val;
       nodes.get(0).val = nodes.get(nodes.size()-1).val;
       nodes.get(nodes.size()-1).val = tmp;
    }
}

// Morris Traversal
// Maintain a prev pointer
// Write the morris traversal first, then add code to find swapped nodes
// time: O(n); space: O(1)
public class Solution {
    public void recoverTree(TreeNode root) {
        if (root==null) return;
        TreeNode curr = root, prev = null, n1=null, n2=null;
        while (curr!=null){
            if (curr.left==null){
                if (prev!=null && prev.val > curr.val){
                    n2 = curr;
                    if (n1==null)   n1 = prev;
                }
                prev = curr;
                curr = curr.right;
            }else{
                TreeNode p = curr.left;
                while (p.right != null && p.right != curr)
                   p = p.right;
                if (p.right == null) {
                   p.right = curr;
                   curr = curr.left;
                } else {
                   p.right = null;
                   if (prev != null && prev.val > curr.val) {
                      n2 = curr;
                      if (n1 == null)
                         n1 = prev;
                   }
                   prev = curr;
                   curr = curr.right;
                }
            }
        }
        swap(n1, n2);
    }
    private void swap(TreeNode n1, TreeNode n2){
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
    }
}
