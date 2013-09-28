// BFS
// recursion as follow 
// http://fisherlei.blogspot.com/2012/12/leetcode-populating-next-right-pointers.html
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

// #2, BFS, actually not constant mem
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
        while(qu.size() > 0){
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
                currNum = nextNum;
                nextNum = 0;
            }
            else
                curr.next = qu.peek();
        }
    }
}

// http://discuss.leetcode.com/questions/7/populating-next-right-pointers-in-each-node
// constant mem, effeciently use the next pointer
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null)
            return;
        TreeLinkNode levelHead = root;
        while (levelHead != null){
            TreeLinkNode p = levelHead;
            while (p != null){
                if (p.left != null){
                    p.left.next = p.right;
                    if (p.next != null)
                        p.right.next = p.next.left;
                }
                p = p.next;
            }
            levelHead = levelHead.left;
        }
    }
}
