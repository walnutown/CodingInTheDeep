package google;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

public class ImplementIterator {
   /*
    * Given a Collection class, implement its iterator
    */

   /*
    * interface Iterator<E>{
    * boolean hasNext();
    * E next();
    * void remove();
    * }
    */

   // create an arrayList class implementing iterable interface
   public class Arraylist<E> implements Iterable<E> {
      Object[] elements;
      int size;

      public Arraylist(int initialCapactiy){
         elements = new Object[initialCapactiy];
         size = 0;
      }
      
      public Arraylist(){
         this(10);
      }
      
      public Arraylist(Collection<? extends E> c){
         elements = c.toArray();
         size = elements.length;
      }

      /*
       * Implement iterator for Arraylist
       */
      public class Itr<E> implements Iterator<E> {
         int cursor;                // index of next element to return
         int lastRet = -1;          // index of last element returned; -1 if no such element
         @Override
         public boolean hasNext() {
            return cursor < size;
         }

         @Override
         public E next() {
            if (!hasNext())
               throw new NoSuchElementException();
            lastRet = cursor;
            E ret = (E) elements[cursor++];
            return ret;
         }

         /**
          * Removes from the underlying collection the last element returned by this iterator.
          * This method can be called only once per call to next(). The behavior of an iterator
          * is unspecified if the underlying collection is modified while the iteration is in
          * progress in any way other than by calling this method.
          * 
          * Throws: java.lang.IllegalStateException if the next method has not yet been called,
          * or the remove method has already been called after the last call to the next method.
          */
         // v denote the position of iterator
         // 1, v 2,3 -> 2,3
         // 1,2,v,3 -> 1,3
         @Override
         public void remove() {
            if (lastRet<0)
               throw new IllegalStateException();
            System.arraycopy(elements, cursor, elements, cursor - 1, size - cursor);// copy array, overwrite the cursor-1
            cursor = lastRet;
            size--;
            lastRet = -1;
         }
      }

      public String toString() {
         StringBuilder sb = new StringBuilder();
         sb.append("[");
         for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            sb.append(" ");
         }
         if (sb.length() > 1)
            sb.deleteCharAt(sb.length() - 1);
         sb.append("]");
         return sb.toString();
      }

      @Override
      public Iterator<E> iterator() {
         return new Itr<E>();
      }
   }
   
   @Test
   public void testIteratorNext(){
      ArrayList<Integer> A = new ArrayList<Integer>();
      for (int i=0; i<10; i++)
         A.add(i);
      Arraylist<Integer> a = new Arraylist<Integer>(A);
      Iterator<Integer> itr = a.iterator();
      while (itr.hasNext()){
         System.out.println(itr.next());
      }
   }
   
   @Test (expected = IllegalStateException.class)
   public void testIteratorInvalidRemove(){
      ArrayList<Integer> A = new ArrayList<Integer>();
      for (int i=0; i<10; i++)
         A.add(i);
      Arraylist<Integer> a = new Arraylist<Integer>(A);
      Iterator<Integer> itr = a.iterator();
      itr.remove();
   }
   
   @Test
   public void testIteratorValidRemove(){
      ArrayList<Integer> A = new ArrayList<Integer>();
      for (int i=0; i<10; i++)
         A.add(i);
      Arraylist<Integer> a = new Arraylist<Integer>(A);
      System.out.println(a);
      Iterator<Integer> itr = a.iterator();
      if (itr.hasNext()){
         itr.next();
         itr.remove();
         System.out.println(a);
      }
   }

}
