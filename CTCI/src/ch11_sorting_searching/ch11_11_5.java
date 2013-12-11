package ch11_sorting_searching;

import java.util.Arrays;

public class ch11_11_5 {

   /*
    * Given a sorted array of strings which is interspersed with empty strings.
    * Write a method to find the location of a given string. 
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      String[] arr = new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
      String target = "dad";
      System.out.println(Arrays.toString(arr));
      System.out.println(findString(arr, 0, arr.length-1, target));
   }
   
   public static int findString(String[] arr, int start, int end, String target){
      if (start > end)
         return -1;
      int mid = (start + end) >>1;
      if (arr[mid].equals(target))
         return mid;
      int mid_low = mid;
      int mid_high = mid;
      while (arr[mid_low].length() == 0)
         mid_low--;
      while (arr[mid_high].length() == 0)
         mid_high++;
      if (arr[mid_low].equals(target))
         return mid_low;
      if (arr[mid_low].compareTo(target) > 0)
         return findString(arr, start, mid_low-1, target);
      if (arr[mid_high].equals(target))
         return mid_high;
      if (arr[mid_high].compareTo(target)< 0)
         return findString(arr, mid_high+1, end, target);
      return -1;
   }

}

// If it weren't for the empty strings, we could simply use binary search
// With interspersed empty strings, we do some modification: if mid is empty string, 
// we simply move mid to the closest non-empty string 

// in my implementation, if target is "", we simply return the index that is first found.