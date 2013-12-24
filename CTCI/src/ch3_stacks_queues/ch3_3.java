package ch3_stacks_queues;

import java.util.Random;

public class ch3_3 {

   /**
    * Implement SetOfStacks
    * composed of several stacks and should create a new stack once the previous one exceeds capacity
    * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack
    */
   // FOLLOW UP
   // implement a function popAt(int index) which performs a pop operation on a specific sub-stack
   // see SetOfStacks.java
   public static void main(String[] args){
      SetOfStacks ss = new SetOfStacks(5);
      Random rd = new Random();
      rd.setSeed(System.currentTimeMillis());
      for (int i = 0; i < 20; i++){
         ss.push(rd.nextInt(10));
         System.out.println(ss); 
         if (i % 4 == 0){
            int val = ss.pop();
            System.out.println("Pop(): " + val);
            System.out.println(ss); 
         }
         if (i % 3 == 1){
            int val = ss.popAt(0);
            System.out.println("PopAt(0): " + val);
            System.out.println(ss); 
         }
      }
      
   }

}
