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

// In place, with binary search. time: average, O(lgn), worst O(n)
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) { 
        if (intervals == null || intervals.size() == 0){
            intervals.add(newInterval);
            return intervals;
        }
        // binary search to find the starting interval to merge
        int start_index = getStartIntervalIndex(intervals, newInterval);
        // insert
        if (start_index == intervals.size())    
            intervals.add(newInterval);
        else if (intervals.get(start_index).start > newInterval.end) 
            intervals.add(start_index, newInterval);
        else{
            Interval start_int = intervals.get(start_index);
            start_int.start = Math.min(start_int.start, newInterval.start);
            start_int.end = Math.max(start_int.end, newInterval.end);
            int i = start_index + 1;
            while (i < intervals.size() && start_int.end >= intervals.get(i).start){
                start_int.end = Math.max(intervals.get(i).end, start_int.end);
                intervals.remove(i);
            }
        }
        return intervals;
    }

    public int getStartIntervalIndex(ArrayList<Interval> intervals, Interval newInterval){
        int start = 0;
        int end = intervals.size()-1;
        while (start <= end){
            int mid = (start + end) >> 1;
            Interval mid_int = intervals.get(mid);
            if (mid_int.end < newInterval.start)    start = mid+1;
            else if (mid_int.end > newInterval.start)   end = mid-1;
            else return mid;
        }
        return start;
    }
}
// in plcae, without binary earch. time: O(n)
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) { 
        if (intervals == null || intervals.size() == 0){
            intervals.add(newInterval);
            return intervals;
        }
        // insert
        int i = 0;
        while (i < intervals.size() && newInterval.start > intervals.get(i).end) i++;
        if (i==intervals.size())    intervals.add(newInterval);
        else if (newInterval.start <= intervals.get(i).start) 
            intervals.add(i, newInterval);
        else
            intervals.add(i+1, newInterval);
        // merge
        while (i+1<intervals.size() && intervals.get(i).end >= intervals.get(i+1).start){
            intervals.get(i).end = Math.max(intervals.get(i).end, intervals.get(i+1).end);
            intervals.remove(i+1);
        }
        return intervals;
    }
}

// we can also create a new result list while traverse the original list. This is trival, skipped.