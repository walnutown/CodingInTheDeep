package facebook;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import lib.TreeNode;

import org.junit.Test;

public class PrintBinaryTreeInColumnOrder {
   /*
    * Print arbitrary binary tree by vertical levels / columns from left to right
      example tree

            a
           / \
          b   c
         / \   \
        d   g   z
         \     /
          e   i
             /
            q
           /
          x
         /
        x1
      /
      x2


      sample output

      x2
      d x1
      b e x
      a g q
      c i
    */
     
   
   // Maintain a map<columnNumber, List<Node>>
   // each time, when we visit the left child, decrement the key;
   // when we visit the right child, increment the key
   // Note we need a treeMap here, as HashMap doesn't provide in-order iteration
   // time: O(n); space: O(n)
    public ArrayList<ArrayList<Integer>> printBinaryTreeInColumnOrder(TreeNode root){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root==null)
          return res;
        Map<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
        dfs(root, 0, map);
        for (ArrayList<Integer> r: map.values())
          res.add(r);
        return res;
    }

    private void dfs(TreeNode node, int key, Map<Integer,ArrayList<Integer>> map){
        if (node==null)
          return;
        if (!map.containsKey(key)){
          ArrayList<Integer> r = new ArrayList<Integer>();
          map.put(key, r);
        }
        map.get(key).add(node.val);
        dfs(node.left, key-1, map);
        dfs(node.right, key+1, map);
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(7);
        root.right.right.left.left = new TreeNode(8);
        root.right.right.left.left.left = new TreeNode(9);
        System.out.println(root.printTree());
        ArrayList<ArrayList<Integer>> res = printBinaryTreeInColumnOrder(root);
        for (ArrayList<Integer> r : res)
          System.out.println(r);
    }
}
