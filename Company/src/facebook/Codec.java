package facebook;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class Codec {

   // The basic idea is similar to LZ77. We maintain two sliding windows, one is dictionary,
   // another is buffer. We search in dictionary for the longest substring that is also the prefix
   // of the buffer.
   // The maximum length of the matched prefix in buffer is 2^4 = 16. Thus, the maximum length of
   // the buffer is 16.
   // The maximum value of the offset pointer is 2^12 = 4096. Thus, the maximum length of the
   // dictionary is 4096.

   // Two methods are used to optimize the running time of the program

   // TODO separate the inputbitstream and outputstream
   private class BitStream {
      byte[] bytes;
      int capacity; // max number of bits
      int bitCount;     // actual number of bits

      BitStream(byte[] bytes) {
         this.bytes = bytes;
         capacity = bytes.length * 8;
         bitCount = 0;
      }

      BitStream(int initialCapacity) {
         capacity = initialCapacity;
         bitCount = 0;
         bytes = new byte[(capacity - 1) / 8];
      }

      public void append(byte b) throws Exception {
         for (int i = 7; i >= 0; i--)
            appendBit((b >> i) & 1);
      }

      public void append(Word word) throws Exception {
         int offset = word.offset, length = word.length;
         int wordMaxOffset = (int) Math.pow(2, MAX_OFFSET);
         int wordMaxLength = (int) Math.pow(2, MAX_LENGTH);
         if (offset < 0 || offset >= wordMaxOffset)
            throw new Exception("Word offset out of bounds");
         if (length < 0 || length >= wordMaxLength)
            throw new Exception("Word length out of bounds");
         for (int i = MAX_OFFSET - 1; i >= 0; i--)
            appendBit((word.offset >> i) & 1);
         for (int i = MAX_LENGTH - 1; i >= 0; i--)
            appendBit((word.length >> i) & 1);
      }

      public void appendBit(int bit) throws Exception {
         if (bit != 0 && bit != 1)
            throw new Exception(bit + " is not a bit");
         bitCount++;
         if (bit == 1) {
            int byteIndex = (bitCount - 1) / 8, offset = 7 - (bitCount - 1) % 8;
            bytes[byteIndex] |= (1 << offset);
         }

      }

      public boolean hasNextWord() {
         if (bitCount == capacity)
            return false;
         if (getBit(bitCount) == 0 && bitCount + 8 <= capacity)
            return true;
         else if (getBit(bitCount) == 1 && bitCount + 16 <= capacity)
            return true;
         return false;
      }

      public int next() {
         int ret = getBit(bitCount);
         bitCount++;
         return ret;
      }

      public int next(int length) throws Exception {
         int ret = getInteger(bitCount, bitCount + length - 1);
         bitCount += length;
         return ret;
      }

      public byte[] toByteArray() {
         trimToSize();
         return bytes;
      }

      @Override
      public String toString() {
         StringBuilder sb = new StringBuilder();
         int count = 0;
         for (int i = 0; i < bitCount; i++) {
            sb.append(getBit(i));
            count++;
            if (count == 8) {
               sb.append(" ");
               count = 0;
            }
         }
         sb.append("\n");
         return sb.toString();
      }

      // minimize the byte array size
      private void trimToSize() {
         int actualLength = (bitCount - 1) / 8 + 1;
         if (actualLength < bytes.length)
            bytes = Arrays.copyOf(bytes, actualLength);
      }

      private int getBit(int bitIndex) {
         int byteIndex = bitIndex / 8, offset = 7 - bitIndex % 8;
         return (bytes[byteIndex] >> offset) & 1;
      }

      private int getInteger(int startIndex, int endIndex) throws Exception {
         if (endIndex - startIndex + 1 > 31)
            throw new Exception("Bit range out of bounds");
         int res = 0;
         for (int i = endIndex; i >= startIndex; i--)
            res |= (getBit(i) << (endIndex - i));
         return res;
      }
   }

   private class Word {
      int offset;
      int length;

      Word(int offset, int length) {
         this.offset = offset;
         this.length = length;
      }
   }

   private class Window {
      int size;
      int start;
      int end;

      Window(int size, int start, int end) {
         this.size = size;
         this.start = start;
         this.end = end;
      }
   }

   private class ByteArray {
      byte[] bytes;
      int capacity;
      int size;

      ByteArray(int initialCapacity) {
         capacity = initialCapacity;
         bytes = new byte[capacity];
         size = 0;
      }

      public void add(byte b) {
         if (size >= capacity)
            throw new ArrayIndexOutOfBoundsException("ByteArray Index Out of Bounds.");
         bytes[size++] = b;
      }
      
      public int get(int byteIndex){
         if (byteIndex>=size)
            throw new ArrayIndexOutOfBoundsException("ByteArray Index Out of Bounds.");
         return bytes[byteIndex];
      }
   }

   final static int MAX_OFFSET = 12;
   final static int MAX_LENGTH = 4;
   final static int BLOCK_SIZE = 1024 * 1024;

   public void decode(File inFile, File outFile) throws Exception {
      byte[] input = read(inFile);
      print(input, input.length);
      BitStream bits = new BitStream(input);
      // TODO need optimization here
      byte[] output = new byte[BLOCK_SIZE];
      int byteIndex = 0;
      while (bits.hasNextWord()) {
         int flag = bits.next();
         if (flag == 0) {
            output[byteIndex++] = (byte) bits.next(8);
         } else {
            int offset = bits.next(12), length = bits.next(4);
            int startIndex = byteIndex - 1 - offset, endIndex = startIndex + length - 1;
            for (int i = startIndex; i <= endIndex; i++)
               output[byteIndex++] = output[i];
         }
      }
      print(output, byteIndex);
      write(output, byteIndex, outFile);
   }

   public void encode(String inFile, String outFile) throws Exception {
      int dictionaryMaxSize = (int) Math.pow(2, MAX_OFFSET) - 1;
      int bufferMaxSize = (int) Math.pow(2, MAX_LENGTH) - 1;
      Window dictionary = new Window(dictionaryMaxSize, -1, -1);
      Window buffer = new Window(bufferMaxSize, 0, bufferMaxSize - 1);

      ByteArray bytes = read(inFile, 0, BLOCK_SIZE);
      print(bytes);
      BitStream bits = new BitStream(input.length * 17);
      int i = 0;
      while (i < input.length) {
         Word word = search(input, dictionary, buffer);
         if (word.length == 0) {
            bits.appendBit(0);
            bits.append(input[i]);
         } else {
            bits.appendBit(1);
            bits.append(word);
         }
         int len = word.length == 0 ? 1 : word.length;
         i += len;
         buffer.start += len;
         buffer.end = Math.min(buffer.end + len, input.length - 1);
         dictionary.end += len;
         dictionary.start = dictionary.end + 1 > dictionary.size ? dictionary.end + 1 - dictionary.size : 0;
      }
      byte[] output = bits.toByteArray();
      print(output, output.length);
      write(output, output.length, outFile);
   }

   // TODO optimize the large file reading
   private ByteArray read(String fileName, int offset, int len) throws IOException {
      // TODO optimize the arraylist here
      RandomAccessFile raf = null;
      ByteArray bytes = new ByteArray(len);
      try {
         raf = new RandomAccessFile(fileName, "r");
         int b;
         while ((b = raf.read()) != -1 && len-->0)
            bytes.add((byte) b);
      } finally {
         if (raf != null)
            raf.close();
      }
      return bytes;
   }

   private void write(byte[] output, int length, File file) throws IOException {
      BufferedOutputStream out = null;
      try {
         out = new BufferedOutputStream(new FileOutputStream(file));
         for (int i = 0; i < length; i++)
            out.write(output[i]);
      } finally {
         if (out != null)
            out.close();
      }
   }

   // O(m*n)
   // TODO optimize the search
   private Word search(byte[] input, Window dictionary, Window buffer) {
      Word word = new Word(0, 0);
      if (buffer.start == 0)
         return word;
      int i = dictionary.start;
      while (i <= dictionary.end) {
         int len = 0;
         while (i + len <= dictionary.end && buffer.start + len < buffer.end && input[i + len] == input[buffer.start + len]) {
            len++;
         }
         if (len > 1 && len > word.length) {
            word.length = len;
            word.offset = dictionary.end - i;
         }
         i++;
      }
      return word;
   }
   
   private void print(ByteArray bytes){
      for (int i = 0; i < bytes.size; i++) {
         for (int j = 7; j >= 0; j--) {
            System.out.print((bytes.get(i) >> j) & 1);
         }
         System.out.print(" ");
      }
      System.out.print("\n");
   }

   private void print(byte[] bytes, int length) {
      for (int i = 0; i < length; i++) {
         for (int j = 7; j >= 0; j--) {
            System.out.print((bytes[i] >> j) & 1);
         }
         System.out.print(" ");
      }
      System.out.print("\n");
   }

   @Test
   public void test() throws Exception {
      File file1 = new File("src/facebook/test.txt");
      File file2 = new File("src/facebook/test1.txt");
      File file3 = new File("src/facebook/test2.txt");
      encode(file1, file2);
      decode(file2, file3);
   }

}
