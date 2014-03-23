package square;

public class ThiefProblem {

   /**
    * Given s line of houses on the street, each house has a value. The theif wants to
    * get the maximum value. Yet, he must obey the following rule, that is: if he steals
    */
   public static void main(String[] args) {
      System.out.println(thief(new int[]{1,20,3,4,5,6,7}));
   }
   
   public static int thief(int[] rooms){
      if (rooms==null || rooms.length==0)   return 0;
      int[] dp = new int[rooms.length+1];
      dp[0] = 0;
      dp[1] = rooms[0];
      for (int i=2; i<=rooms.length; i++)
         dp[i] = Math.max(rooms[i-1] + dp[i-2], dp[i-1]);
      return dp[rooms.length];
   }

}
