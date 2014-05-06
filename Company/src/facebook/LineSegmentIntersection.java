package facebook;

import lib.LineSegment;
import lib.Point;

import org.junit.Test;

public class LineSegmentIntersection {

   /**
    * Given two line segments (p1, q1) and (p2, q2), find if the given line segments intersect with
    * each other.
    */

   // http://www.geeksforgeeks.org/check-if-two-given-line-segments-intersect/

   // For two line segments to intersect with each other, there're two cases
   // [1] they have different orientations
   // [2] they're collinear and has collision
   public boolean intersect(LineSegment s1, LineSegment s2) {
      Orientation o1 = getOrientation(s1.p1, s1.p2, s2.p1);
      Orientation o2 = getOrientation(s1.p1, s1.p2, s2.p2);
      Orientation o3 = getOrientation(s2.p1, s2.p2, s1.p1);
      Orientation o4 = getOrientation(s2.p1, s2.p2, s1.p2);
      if (o1 != o2 && o3 != o4) // general case[1]
         return true;
      if (o1 == Orientation.COLLINEAR && isOnSegment(s1, s2.p1))
         return true;
      if (o2 == Orientation.COLLINEAR && isOnSegment(s1, s2.p2))
         return true;
      if (o3 == Orientation.COLLINEAR && isOnSegment(s2, s1.p1))
         return true;
      if (o4 == Orientation.COLLINEAR && isOnSegment(s2, s2.p2))
         return true;
      return false;
   }

   // Check whether one point is on the segment
   // Given the 3 points are collnear
   private boolean isOnSegment(LineSegment s, Point r) {
      Point p = s.p1, q = s.p2;
      if (r.x <= Math.max(p.x, q.x) && r.x >= Math.min(p.x, q.x) && r.y <= Math.max(p.y, q.y) && r.y >= Math.min(p.y, q.y))
         return true;
      return false;
   }

   private Orientation getOrientation(Point p, Point q, Point r) {
      // See 10th slides from following link for derivation of the formula
      // http://www.dcs.gla.ac.uk/~pat/52233/slides/Geometry1x1.pdf
      int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
      if (val == 0)
         return Orientation.COLLINEAR;
      return val > 0 ? Orientation.CLOCKWISE : Orientation.COUNTERCLOCKWISE;
   }

   public enum Orientation {
      CLOCKWISE, COUNTERCLOCKWISE, COLLINEAR
   }
   
   @Test
   public void test(){
      LineSegment s1 = new LineSegment(new Point(1,1), new Point(10,1));
      LineSegment s2 = new LineSegment(new Point(1,2), new Point(10,2));
      System.out.println(intersect(s1, s2));
      LineSegment s3 = new LineSegment(new Point(10,0), new Point(0,10));
      LineSegment s4 = new LineSegment(new Point(0,0), new Point(10,10));
      System.out.println(intersect(s3, s4));
   }
}
