package facebook;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

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

   private class BitStream {
      byte[] bytes;
      int capacity; // max number of bits
      int size;     // actual number of bits

      BitStream() {
      }

      ByteArray toByteArray() {
         int actualLength = (size - 1) / 8 + 1;
         ByteArray byteArr = new ByteArray(bytes, actualLength);
         return byteArr;
      }

      @Override
      public String toString() {
         StringBuilder sb = new StringBuilder();
         int count = 0;
         for (int i = 0; i < size; i++) {
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

      int getBit(int bitIndex) {
         int byteIndex = bitIndex / 8, offset = 7 - bitIndex % 8;
         return (bytes[byteIndex] >> offset) & 1;
      }
   }

   private class BitOutputStream extends BitStream {

      BitOutputStream(int initialCapacity) {
         capacity = initialCapacity;
         size = 0;
         bytes = new byte[(capacity - 1) / 8];
      }

      void write(byte b) throws Exception {
         for (int i = 7; i >= 0; i--)
            writeBit((b >> i) & 1);
      }

      void write(Word word) throws Exception {
         int offset = word.offset, length = word.length;
         int wordMaxOffset = (int) Math.pow(2, OFFSET_BIT_NUM);
         int wordMaxLength = (int) Math.pow(2, LENGTH_BIT_NUM);
         if (offset < 0 || offset >= wordMaxOffset)
            throw new Exception("Word offset out of bounds");
         if (length < 0 || length >= wordMaxLength)
            throw new Exception("Word length out of bounds");
         for (int i = OFFSET_BIT_NUM - 1; i >= 0; i--)
            writeBit((word.offset >> i) & 1);
         for (int i = LENGTH_BIT_NUM - 1; i >= 0; i--)
            writeBit((word.length >> i) & 1);
      }

      void writeBit(int bit) throws Exception {
         if (bit != 0 && bit != 1)
            throw new Exception(bit + " is not a bit");
         size++;
         if (bit == 1) {
            int byteIndex = (size - 1) / 8, offset = 7 - (size - 1) % 8;
            bytes[byteIndex] |= (1 << offset);
         }
      }
   }

   private class BitInputStream extends BitStream {
      BitInputStream(ByteArray byteArr) {
         this.bytes = byteArr.toArray();
         capacity = byteArr.size * 8;
         size = 0;
      }

      void seek(int offset) throws Exception {
         if (offset >= capacity)
            throw new Exception("Offset out of bounds");
         size = offset;
      }

      boolean hasNextWord() {
         if (size == capacity)
            return false;
         if (getBit(size) == 0 && size + 8 <= capacity)
            return true;
         else if (getBit(size) == 1 && (size + LENGTH_BIT_NUM + OFFSET_BIT_NUM <= capacity))
            return true;
         return false;
      }

      int next() {
         int ret = getBit(size);
         size++;
         return ret;
      }

      int next(int length) throws Exception {
         int ret = getInteger(size, size + length - 1);
         size += length;
         return ret;
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

   // use custom class instead of ArrayList<Byte> to reduce time of boxing and unboxing
   private class ByteArray {
      byte[] bytes;
      int capacity;
      int size;

      ByteArray(int initialCapacity) {
         capacity = initialCapacity;
         bytes = new byte[capacity];
         size = 0;
      }

      ByteArray(byte[] bytes, int size) {
         this.bytes = bytes;
         capacity = bytes.length;
         this.size = size;
      }

      void add(byte b) {
         bytes[size++] = b;
      }

      void add(ByteArray in, int start, int length) {
         for (int i = start; i < start + length; i++)
            add(in.get(i));
      }

      byte get(int byteIndex) {
         return bytes[byteIndex];
      }

      byte[] toArray() {
         return bytes;
      }

      boolean isFull() {
         return size == capacity;
      }
      
      boolean isEmpty(){
         return size==0;
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

   final static int OFFSET_BIT_NUM = 12;
   final static int LENGTH_BIT_NUM = 4;
   final static int BLOCK_SIZE = 4096*100; // 2^12 should be its factor

   // write to buffer when we have 4k bytes
   // the key problem is there may be remaining bytes in inBytes when 4k is reached, how to combine
   // the remaining bytes with next inBytes?
   public void decode(String inFile, String outFile) throws Exception {
      BufferedInputStream in = new BufferedInputStream(new FileInputStream(inFile));
      BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFile));
      ByteArray inBytes = null, outBytes = null;
      BitInputStream inBits = null;
      try {
         do {
            int maxInputSize = inBytes==null? BLOCK_SIZE : inBytes.size; 
            inBytes = new ByteArray(BLOCK_SIZE);
            if (inBits != null) {
               ByteArray oldInBytes = inBits.toByteArray();
               inBytes.add(oldInBytes, oldInBytes.size, maxInputSize - oldInBytes.size);
            }
            read(in, inBytes, BLOCK_SIZE - inBytes.size);
            print(inBytes);
            inBits = new BitInputStream(inBytes);
            outBytes = new ByteArray(BLOCK_SIZE);
            while (inBits.hasNextWord() && !outBytes.isFull()) {
               int flag = inBits.next();
               if (flag == 0) {
                  outBytes.add((byte) inBits.next(8));
               } else {
                  int offset = inBits.next(OFFSET_BIT_NUM), length = inBits.next(LENGTH_BIT_NUM);
                  int startIndex = outBytes.size - 1 - offset, endIndex = startIndex + length - 1;
                  for (int i = startIndex; i <= endIndex; i++) {
                     outBytes.add(outBytes.get(i));
                  }
               }
            }
            print(outBytes);
            System.out.println("Decode: input: " + inBits.toByteArray().size + " output: " + outBytes.size + "\n");
            write(outBytes, out);
         } while (!inBytes.isEmpty());
      } finally {
         if (in != null)
            in.close();
         if (out != null)
            out.close();
      }
   }

   public void encode(String inFile, String outFile) throws Exception {
      int dictionaryMaxSize = (int) Math.pow(2, OFFSET_BIT_NUM) - 1;
      int bufferMaxSize = (int) Math.pow(2, LENGTH_BIT_NUM) - 1;
      Window dictionary = new Window(dictionaryMaxSize, -1, -1);
      Window buffer = new Window(bufferMaxSize, 0, bufferMaxSize - 1);
      BufferedInputStream in = new BufferedInputStream(new FileInputStream(inFile));
      BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFile));
      ByteArray inBytes = null, outBytes = null;
      BitOutputStream outBits = null;
      try {
         do {
            // init windows
            dictionary.start = -1;
            dictionary.end = -1;
            buffer.start = 0;
            buffer.end = bufferMaxSize - 1;

            inBytes = new ByteArray(BLOCK_SIZE);
            read(in, inBytes, BLOCK_SIZE);
            print(inBytes);
            // when the chunk is small, the compressed one may be larger than the original one
            outBits = new BitOutputStream(inBytes.size * (1 + LENGTH_BIT_NUM + OFFSET_BIT_NUM));
            int i = 0;
            while (i < inBytes.size) {
               Word word = search(inBytes, dictionary, buffer);
               if (word.length == 0) {
                  outBits.writeBit(0);
                  outBits.write(inBytes.get(i));
               } else {
                  outBits.writeBit(1);
                  outBits.write(word);
               }
               int len = word.length == 0 ? 1 : word.length;
               i += len;
               // shift windows
               buffer.start += len;
               buffer.end = Math.min(buffer.end + len, inBytes.size - 1);
               dictionary.end += len;
               dictionary.start = dictionary.end + 1 > dictionary.size ? dictionary.end + 1 - dictionary.size : 0;
            }
            outBytes = outBits.toByteArray();
            print(outBytes);
            System.out.println("Encode: input: " + inBytes.size + " output: " + outBytes.size + "\n");
            write(outBytes, out);
         } while (inBytes.isFull());
         System.out.println("Encode End\n");
      } finally {
         if (in != null)
            in.close();
         if (out != null)
            out.close();
      }

   }

   private void read(BufferedInputStream in, ByteArray bytes, int len) throws IOException {
      int b;
      while (len-- > 0 && (b = in.read()) != -1)
         bytes.add((byte) b);
   }

   private void write(ByteArray bytes, BufferedOutputStream out) throws IOException {
      for (int i = 0; i < bytes.size; i++)
         out.write(bytes.get(i));
   }

   // O(m*n)
   // TODO optimize the search
   private Word search(ByteArray bytes, Window dictionary, Window buffer) {
      Word word = new Word(0, 0);
      if (buffer.start == 0)
         return word;
      int i = dictionary.start;
      while (i <= dictionary.end) {
         int len = 0;
         while (i + len <= dictionary.end && buffer.start + len < buffer.end && bytes.get(i + len) == bytes.get(buffer.start + len)) {
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

   private void print(ByteArray bytes) {
      for (int i = 0; i < bytes.size; i++) {
         for (int j = 7; j >= 0; j--)
            System.out.print((bytes.get(i) >> j) & 1);
         System.out.print(" ");
      }
      System.out.print("\n");
   }

   @Test
   public void testSingleRepeat() throws Exception {
      String file1 = "src/facebook/test11.txt";
      String file2 = "src/facebook/test12.txt";
      String file3 = "src/facebook/test13.txt";
      encode(file1, file2);
      decode(file2, file3);
   }
   
   @Test
   public void testSmallFile() throws Exception{
      String file1 = "src/facebook/test21.txt";
      String file2 = "src/facebook/test22.txt";
      String file3 = "src/facebook/test23.txt";
      encode(file1, file2);
      decode(file2, file3);
   }
   
   @Test
   public void testLargeFile() throws Exception{
      String file1 = "src/facebook/test31.txt";
      String file2 = "src/facebook/test32.txt";
      String file3 = "src/facebook/test33.txt";
      encode(file1, file2);
      decode(file2, file3);
   }
   
   @Test
   public void testSuperLargeFile() throws Exception{
      long startTime = System.currentTimeMillis();
      String file1 = "src/facebook/test41.txt";
      String file2 = "src/facebook/test42.txt";
      String file3 = "src/facebook/test43.txt";
      encode(file1, file2);
      decode(file2, file3);
      System.out.println(System.currentTimeMillis() - startTime);
   }

}
