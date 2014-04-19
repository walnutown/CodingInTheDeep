package ch11_sorting_searching;

import java.util.Arrays;

import org.junit.Test;

public class CountingSort {
   /*
    * Counting sort determines, for each input element x, the number of elements less than x. It
    * uses this information to place element x directly into its position in the output array. we
    * must modify this scheme slightly to handle the situation in which several elements have the
    * same value, since we do not want to put them all in the same position.
    * see CLSR 8.2
    */
   
   // Note:
   // [1] CountingSort is efficient when input range is not significantly greater than the number of
   // elements to be sorted
   // [2] Can beat the lower bond of comparison sort O(nlgn)
   // [3] uses a hashing to get the index of element in count table. Thus, can also work on negative numbers
   // [4] can be paralled

   // [1] build a count table C of size K (K = A.max - A.min+1), store the number of occurrence times
   // of an element in A
   // [2] update C to get prefix sum of each index. Then, each position in C stores the number of
   // smaller or equal elements
   // [3] use C to locate an element in the result array
   // time: O(k+n); space: O(k)
   public int[] countingSort(int[] A) {
      int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
      for (int num : A){
         max = Math.max(max, num);
         min = Math.min(min, num);
      }
      int K = max-min+1, N = A.length;
      int[] C = new int[K];
      for (int num : A) // count table
         C[num-min]++;
      for (int i=1; i<K; i++)   // prefix sum table
         C[i] += C[i-1];
      int[] res = new int[N];
      for (int i=N-1; i>=0; i--){
         int countIndex = A[i]-min;
         res[--C[countIndex]] = A[i];
      }
      return res;
   }
   
   
   @Test
   public void test(){
      int[] A = new int[]{2,5,3,0,2,3,0,3};
      System.out.println(Arrays.toString(countingSort(A)));
   }
}
