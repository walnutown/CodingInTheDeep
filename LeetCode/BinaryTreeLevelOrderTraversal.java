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


// #2 trial
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
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.add(root);
        ArrayList<Integer> row = new ArrayList<Integer>();
        int currNum = 1;
        int nextNum = 0;
        while (qu.size() > 0){
            TreeNode curr = qu.poll();
            row.add(curr.val);
            currNum--;
            if (curr.left != null){
                qu.add(curr.left);
                nextNum++;
            }
            if (curr.right != null){
                qu.add(curr.right);
                nextNum++;
            }
            if (currNum == 0){
                currNum = nextNum;
                nextNum = 0;
                res.add(new ArrayList<Integer>(row));
                row.clear();
            }
        }
        return res;
    }
}



// Accepted, Dec 24, same as CTCI ch4_4
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return res;
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.add(root);
        int curr_num = 1, next_num = 0;
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
            if (--curr_num == 0){           // refactor here
                curr_num = next_num;
                next_num = 0;
                res.add(new ArrayList<Integer>(r));
                r.clear();
            }
        }
        return res;
    }
}