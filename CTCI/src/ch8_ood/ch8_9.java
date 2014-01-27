package ch8_ood;

import java.util.Map;

/**
 * 
 * Explain the data structure and algorithms 
 * that you would use to design an in-memory file system.
 *
 */

// use tree structure, like tire implementation
public class ch8_9 {
   public abstract class Node{
      protected Node parent;
      protected long created;
      protected long lastUpdated;
      protected long lastAccessed;
      protected String name;
      protected Map<String, Node> children;
      protected Type type;
      
      public Node(){}
      
      public abstract int size();
      
      public abstract boolean has(String filename);
      
      public abstract boolean remove(String filename);
      
      public abstract boolean create(String filename);
      
      // soft link file src and dst
      // find the node and put the filenam-node pair into the map
      public abstract boolean link(String src, String dst);
   }
   
   public enum Type{
      Directory, File
   }
}
