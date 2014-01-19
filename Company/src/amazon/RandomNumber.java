package amazon;

import java.util.Random;

public class RandomNumber {

   /**
    * rand7 from rand5
    * rand5 from rand7: if 6,7, redo
    * rand28 from rand5: get rand8 first, then use rand8 to construct the matrix
    */
   private static Random r= new Random(System.currentTimeMillis());
   public static void main(String[] args) {
      System.out.println(rand7());
   }
   
   public static int rand5(){
      return r.nextInt(5)+1;
   }
   
   public static int rand7(){
      int[][] matrix = new int[][]{
            {1,2,3,4,5},
            {6,7,1,2,3},
            {4,5,6,7,1},
            {2,3,4,5,6},
            {7,0,0,0,0}};
      int res = 0;
      while (res == 0){
         int i = rand5(), j = rand5();
         res = matrix[i-1][j-1];
      }
      return res;
   }

}
