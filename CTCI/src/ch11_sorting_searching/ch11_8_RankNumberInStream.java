package ch11_sorting_searching;

public class ch11_8_RankNumberInStream {

   /*
    * Imagine you're reading in a stream of integers.
    * You wish to be able to look up the rank of a number x,
    * x is the number of values less than or equal to x.
    * Implement the data structure and algorithms to support the operations
    */
   // questions to note : whether we have duplicates in the stream?
   
   // tree + attribute to track the number of left-substree nodes
   // get the rank while insert the new node
   public static void main(String[] args) {
      int[] arr = new int[] { 1, 20, -3, 5, 9, 4, 200 };
      RankNode root = new RankNode(arr[0]);
      for (int i = 1; i < arr.length; i++) {
         track(arr[i], root);
      }
      System.out.println(getRankOfNumber(root, 200));
   }

   public static void track(int num, RankNode root) {
      root.insert(num);
   }

   public static int getRankOfNumber(RankNode root, int number) {
      return root.getRank(number);
  }

   public static class RankNode {
      public int left_size = 0;
      public RankNode left;
      public RankNode right;
      public int data = 0;
      public RankNode(int d) {
          data = d;
      }
      
      public void insert(int d) {
          if (d <= data) {
              if (left != null) {
                  left.insert(d);
              } else {
                  left = new RankNode(d);
              }
              left_size++;
          } else {
              if (right != null) {
                  right.insert(d);
              } else {
                  right = new RankNode(d);
              }
          }
      }
      /*
       * If x is node.data
       *    return node.left_size
       * If x is on left of node
       *    return getRank(node.lfet, x)
       * If x is on right of node
       *    return node.left_size + 1 + getRank(node.right, x)
       * */
      public int getRank(int d) {
          if (d == data) {
              return left_size+1;
          } else if (d < data) {
              if (left == null) {
                  return -1;
              } else {
                  return left.getRank(d);
              }
          } else {
              int right_rank = right == null ? -1 : right.getRank(d);
              if (right_rank == -1) {
                  return -1;
              } else {
                  return left_size + 1 + right_rank;
              }
          }
      }
  }


}
