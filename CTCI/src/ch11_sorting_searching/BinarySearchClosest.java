package ch11_sorting_searching;

import java.util.Arrays;

public class BinarySearchClosest {

   /**
    * Binary search an array to find the closest element of the target
    */
   public static void main(String[] args) {
      int[] arr = new int[]{-1,4,5,7,10};
      System.out.println(Arrays.toString(arr));
      System.out.println(binarySearchClosest(arr, 3));

   }
   
   public static int binarySearchClosest(int[] arr, int target){
      int start = 0, end = arr.length-1;
      while (start<=end){
         int mid = start + ((end-start)>>1);
         if (arr[mid]<target)   start = mid+1;
         else if (arr[mid]>target) end=mid-1;
         else return mid;
      }
      if (start>=arr.length)    return end;
      else if (end<0)   return start;
      else{
         if (arr[start]-target < target-arr[end])   return start;
         else return start;
      }
   }

}
