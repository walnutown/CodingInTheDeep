/*
    Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

    For example:
    Given binary tree {3,9,20,#,#,15,7},
        3
       / \
      9  20
        /  \
       15   7
    return its bottom-up level order traversal as:
    [
      [15,7]
      [9,20],
      [3],
    ]

*/

// same as binaryTreeLevelOrderTraversal, plus reverse step, time: O(n); space: O(b^d)
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root==null) return res;
        int curr_num =1, next_num = 0;
        Stack<ArrayList<Integer>> st = new Stack<ArrayList<Integer>>();
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.add(root);
        ArrayList<Integer> r = new ArrayList<Integer>();
        while (!qu.isEmpty()){
            TreeNode curr = qu.poll();
            r.add(curr.val);
            if (curr.left != null){ 
                qu.add(curr.left);
                next_num++;
            }
            if (curr.right != null){  
                qu.add(curr.right);
                next_num++;
            }
            if (--curr_num==0){
                curr_num = next_num;
                next_num = 0;
                st.push(new ArrayList<Integer>(r));
                r.clear();
            }
        }
        while (!st.isEmpty())   res.add(st.pop());
        return res;
    }
}