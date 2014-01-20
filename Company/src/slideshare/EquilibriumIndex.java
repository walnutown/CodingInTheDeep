package slideshare;

public class EquilibriumIndex {

   /**
    * A zero-indexed array A consisting of N integers is given. An equilibrium index of this array
    * is any integer P such that 0 ≤ P < N and the sum of elements of lower indices is equal to the
    * sum of elements of higher indices, i.e.
    * A[0] + A[1] + ... + A[P−1] = A[P+1] + ... + A[N−2] + A[N−1].
    * Sum of zero elements is assumed to be equal to 0. This can happen if P = 0 or if P = N−1.
    * For example, consider the following array A consisting of N = 7 elements:
    * A[0] = -7 A[1] = 1 A[2] = 5
    * A[3] = 2 A[4] = -4 A[5] = 3
    * A[6] = 0
    * P = 3 is an equilibrium index of this array, because:
    * A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
    * P = 6 is also an equilibrium index, because:
    * A[0] + A[1] + A[2] + A[3] + A[4] + A[5] = 0
    * and there are no elements with indices greater than 6.
    * P = 7 is not an equilibrium index, because it does not fulfill the condition 0 ≤ P < N.
    */
   public static void main(String[] args) {
      System.out.println(getIndex(new int[]{0, 2, 5, 2, 0, 0, 0}));
   }

   public static int getIndex(int[] A) {
      if (A == null || A.length == 0)
         return -1;
      long sum = 0; // notice long here, avoid overflow 
      for (int num : A)
         sum += num;
      long left = 0;
      for (int i = 0; i < A.length; i++) {
         if (left == sum - A[i] - left)
            return i;
         left += A[i];
      }
      return -1;
   }

}
