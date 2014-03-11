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
// take care of the case that slope is infinite, and the case of same points
// time: O(n^2)
public class Solution {
    public int maxPoints(Point[] points) {
        if (points==null)   return 0;
        if (points.length<=2)   return points.length;
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        int N = points.length, max=2;
        for (int i=0; i<N; i++){
            Point p1 = points[i];
            int base =1, infinite=0;
            for (int j=i+1; j<N; j++){
                Point p2 = points[j];
                if (p1.x==p2.x){
                    if (p1.y==p2.y)
                        base++;
                    else
                        infinite++;
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
            map.clear();  
        }
        return max;
    }
}