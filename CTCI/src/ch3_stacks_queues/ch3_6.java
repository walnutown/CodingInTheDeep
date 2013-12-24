package ch3_stacks_queues;

import java.util.Random;
import java.util.Stack;

public class ch3_6 {

   /**
    * Write a program to sort a stack in ascending order (with biggest items on top)
    * You may use one additional stack to hold items. You may not copy the elements into any 
    * other data structure (such as an array). The stack supports the following operations:
    * push, pop, peek, and isEmpty
    */
   public static void main(String[] args) {
      Stack<Integer> st = new Stack<Integer>();
      Random rd = new Random();
      rd.setSeed(System.currentTimeMillis());
      for (int i = 0; i < 10; i++){
         st.push(rd.nextInt(10));
      }
      System.out.println(st);
      sortStack(st);
      System.out.println(st);
   }
   
   public static void sortStack(Stack<Integer> st){
      Stack<Integer> ordered_st = new Stack<Integer>();
      while (!st.isEmpty()){
         int tmp = st.pop();
         while (!ordered_st.isEmpty()){
            if (tmp > ordered_st.peek())
               st.push(ordered_st.pop());
            else    break;
         }
         ordered_st.push(tmp);
      }
      while (!ordered_st.isEmpty()){
         st.push(ordered_st.pop());
      }
   }
}
