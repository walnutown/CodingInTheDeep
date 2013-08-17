// how to find the two swapped values

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
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            return;
        }
        /*
        if (root.left != null && root.right == null){
            if (root.left.val >= root.val){
                int m = root.left.val;
                root.left.val = root.val;
                root.val = m;
            }
            return;
        }
        
       if (root.left == null && root.right != null){
            if (root.right.val <= root.val){
                int m = root.right.val;
                root.right.val = root.val;
                root.val = m;
            }
            return;
        }
        */
        TreeNode[] temp = new TreeNode[2];
        temp[0] = new TreeNode(Integer.MIN_VALUE);
        ArrayList<TreeNode> swap = new ArrayList<TreeNode>(); 
        int count = 0;
        
        // find the two nodes
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        TreeNode curr = root.left;
        while (!st.empty() || curr != null){
            if (curr != null){
                st.push(curr);
                curr = curr.left;
            }
            else{
                curr = st.pop();
                temp[1] = curr;
                if (temp[0].val >= temp[1].val){
                    if (count == 0){
                        swap.add(temp[0]);
                        count++;
                    }
                    else if (count == 1){
                        swap.add(temp[1]);
                        break;
                    }
                }
                temp[0] = temp[1];
                curr = curr.right;
            }
        }
        
        // swap the node value
        if (swap.size() == 2){
            int m = swap.get(0).val;
            swap.get(0).val = swap.get(1).val;
            swap.get(1).val = m;
        }
    } 
    
}