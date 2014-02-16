package lib;

import java.util.Random;

public class ArrayGenerator {
   private Random random;
   public ArrayGenerator(){
      random = new Random(System.currentTimeMillis());
   }
   public int[] generateIntArray(int size, int minValue, int maxValue){
      int[] A = new int[size];
      for (int i=0; i<size; i++){
         A[i] = minValue + random.nextInt(maxValue-1-minValue);
      }
      return A;
   }
}
