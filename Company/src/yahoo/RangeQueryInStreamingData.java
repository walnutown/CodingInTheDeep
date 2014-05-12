package yahoo;

public class RangeQueryInStreamingData {
   /**
    * Given continuous data stream , design data structure to return 15 min stock information
    */

   // The basic idea is to use a queue, because we need a FIFO data structure here. The problem lies
   // in the implementation we choose.
   // LinkedList is an option, yet it doesn't support O(1) random access, which is needed when we
   // calculate median of the data.
   // Another option is a normal array. We have an array of fixed size, and every time we remove the 
   // first element in array, left shift all remaining elements and add new element to the end of the
   // array, which takes O(n) time.
   // The best solution I can think of is to use ArrayDeque, it provides constant time for addFirst(),
   // addLast(), removeFirst() and allows O(1) random access.
   // The core mechanism of ArrayDeque is Circular Buffer. 
   // http://www.cs.wcupa.edu/rkline/ds/deque-stack-algorithms.html
}
