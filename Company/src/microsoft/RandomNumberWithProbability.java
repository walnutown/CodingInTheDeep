package microsoft;

import java.util.Random;

public class RandomNumberWithProbability {
   static Random r = new Random(System.currentTimeMillis());
   /**
    * Given random() that can return 0 or 1 uniformly, implement random_new()
    * that can return 0 with 90%, and 1 with 10%.
    * 
    * Sol:
    *   generate a 4-bit number x. Then, x is in [0,16)
    *   if x == 0, return 1;
    *   eles if 1<=x && x<=9, return 0;
    *   else redo
    */
   public static void main(String[] args) {
      int zero=0, one=0;
      for (int i=0; i<100; i++){
         if (random_new()==0) zero++;
         else one++;
      }
      System.out.println("zero: " + zero+" ; "+"one: "+one);
   }
   
   public static int random(){
      return r.nextInt(2);
   }
   
   public static int random_new(){
      int num = 0;
      for (int i=0; i<4; i++)
         num += random() * (2^i);
      if (num == 0) return 1;
      else if (num>=1 && num<=9)    return 0;
      else return random_new();
   }
}
