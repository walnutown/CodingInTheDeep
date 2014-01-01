// E.g. Given [1, 4, 3, 2, 5], which two shall we swap to fix the array?
// One way is starting from the second element in the list and comparing it with its previous one. If it is smaller than its previous one, then we know at least one of the two is in wrong spot. So, the larger one in the first pair and the smaller one in the second pair are the ones we are looking for.

// But, how about [1, 3, 2, 4, 5]?
// This tells us that if there is only one such pair where the latter one is greater than the previous one. That pair is actually the two element we are looking for.




// inorder traversal, DFS version
public class Solution {
    ArrayList<TreeNode> swap;
    TreeNode prev;
    
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            return;
        }
        
        prev = null;
        swap = new ArrayList<TreeNode>();
        
        inorderTraversal(root);  
        
        // swap the node value
        // two swapped nodes are the first and last lement of the arraylsit
            int m = swap.get(0).val;
            swap.get(0).val = swap.get(swap.size()-1).val;
            swap.get(swap.size()-1).val = m;
    } 
    
    public void inorderTraversal(TreeNode node){
        if (node == null){
            return;
        }
        inorderTraversal(node.left);
        if (prev != null && prev.val >= node.val){
               swap.add(prev);
               swap.add(node);
        } 
        prev = node;
        inorderTraversal(node.right);
    }
    
}



public static void inMorrisTraversal2(TreeNode root){
        if(root == null) return;
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur!=null){
            //没有左后代，访问当前节点，跳到右节点
            if(cur.left==null){
                System.out.println(cur.val+" ");
                cur = cur.right;
            }else{
                pre = cur.left;
                while(pre.right!=null && pre.right!=cur){
                    pre = pre.right;
                }//pre 左后代最右叶子节点 指向当前节点, 跳到左后代
                //表示当前节点的左子树未访问
                if(pre.right == null){
                    pre.right = cur;
                    cur = cur.left;
                }else{//先输出当前再移向右子树
                    pre.right = null;
                    System.out.println(cur.val + " ");
                    cur = cur.right;
                }
            }
        }
        System.out.println();
    }
    // root left right
    public static void preMorrisTraversal(TreeNode root){
        if(root == null) return;
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur!=null){
            //无左后代,访问当前节点，
            if(cur.left == null){
                System.out.println(cur.val +" ");
                cur= cur.right;
            }else{
                pre = cur.left;
                while(pre.right!=null && pre.right!= cur){
                    pre = pre.right;
                }
                //左后代的最右子节点指向当前节点
                if(pre.right == null){//先输出当前再移向左子树
                    pre.right = cur;
                    System.out.println(cur.val + " ");
                    cur = cur.left;
                }else{
                    pre. right = null;
                    cur = cur.right;
                }
            }
        }
        System.out.println();
    }
    // left right root
    public static void postMorrisTraversal(TreeNode root){
        if(root == null) return;
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur!=null){
            if(cur.left== null){
                cur = cur.right;
            }else{
                pre = cur.left;
                while(pre.right!=null && pre.right!=cur){
                    pre = pre.right;
                }
                if(pre.right==null){
                    pre.right = cur;
                    cur = cur.left;
                    System.out.println(cur.val +" ");
                }else{
                    pre.right = null;
                    cur = cur.right;
                    System.out.println(cur.val +" ");
                }
            }
        }
        
    }

// Accepted, Inorder traversal, iterative version
public class Solution {
    public void recoverTree(TreeNode root) {
       if (root==null)  return;
       TreeNode[] nodes = new TreeNode[2];
       Stack<TreeNode>  st = new Stack<TreeNode>();
       TreeNode prev = null;
       while (root != null){
           st.push(root);
           root = root.left;
       }
       while (!st.isEmpty()){
           TreeNode curr = st.pop();
           if (prev != null && prev.val > curr.val){
               if (nodes[0]==null){
                   nodes[0] = prev;
                   nodes[1] = curr;
               }else{
                   nodes[1] = curr;
               }
           }
           prev = curr;
           curr = curr.right;
           while (curr != null){
               st.push(curr);
               curr = curr.left;
           }
       }
       int tmp = nodes[0].val;
       nodes[0].val = nodes[1].val;
       nodes[1].val = tmp;
    }
}
// Accepted, arraylsit version, the two wsapped nodes are hte first and last node in the arraylsit
// no matter there're two pairs or just one pair of swapped nodes
public class Solution {
    public void recoverTree(TreeNode root) {
       if (root==null)  return;
       ArrayList<TreeNode>  nodes = new ArrayList<TreeNode>();
       Stack<TreeNode>  st = new Stack<TreeNode>();
       TreeNode prev = null;
       while (root != null){
           st.push(root);
           root = root.left;
       }
       while (!st.isEmpty()){
           TreeNode curr = st.pop();
           if (prev != null && prev.val > curr.val){
               nodes.add(prev);
               nodes.add(curr);
           }
           prev = curr;
           curr = curr.right;
           while (curr != null){
               st.push(curr);
               curr = curr.left;
           }
       }
       int tmp = nodes.get(0).val;
       nodes.get(0).val = nodes.get(nodes.size()-1).val;
       nodes.get(nodes.size()-1).val = tmp;
    }
}
