// Accepted, const mem
// devised from ponyma, http://discuss.leetcode.com/questions/282/populating-next-right-pointers-in-each-node-ii
public class Solution {
    public static void connect(TreeLinkNode root) {
      while (root != null) {
         TreeLinkNode next = null;  // the first node of next level
         TreeLinkNode prev = null;   // previous node on the same level
         for (; root!=null; root=root.next) {
            if (next == null)   next = root.left!=null ? root.left : root.right;
            if (root.left != null) {
               if (prev != null)    prev.next = root.left;
               prev = root.left;
            }
            if (root.right != null) {
               if (prev != null)    prev.next = root.right;
               prev = root.right;
            }
         }
         root = next;
      }
   }
}

// Accepted, BFS, not const mem
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