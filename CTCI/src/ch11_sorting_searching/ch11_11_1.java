package ch11_sorting_searching;

import java.util.Arrays;

/*
 * You're given two sorted arrays, A and B, where A has a large enough buffer at the end
 * to hold B. Write a method to merge B into A in sorted order. 
 */
public class ch11_11_1 {

   /**
    * @param args
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      int[] a = new int[7];
      a[0] = -4;
      a[1] = 20;
      int[] b = new int[]{1,3,5,7,9};
      System.out.println(Arrays.toString(a));
      mergeArray(a, 2, b);
      System.out.println(Arrays.toString(a));
   }
   // merge sort starting from end of array
   public static void mergeArray(int[] a, int size, int[] b){
      int i = a.length -1;
      int j = size-1;
      int k = b.length-1;
      while (j >= 0 && k >= 0){
         if (a[j] > b[k]){
            a[i] = a[j];
            j--;
         }else{
            a[i] = b[k];
            k--;
         }
         i--;
      }
   }
}
