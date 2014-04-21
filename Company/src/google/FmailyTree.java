package google;

import java.util.ArrayList;

public class FmailyTree {

   /*
    * Given a family tree for a few generations for the entire population and two people write a
    * routine that will find out if they are blood related. Siblings are blood related since they
    * have the same parents. Cousins are blood related since one of their parents have the same
    * parents etc. Design the data structure first and then write the routine.
    */

   // http://www.careercup.com/question?id=4812957531766784

   // This is actually a "connected components" problem. The "family tree" is actually a DAG and If
   // two persons belong to the same connected component they are blood relatives.

   class Person {
      String name;
      ArrayList<Person> children;
      Person father;
      Person mother;

      public Person(String name) {
         this.name = name;
      }
      
      public ArrayList<Person> getParents(){
         ArrayList<Person> parents = new ArrayList<Person>();
         parents.add(father);
         parents.add(mother);
         return parents;
      }
      
      // Use BFS to search all parents of this's ancestors and store them
      // in a set. Then BFS search all parents of other's ancestors, once we find
      // that the two share common ancestor, they're blood related
      public boolean isBloodRelative(Person other){
         return false;
      }
   }
}
