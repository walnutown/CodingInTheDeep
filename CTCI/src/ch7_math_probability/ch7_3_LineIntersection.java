package ch7_math_probability;

import org.junit.Test;

public class ch7_3_LineIntersection {

   /**
    * Given two lines on Cartesian plane, determine whether the two lines would intersect
    */
   
   // [1] If two lines have different slopes, they will intersect
   // [2] The issue is that the slope is of double type, we may encounter precise loss issue
   // [3] Use epsilon to check equality
   public class Line {
      // understand limitations of floating point representation. Never check
      // for equality with ==. Instead, check if the difference is less than an epsilon value
      double epsilon = 0.0000001;
      double slope;
      double yintercept;

      public Line(double s, double y) {
         slope = s;
         yintercept = y;
      }

      public boolean intersect(Line l2) {
         return Math.abs(this.slope - l2.slope) > epsilon || Math.abs(this.yintercept - l2.yintercept) < epsilon;
      }
   }

   @Test
   public void test() {
      Line l1 = new Line(0.1, 5);
      Line l2 = new Line(0.1, 6);
      System.out.println(l1.intersect(l2));
   }

}
