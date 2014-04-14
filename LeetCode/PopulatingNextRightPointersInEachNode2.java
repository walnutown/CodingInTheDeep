/*
    Follow up for problem "Populating Next Right Pointers in Each Node".

    What if the given tree could be any binary tree? Would your previous solution still work?

    Note:

    You may only use constant extra space.
    For example,
    Given the following binary tree,
             1
           /  \
          2    3
         / \    \
        4   5    7
    After calling your function, the tree should look like:
             1 -> NULL
           /  \
          2 -> 3 -> NULL
         / \    \
        4-> 5 -> 7 -> NULL
*/

// time: O(n); space: O(1)
// devised from ponyma, http://discuss.leetcode.com/questions/282/populating-next-right-pointers-in-each-node-ii
public class Solution {
    public static void connect(TreeLinkNode root) {
      while (root != null) {
         TreeLinkNode next = null;  // the first node of next level
         TreeLinkNode prev = null;   // previous node on the same level
         while (root!=null){
            if (next == null)   next = root.left!=null ? root.left : root.right;
            if (root.left != null) {
               if (prev != null)    prev.next = root.left;
               prev = root.left;
            }
            if (root.right != null) {
               if (prev != null)    prev.next = root.right;
               prev = root.right;
            }
            root = root.next;
         }
         root = next;
      }
   }
}

// BFS
// time: O(n); space: O(n)
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root==null) return;
        Queue<TreeLinkNode> qu = new LinkedList<TreeLinkNode>();
        qu.add(root);
        int curr_num = 1;
        int next_num = 0;
        while (!qu.isEmpty()){
            TreeLinkNode curr = qu.poll();
            if (curr.left != null){
                qu.add(curr.left);
                next_num++;
            }
            if (curr.right != null){
                qu.add(curr.right);
                next_num++;
            }
            if (--curr_num >= 1)  curr.next = qu.peek();
            if (curr_num == 0){
                curr_num = next_num;
                next_num = 0;
            }
        }
    }
}