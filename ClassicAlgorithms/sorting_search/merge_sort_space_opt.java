package sorting_search;

import java.util.Arrays;

public class merge_sort_space_opt {

   /**
    * @param args
    */
   public static void main(String[] args) {
      int[] arr = new int[]{20, -1, 3, -1000, 0};
      mergeSort(arr, 0, arr.length-1);
      System.out.println(Arrays.toString(arr));
   }
   
   public static void mergeSort(int[] arr, int start, int end){
      if (start >= end)
         return;
      int mid = (start + end) >> 1; // see explanation below
      mergeSort(arr, start, mid);
      mergeSort(arr, mid+1, end);
      merge(arr, start, mid, end);
   }
   
   public static void merge(int[] arr, int start, int mid, int end){
      int lp = start;
      int rp = mid+1;
      int index = start;
      int[] tmp = new int[arr.length]; 
      while (lp <= mid && rp <= end){
         if (arr[lp] < arr[rp]){
            tmp[index] = arr[lp];
            lp++;
         }
         else{
            tmp[index] = arr[rp];
            rp++;
         }
         index++;
      }
      while (lp <= mid){
         tmp[index] = arr[lp];
         index++;
         lp++;
      }
      // no need to copy right-side half here, think why?
      for (int i = start; i<= end; i++){
         arr[i] = tmp[i];
      }
   }
}

// in JDK source code, the implementation of mergeSort uses x >>1 to replace x/2
// because x is positive here. Below is some more:
// First, dividing by two and shifting right by one will not yield the same result for negative numbers in all cases. 
// Second, where the shifted result is sufficent, its roughly 10 to 20 times faster than dividing. 
// Third, the compiler will not optimize x/2 to x>>1 because in any non-trivial case it will be unable to prove that the shifted operand is not negative

