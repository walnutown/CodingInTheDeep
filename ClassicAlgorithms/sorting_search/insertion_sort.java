package sorting_search;

import java.util.Arrays;

public class insertion_sort {

   /**
    * @param args
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      int[] arr = new int[]{20, -3, -10, 30, 50};
      insertionSort(arr);
      System.out.println(Arrays.toString(arr));
   }
   
   public static void insertionSort(int[] arr){
      if (arr == null || arr.length <= 1)
         return;
      for (int i = 1 ; i < arr.length; i++){
         insert2(arr, i);
      }
   }
   
   public static void insert(int[] arr, int num_index){
      int num = arr[num_index];
      int i = num_index-1;
      while (i >= 0){
         arr[i+1] = arr[i];
         if (num > arr[i]){
            arr[i+1] = num;
            break;
         }
         i--;
      }
      if (i == -1)
         arr[0] = num;
   }
   
   public static void insert2(int[] arr, int num_index){
      int num = arr[num_index];
      int i = num_index -1;
      for (; i >= 0 && num < arr[i]; i--)
         arr[i+1] = arr[i];
      arr[i+1] = num;
   }

}
