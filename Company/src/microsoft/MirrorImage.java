package microsoft;

import java.util.Arrays;

public class MirrorImage {

   /**
    * Given an image represented by byte[][] image, return its mirror image.
    * 
    * Sol:
    * should decide the direction of the mirror
    */
   public static void main(String[] args) {
      byte[][] img = new byte[][] { { 2, 0, 30, 1 }, { 0, 0, 41, 1 }, { 1, 13, 0, 10 },
            { 1, 30, 1, 1 }, };
      printImage(img);
      mirrorImage(img, Direction.Vertical);
      printImage(img);
   }

   enum Direction {
      Vertical, Horizontal
   }

   public static void mirrorImage(byte[][] img, Direction d) {
      if (img == null || img.length == 0 || img[0].length == 0)
         return;
      int h = img.length, w = img[0].length;
      if (d == Direction.Vertical) {
         for (int i = 0; i < h; i++) {
            int j = 0, k = w - 1;
            while (j < k) {
               byte tmp = img[i][k];
               img[i][k] = img[i][j];
               img[i][j] = tmp;
               j++;
               k--;
            }
         }
      }
      // Direction.Horizontal
      // ...
   }

   public static void printImage(byte[][] img) {
      if (img == null || img.length == 0 || img[0].length == 0)
         return;
      for (int i = 0; i < img.length; i++)
         System.out.println(Arrays.toString(img[i]));
      System.out.println();
   }

}
