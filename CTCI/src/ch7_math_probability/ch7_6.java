package ch7_math_probability;

import java.util.ArrayList;
import java.util.HashMap;

public class ch7_6 {
   /**
    * Given a two-dimensional graph with points on it, 
    * find a line which passes the most number of points
    * 
    */
   public static Line findBestLine(Point[] points){
      Line bestLine = null;
      int bestCount = 0;
      HashMap<Double, ArrayList<Line>> linesBySlope = new HashMap<Double, ArrayList<Line>>();
      for (int i=0; i<points.length; i++){
         for (int j=i+1; j<points.length; j++){
            Line line = new Line(points[i], points[j]);
            insertLine(linesBySlope, line);
            int count = countEquivalentLines(linesBySlope, line);
            if (count > bestCount){
               bestLine = line;
               bestCount = count;
            }
         }
      }
      return bestLine;
   } 
   
   public static void insertLine(HashMap<Double, ArrayList<Line>> linesBySlope, Line line){
      double key = line.getFlooredSlope();
      if (!linesBySlope.containsKey(key)){
         ArrayList<Line> tmp = new ArrayList<Line>();
         tmp.add(line);
         linesBySlope.put(key, tmp);
      }else linesBySlope.get(key).add(line);
   }
   
   public static int countEquivalentLines(ArrayList<Line> lines, Line line){
      if (lines==null)  return 0;
      int count = 0;
      for (Line l : lines)
         if (l.equals(line))    count++;
      return count;
   }
   
   public static int countEquivalentLines(HashMap<Double, ArrayList<Line>> linesBySlope, Line line){
      double key = line.getFlooredSlope();
      double eps = line.epsilon;
      // notice here that we should take 3 values here, key, key+eps, key-eps
      return countEquivalentLines(linesBySlope.get(key), line) + countEquivalentLines(linesBySlope.get(key-eps), line) + countEquivalentLines(linesBySlope.get(key+eps), line);
   }
   
}
