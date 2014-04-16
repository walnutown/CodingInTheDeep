package lib;

public class Interval {
   public int start;
   public int end;
   public int cost;

   public Interval(int start, int end, int cost) {
      this.start = start;
      this.end = end;
      this.cost = cost;
   }

   public String toString() {
      return "[" + start + "," + end + "]";
   }
}