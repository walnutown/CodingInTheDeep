package ch18_hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


public class ch18_8_LocateSubstrings {

   /**
    * Given a string s and an array of smaller strings T, design a method to search s for each small
    * string in T
    */
   
   // use suffix tree
   // think of leetcode-- ImplementStrStr, only need to call the search method once 
   // in this question, call the search method multiple times. So, we use different approaches.
   @Test
   public void test() {
      String testString = "mississippi";
      String[] stringList = {"is", "sip", "hi", "sis"};
      SuffixTree tree = new SuffixTree();
      tree.build(testString);
      for (String s : stringList) {
          ArrayList<Integer> list = tree.search(s);
          if (list != null) {
              System.out.println(s + ": " + list.toString());
          }
      }
   }

   public class SuffixTree {
      SuffixTreeNode root; 
      public SuffixTree(){
         root = new SuffixTreeNode('0');
      }
      // O(n!), n is the length of s
      public void build(String s){
         for (int i=0; i<s.length(); i++){
            root.insertString(s.substring(i), i);
         }
      }
      // O(n), n is the length of s
      public ArrayList<Integer> search(String s){
         return root.search(s);
      }
   }

   public class SuffixTreeNode {
      Map<Character, SuffixTreeNode> children = new HashMap<Character, SuffixTreeNode>();
      char value;
      ArrayList<Integer> indexes = new ArrayList<Integer>();

      public SuffixTreeNode(char value) {
         this.value = value;
      }

      public void insertString(String s, int index) {
         if (s == null || s.length() == 0)
            return;
         indexes.add(index);
         char v = s.charAt(0);
         if (!children.containsKey(v)) {
            SuffixTreeNode child = new SuffixTreeNode(v);
            children.put(v, child);
         }
         children.get(v).insertString(s.substring(1), index);
      }

      public ArrayList<Integer> search(String s) {
         if (s == null || s.length() == 0)
            return indexes;
         char v = s.charAt(0);
         if (children.containsKey(v))
            return children.get(v).search(s.substring(1));
         return null;
      }
   }

}
