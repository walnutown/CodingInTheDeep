/*
    Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

    You may assume that the intervals were initially sorted according to their start times.

    Example 1:
    Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

    Example 2:
    Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

    This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
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

// Insert the interval first, then MergeInterval
// Note the case that newInterval is added to the end of the list
// time: O(n); space: O(1)
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) { 
        if (intervals==null || intervals.size()==0){
            intervals = new ArrayList<Interval>(); intervals.add(newInterval);
            return intervals;
        }
        int i = 0;
        while (i<intervals.size() && intervals.get(i).start < newInterval.start)
            i++;
        if (i==intervals.size())    intervals.add(newInterval); // Note here
        else    intervals.add(i, newInterval);
        i = 0;
        while (i<intervals.size()-1){
            Interval curr = intervals.get(i), next = intervals.get(i+1);
            if (curr.end<next.start)
                i++;
            else{
                curr.start = Math.min(curr.start, next.start);
                curr.end = Math.max(curr.end, next.end);
                intervals.remove(i+1);
            }
        }
        return intervals;
    }
}