package ch7_math_probability;

import java.util.ArrayList;

public class ch7_4 {

   /**
    * Write methods to implement the multiply, subtract, and divide operations
    * for integers. Use only add operator
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      System.out.println(multiply(10,-21));
   }
   
   public static long multiply (int num1, int num2){
      if (num1==0 || num2==0)   return 0;
      long a = Math.abs((long)num1);
      int b = Math.abs(num2);
      if (a < b)    return multiply(b, (int)a);         // algorithm is faster if a > b
      ArrayList<Long> values = new ArrayList<Long>();
      int index = 0;
      while ((1<<index) <= b){
         values.add(a);
         a = a << 1;
         index++;
      }
      index--;
      long mul = 0;
      while (b > 0){
         if (b - (1<<index) >= 0){
            mul += values.get(index);
            b -= (1<<index);
         }else  index--;
      } 
      return (num1>0) ^ (num2>0) ? -mul : mul; 
   }

}
