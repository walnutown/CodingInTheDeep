package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import lib.Interval;

import org.junit.Test;

public class ScheduleMeetingsInMinimumRooms {

   /*
    * Given a set of lectures, with start and end times.
    * Find the minimum number of classrooms, needed to schedule all the lectures so that two
    * lectures do not occur at the same time in the same room
    */

   // http://courses.engr.illinois.edu/cs473/sp2011/lectures/11_notes.pdf
   
   // Greedy algorithm
   // [1] sort all the lectures according to their start time
   // [2] keep track of the finish time of the last lecture in each room
   // [3] Find whether there's a room that is not conflict with the current lecture
   // if yes, add this lecture to the room; otherwise, create a new room. 
   // O(n) for list, O(lgn) for priority queue
   // time: O(nlgn); space: O(n)
   class Room{
      int end;
      ArrayList<Interval> intervals;
      public Room(){
         intervals = new ArrayList<Interval>();
      }
      public void addInterval(Interval interval){
         end = Math.max(end, interval.end);
         intervals.add(interval);
      }
      public String toString(){
         return intervals.toString();
      }
   }
   
   public int getMinimumNumberOfRooms(Interval[] intervals){
      ArrayList<Room> rooms = new ArrayList<Room>();
      if (intervals==null || intervals.length==0)
         return 0;
      Arrays.sort(intervals, new Comparator<Interval>(){
         public int compare(Interval int1, Interval int2){
            return int1.start - int2.start;
         }
      });
      Room room1 = new Room();
      room1.addInterval(intervals[0]);
      rooms.add(room1);
      for (int i=1; i<intervals.length; i++){
         Interval curr = intervals[i];
         int j=0;
         for (; j<rooms.size(); j++){
            if (curr.start > rooms.get(j).end){
               rooms.get(j).addInterval(curr);
               break;
            }
         }
         if (rooms.size()==j) {   // the interval has not been assigned a room
            Room room = new Room();
            room.addInterval(curr);
            rooms.add(room);
         }
      }
      return rooms.size();
   }
   
   @Test
   public void test(){
      Interval[] intervals = new Interval[]{
            new Interval(1,3),
            new Interval(2,5),
            new Interval(4,7),
            new Interval(6,9),
            new Interval(1,10),
            new Interval(5,12),
            new Interval(8,10),
      };
      System.out.println(getMinimumNumberOfRooms(intervals));
   }
}
