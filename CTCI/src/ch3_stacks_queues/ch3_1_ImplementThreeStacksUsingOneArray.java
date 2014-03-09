package ch3_stacks_queues;

import java.util.EmptyStackException;
import java.util.Random;

public class ch3_1_ImplementThreeStacksUsingOneArray {

   /**
    * Describe how you could use a single array to implement three stacks
    */
   // fixed-size stack, or dynamic-size stack
   // the following code implements 3 fixed-size stacks
   // for the dynamic version, we have to expand the size and move elements if necessary
   public static void main(String[] args) {
      ArrayStacks<Integer> as = new ArrayStacks<Integer>(5);
      Random rd = new Random(System.currentTimeMillis());
      for (int i = 0; i < 10; i++) {
         int value = rd.nextInt(10);
         int index = rd.nextInt(3);
         System.out.println("Push() to Stack " + index + " value: " + value);
         as.push(index, value);
         System.out.println(as);
         if (i > 5) {
            index = rd.nextInt(3);
            value = as.pop(index);
            System.out.println("Pop() from Stack " + index + " value: " + value);
         }
      }
   }

   public static class ArrayStacks<Integer> {
      private int[] arr;
      private int capacity;
      private int size;
      private int[] st_tops;

      public ArrayStacks(int capacity) {
         arr = new int[3 * capacity];
         this.capacity = capacity;
         size = 0;
         st_tops = new int[] { -1, capacity-1, 2 * capacity-1 };
      }

      public int size() {
         return size;
      }

      public void push(int index, int value) {
         if (this.isFull(index))
            throw new StackOverflowError();
         arr[++st_tops[index]] = value;
      }

      public int pop(int index) {
         if (this.isEmpty(index))
            throw new EmptyStackException();
         return arr[st_tops[index]--];
      }

      public int peek(int index) {
         if (this.isEmpty(index))
            throw new EmptyStackException();
         return arr[st_tops[index]];
      }

      public boolean isEmpty(int index) {
         return st_tops[index] < index * capacity;
      }

      public boolean isFull(int index) {
         return st_tops[index] >= (index + 1) * capacity;
      }

      public String toString() {
         StringBuilder sb = new StringBuilder();
         sb.append("Stack0: [ ");
         for (int i = 0; i <= st_tops[0]; i++)
            sb.append(arr[i] + " ");
         sb.deleteCharAt(sb.length()-1);
         sb.append("]\n");
         sb.append("Stack1: [ ");
         for (int i = capacity; i <= st_tops[1]; i++)
            sb.append(arr[i] + " ");
         sb.deleteCharAt(sb.length()-1);
         sb.append("]\n");
         sb.append("Stack2: [ ");
         for (int i = 2 * capacity; i <= st_tops[2]; i++)
            sb.append(arr[i] + " ");
         sb.deleteCharAt(sb.length()-1);
         sb.append("]");
         return sb.toString();
      }
   }

}
