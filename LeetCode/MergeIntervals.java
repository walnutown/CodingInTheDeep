// Accepted, Dec 24
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
                curr.start = Math.min(curr.start, next.start);
                curr.end = Math.max(curr.end, next.end);
                intervals.remove(i+1);
            }
        }
        return intervals;
    }
}