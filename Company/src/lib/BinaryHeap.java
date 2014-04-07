package lib;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Implement a binary min heap
 * 
 * Ref:
 * http://courses.cs.washington.edu/courses/cse373/11wi/homework/5/BinaryHeap.java
 */
public class BinaryHeap<E> {
   private static final int DEFAULT_INITIAL_CAPACITY = 11;
   private Object[] queue;
   private int size = 0;
   private Comparator<? super E> comparator;

   public BinaryHeap() {
      this(DEFAULT_INITIAL_CAPACITY, null);
   }

   public BinaryHeap(int initialCapacity, Comparator<? super E> comparator) {
      if (initialCapacity < 1)
         throw new IllegalArgumentException();
      this.queue = new Object[initialCapacity];
      this.comparator = comparator;
   }

   // increases the capacity of the array
   private void grow(int minCapacity) {
      if (minCapacity < 0) // overflow
         throw new OutOfMemoryError();
      int oldCapacity = queue.length;
      // Double size if small; else grow by 50%
      int newCapacity = (oldCapacity < 64 ? (oldCapacity + 1) * 2 : (oldCapacity / 2) * 3);
      if (newCapacity < 0)  // overflow
         newCapacity = Integer.MAX_VALUE;
      if (newCapacity < minCapacity)
         newCapacity = minCapacity;
      queue = Arrays.copyOf(queue, newCapacity);
   }

   // inserts the specified element into this priority queue
   public boolean offer(E e) {
      if (e == null) // not support null
         throw new NullPointerException();
      int i = size;
      if (i >= queue.length)
         grow(i + 1);
      size = i + 1;
      if (i == 0)
         queue[0] = e;
      else
         siftUp(i, e);
      return true;
   }

   public boolean add(E e) {
      return offer(e);
   }

   public E peek() {
      if (size == 0)
         return null;
      return (E) queue[0];
   }

   public E poll() {
      if (size == 0)
         return null;
      int s = --size;
      E result = (E) queue[0];
      E x = (E) queue[s];
      queue[s] = null;
      if (s != 0)
         siftDown(0, x);
      return result;
   }

   /*-------------------------Helper Functions---------------------------------*/
   private void siftUp(int k, E x) {
      if (comparator != null)
         siftUpUsingComparator(k, x);
      else
         siftUpComparable(k, x);
   }

   private void siftUpComparable(int k, E x) {
      Comparable<? super E> key = (Comparable<? super E>) x;
      while (k > 0) {
         int parent = (k - 1) >>> 1; // unsigned right shift operator
         Object e = queue[parent];
         if (key.compareTo((E) e) >= 0)
            break;
         queue[k] = e;
         k = parent;
      }
      queue[k] = key;
   }

   private void siftUpUsingComparator(int k, E x) {
      while (k > 0) {
         int parent = (k - 1) >>> 1;
         Object e = queue[parent];
         if (comparator.compare(x, (E) e) >= 0)
            break;
         queue[k] = e;
         k = parent;
      }
      queue[k] = x;
   }

   private void siftDown(int k, E x) {
      if (comparator != null)
         siftDownUsingComparator(k, x);
      else
         siftDownComparable(k, x);
   }

   private void siftDownComparable(int k, E x) {
      Comparable<? super E> key = (Comparable<? super E>) x;
      int half = size >>> 1; // loop while a non-leaf
      while (k < half) {
         int child = (k << 1) + 1; // assume left child is least
         Object c = queue[child];
         int right = child + 1;
         if (right < size && ((Comparable<? super E>) c).compareTo((E) queue[right]) > 0)
            c = queue[child = right];
         if (key.compareTo((E) c) <= 0)
            break;
         queue[k] = c;
         k = child;
      }
      queue[k] = key;
   }

   private void siftDownUsingComparator(int k, E x) {
      int half = size >>> 1;
      while (k < half) {
         int child = (k << 1) + 1;
         Object c = queue[child];
         int right = child + 1;
         if (right < size && comparator.compare((E) c, (E) queue[right]) > 0)
            c = queue[child = right];
         if (comparator.compare(x, (E) c) <= 0)
            break;
         queue[k] = c;
         k = child;
      }
      queue[k] = x;
   }

   /*
    * Returns an array containing all of the elements in this queue. The elements are in no
    * particular order.
    * The returned array will be "safe" in that no references to it are maintained by this queue.
    * (In other words, this method must allocate a new array). The caller is thus free to modify the
    * returned array.
    * This method acts as bridge between array-based and collection-based APIs.
    */
   public Object[] toArray() {
      return Arrays.copyOf(queue, size);
   }

   /*
    * Returns an array containing all of the elements in this queue; the runtime type of the
    * returned array is that of the specified array. The returned array elements are in no
    * particular order. If the queue fits in the specified array, it is returned therein. Otherwise,
    * a new array is allocated with the runtime type of the specified array and the size of this
    * queue.
    * If the queue fits in the specified array with room to spare (i.e., the array has more elements
    * than the queue), the element in the array immediately following the end of the collection is
    * set to null.
    * Like the toArray() method, this method acts as bridge between array-based and collection-based
    * APIs. Further, this method allows precise control over the runtime type of the output array,
    * and may, under certain circumstances, be used to save allocation costs.
    * Suppose x is a queue known to contain only strings. The following code can be used to dump the
    * queue into a newly allocated array of String:
    * String[] y = x.toArray(new String[0]);
    * Note that toArray(new Object[0]) is identical in function to toArray().
    */
   public <T> T[] toArray(T[] a) {
      if (a.length < size)
         // Make a new array of a's runtime type, but my contents:
         return (T[]) Arrays.copyOf(queue, size, a.getClass());
      System.arraycopy(queue, 0, a, 0, size);
      if (a.length > size)
         a[size] = null;
      return a;
   }
}
