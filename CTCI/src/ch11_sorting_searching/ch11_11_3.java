package ch11_sorting_searching;

import java.util.Arrays;

/*
 * Find the index of a target number in a rotated array
 * 
 * if there're repeated target numbers, return which index?
 */
public class ch11_11_3 {

   /**
    * @param args
    */
   public static void main(String[] args) {
      int num = 5;
      int[] arr = new int[]{15,15,15,15,25,1,3,4,5,7,10,14};
      System.out.println(Arrays.toString(arr));
      System.out.println(searchTargetInRotatedArray2(arr, 0, arr.length-1, num));
   }
   
   public static int searchTargetInRotatedArray(int[] arr, int start, int end, int num){
      int mid = (start + end) >>1;
      if (start > end)
         return -1;
      if (start == end){
         return arr[mid] == num ? mid:-1;
      }
      if (arr[mid] == num)
         return mid;
      else if (arr[mid] > num){
         if (arr[end] > arr[mid])
            return searchTargetInRotatedArray(arr, start, mid, num);
         else
            return Math.max(searchTargetInRotatedArray(arr, start, mid, num), searchTargetInRotatedArray(arr, mid+1, end, num));
      }else{
         if (arr[start] < arr[mid])
            return searchTargetInRotatedArray(arr, mid+1, end, num);
         else
            return Math.max(searchTargetInRotatedArray(arr, start, mid, num), searchTargetInRotatedArray(arr, mid+1, end, num));
      }
   }
   // -- either the left or right half must be normally ordered -- KEY POINT OF THIS QUESTION
   public static int searchTargetInRotatedArray2(int[] arr, int start, int end, int num){
      if (start > end)
         return -1;
      int mid = (start + end) >> 1;
      if (arr[mid] == num)
         return mid;
      // left half is ordered
      if (arr[start] < arr[mid]){
         if (num >= arr[start] && num < arr[mid])
            return searchTargetInRotatedArray2(arr, start, mid-1, num);
         else
            return searchTargetInRotatedArray2(arr, mid+1, end, num);
      }else if (arr[start] > arr[mid]){ // right half is ordered
         if (num > arr[mid] && num <= arr[end])
            return searchTargetInRotatedArray2(arr, mid+1, end, num);
         else
            return searchTargetInRotatedArray2(arr, start, mid-1, num);
      }else if (arr[start] == arr[mid]){
         if (arr[mid] != arr[end]) // right half is not repeated
            return searchTargetInRotatedArray2(arr, mid+1, end, num);
         else
            return Math.max(searchTargetInRotatedArray2(arr, start, mid-1, num), searchTargetInRotatedArray2(arr, mid+1, end, num));
      }
      return -1;
   }
   
   

}
