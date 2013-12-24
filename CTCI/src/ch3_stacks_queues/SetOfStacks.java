package ch3_stacks_queues;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

// the stack is not required to be full in this class
public class SetOfStacks {
   private ArrayList<Stack<Integer>> stacks;
   private int stack_index;
   private int capacity;
   
   public SetOfStacks(int capacity){
      stacks = new ArrayList<Stack<Integer>>();
      stack_index = 0;
      this.capacity = capacity;
   }
   
   public void push(int value){
      if (stack_index < 0)  stack_index = 0;
      Stack<Integer> st_curr = this.getCurrentStack();
      if (st_curr.size() == capacity)
         stack_index++;
      st_curr = this.getCurrentStack();
      st_curr.push(value);    
   }
   
   public Integer peek(){
      Stack<Integer> st_curr = this.getCurrentStack();
      if (st_curr.isEmpty()){
         stacks.remove(stack_index);
         stack_index--;
      }
      st_curr = this.getCurrentStack();
      return st_curr.peek();
   }
   
   public Integer pop(){
      Stack<Integer> st_curr = this.getCurrentStack();
      if (st_curr.isEmpty()){
         stacks.remove(stack_index);
         stack_index--;
      }
      st_curr = this.getCurrentStack();
      return st_curr.pop();
   }
   // if the stack with index is empty, throw exception
   public Integer popAt(int index){
      if (index > stack_index || index < 0)
         throw new IndexOutOfBoundsException();
      Stack<Integer> st = stacks.get(index);
      return st.pop();
   }
   
   public Stack<Integer> getCurrentStack(){
      if (stack_index < 0)
         throw new EmptyStackException();
      while (stack_index >= stacks.size())
         stacks.add(new Stack<Integer>());
      return stacks.get(stack_index);
   }
   
   public String toString(){
      return stacks.toString();
   }
}
