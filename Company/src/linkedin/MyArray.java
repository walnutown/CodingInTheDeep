package linkedin;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

// create an array class implementing iterable interface
public class MyArray<E> implements Iterable<E>{
   E[] arr;
   int length;
   
   public MyArray(E[] arr){
      this.arr = arr;
      this.length = arr.length;
   }
   
   @Override
   public Iterator<E> iterator() {
      return new ArrayIterator<E>();
   }
   
   /*
    * Implement iterator for MyArray
    */
   public class ArrayIterator<E> implements Iterator<E>{
      int index = 0;
      boolean can_remove = false;
      
      @Override
      public boolean hasNext() {   
         return index < length;
      }

      @Override
      public E next() {
         if (!hasNext())
            throw new NoSuchElementException();
         E res = (E)arr[index++];
         can_remove = true;
         return res;
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
         if (!can_remove)
            throw new IllegalStateException();
         System.arraycopy(arr, index, arr, index-1, length-index);
         index--;   // important here to decrease index and length
         length--;
         can_remove = false;
      }    
   }
   
   public String toString(){
      StringBuilder sb = new StringBuilder();
      sb.append("[");
      for (int i = 0; i < length; i++){
         sb.append(arr[i]);
         sb.append(" ");
      }
      if (sb.length() > 1)
         sb.deleteCharAt(sb.length()-1);
      sb.append("]");
      return sb.toString();
   }
   
}
