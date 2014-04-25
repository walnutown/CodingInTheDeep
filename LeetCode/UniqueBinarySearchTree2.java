/*
    Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

    For example,
    Given n = 3, your program should return all 5 unique BST's shown below.

       1         3     3      2      1
        \       /     /      / \      \
         3     2     1      1   3      2
        /     /       \                 \
       2     1         2                 3
    confused what "{1,#,2,3}" means?
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */

// Recursion
// Each time, cut the numbers into 3 halves, [start, i-1], i, [i+1, end], which maps to node.left, node, node.right
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        if (n<=0){
            ArrayList<TreeNode> res = new ArrayList<TreeNode>();
            res.add(null);
            return res;
        }
        return gen(1, n);
    }
    private ArrayList<TreeNode> gen(int start, int end){
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        if (start>end)  return res;
        for (int i=start; i<=end; i++){
            ArrayList<TreeNode> lefts = gen(start, i-1), rights = gen(i+1, end);
            if (lefts.size()==0)    lefts.add(null);
            if (rights.size()==0)   rights.add(null);
            for (TreeNode left:lefts){      // connect right and left child
                for (TreeNode right:rights){
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        return res;
    }
}

// Dynamic Programming
// Maintain a table, dp[i] stores the trees build from array [1..i]
// Each time, for the left subtree, we can use dp[i-1] directly, yet for the right subtree, we need to build
// trees from the array[i+1,j], which is actually array[1...i-j]+ j
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        Map<Integer, ArrayList<TreeNode>> dp = new HashMap<Integer, ArrayList<TreeNode>>();
        dp.put(0, new ArrayList<TreeNode>()); dp.get(0).add(null);
        if (n<=0)   return dp.get(0);
        dp.put(1, new ArrayList<TreeNode>()); dp.get(1).add(new TreeNode(1));
        for (int i=2; i<=n; i++){
            dp.put(i, new ArrayList<TreeNode>());
            for (int j=1; j<=i; j++){
                for (TreeNode left : dp.get(j-1)){
                    for (TreeNode right : dp.get(i-j)){
                        TreeNode root = new TreeNode(j);
                        root.left = left;
                        root.right = genNode(right, j);     // if right subtree, need to add increment to ndoe val
                        dp.get(i).add(root);
                    }
                }
            }
        }
        return dp.get(n);
    }
    // generate right subtree nodes using DFS
    public TreeNode genNode(TreeNode n, int inc){
        if (n==null)    return null;
        TreeNode res = new TreeNode(n.val+inc);
        res.left = genNode(n.left, inc);
        res.right = genNode(n.right, inc);
        return res;
    }   
}

