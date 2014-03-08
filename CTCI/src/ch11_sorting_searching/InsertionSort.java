package ch11_sorting_searching;

import java.util.Arrays;

/*
 * Implement in place insertion sort 
 */
public class InsertionSort {

   public static void main(String[] args) {
      int[] arr = new int[]{20, -3, -10, 30, 50};
      insertionSort(arr);
      System.out.println(Arrays.toString(arr));
   }
   
   public static void insertionSort(int[] arr){
      if (arr == null || arr.length <= 1)
         return;
      for (int i = 1 ; i < arr.length; i++){
         insert(arr, i);
      }
   }
   
   // we can use binary search here to optimize the running time of searching for the insertion position
   // but we still have to move the right half elements
   // Thus, the worst case will remian O(n^2).
   public static void insert(int[] arr, int num_index){
      int num = arr[num_index];
      int i = num_index -1;
      for (; i >= 0 && num < arr[i]; i--)
         arr[i+1] = arr[i];
      arr[i+1] = num;
   }

}
