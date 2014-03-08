package ch9_recursion_dynamic_programming;

import java.util.ArrayList;

public class ch9_5_StringPermutations {

   /*
    * Write a method to compute all permutations of a string 
    */
   // see Leetcode-- Permutations
   public static void main(String[] args) {
      System.out.println(getPermutations("aba"));
   }
   
   // The string contains duplicate characters
   public static ArrayList<String> getPermutations(String s){
      ArrayList<String> res = new ArrayList<String>();
      if (s == null || s.length() == 0)
         return res;
      res.add(s.charAt(0)+"");
      for (int i=1; i < s.length(); i++){
         char curr = s.charAt(i);
         int size = res.size();
         for (int j = 0; j < size; j++){
            StringBuilder sb = new StringBuilder(res.get(j));
            for (int k = 0; k <= sb.length(); k++){
               sb.insert(k, curr);
               if (!res.contains(sb.toString())) // support duplicate characters here
                  res.add(sb.toString());
               sb.deleteCharAt(k);
            }
         }
         // remove the unneeded strings
         for (int j = 0; j < size; j++){
            res.remove(0);
         }
      }
      return res;
   }

}
