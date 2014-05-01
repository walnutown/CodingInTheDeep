package ch3_stacks_queues;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Random;
import java.util.Stack;

import org.junit.Test;

public class ch3_3_ImplementSetOfStacks {

   /**
    * Implement SetOfStacks
    * composed of several stacks and should create a new stack once the previous one exceeds
    * capacity
    * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack
    */
   // FOLLOW UP
   // implement a function popAt(int index) which performs a pop operation on a specific sub-stack
   

   // the stack is not required to be full in this implementation
   public class SetOfStacks {
      private ArrayList<Stack<Integer>> stacks;
      private int stack_index;
      private int capacity;

      public SetOfStacks(int capacity) {
         stacks = new ArrayList<Stack<Integer>>();
         stack_index = 0;
         this.capacity = capacity;
      }

      public void push(int value) {
         if (stack_index < 0)
            stack_index = 0; 
         while (getCurrentStack().size() == capacity)
            stack_index++;
         getCurrentStack().push(value);
      }

      public Integer peek() {
         while (getCurrentStack().isEmpty()) {
            stacks.remove(stack_index);
            stack_index--;
         }
         return getCurrentStack().peek();
      }

      public Integer pop() {
         while (getCurrentStack().isEmpty()) {
            stacks.remove(stack_index);
            stack_index--;
         }
         return getCurrentStack().pop();
      }

      // Two cases for exceptions:
      // [1] the stack of index is not existing
      // [2] the stack of index is empty
      public Integer popAt(int index) {
         if (index > stack_index || index < 0)
            throw new IndexOutOfBoundsException();
         Stack<Integer> st = stacks.get(index);
         if (st.isEmpty())
            throw new NullPointerException();
         return st.pop();
      }

      // Core function of this class
      private Stack<Integer> getCurrentStack() {
         if (stack_index < 0)
            throw new EmptyStackException();
         while (stack_index >= stacks.size())
            stacks.add(new Stack<Integer>());
         return stacks.get(stack_index);
      }

      public String toString() {
         return stacks.toString();
      }
   }
   
   @Test
   public void test() {
      SetOfStacks ss = new SetOfStacks(5);
      Random rd = new Random();
      rd.setSeed(System.currentTimeMillis());
      for (int i = 0; i < 20; i++) {
         ss.push(rd.nextInt(10));
         System.out.println(ss);
         if (i % 4 == 0) {
            int val = ss.pop();
            System.out.println("Pop(): " + val);
            System.out.println(ss);
         }
         if (i % 3 == 1) {
            int val = ss.popAt(0);
            System.out.println("PopAt(0): " + val);
            System.out.println(ss);
         }
      }
   }
}
