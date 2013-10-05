// BFS, smae as populate_1
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null){
            return;
        }
        
        Queue<TreeLinkNode> qu = new LinkedList<TreeLinkNode>();
        qu.add(root);
        int currCount = 1;
        int nextCount = 0;
        
        while(qu.size() > 0){
            TreeLinkNode curr = qu.poll();
            currCount--;
            // -_-|....... curr.left, not root.left, wrong again!!!!
            if (curr.left != null){
                qu.add(curr.left);
                nextCount++;
            }
            if (curr.right != null){
                qu.add(curr.right);
                nextCount++;
            }
            if (currCount == 0){
                curr.next = null;
                currCount = nextCount;
                nextCount = 0;
            }
            else if (currCount > 0){
                TreeLinkNode next = qu.peek();
                curr.next = next;
            }
        }
    }
}


// #2 trial
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null)
            return;
        Queue<TreeLinkNode> qu = new LinkedList<TreeLinkNode>();
        qu.add(root);
        int currNum = 1;
        int nextNum = 0;
        while (qu.size() > 0){
            TreeLinkNode curr = qu.poll();
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
                curr.next = null;
                currNum = nextNum;
                nextNum = 0;
            }
            else{
                curr.next = qu.peek();
            }
        }
    }
}


// see const mem here, http://discuss.leetcode.com/questions/282/populating-next-right-pointers-in-each-node-ii


public static void connect(TreeLinkNode root) {
      // Start typing your Java solution below
      // DO NOT write main() function
      while (root != null) {
         TreeLinkNode next = null;
         TreeLinkNode pre = null;
         for (; root != null; root = root.next) {
            if (next == null)
               next = root.left != null ? root.left : root.right;
            if (root.left != null) {
               if (pre != null)
                  pre.next = root.left;
               pre = root.left;
            }
            if (root.right != null) {
               if (pre != null)
                  pre.next = root.right;
               pre = root.right;
            }
         }
         root = next;
      }
   }