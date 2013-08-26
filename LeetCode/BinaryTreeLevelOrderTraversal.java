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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null){
            return res;
        }   
        int count = 0;
        int depth = 1;
        ArrayList<Integer> levelArr = new ArrayList<Integer>();      
        int currCount = 1;
        int nextCount = 0;
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.add(root);
        while (qu.size() > 0){
            TreeNode curr = qu.poll();
            levelArr.add(curr.val);
            currCount--;
            
            if (curr.left != null){
                qu.add(curr.left);
                nextCount++;
            }
            if(curr.right != null){
                qu.add(curr.right);
                nextCount++;
            }
            
            if (currCount == 0){
                currCount = nextCount;
                nextCount = 0;
                ArrayList<Integer> temp = new ArrayList<Integer>(levelArr);
                res.add(temp);
                levelArr.clear();
            }
            
        }
        if (levelArr.size() > 0){
            ArrayList<Integer> temp = new ArrayList<Integer>(levelArr);
            res.add(temp);
        }
        
        return res;
    }
}