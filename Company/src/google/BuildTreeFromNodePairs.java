package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class BuildTreeFromNodePairs {
   /*
    * Given a set of node pairs, in each pair (x, y), x is parent node, y is child node.
    * Build the B-tree from those node pairs and print it in given format.
    * eg,
    * set: (a,b) (b,c) (a,d) (d,e) (d,f) (d,g)
    * the tree is root = a, root.child = [b, d] ...
    * print format:
    * a
    * [space]b
    * [space][space]c
    * [space]d
    * [space][space]e
    * [space][space]f
    * [space][space]g
    */
   // Sol1
   // Build the B-tree first, then print it
   // In the build step, we maintain a map of label->node, and fill each nodes's children list
   // In the print step, we use a pre-order traversal
   
   // Sol2
   // Actually we don't need to build the tree, use one map<Character, List<Character>>
   
   class BTreeNode {
      char val;
      ArrayList<BTreeNode> children;

      public BTreeNode(char val) {
         this.val = val;
         children = new ArrayList<BTreeNode>();
      }
      
   }

   class Pair {
      char left;
      char right;

      Pair(char left, char right) {
         this.left = left;
         this.right = right;
      }
   }

   public BTreeNode buildTree(Set<Pair> pairs) {
      Map<Character, BTreeNode> nodes = new HashMap<Character, BTreeNode>();
      Set<BTreeNode> hasParent = new HashSet<BTreeNode>();
      for (Pair pair:pairs){
         char parent = pair.left, child = pair.right;
         if (!nodes.containsKey(parent))
            nodes.put(parent, new BTreeNode(parent));
         if (!nodes.containsKey(child))
            nodes.put(child, new BTreeNode(child));
         BTreeNode pNode = nodes.get(parent), cNode = nodes.get(child);
         pNode.children.add(cNode);
         hasParent.add(cNode);
      }
      BTreeNode root = null;
      for (BTreeNode node:nodes.values()){
         if (!hasParent.contains(node))
            root = node;
      }
      return root;
   }
   
   public void printBTree(BTreeNode root){
      preorderTraversal(root, 0);
   }
   
   private void preorderTraversal(BTreeNode root, int dep){
      StringBuilder sb = new StringBuilder();
      for (int i=dep; i>=1; i--)
         sb.append("*");
      sb.append(root.val);
      System.out.println(sb.toString());
      for (BTreeNode child:root.children)
         preorderTraversal(child, dep+1);
   }
   
   @Test
   public void test(){
      Set<Pair> set = new HashSet<Pair>();
      set.add(new Pair('a','b'));
      set.add(new Pair('b','c'));
      set.add(new Pair('a','d'));
      set.add(new Pair('d','e'));
      set.add(new Pair('d','f'));
      set.add(new Pair('d','g'));
      BTreeNode root = buildTree(set);
      printBTree(root);
   }
}
