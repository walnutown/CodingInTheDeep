/*
    Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
*/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

// Use the property that two cross lines with same slope are actually the same line
// [1] Choose an anchor point, create a line by choosing another point
// [2] count the number of lines of different slopes that pass through the anchor point, we
// use a map here to store the count result
// [3] Note there may be same points in the given set, which should be counted into all slopes
// [4] Note the two points with same x value, they have infinite slope
// time: O(n^2); space: O(n)

public class Solution {
    public int maxPoints(Point[] points) {
        if (points==null)   return 0;
        if (points.length<=2)   return points.length;
        int N = points.length, max=2;
        for (int i=0; i<N; i++){
            Point p1 = points[i];
            Map<Double, Integer> map = new HashMap<Double, Integer>();
            int base =1, infinite=0;  // base counts the number of points that have the same coordinates as p1
            for (int j=i+1; j<N; j++){ // infinite counts the number of lines with infinite slope
                Point p2 = points[j];
                if (p1.x==p2.x){
                    if (p1.y==p2.y)     base++;
                    else    infinite++;
                }
                else{
                    double slope = p1.y==p2.y ? 0.0 : (double) (p1.y-p2.y)/(p1.x-p2.x); // -0.0, 0.0
                    if (map.containsKey(slope))
                        map.put(slope, map.get(slope)+1);
                    else
                        map.put(slope, 1);
                }
            }
            int sum = infinite;
            for (int num : map.values()){
                sum = Math.max(num, sum);
            }
            max = Math.max(max, sum+base);
        }
        return max;
    }
}