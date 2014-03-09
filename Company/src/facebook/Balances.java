package facebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Balances {

   /**
    * Facebook Programming Challenge
    */
   // use a BalanceNode array as cache, to deal with the references between nodes
   // see Leetcode - CloneGraph
   public static void main(String[] args) {
      BalanceNode[] B = null;
      try {
         B = build();
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
      write(B);
   }

   public static void write(BalanceNode[] B) {
      for (BalanceNode b : B) {
         StringBuilder sb = new StringBuilder();
         sb.append(b.getIndex() + ": ");
         int lw = b.getBalancedLeftWeight();
         int rw = b.getBalancedRightWeight();
         if (lw > rw)
            sb.append("0 " + (lw - rw));
         else
            sb.append((rw - lw) + " 0");
         System.out.println(sb.toString());
      }
   }

   public static BalanceNode[] build() throws FileNotFoundException {
      // Scanner scanner = new Scanner(System.in);
      Scanner scanner = new Scanner(new File("src/facebook/Balances_testcases/input001.txt"));
      int count = Integer.parseInt(scanner.nextLine());
      String[] ss = new String[count * 2];
      BalanceNode[] B = new BalanceNode[count];
      for (int i = 0; i < ss.length; i++)
         ss[i] = scanner.nextLine();
      for (int i = ss.length - 1; i >= 0; i = i - 2) {
         BalanceNode b = B[i / 2] != null ? B[i / 2] : new BalanceNode(i / 2);
         String left = ss[i - 1], right = ss[i];
         b.left = buildWing(left, B);
         b.right = buildWing(right, B);
         B[i / 2] = b;
      }

      return B;
   }

   public static BalanceWing buildWing(String str, BalanceNode[] B) {
      String[] ss = str.split(" ");
      BalanceWing wing = new BalanceWing(Integer.parseInt(ss[0]));
      for (int i = 1; i < ss.length; i++) {
         int index = Integer.parseInt(ss[i]);
         BalanceNode child = B[index] != null ? B[index] : new BalanceNode(index);
         B[index] = child;
         wing.addChild(child);
      }
      return wing;
   }

   public static class BalanceNode {
      int index;
      BalanceWing left, right;

      public BalanceNode(int num) {
         this.index = num;
         left = null;
         right = null;
      }

      public int getIndex() {
         return index;
      }

      public int getBalancedWeight() {
         int w = Math.max(getBalancedLeftWeight(), getBalancedRightWeight());
         return w * 2 + 10;
      }

      public int getBalancedLeftWeight() {
         return left == null ? 0 : left.getBalancedWeight();
      }

      public int getBalancedRightWeight() {
         return right == null ? 0 : right.getBalancedWeight();
      }

      public String toString() {
         StringBuilder sb = new StringBuilder();
         sb.append(index + ": ");
         if (left != null)
            sb.append(left.toString() + "; ");
         if (right != null)
            sb.append(right.toString());
         return sb.toString();
      }
   }

   public static class BalanceWing {
      int weight;
      ArrayList<BalanceNode> children;

      public BalanceWing(int weight) {
         this.weight = weight;
         children = new ArrayList<BalanceNode>();
      }

      public boolean hasChildren() {
         return !children.isEmpty();
      }

      public void addChild(BalanceNode node) {
         children.add(node);
      }

      public int getBalancedWeight() {
         int aw = weight;
         if (hasChildren()) {
            for (BalanceNode b : children)
               aw += b.getBalancedWeight();
         }
         return aw;
      }

      public String toString() {
         return weight + "-" + children.toString();
      }
   }
}
