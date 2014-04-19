package google;

import org.junit.Test;

public class ArrayPartitionSum {
   /*
    * Given an array of integers and a target
    * Check whether there's a way to partition the array into several parts, whose sum is target
    * eg, A = [1,5,0,6], target = 21;
    * return true, (because 15 + 0 + 6 = 21)
    */
   
   // Backtracking
   // time: O(2^n); space: recursive stack
   public boolean isValid(int[] A, int target){
      if (A==null || A.length==0)
         return false;
      return dfs(A, 0, target);
   }
   
   private boolean dfs(int[] A, int dep, int target){
      if (target==0)
         return true;
      if (target<0)
         return false;
      boolean isValid = false;
      for (int i=dep; i<A.length; i++){
         int num = getNum(A, dep, i);
         isValid |= dfs(A, i+1, target-num);
      }
      return isValid;
   }
   
   private int getNum(int[] A, int start, int end){
      int res = 0;
      for (int i=start; i<=end; i++)
         res = res*10 + A[i];
      return res;
   }
   
   @Test
   public void test(){
      int[] A = new int[]{1,5,0,6};
      System.out.println(isValid(A, 22));
   }
}
