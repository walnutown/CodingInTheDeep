package amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

public class AverageScore {

   /**
    * Give a list of Result, return the average score of each student
    * average score is calculated as the average of top 5 scores of each student
    * 
    * struct Result{
    * int studentID;
    * string data;
    * int testScore;
    * }
    */

   public static void main(String[] args) {
      ArrayList<Result> results = new ArrayList<Result>();
      Random random = new Random(System.currentTimeMillis());
      for (int i = 0; i < 10; i++) {
         int id = random.nextInt(4);
         for (int j = 0; j < 5; j++) {
            results.add(new Result(id, random.nextInt(100)));
         }
      }
      System.out.println(results.toString());
      System.out.println(getAverage(results));
   }

   public final static int NUM = 5;

   public static Map<Integer, Double> getAverage(ArrayList<Result> results) {
      Map<Integer, PriorityQueue<Integer>> map = new HashMap<Integer, PriorityQueue<Integer>>();
      Map<Integer, Double> res = new HashMap<Integer, Double>();
      Comparator<Integer> comp = new Comparator<Integer>(){
         public int compare(Integer n1, Integer n2) {
            return -(n1-n2);
         }
      };
      for (Result r : results) {
         int id = r.studentID;
         if (map.containsKey(id)) {
            map.get(id).add(r.testScore);
         } else {
            map.put(id, new PriorityQueue<Integer>(NUM, comp));
            map.get(id).add(r.testScore);
         }
      }
      //System.out.println(map.toString());
      for (int id : map.keySet()) {
          double sum = 0;
         PriorityQueue<Integer> pq = map.get(id);
         for (int i = 0; i < NUM && !pq.isEmpty(); i++)
            sum += pq.poll();
         res.put(id, sum/NUM);
      }
      return res;
   }

   public static class Result {
      public int studentID;
      public int testScore;

      public Result(int studentID, int testScore) {
         this.studentID = studentID;
         this.testScore = testScore;
      }
      
      public String toString(){
         return "("+studentID+","+testScore+")";
      }

   }

}
