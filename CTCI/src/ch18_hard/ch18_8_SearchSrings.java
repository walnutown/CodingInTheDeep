package ch18_hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class ch18_8_SearchSrings {

   /**
    * Given a string S and an array of smaller strings T, design a method to search S for each small
    * string in T
    */

   // http://www.geeksforgeeks.org/pattern-searching-set-8-suffix-tree-introduction/
   // http://www.allisons.org/ll/AlgDS/Tree/Suffix/
   
   // There're n(n+1)/2 substrings in a string, so, it's rather surprising that a suffix tree can be
   // built in O(n) time
   
   // Similar to Leetcode/ImplementStrStr,
   // The difference lies that, we only need to call StrStr() once in Leetcode/ImplementStrStr
   // but in this question, we have to call StrStr() multiple times for each word. So, we use different
   // approaches.
   
   // use suffix tree, here we didn't use the build method of O(n) running time
   // O(n^2) time to build the suffix tree, O(m) time to search for the string pattern

   public class SuffixTree {
      SuffixTreeNode root;

      public SuffixTree() {
         root = new SuffixTreeNode('0');
      }
      
      public SuffixTree(String s){
         root = new SuffixTreeNode('0');
         build(s);
      }

      // insert each suffix into the suffix tree
      // O(n^2), n is the length of s
      private void build(String s) {
         for (int i = 0; i < s.length(); i++) { 
            root.insertSuffix(s.substring(i), i);
         }
      }

      // O(n), n is the length of s
      public ArrayList<Integer> search(String s) {
         return root.search(s);
      }
   }

   public class SuffixTreeNode {
      Map<Character, SuffixTreeNode> children = new HashMap<Character, SuffixTreeNode>();
      char value;
      ArrayList<Integer> indices = new ArrayList<Integer>();

      public SuffixTreeNode(char value) {
         this.value = value;
      }

      public void insertSuffix(String s, int index) {
         if (s == null || s.length() == 0)
            return;
         indices.add(index);
         char v = s.charAt(0);
         if (!children.containsKey(v)) {
            SuffixTreeNode child = new SuffixTreeNode(v);
            children.put(v, child);
         }
         children.get(v).insertSuffix(s.substring(1), index);
      }

      public ArrayList<Integer> search(String s) {
         if (s == null || s.length() == 0)
            return indices;
         char v = s.charAt(0);
         if (children.containsKey(v))
            return children.get(v).search(s.substring(1));
         return null;
      }
   }

   @Test
   public void test() {
      String testString = "mississippi";
      String[] stringList = { "is", "sip", "hi", "sis" };
      SuffixTree tree = new SuffixTree(testString);
      for (String s : stringList) {
         ArrayList<Integer> list = tree.search(s);
         if (list != null) {
            System.out.println(s + ": " + list.toString());
         }
      }
   }

}
