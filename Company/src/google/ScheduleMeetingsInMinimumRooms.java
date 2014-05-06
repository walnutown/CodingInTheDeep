package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

import lib.Interval;

import org.junit.Test;

public class ScheduleMeetingsInMinimumRooms {

   /**
    * Given a set of lectures, with start and end times.
    * Find the minimum number of classrooms, needed to schedule all the lectures so that two
    * lectures do not occur at the same time in the same room
    */

   // http://courses.engr.illinois.edu/cs473/sp2011/lectures/11_notes.pdf

   // Sol1
   // Greedy algorithm based on end time of interval, this solution can provide detailed
   // arrangement of the rooms.
   // [1] sort all the lectures according to their start time
   // [2] keep track of the finish time of the last lecture in each room
   // [3] Find whether there's a room that is not conflict with the current lecture
   // if yes, add this lecture to the room; otherwise, create a new room.
   // O(n) for list, O(lgn) for priority queue
   // time: O(nlgn); space: O(n)
   class Room {
      int end;
      ArrayList<Interval> intervals;

      public Room() {
         intervals = new ArrayList<Interval>();
      }

      public void addInterval(Interval interval) {
         end = Math.max(end, interval.end);
         intervals.add(interval);
      }

      public String toString() {
         return intervals.toString();
      }
   }

   public int getMinimumNumberOfRooms(Interval[] intervals) {
      ArrayList<Room> rooms = new ArrayList<Room>();
      if (intervals == null || intervals.length == 0)
         return 0;
      Arrays.sort(intervals, new Comparator<Interval>() {
         public int compare(Interval int1, Interval int2) {
            return int1.start - int2.start;
         }
      });
      Room room1 = new Room();
      room1.addInterval(intervals[0]);
      rooms.add(room1);
      for (int i = 1; i < intervals.length; i++) {
         Interval curr = intervals[i];
         int j = 0;
         for (; j < rooms.size(); j++) {
            if (curr.start > rooms.get(j).end) {
               rooms.get(j).addInterval(curr);
               break;
            }
         }
         if (rooms.size() == j) {   // the interval has not been assigned a room
            Room room = new Room();
            room.addInterval(curr);
            rooms.add(room);
         }
      }
      return rooms.size();
   }

   // Sol2
   // Based on the observation that the maximum number of rooms is equal to the maximum depth.
   // Calculate maximum number of conflict intervals at the same time (depth)
   // Maintain a queue of intervals, and a variable hold the max number of rooms
   // Traverse the sorted intervals, for each interval, add it into the queue
   // and remove all the intervals that are not conflict with it, update the max.
   // time: O(n^2); space: O(n)
   public int getMinimumNumberOfRooms2(Interval[] intervals) {
      if (intervals == null || intervals.length == 0)
         return 0;
      Arrays.sort(intervals, new Comparator<Interval>() {
         public int compare(Interval int1, Interval int2) {
            return int1.start - int2.start;
         }
      });
      LinkedList<Interval> conflicts = new LinkedList<Interval>();
      int N = intervals.length, max = 0;
      for (int i = 0; i < N; i++) {
         if (conflicts.size() == 0)
            conflicts.add(intervals[i]);
         else {
            Iterator<Interval> itr = conflicts.iterator();
            while (itr.hasNext()) {
               Interval tmp = itr.next();
               if (tmp.end < intervals[i].start)
                  itr.remove();
            }
            conflicts.add(intervals[i]);
            max = Math.max(max, conflicts.size());
         }
      }
      return max;
   }

   // Sol3
   // Time optimize the Sol2 using priority queue to store the conflict intervals
   // In this way, we can reduce the average time of removing unconflict rooms
   public int getMinimumNumberOfRooms3(Interval[] intervals) {
      if (intervals == null || intervals.length == 0)
         return 0;
      Arrays.sort(intervals, new Comparator<Interval>() {
         public int compare(Interval int1, Interval int2) {
            return int1.start - int2.start;
         }
      });
      int max = 0;
      PriorityQueue<Interval> pq = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
         public int compare(Interval int1, Interval int2) {
            return int1.end - int2.end;
         }
      });
      for (Interval intr : intervals) {
         while (!pq.isEmpty() && pq.peek().end < intr.start)
            pq.poll();
         pq.add(intr);
         max = Math.max(max, pq.size());
      }
      return max;
   }

   // Sol4
   // Sort all the time point (mark the starting time).
   // When we meet a starting time, increment the depth, when we meet a ending time, decrement
   // In this way, we can find the max depth.
   // This can also be used to count the number of online users in different periods
   // time: O(ngln); space: O(n)
   public int getMinimumNumberOfRooms4(Interval[] intervals) {
      ArrayList<TimePoint> tps = new ArrayList<TimePoint>();
      for (Interval intr : intervals) {
         tps.add(new TimePoint(intr.start, true));
         tps.add(new TimePoint(intr.end, false));
      }
      Collections.sort(tps, new Comparator<TimePoint>() {
         public int compare(TimePoint p1, TimePoint p2) {
            return p1.val - p2.val;
         }
      });
      int max = 0, count = 0;
      for (TimePoint tp : tps) {
         if (tp.isStart) {
            count++;
            max = Math.max(max, count);
         } else
            count--;
      }
      return max;
   }

   private class TimePoint {
      int val;
      boolean isStart;

      public TimePoint(int val, boolean isStart) {
         this.val = val;
         this.isStart = isStart;
      }
   }

   @Test
   public void test() {
      Interval[] intervals = new Interval[] { new Interval(1, 3), new Interval(2, 5),
            new Interval(4, 7), new Interval(6, 9), new Interval(1, 10), new Interval(5, 12),
            new Interval(8, 10), };
      System.out.println(getMinimumNumberOfRooms(intervals));
      System.out.println(getMinimumNumberOfRooms2(intervals));
      System.out.println(getMinimumNumberOfRooms3(intervals));
      System.out.println(getMinimumNumberOfRooms4(intervals));
   }
}
