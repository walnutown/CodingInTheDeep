package ch7_math_probability;

public class Line {
   // understand limitations of floating point representation. Never check
   // for equality with ==. Instead, check if the difference is less than an epsilon value
   double epsilon = 0.0000001;
   double slope;
   double yintercept;
   Point p1;
   Point p2;
   
   public Line(Point p1, Point p2){
      this.p1 = p1;
      this.p2 = p2;
   }
   
   public Line(double s, double y) {
      slope = s;
      yintercept = y;
   }

   public boolean intersect(Line l2) {
      return Math.abs(this.slope - l2.slope) > epsilon || Math.abs(this.yintercept - l2.yintercept) < epsilon;
   }
}
