package lib;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryHeapTests {

   @Test
   public void testAddElement() {
      int[] arr_expected = new int[]{0,3,4,5,6,7,8};
      BinaryHeap<Integer> heap = new BinaryHeap<Integer>();
      heap.add(0);
      heap.add(5);
      heap.add(7);
      heap.add(3);
      heap.add(6);
      heap.add(4);
      heap.add(8);
      Integer[] arr_actual = heap.toArray(new Integer[0]);
      assertTrue(isSameArray(arr_actual, arr_expected));
   }
   
   public boolean isSameArray(Integer[] arr_actual, int[] arr_expected){
      for (int i=0; i<arr_expected.length; i++){
         if (arr_actual[i] != arr_expected[i])
            return false;
      }
      return true;
   }
   
   @Test
   public void testPollElement(){
      BinaryHeap<Integer> heap = new BinaryHeap<Integer>();
      heap.add(0);
      heap.add(5);
      heap.add(7);
      heap.add(3);
      heap.add(6);
      heap.add(4);
      heap.add(8);
      assertTrue(isSameArray(heap.toArray(new Integer[0]), new int[]{0,3,4,5,6,7,8}));
      assertTrue(heap.poll()==0);
      assertTrue(isSameArray(heap.toArray(new Integer[0]), new int[]{3,5,4,8,6,7}));
      assertTrue(heap.poll()==3);
      assertTrue(isSameArray(heap.toArray(new Integer[0]), new int[]{4,5,7,8,6}));
      assertTrue(heap.poll()==4);
      assertTrue(isSameArray(heap.toArray(new Integer[0]), new int[]{5,6,7,8}));
      assertTrue(heap.poll()==5);
      assertTrue(isSameArray(heap.toArray(new Integer[0]), new int[]{6,8,7}));
      assertTrue(heap.poll()==6);
      assertTrue(isSameArray(heap.toArray(new Integer[0]), new int[]{7,8}));
      assertTrue(heap.poll()==7);
      assertTrue(isSameArray(heap.toArray(new Integer[0]), new int[]{8}));
      
   }

}
