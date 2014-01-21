package lib;

import java.util.Set;

public interface Dictionary {
   
   void add(String word);
   
   boolean contains(String word);
   
   void remove(String word);
   
   Set<String> getWords(); 
}
