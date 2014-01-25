/*
    Given a collection of intervals, merge all overlapping intervals.

    For example,
    Given [1,3],[2,6],[8,10],[15,18],
    return [1,6],[8,10],[15,18].
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
// Sort and compare, time: O(nlgn); space: O(1) -- in place 
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1)
            return intervals;
        // no need to compare end here
        Comparator<Interval> com = new Comparator<Interval>(){
            public int compare(Interval in1, Interval in2){
                return in1.start - in2.start;
            }
        };
        Collections.sort(intervals, com);
        int i = 0;
        while (i < intervals.size()-1){
            Interval curr = intervals.get(i);
            Interval next = intervals.get(i+1);
            if (curr.end < next.start)
                i++;
            else if (curr.end > next.end)
                intervals.remove(i+1);
            else{
                curr.end = next.end;
                intervals.remove(i+1);
            }
        }
        return intervals;
    }
}