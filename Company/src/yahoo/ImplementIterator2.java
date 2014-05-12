package yahoo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

public class ImplementIterator2 {
   /**
    * Implement an iterator of a collection of collections
    */

   public class DeepItr<E> implements Iterator<E> {

      private Iterator<? extends Collection<E>> itr;
      private Iterator<E> innerItr;

      public DeepItr(Collection<? extends Collection<E>> collections) {
         itr = collections.iterator();
      }

      @Override
      public boolean hasNext() {
         while (innerItr == null || !innerItr.hasNext()) {
            if (itr.hasNext()) {
               innerItr = itr.next().iterator();
            } else
               return false;
         }
         return true;
      }

      @Override
      public E next() {
         if (!hasNext())
            throw new NoSuchElementException();
         return innerItr.next();
      }

      @Override
      public void remove() {
         // TODO Auto-generated method stub
      }
   }

   @Test
   public void test() {
      ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
      for (int i = 0; i < 5; i++) {
         lists.add(new ArrayList<Integer>());
         for (int j=0; j<i+1; j++)
            lists.get(i).add(j);
      }
      System.out.println(lists.toString());
      DeepItr<Integer> itr = new DeepItr<Integer>(lists);
      while (itr.hasNext())
         System.out.print(itr.next()+ ", ");

   }
}
