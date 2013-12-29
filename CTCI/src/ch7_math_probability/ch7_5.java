package ch7_math_probability;

public class ch7_5 {

   /**
    * Given two squares on a two-dimensional plane, find a line that
    * would cut these two squares in half. Assume that the top and
    * the bottom sides of the square run parallel to the x-axis.
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub

   }
    
   public static class Square{
      Point p1;
      Point p2;
      Point p3;
      Point p4;
      
      public Square(Point p1, Point p2, Point p3, Point p4){
         this.p1 = p1;
         this.p2 = p2;
         this.p3 = p3;
         this.p4 = p4;
      }
      
      public double getSize(){
         return Math.abs(this.p1.x - this.p2.x);
      }
      
      public Point getMiddle(){
         return new Point((p1.x + p2.x)/2.0, (p1.y+p3.y)/2.0);
      }
      
      /*
       * return the point where the line segment connecting m1 and m2 intercepts the edge of square1
       * That is, draw a line from m2 to m1, and continue it out until the edge of the square 
       */
      public Point extend(Point m1, Point m2, double size){
         // find what direction the line m2->m1 goes
         double xdir = m1.x < m2.x ? -1 : 1;
         double ydir = m1.y < m2.y ? -1 : 1;
         if (m1.x == m2.x)  return new Point(m1.x, m1.y + ydir*size/2.0);
         
         double slope = (m1.y - m2.y) / (m1.x - m2.x);
         double x1 = 0, y1 = 0;
         if (Math.abs(slope) == 1){
            x1 = m1.x + xdir*size/2.0;
            y1 = m1.y + ydir*size/2.0;
         }else if (Math.abs(slope) < 1){
            x1 = m1.x + xdir*size/2.0;
            y1 = slope*(x1-m1.x) + m1.y;
         }else{
            y1 = m1.y + ydir*size/2.0;
            x1 = (y1 - m1.y)/slope + m1.x;
         }
         return new Point(x1, y1);
      }
      
      public Line cut(Square other){
         // calculate where a line between each middle would collide with the edges of the squares
         Point p1 = extend(this.getMiddle(), other.getMiddle(), this.getSize());
         Point p2 = extend(this.getMiddle(), other.getMiddle(), -1 * this.getSize());
         Point p3 = extend(other.getMiddle(), this.getMiddle(), other.getSize());
         Point p4 = extend(other.getMiddle(), this.getMiddle(), -1 * other.getSize());
         // of above points, find start and end of lines. start is farthest left and end is farthest right
         Point start = p1;
         Point end = p1;
         Point[] points = {p2, p3, p4};
         for (int i=0; i<points.length; i++){
            if (points[i].x < start.x || points[i].x==start.x && points[i].y<start.y)
               start = points[i];
            else if (points[i].x > end.x || points[i].x==start.x && points[i].y > end.y)
               end = points[i];
         }
         return new Line(start, end);
      }
   }
   
}
