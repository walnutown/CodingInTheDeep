package ch11_sorting_searching;

import java.util.Arrays;

public class ch11_5_SearchInArrayWithEmptyStrings {

   /*
    * Given a sorted array of strings which is interspersed with empty strings.
    * Write a method to find the location of a given string.
    */

   // If it weren't for the empty strings, we could simply use binary search
   // With interspersed empty strings, we do some modification: if mid is empty string,
   // move mid to the closest non-empty string
   // if target is "", we simply return the index that is first found.
   public static void main(String[] args) {
      String[] arr = new String[] { "at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "" };
      String target = "";
      System.out.println(Arrays.toString(arr));
      System.out.println(findString(arr, target));
   }

   public static int findString(String[] arr, String target) {
      int start = 0, end = arr.length-1;
      while (start<=end){
         int mid = start+ (end-start)/2;
         // if empty string, search both sides simultaneously to find the closest non-empty string
         if (arr[mid].isEmpty()&&target.isEmpty())  return mid;
         if (arr[mid].isEmpty()) { 
            int left = mid - 1;
            int right = mid + 1;
            while (true) {
                if (left < start && right > end) {
                    return -1;
                } else if (right <= end && !arr[right].isEmpty()) {
                    mid = right;
                    break;
                } else if (left >= start && !arr[left].isEmpty()) {
                    mid = left;
                    break;
                }
                right++;
                left--;
            }
        }
         int com = arr[mid].compareTo(target);
         if (com==0)    return mid;
         else if (com<0) start = mid+1;
         else end = mid-1;
      }
      return -1;
   }
}
