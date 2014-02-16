package lib;

import java.util.Comparator;

/**
 * Implement a binary heap
 * 
 * Ref:
 *  http://courses.cs.washington.edu/courses/cse373/11wi/homework/5/BinaryHeap.java
 */
public class BinaryHeap<E> {
   private static final int DEFAULT_INITIAL_CAPACITY = 11;
   private Object[] queue;
   private int size = 0;
   private Comparator<? super E> comparator;
   
   public PriorityQueue(int initialCapacity, Comparator<? super E> comparator){
      if (initialCapacity < 1)
         throw new IllegalArgumentException();
      this.queue = new Object[initialCapacity];
      this.comparator = comparator;
   }
   
   // increases the capacity of the array
   private void grow(int minCapacity){
      if (minCapacity < 0) // overflow
         throw new OutOfMemoryError();
      int oldCapacity = queue.length;
      
   }
   
}
