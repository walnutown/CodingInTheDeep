package ch11_sorting_searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
 * Write a method to sort an array of strings so that all the anagrams are next to each other 
 * Group anagrams in a string array
 */
public class ch11_11_2 {

   /**
    * @param args
    */
   public static void main(String[] args) {
     
      String[] arr = new String[]{"abc", "d", "bca", "etg", "cat", "cab"};
      System.out.println(Arrays.toString(arr));
      groupAnagrams(arr);
      System.out.println(Arrays.toString(arr));
   }
   
   public static void groupAnagrams(String[] arr){
      Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
      for(String word : arr){
         String key = sortWord2(word);
         if (!map.containsKey(key)){
            ArrayList<String> val_list = new ArrayList<String>();
            val_list.add(word);
            map.put(key, val_list);
         }else
            map.get(key).add(word);
      }
      int index = 0;
      for (ArrayList<String> val_list: map.values()){
         for (String val : val_list)
            arr[index++] = val;
      }
   }
   
   // really ugly here 
   public static String sortWord(String word){
      ArrayList<Character> ch_list = new ArrayList<Character>();
      for (int i = 0 ; i < word.length(); i++){
         ch_list.add(word.charAt(i));
      }
      Collections.sort(ch_list);
      StringBuilder sb = new StringBuilder();
      for (Character ch : ch_list){
         sb.append(ch);
      }
      return sb.toString();
   }
   
   public static String sortWord2(String word){
      char[] ch_str = word.toCharArray();
      Arrays.sort(ch_str);
      return new String(ch_str);
   }

}
