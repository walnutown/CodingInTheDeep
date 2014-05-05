package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

import lib.Point;

import org.junit.Test;

public class KNearestNeighbors {

   /**
    * Find the K closest points to the origin in 2D plane, given an array containing N points. You
    * can assume K is much smaller than N, and N is very large. You need only use standard math
    * operators (addition, subtraction, multiplication, and division).
    */

   // Sol1
   // Use a maxHeap of size k+1
   // time: O(nlgk); space: O(k+1)
   public ArrayList<Point> knn(Point[] A, final Point origin, int k) {
      PriorityQueue<Point> maxHeap = new PriorityQueue<Point>(k+1, new Comparator<Point>() {
         public int compare(Point p1, Point p2) {
            return getDistance(p2, origin) - getDistance(p1, origin);
         }
      });
      for (int i=0; i<A.length; i++){
         maxHeap.add(A[i]);
         if (i>=k)
            maxHeap.poll();
      }
      ArrayList<Point> res = new ArrayList<Point>();
      while (!maxHeap.isEmpty())
         res.add(maxHeap.poll());
      return res;
   }

   // Sol2
   // quick select
   // time: O(n); space: O(1)
   public Point[] knn2(Point[] A, Point origin, int k) {
      if (A == null)
         return null;
      return quickSelect(A, origin, k);
   }

   private Point[] quickSelect(Point[] A, Point origin, int k) {
      int start = 0, end = A.length - 1;
      while (start < end) {
         int pivot = partition(A, start, end, origin);
         if (pivot == k - 1)
            break;
         else if (pivot < k - 1)
            start = pivot + 1;
         else
            end = pivot - 1;
      }
      return Arrays.copyOfRange(A, 0, k);
   }

   private int partition(Point[] A, int start, int end, Point origin) {
      Point pivot = A[end];
      int pivot_value = getDistance(pivot, origin);
      int i = start - 1, j = start;
      for (; j < end; j++) {
         if (getDistance(A[j], origin) <= pivot_value) {
            swap(A, ++i, j);
         }
      }
      swap(A, i + 1, end);
      return i + 1;
   }

   private void swap(Point[] A, int i, int j) {
      if (i == j)
         return;
      Point tmp = A[i];
      A[i] = A[j];
      A[j] = tmp;
   }

   private int getDistance(Point p1, Point p2) {
      return ((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
   }

   @Test
   public void test() {
      Point[] A = new Point[10];
      Random random = new Random(System.currentTimeMillis());
      for (int i = 0; i < 10; i++) {
         A[i] = new Point(random.nextInt(10), random.nextInt(10));
      }
      // Point[] A = new Point[]{new Point(5,5), new Point(6,4), new Point(4,9), new Point(8,0), new
      // Point(0,4), new Point(2,2), new Point(1,1), new Point(6,1), new Point(0,4), new
      // Point(3,1)};
      System.out.println(Arrays.toString(A));
      System.out.println(knn(A, new Point(0, 0), 3));
      System.out.println(Arrays.toString(knn2(A, new Point(0, 0), 3)));
   }

}
