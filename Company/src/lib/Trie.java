package lib;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Trie is a prefix tree
 */
// the most challenging part is how to deal with the case: good, goody.
// That's why we need the 'isEnd' flag
public class Trie {
   private TrieNode root;

   public Trie() {
      root = new TrieNode('.');
   }

   public void add(String word) {
      root.add(word);
   }

   public boolean contains(String word) {
      return root.contains(word);
   }

   public void remove(String word) {
      root.remove(word);
   }

   public Set<String> getWords() {
      return root.getSuffix();
   }
   // use a map to store children with different initial characters
   // use isEnd to mark a whole word
   private class TrieNode {
      private Map<Character, TrieNode> children;
      private char value;
      private boolean isEnd;

      TrieNode(char value) {
         this.value = value;
         children = new HashMap<Character, TrieNode>();
         isEnd = false;
      }

      public boolean hasChildren() {
         return !children.isEmpty();
      }

      public void add(String word) {
         if (word == null || word.length() == 0) {
            this.isEnd = true;
            return;
         }
         char ch = word.charAt(0);
         if (!children.containsKey(ch))
            children.put(ch, new TrieNode(ch));
         children.get(ch).add(word.substring(1));
      }

      public boolean contains(String word) {
         if (word == null || word.length() == 0)
            return isEnd;
         char ch = word.charAt(0);
         if (!children.containsKey(ch))
            return false;
         TrieNode child = children.get(ch);
         if (word.length() == 1 && child.isEnd)
            return true;
         return child.contains(word.substring(1));
      }

      // this method can be optimized
      public void remove(String word) {
         if (word == null || word.length() == 0)
            return;
         if (!this.contains(word))
            return;
         char ch = word.charAt(0);
         TrieNode child = children.get(ch);
         if (child.isEnd && word.length() == 1) {
            child.isEnd = false;
         }
         if (!child.hasChildren() || child.getSuffix().size() <= 1)
            children.remove(ch);
         else
            child.remove(word.substring(1));
      }

      public Set<String> getSuffix() {
         Set<String> suffix = new HashSet<String>();
         if (!this.hasChildren())
            return null;
         for (char ch : children.keySet()) {
            TrieNode child = children.get(ch);
            if (!child.hasChildren()) {
               suffix.add(ch + "");
            } else {
               for (String s : child.getSuffix()) {
                  suffix.add(ch + s);
               }
            }
            if (isEnd)
               suffix.add(""); // the word is part of another word. e.g., good and goody
         }
         return suffix;
      }

      public String toString() {
         return "" + value;
      }
   }
}
