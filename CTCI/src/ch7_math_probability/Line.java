package ch7_math_probability;

public class Line {
   // understand limitations of floating point representation. Never check
   // for equality with ==. Instead, check if the difference is less than an epsilon value
   double epsilon = 0.0001;
   double slope;
   double yintercept;
   Point p1;
   Point p2;
   boolean infinite_slope = false;
   
   public Line(double s, double y) {
      slope = s;
      yintercept = y;
   }
   
   public Line(Point p1, Point p2){
      this.p1 = p1;
      this.p2 = p2;
      if (Math.abs(p1.x - p2.x) > epsilon){
         slope = (p1.y - p2.y)/(p1.x - p2.x);
         yintercept = p1.y - slope * p1.x;   // y intercept from y=mx+b
      }else{
         infinite_slope = true;
         yintercept = Integer.MAX_VALUE;
      }
   }
   
   public double getFlooredSlope(){         // 相当于保留到小数点后多少位, but there may exist epsilon difference if 位数多于epsilon的位数
      int r = (int) (this.slope/this.epsilon);
      return ((double)r * this.epsilon);
   }

   public boolean intersect(Line l2) {
      return Math.abs(this.slope - l2.slope) > epsilon || Math.abs(this.yintercept - l2.yintercept) < epsilon;
   }
   
   public boolean isEquivalent(double a, double b){
      return Math.abs(a-b) < epsilon;
   }
   // remember to check infinite_slope here
   public boolean equals(Object obj){
      Line other = (Line) obj;
      return isEquivalent(this.slope, other.slope) && isEquivalent(this.yintercept, this.yintercept) && this.infinite_slope==other.infinite_slope;
   }
}
