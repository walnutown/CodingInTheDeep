package ch11_sorting_searching;

public class ch11_11_8 {
   
   /*
    * Imagine you're reading in a stream of integers. 
    * Periodically, you wish to be able to look up the rank of a number x
    * x is the number of values less than or equal to x
    */
   public static void main(String[] args) {
      int[] arr = new int[]{1, 20, -3, 5, 9, 4, 200};
      RankNode root = new RankNode(arr[0]);
      for (int i = 1; i < arr.length; i++){
         track(arr[i], root);
      }
      System.out.println(getRankOfNumber(1, root));
   }
   
   public static void track(int num, RankNode root){
      root.insert(num);
   }
   
   public static int getRankOfNumber(int num, RankNode root){
      RankNode p = root;
      while (p != null){
         if (p.val == num)
            return p.rank;
         if (p.val < num)
            return getRankOfNumber(num, root.right);
         if (p.val > num)
            return getRankOfNumber(num, root.left);
      }
      return 0;
   }
   
   public static class RankNode{
      public int val;
      public RankNode left, right;
      public int rank;
      public RankNode(int val){
         this.val = val;
         left = null;
         right = null;
         rank = 0;
      }
      
      public void insert(int num){
         if (num < val){
            if (left == null){
               left = new RankNode(num);
               left.rank = rank;
            }
            else
               left.insert(num);
            rank++;
            updateRankOfRightSubTree(right);
         }else{
            if (right == null){
               right = new RankNode(num);
               right.rank = rank+1;
            }
            else
               right.insert(num);
         }
      }
      
      public void updateRankOfRightSubTree(RankNode root){
         if (root == null)
            return;
         root.rank++;
         updateRankOfRightSubTree(root.left);
         updateRankOfRightSubTree(root.right); 
      }
      
      public String toString(){
         return "(" + val + ":" + rank + ")";
      }
   }

}


// questions to note : whether we have duplicates in the stream?