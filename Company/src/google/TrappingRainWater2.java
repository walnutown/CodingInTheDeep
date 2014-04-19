package google;

public class TrappingRainWater2 {
   /*
    * Given a 2D matrix where each element represents the elevation(height) on that point, find how
    * many rain water it is able to hold.
    * For example, given the below 3×3 matrix:
    * 3 3 3
    * 3 0 3
    * 3 3 3
    * It should hold 3 units of rain water.
    */
   
   // This is the 2D version of Leetcode/TrappingRainWater
   // http://stackoverflow.com/questions/21818044/the-maximum-volume-of-trapped-rain-water-in-3d
  
   // Sol1
   // The naive solution is to find the water that can be trapped in each position.
   // More specific, for each position, find all the paths from it to the border of 
   // the matrix, we record the highest value on each path, and the final bar height
   // will be the minimum of those highest values.
   // time: O(n^4); space: O(1)
   
   // We can find that when we calculate the highest values on the path, there're lots of 
   // duplicate calculations. We can optimize Sol1 through this observation.
   
   
   
   public int trapWater(int[][] M){
      return 0;
   }
}
