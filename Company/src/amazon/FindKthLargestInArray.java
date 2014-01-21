package amazon;

public class FindKthLargestInArray {

   /**
    * Find the kth largest number in the array
    * Sol:
    *   <1> sort, O(nlgn)
    *   <2> heap, O(nlgk)
    *   <3> quickSelect, O(n)
    */
   public static void main(String[] args) {
      System.out.println(findKthLargestInArray(new int[]{1,7,3,4,5}, 2));
   }
   
   // Quick Select
   public static int findKthLargestInArray(int[] A, int k){
      if (A==null || A.length==0)   return 0;
      return quickSelect(A, 0, A.length-1, k-1);
   }
   public static int quickSelect(int[] A, int start, int end, int k){
      if (start == end) return A[start];
      int pivot = start + ((end-start)>>2);
      pivot = partition(A, start, end, pivot);
      if (pivot == k)   return A[pivot];
      else if (pivot < k)   return quickSelect(A, pivot+1, end, k);
      else return quickSelect(A, start, pivot-1, k);
   }
   // partition the array and return the idnex of the new pivot
   public static int partition(int[] A, int start, int end, int pivot){
      int value = A[pivot];
      swap(A, end, pivot); // move pivot to the end
      int pivot_new = start;
      for (int i=start; i<end; i++){
         if (A[i] >= value)
            swap(A, pivot_new++, i);
      }
      swap(A, end, pivot_new); // move pivot to its final place
      return pivot_new;
   }
   public static void swap(int[] A, int a, int b){
      int tmp = A[a];
      A[a] = A[b];
      A[b] = tmp;
   }
}
