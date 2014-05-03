package ch9_recursion_dynamic_programming;

import java.util.Arrays;

import org.junit.Test;

public class ch9_7_PaintFill {

   /**
    * Implement the "paint fill" function
    * Given a screen by a two-dimensional array of colors, a point, and a new color, fill in the
    * surrounding area until the color changes from the original color
    */

   // DFS to find all points that need to change color
   public void paintFill(int[][] canvas, int i, int j, int color) {
      int curr_color = canvas[i][j];
      int height = canvas.length;
      int weight = canvas[0].length;
      canvas[i][j] = color;
      if (i + 1 < height && canvas[i + 1][j] == curr_color)
         paintFill(canvas, i + 1, j, color);
      if (i - 1 >= 0 && canvas[i - 1][j] == curr_color)
         paintFill(canvas, i - 1, j, color);
      if (j + 1 < weight && canvas[i][j + 1] == curr_color)
         paintFill(canvas, i, j + 1, color);
      if (j - 1 >= 0 && canvas[i][j - 1] == curr_color)
         paintFill(canvas, i, j - 1, color);
   }

   @Test
   public void test() {
      int[][] canvas = new int[3][3];
      canvas[1][1] = 1;
      canvas[0][1] = 1;
      canvas[1][2] = 1;
      printCanvas(canvas);
      paintFill(canvas, 1, 1, 2);
      printCanvas(canvas);
   }

   private void printCanvas(int[][] canvas) {
      for (int i = 0; i < canvas.length; i++) {
         System.out.println(Arrays.toString(canvas[i]));
      }
      System.out.println("");
   }

}
