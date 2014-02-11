package ch11_sorting_searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingSubsequence2 {

   /*
    * Find the longest increasing subsequence in an array of integers
    */
   public static void main(String[] args) {
      int[] arr = new int[]{1,-2, 3, 5, 10, 6, 8};
      System.out.println(Arrays.toString(arr));
      System.out.println(findLIS(arr).toString());
   }
   
   public static ArrayList<Integer> findLIS(int[] arr){
      ArrayList<Integer> res = new ArrayList<Integer>();
      if (arr == null || arr.length == 0)
         return res;
      Map<Integer, ArrayList<Integer>> mem = new HashMap<Integer, ArrayList<Integer>>();
      initMem(mem, arr.length);
      mem.get(0).add(arr[0]);
      for (int i = 1; i < arr.length ; i++){
         mem.get(i).add(arr[i]);
         for (int j = 0; j < i; j++){
            if (arr[i] > arr[j] && mem.get(i).size() < mem.get(j).size()+1){
               mem.put(i, new ArrayList<Integer>(mem.get(j)));
               mem.get(i).add(arr[i]);
            }
         }
      }
      for (ArrayList<Integer> list : mem.values()){
         res = list.size() > res.size() ? list : res;
      }
      return res;
   }
   
   public static void initMem(Map<Integer, ArrayList<Integer>> mem, int length){
      for (int i = 0; i < length; i++)
         mem.put(i, new ArrayList<Integer>());
   }

}
