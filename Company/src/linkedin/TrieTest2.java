package linkedin;

import lib.Trie;

public class TrieTest2 {

   /**
    * @param args
    */
   public static void main(String[] args) {
      Trie dict = new Trie();
      dict.add("apple");
      dict.add("google");
      System.out.println(dict.getWords().toString());
      dict.add("good");
      dict.add("goode");
      dict.add("gooda");
      dict.add("banana");
      System.out.println(dict.getWords().toString());
      System.out.println("good: " + dict.contains("good"));
      System.out.println("goo: " + dict.contains("goo"));
      dict.remove("good");
      System.out.println(dict.getWords().toString());
      System.out.println("gooda: " + dict.contains("gooda"));
      dict.remove("gooda");
      dict.remove("googleer");
      System.out.println(dict.getWords().toString());
      System.out.println("gooda: " + dict.contains("gooda"));
      System.out.println("goode: " + dict.contains("goode"));
      System.out.println("googleer: " + dict.contains("googleer"));
   }

}
