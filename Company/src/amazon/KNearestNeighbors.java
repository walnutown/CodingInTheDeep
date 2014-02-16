package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

import lib.Point;

public class KNearestNeighbors {

   /**
    * Find the K closest points to the origin in 2D plane, given an array containing N points. You
    * can assume K is much smaller than N and N is very large. You need only use standard math
    * operators (addition, subtraction, multiplication, and division).
    */
   public static void main(String[] args) {
      Point[] A = new Point[10];
      Random random = new Random(System.currentTimeMillis());
      for (int i=0; i<10; i++){
         A[i] = new Point(random.nextInt(10), random.nextInt(10));
      }
//      Point[] A = new Point[]{new Point(5,5), new Point(6,4), new Point(4,9), new Point(8,0), new Point(0,4), new Point(2,2), new Point(1,1), new Point(6,1), new Point(0,4), new Point(3,1)};
      System.out.println(Arrays.toString(A));
      System.out.println(knn(A, new Point(0, 0), 3));
      System.out.println(Arrays.toString(knn2(A, new Point(0, 0), 3)));
   }

   // priority queue
   public static ArrayList<Point> knn(Point[] A, final Point origin, int k) {
      Comparator<Point> comp = new Comparator<Point>() {
         public int compare(Point p1, Point p2) {
            return ((p1.x - origin.x) * (p1.x - origin.x) + (p1.y - origin.y) * (p1.y - origin.y)) - ((p2.x - origin.x) * (p2.x - origin.x) + (p2.y - origin.y) * (p2.y - origin.y));
         }
      };
      PriorityQueue<Point> pq = new PriorityQueue<Point>(k, comp);
      for (Point p : A)
         pq.add(p);
      ArrayList<Point> res = new ArrayList<Point>();
      while (k-- > 0)
         res.add(pq.poll());
      return res;
   }

   // quick select
   public static Point[] knn2(Point[] A, Point origin, int k) {
      if (A == null)
         return null;
      return quickSelect(A, origin, k);
   }

   public static Point[] quickSelect(Point[] A, Point origin, int k) {
      int start=0, end=A.length-1;
      while (start < end) {
         int pivot = partition(A, start, end, origin);
         if (pivot == k-1)
            return Arrays.copyOfRange(A, 0, k);
         else if (pivot < k-1)
            start = pivot + 1;
         else
            end = pivot - 1;
      }
      return Arrays.copyOfRange(A, 0, k);
   }

   public static int partition(Point[] A, int start, int end, Point origin) {
      Point pivot = A[end];
      int pivot_value = getDistance(pivot, origin);
      int i = start-1, j = start;
      for (; j < end; j++) {
         if (getDistance(A[j], origin) <= pivot_value){
            swap(A, ++i, j);
         }
      }
      swap(A, i+1, end);
      return i+1;
   }

   public static void swap(Point[] A, int i, int j) {
      if (i == j)
         return;
      Point tmp = A[i];
      A[i] = A[j];
      A[j] = tmp;
   }

   public static int getDistance(Point p1, Point p2) {
      return ((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
   }

}
