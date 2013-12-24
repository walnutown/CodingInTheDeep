package ch3_stacks_queues;

import java.util.Random;

public class ch3_2 {

   /**
    * How would you design a stack which, in addition to push and pop,
    * also has a function min which returns the minimum element?
    * push, pop and min should all operate in O(1)
    */
   // see StackWithMin.java
   public static void main(String[] args){
      StackWithMin st = new StackWithMin();
      Random rd = new Random();
      rd.setSeed(System.currentTimeMillis());
      for (int i = 0; i < 10; i++){
         st.push(rd.nextInt(10));
         System.out.println(st);
         System.out.println(st.min());
      }
   }

}
