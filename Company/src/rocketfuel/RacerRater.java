package rocketfuel;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class RacerRater {

   public static final int BUCKET_CAPACITY = 10;

   /**
    * racerId is an integer in the range [0,10^9]
    * startTime and endTime are both integers such that 0 <= startTime < endTime <= 10^18
    * 
    * @throws FileNotFoundException
    */
   public static void main(String[] args) throws FileNotFoundException {

      Racer[] racers = read();
      // System.out.println(Arrays.toString(racers));
      Bucket[] buckets = divideBuckets(racers);
      //System.out.println(Arrays.toString(buckets));
      getScores(racers, buckets);

      printScore(racers);
   }

   public static void printScore(Racer[] racers) {
      Arrays.sort(racers, new ScoreComparator());
      for (Racer r : racers)
         System.out.println(r.id + " " + r.score);
   }

   public static void getScores(Racer[] racers, Bucket[] buckets) {
      Arrays.sort(racers, new EndComparator());
      int i,j;
      for (i = 0; i < racers.length; i++) {
         int score=0;
         for (j=buckets.length-1; j>=0; j--){
            if (racers[i].start < buckets[j].start){
               score += buckets[j].size();
            }else break;
         }
         racers[i].score = score + getScoreInSameBucket(racers[i], j, buckets);
         buckets[j].add(racers[i]);
      }
   }

   public static int getScoreInSameBucket(Racer r, int bucket_index, Bucket[] buckets) {
      int score = 0;
      Bucket b = buckets[bucket_index];
      for (int i = 0; i < b.size(); i++) {
         if (r.start < b.get(i).start)
            score++;
      }
      return score;
   }

   public static Bucket[] divideBuckets(Racer[] racers) {
      int num = racers.length % BUCKET_CAPACITY== 0 ? racers.length / BUCKET_CAPACITY : racers.length / BUCKET_CAPACITY+1;
      Arrays.sort(racers, new StartComparator());
      Bucket[] buckets = initBuckets(num);
      int count = 0, j = 0;
      for (int i = 0; i < racers.length; i++) {
         if (count == 0)
            buckets[j].start = racers[i].start;
         count++;
         if (count == BUCKET_CAPACITY || i == racers.length - 1) {
            buckets[j].end = racers[i].start;
            count = 0;
            j++;
         }
      }
      return buckets;
   }

   public static Bucket[] initBuckets(int num) {
      Bucket[] buckets = new Bucket[num];
      for (int i = 0; i < num; i++)
         buckets[i] = new Bucket();
      return buckets;
   }

   // The first line of the log contains a single integer n from 0 to 70,000 that represents the
   // number of racers in the log
   public static Racer[] read() throws FileNotFoundException {
      Scanner in = new Scanner(new File("input004.txt"));
      int len = Integer.parseInt(in.nextLine());
      Racer[] racers = new Racer[len];
      int i = 0;
      while (in.hasNextLine()) {
         Scanner line = new Scanner(in.nextLine());
         long id = line.nextLong(), start = line.nextLong(), end = line.nextLong();
         racers[i++] = new Racer(id, start, end);
      }
      return racers;
   }

   public static class StartComparator implements Comparator<Racer> {
      @Override
      public int compare(Racer r1, Racer r2) {
         if (r1.start == r2.start)
            return 0;
         return (r1.start - r2.start) > 0 ? 1 : -1;
      }

   }

   public static class ScoreComparator implements Comparator<Racer> {
      @Override
      public int compare(Racer r1, Racer r2) {
         if (r1.score == r2.score) {
            if (r1.id == r2.id)
               return 0;
            else
               return (r1.id - r2.id) > 0 ? 1 : -1;
         }
         return (r1.score - r2.score) > 0 ? 1 : -1;
      }

   }

   public static class EndComparator implements Comparator<Racer> {
      @Override
      public int compare(Racer r1, Racer r2) {
         if (r1.end == r2.end)
            return 0;
         return (r1.end - r2.end) > 0 ? 1 : -1;
      }

   }

   /*
    * racerId is an integer in the range [0,10^9]
    * startTime and endTime are both integers such that 0 <= startTime < endTime <= 10^18
    */
   public static class Racer {
      public long id;
      public long start;
      public long end;
      public int score;

      Racer(long id, long start, long end) {
         this.id = id;
         this.start = start;
         this.end = end;
         score = 0;
      }

      public String toString() {
         return "[" + id + " " + start + " " + end + "]";
      }
   }

   /*
    * a data structure with K buckets (e.g., K = 300 or some function of input size), each of which
    * is initially empty and is defined by two times.
    */
   public static class Bucket {
      public long start;
      public long end;
      public Racer[] list;
      private int index;

      public Bucket() {
         this.start = 0;
         this.end = 0;
         index = 0;
         list = new Racer[BUCKET_CAPACITY];
      }

      public Bucket(long start, long end) {
         this.start = start;
         this.end = end;
         index = 0;
         list = new Racer[BUCKET_CAPACITY];
      }

      public Racer get(int i) {
         return list[i];
      }

      public int size() {
         return index;
      }

      public boolean isFull() {
         return index == BUCKET_CAPACITY;
      }

      public void add(Racer r) {
         list[index++] = r;
      }

      public Racer[] getRacers() {
         return list;
      }

      public String toString() {
         return start + " " + end;
      }
   }

}
