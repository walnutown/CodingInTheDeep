package ch5_bit_manipulation;

import org.junit.Test;

public class ch5_8_DrawHorizontalLine {

   /**
    * Monochrome screen is stored as a single array of bytes, allowing eight consecutive pixels to
    * be stored in one byte. The screen has width w, where w is divisible by 8 (that is, no byte
    * will be split across rows). The height of the screen, of course, can be derived from the
    * length of that array and the width. Implement a function drawHorizontalLine(byte[] screen, int
    * width, int x1, int x2, int y) which draws a horizontal line from (x1, y) to (x2, y)
    */

   // [1] Locate the byte of the starting and ending point of the line
   // [2] if starting and ending points are in the same byte, fill the bits in range
   // [3] if starting and ending points are in different bytes, we also have to fill
   // the bytes between the two.
   public void drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y) {
      int start_offset = x1 % 8;
      int first_full_byte = x1 / 8 + 1;

      int end_offset = x2 % 8;
      int last_full_byte = x2 / 8 - 1;

      int height_offset = (width / 8) * y;

      // Set full bytes to 1s
      for (int b = first_full_byte; b <= last_full_byte; b++) {
         screen[height_offset + b] = (byte) 0xFF;
      }

      byte start_mask = (byte) (0xFF >> start_offset);
      byte end_mask = (byte) ~(0xFF >> (end_offset + 1));

      // Set start and end of the line
      if ((x1 / 8) == (x2 / 8)) { // If x1 and x2 are in the same byte
         byte mask = (byte) (start_mask & end_mask);
         screen[height_offset + first_full_byte - 1] |= mask;
      } else {
         screen[height_offset + first_full_byte - 1] |= start_mask;
         screen[height_offset + last_full_byte + 1] |= end_mask;
      }
   }

   private void printByte(byte b) {
      for (int i = 7; i >= 0; i--) {
         System.out.print((b >> i) & 1);
      }
   }

   private void printScreen(byte[] screen, int width) {
      for (int i = 0; i < screen.length; i++) {
         printByte(screen[i]);
         System.out.println("");
      }
      System.out.println("");
   }

   @Test
   public void test() {
      byte[] screen = new byte[8];
      int width = 8;
      printScreen(screen, width);
      drawHorizontalLine(screen, width, 0, 5, 4);
      printScreen(screen, width);
   }

}
