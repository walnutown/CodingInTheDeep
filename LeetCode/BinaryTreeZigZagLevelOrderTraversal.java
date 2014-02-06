/*
    Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

    For example:
    Given binary tree {3,9,20,#,#,15,7},
        3
       / \
      9  20
        /  \
       15   7
    return its zigzag level order traversal as:
    [
      [3],
      [20,9],
      [15,7]
    ]

*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// one stack, need to reverse in even level
// time: O(n); space: O(b^d)
public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null)   return res;
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.add(root);
        Stack<Integer> st = new Stack<Integer>();
        int curr_num = 1, next_num = 0;
        int level = 0;
        while(qu.size() > 0){
            TreeNode curr = qu.poll();
            st.push(curr.val);
            curr_num--;
            if (curr.left != null){
                qu.add(curr.left);
                next_num++;
            }
            if (curr.right != null){
                qu.add(curr.right);
                next_num++;
            }
            if (curr_num == 0){
                curr_num = next_num;
                next_num = 0;
                level++;
                if (level%2 == 1)   res.add(new ArrayList<Integer>(st));
                else{
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    while(!st.isEmpty()){
                        tmp.add(st.pop());
                    }
                    res.add(tmp);
                }
                st.clear();
            }
        }
        return res;
    }
}


// Two stacks, time: O(n); space: O(b^d)
// time complexity is better than the above, becuase we don't have to do extra pops to reverse the list
public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // use two stacks
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null)   return res;
        Stack<TreeNode> odd = new Stack<TreeNode>();
        Stack<TreeNode> even = new Stack<TreeNode>();
        odd.push(root);
        int level = 1;
        ArrayList<Integer> r = new ArrayList<Integer>();
        while (!(odd.isEmpty() && even.isEmpty())){
            if ((level & 0x01) > 0){
                TreeNode curr = odd.pop();
                r.add(curr.val);
                if (curr.left != null)  even.push(curr.left);
                if (curr.right != null)  even.push(curr.right);
                if (odd.isEmpty()){  
                    res.add(new ArrayList<Integer>(r));
                    level++;
                    r.clear();
                }
            }else{
                TreeNode curr = even.pop();
                r.add(curr.val);
                if (curr.right != null)  odd.push(curr.right);
                if (curr.left != null)  odd.push(curr.left);
                if (even.isEmpty()){
                    res.add(new ArrayList<Integer>(r));
                    level++;
                    r.clear();
                }
            }
        }
        return res;
    }
}