package square;

public class ThiefProblem {

   /**
    * 经典的小偷问题：一排房子，每个房子里有一定价值的东西，小偷不能偷相邻的两
    * 个房间。即如果小偷光临了房间i, 那么就不能再偷房间i – 1和房间i + 1。要求返回
    * 小偷能偷到东西的总价值的最大值
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
