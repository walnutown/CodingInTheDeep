package amazon;

public class FindOneMissingInteger {

   /**
    * An array of integers from [1...n], there's one integer missing, find the missing integer
    * Sol1: bit manipulation
    * <1> xor each number in the array
    * <2> xor 1 to n
    * Sol2: count array
    * Sol3: sum array
    */
   public static void main(String[] args) {
      int[] A = new int[] { 1, 2, 3, 4, 5, 6, 7, 9 };
      int n = 9;
      System.out.println(findMissingInteger1(A, n));
      System.out.println(findMissingInteger2(A, n));
      System.out.println(findMissingInteger3(A, n));
   }

   public static int findMissingInteger1(int[] A, int n) {
      if (A == null || A.length == 0)
         return 1;
      int xor = 0;
      for (int i = 0; i < A.length; i++)
         xor ^= A[i];
      for (int i = 1; i <= n; i++)
         xor ^= i;
      return xor;
   }

   public static int findMissingInteger2(int[] A, int n) {
      if (A == null || A.length == 0)
         return 1;
      int[] count = new int[n + 1];
      for (int i = 0; i < A.length; i++)
         count[A[i]] = 1;
      for (int i = 1; i < count.length; i++) {
         if (count[i] == 0)
            return i;
      }
      return 1;
   }

   public static int findMissingInteger3(int[] A, int n) {
      int sum = 0;
      for (int i = 1; i <= n; i++)
         sum += i;
      for (int i = 0; i < A.length; i++)
         sum -= A[i];
      return sum;
   }

}
