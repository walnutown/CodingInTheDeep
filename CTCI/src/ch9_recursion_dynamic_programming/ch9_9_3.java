package ch9_recursion_dynamic_programming;

import java.util.Arrays;

public class ch9_9_3 {

   /*
    * Magic Index : A[i] = i
    * Given a sorted array of distinct integers, write a method to find a magic index
    * if one exists, in array A
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      int[] arr = new int[]{-3, 3, 3, 3, 3, 20};
      System.out.println(Arrays.toString(arr));
      System.out.println(findMagicIndex(arr));
      System.out.println(findMagicIndex3(arr, 0, arr.length));
   }
   
   public static int findMagicIndex(int[] arr){
      int index = 0;
      while (index < arr.length){
         if (arr[index] == index)
            return index;
         else if (index < arr[index]){
            index = arr[index];
         }
         else
            index++;
      }
      return -1;
   }
   
   // Follow Up
   // What if the values are not distinct?
   
   // the same
   
   // use binary search, array is of unique values
   public static int findMagicIndex2(int[] arr, int start, int end){
      if (start > end)
         return -1;
      int mid = (start + end)/2;
      if (arr[mid] == mid)
         return mid;
      else if (arr[mid] > mid)
         findMagicIndex2(arr, mid+1, end);
      else
         findMagicIndex2(arr, start, mid-1);
      return -1;
   }
   // use binary search, array contains repeated values
   public static int findMagicIndex3(int[] arr, int start, int end){
      if (start > end)
         return -1;
      int mid = (start + end) >>1;
      if (arr[mid] == mid)
         return mid;
      else if(arr[mid] > mid){
         return Math.max(findMagicIndex3(arr, start, mid-1), findMagicIndex3(arr, arr[mid], end));
      }else
         return Math.max(findMagicIndex3(arr, start, arr[mid]), findMagicIndex3(arr, mid+1, end));
   }

}
