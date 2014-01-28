package amazon;

import java.util.ArrayList;
import java.util.Scanner;

public class FindMissingTermInArithmeticProgression {

   /**
    * Input Format
    * The first line contains an Integer N, which is the number of terms which will be provided as
    * input.
    * This is followed by N consecutive Integers, with a space between each pair of integers. All of
    * these are on one line, and they are in AP (other than the point where an integer is missing).
    * 
    * 
    * Output Format
    * One Number which is the missing integer from the series.
    * 
    * Sample Input
    * 5
    * 1 3 5 9 11
    * 
    * Sample Output
    * 7
    */
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int num = Integer.parseInt(in.nextLine());
      String arrs = in.nextLine();
      Scanner lineScanner = new Scanner(arrs);
      ArrayList<Integer> arr = new ArrayList<Integer>();
      while (lineScanner.hasNextInt())
         arr.add(lineScanner.nextInt());
      int diff = (arr.get(arr.size() - 1) - arr.get(0)) / num;
      for (int i = 0; i < arr.size() - 1; i++) {
         if (arr.get(i) + diff != arr.get(i + 1))
            System.out.println(arr.get(i) + diff);
      }

   }

}
