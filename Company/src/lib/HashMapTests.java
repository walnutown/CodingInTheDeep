package lib;

import static org.junit.Assert.*;

import org.junit.Test;

public class HashMapTests {

   @Test
   public void testPutToMap() {
      HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
      map.put(1, 10);
      assertTrue(map.containsKey(1));
      assertTrue(map.size()==1);
   }
   
   @Test
   public void testResizeHashMap(){
      HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
      assertTrue(map.capacity()==map.DEFAULT_INITIAL_CAPACITY);
      for (int i=0; i<20; i++){
         map.put(i, i+1);
      }
      assertTrue(map.capacity()==map.DEFAULT_INITIAL_CAPACITY*2);
   }
   
   @Test
   public void testGetFromMap(){
      HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
      map.put(1, 10);
      assertTrue(map.get(1)==10);
   }
   
   @Test
   public void testRemoveFromMap(){
      HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
      map.put(1, 10);
      assertTrue(map.containsKey(1));
      map.remove(1);
      assertTrue(!map.containsKey(1));
   }

}
