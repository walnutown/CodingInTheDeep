package linkedin;

import java.util.ArrayList;
import java.util.Iterator;

public class arraylist_iterator {

   /**
    * test the arrayiterator implemented in MyArray
    * compare the results with iterator of ArrayList
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Integer[] arr = new Integer[]{1,2,3,4};
      MyArray<Integer> marr = new MyArray<Integer>(arr);
      Iterator<Integer> it = marr.iterator();
      while (it.hasNext()){
         System.out.println(marr);
         System.out.println(it.next());
         it.remove();
         System.out.println(marr);
         System.out.println("");
      }
      
      ArrayList<Integer> alist = new ArrayList<Integer>();
      alist.add(1);
      alist.add(2);
      alist.add(3);
      alist.add(4);
      Iterator<Integer> it2 = alist.iterator();
      while (it2.hasNext()){
         System.out.println(alist);
         System.out.println(it2.next());
         it2.remove();
         System.out.println(alist);
         System.out.println("");
      }
      
   }

}
