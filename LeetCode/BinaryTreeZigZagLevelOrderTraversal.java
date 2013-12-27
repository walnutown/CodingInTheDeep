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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null){
            return res;
        }
        
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.add(root);
        Stack<Integer> arr = new Stack<Integer>();
        int currCount = 1;
        int nextCount = 0;
        int lineCount = 0;
        while(qu.size() > 0){
            TreeNode curr = qu.poll();
            arr.push(curr.val);
            currCount--;
            
            if (curr.left != null){
                qu.add(curr.left);
                nextCount++;
            }
            
            if (curr.right != null){
                qu.add(curr.right);
                nextCount++;
            }
            
            if (currCount == 0){
                currCount = nextCount;
                nextCount = 0;
                lineCount++;
                if (lineCount%2 == 1){
                    res.add(new ArrayList<Integer>(arr));
                }
                else{
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    while(arr.size() > 0){
                        temp.add(arr.pop());
                    }
                    res.add(temp);
                }
                arr.clear();
            }
        }
        return res;
    }
}


// Accepted, Dec 26, two stacks, time complexity is better than the above, becuase we 
// don't have to do extra pops to reverse the list
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