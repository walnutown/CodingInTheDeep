package ch9_recursion_dynamic_programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ch9_9_4 {

   /*
    * Write a method to return all subsets of a set 
    */
   public static void main(String[] args) {
      Set<Integer> set = new HashSet<Integer>();
      set.add(1);
      set.add(4);
      set.add(10);
      set.add(20);
      System.out.println(set);
      System.out.println(findSubsets(new ArrayList<Integer>(set)));
      System.out.println(findSubsets2(new ArrayList<Integer>(set)));
      System.out.println(findSubsets3(new ArrayList<Integer>(set)));
   }
   // O(2 ^ n), DFS
   public static ArrayList<ArrayList<Integer>> findSubsets(ArrayList<Integer> set){
      ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
      Collections.sort(set);
      finder(set, 0, res, new ArrayList<Integer>());
      return res;
   }

   public static void finder(ArrayList<Integer> set, int dep, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> r){
      if (dep == set.size())
         return;
      for (int i = dep; i < set.size(); i++){
         r.add(set.get(i));
         res.add(new ArrayList<Integer>(r));
         finder(set, i+1, res, r);
         r.remove(r.size()-1);
      }    
   }
   
   // each subset can be represented as a binary string, this is limited by the architecture of the OS
   public static ArrayList<ArrayList<Integer>> findSubsets2(ArrayList<Integer> set){
      ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
      Collections.sort(set);
      int len = set.size();
      int num = 1 << len;
      for (int i = 0; i < num; i++)
         res.add(new ArrayList<Integer>(getSubset(i, set))); 
      return res;
   }
   
   public static ArrayList<Integer> getSubset(int num, ArrayList<Integer> set){
      ArrayList<Integer> r = new ArrayList<Integer>();
      for (int i = 0; i < set.size(); i++){
         int bit_pos = 1<<i;
         if ( (bit_pos & num )> 0)  // get the value of bit_pos
            r.add(set.get(i));
      }
      return r;
   }
   
   // DP
   public static ArrayList<ArrayList<Integer>> findSubsets3(ArrayList<Integer> set){
      ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
      res.add(new ArrayList<Integer>());
      for (int num : set){
         int size = res.size();
         for (int i = 0; i < size; i++){
            ArrayList<Integer> tmp = new ArrayList<Integer>(res.get(i));
            tmp.add(num);
            res.add(tmp);
         }
      }
      return res;
   }
}
