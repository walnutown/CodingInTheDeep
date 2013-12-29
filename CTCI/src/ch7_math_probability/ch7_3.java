package ch7_math_probability;

public class ch7_3 {

   /**
    * Given two lines on Cartesian plane, determine whether the two lines would intersect
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Line l1 = new Line(0.1, 5);
      Line l2 = new Line(0.1, 6);
      System.out.println(l1.intersect(l2));
   }
   
   public static class Line{
      // understand limitations of floating point representation. Never check
      // for equality with ==. Instead, check if the difference is less than an epsilon value
      double epsilon = 0.0000001;
      double slope;
      double yintercept;
      
      public Line(double s, double y){
         slope = s;
         yintercept = y;
      }
      
      public boolean intersect(Line l2){
         return Math.abs(this.slope - l2.slope) > epsilon || Math.abs(this.yintercept - l2.yintercept) < epsilon;
      }
   }

}
