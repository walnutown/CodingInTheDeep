package lib;

import java.util.Set;

import junit.framework.TestCase;

import org.junit.Test;

public class TrieTests extends TestCase{

   @Override
   protected void setUp() throws Exception {
      super.setUp();
   }

   @Override
   protected void tearDown() throws Exception {
      super.tearDown();
   }

   @Test
   public void testAddUniqueWordsToTrie() {
      Trie dict = new Trie();
      dict.add("good");
      dict.add("goode");
      dict.add("gooda");
      dict.add("banana");
      dict.add("apple");
      Set<String> words = dict.getWords();
      assertTrue(words.contains("good"));
      assertTrue(words.contains("goode"));
      assertTrue(words.contains("gooda"));
      assertTrue(words.contains("banana"));
      assertTrue(words.contains("apple")); 
   }
   
   public void testAddDuolicateWordsToTrie() {
      Trie dict = new Trie();
      dict.add("good");
      dict.add("good");
      dict.add("gooda");
      dict.add("banana");
      dict.add("apple");
      Set<String> words = dict.getWords();
      assertTrue(words.contains("good"));
      assertTrue(words.contains("gooda"));
      assertTrue(words.contains("banana"));
      assertTrue(words.contains("apple"));
      
   }
   
   @Test
   public void testContainsWordInTrie(){
      Trie dict = new Trie();
      dict.add("good");
      assertTrue(dict.contains("good"));
   }
   
   @Test
   public void testNotContainsWordNotInTrie(){
      Trie dict = new Trie();
      dict.add("good");
      assertTrue(!dict.contains("goode"));
      assertTrue(!dict.contains("goo"));
      assertTrue(!dict.contains("abs"));
   }
   
   @Test
   public void testRemoveWordWithMuliChilerenInTrie(){
      Trie dict = new Trie();
      dict.add("good");
      dict.add("goode");
      dict.add("gooda");
      dict.remove("good");
      assertTrue(!dict.contains("good"));
      assertTrue(dict.contains("goode"));
      assertTrue(dict.contains("gooda"));    
   }
   
   @Test
   public void testRemoveWordWithoutChildrenInTrie(){
      Trie dict = new Trie();
      dict.add("good");
      dict.add("goode");
      dict.add("gooda");
      dict.remove("goode");
      assertTrue(dict.contains("good"));
      assertTrue(!dict.contains("goode"));
      assertTrue(dict.contains("gooda")); 
   }
   
   @Test
   public void testRemoveWordNotInTrie(){
      Trie dict = new Trie();
      dict.add("good");
      dict.add("goode");
      dict.add("gooda");
      dict.remove("goodeer");
      assertTrue(dict.contains("good"));
      assertTrue(dict.contains("goode"));
      assertTrue(dict.contains("gooda")); 
   }
}
