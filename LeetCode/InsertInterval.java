
// Submission Result: Wrong Answer

// Input:  [[2,5],[6,7],[8,9]], [0,10]
// Output: [[2,5],[0,10]]
// Expected:   [[0,10]]
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // In place, better if we use LinkedList since we have to remove node from the list
        if (intervals == null || intervals.size() == 0){
            intervals.add(newInterval);
            return intervals;
        }
        // binary search to find the starting interval for merge
        int start_index = getStartIntervalIndex(intervals, newInterval);
        // insert
        if (start_index == intervals.size())    
            intervals.add(newInterval);
        if (intervals.get(start_index).start > newInterval.end) 
            intervals.add(0, newInterval);
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
            else if (mid_int.start > newInterval.end)   end = mid-1;
            else return mid;
        }
        return start;
    }
}



// Accepted, Dec 24
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // In place, better if we use LinkedList since we have to remove node from the list
        if (intervals == null || intervals.size() == 0){
            intervals.add(newInterval);
            return intervals;
        }
        // binary search to find the starting interval for merge
        int start_index = getStartIntervalIndex(intervals, newInterval);
        // insert
        if (start_index == intervals.size())    
            intervals.add(newInterval);
        if (intervals.get(start_index).start > newInterval.end) 
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
    // binary search for starting interval, notice the comparing condition
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