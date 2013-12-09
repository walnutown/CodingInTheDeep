package sorting_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class merge_sort {

   /**
    * @param args
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      List<Integer> test = new ArrayList<Integer>(Arrays.asList(20,-1));
      System.out.println(mergeSort(test, 0, test.size()));
   }
   
   public static List<Integer> mergeSort(List<Integer> arr, int start, int end){
      List<Integer> res = new ArrayList<Integer>();
      if (arr == null || arr.size() == 0)
         return res;
      if (arr.size() == 1)
         return arr;
      int mid = (start + end) >> 1;
      res = merge(mergeSort(arr.subList(start, mid), start, mid), mergeSort(arr.subList(mid, end), mid, end));
      return res;
   }
   
   public static List<Integer> merge(List<Integer> l_arr, List<Integer> r_arr){
      List<Integer> res = new ArrayList<Integer>();
      int i = 0;
      int j = 0;
      while (i < l_arr.size() && j < r_arr.size()){
         if (l_arr.get(i) < r_arr.get(j)){
            res.add(l_arr.get(i));
            i++;
         }else{
            res.add(r_arr.get(j));
            j++;
         }
      }
      while (i < l_arr.size()){
         res.add(l_arr.get(i));
         i++;
      }
      while(j < r_arr.size()){
         res.add(r_arr.get(j));
         j++;
      }
      return res;
   }

}
