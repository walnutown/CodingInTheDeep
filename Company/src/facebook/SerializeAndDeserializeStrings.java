package facebook;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class SerializeAndDeserializeStrings {
   /**
    * How to serialize a list of strings and pass it over the network, and de-serialize the list of
    * strings? The string may contain any possible character out of 256 valid characters.
    * 
    */

   // http://www.careercup.com/question?id=5979667

   // Sol1
   // Add header to each string. This solution converts strings to byte stream.
   // Header is composed of k bytes, and stores the length of the string
   // here, we use k = 4, which covers the string length of 2^32
   public byte[] serialize(String[] strs) throws Exception {
      ArrayList<Byte> ret = new ArrayList<Byte>();
      for (String str : strs) {
         ret.addAll(encode(str));
      }
      byte[] r = new byte[ret.size()];
      for (int i = 0; i < ret.size(); i++)
         r[i] = ret.get(i);
      return r;
   }

   private ArrayList<Byte> encode(String s) throws Exception {
      ArrayList<Byte> ret = new ArrayList<Byte>();
      ret.addAll(getHeader(s));
      for (int i = 0; i < s.length(); i++) {
         byte val = (byte) s.charAt(i);
         ret.add(val);
      }
      return ret;
   }

   private ArrayList<Byte> getHeader(String s) throws Exception {
      ArrayList<Byte> ret = new ArrayList<Byte>();
      for (int i = 0; i < 4; i++)
         ret.add((byte) 0);
      long N = s.length();
      if (N > Math.pow(2, 32))
         throw new Exception("String length exceeds.");
      int j = 3;
      while (N > 0) {
         ret.set(j, (byte) (N % 256));
         N /= 256;
         j--;
      }
      return ret;
   }

   public String[] deserialize(byte[] bytes) throws Exception {
      ArrayList<String> ret = new ArrayList<String>();
      int N = bytes.length;
      if (N < 4)
         throw new Exception("Invalid bytes");
      int start = 0;
      while (start + 4 < N) {
         int len = getStringLength(bytes, start);
         ret.add(decode(bytes, start + 4, len));
         start = start + 4 + len;
      }
      String[] r = new String[ret.size()];
      for (int i = 0; i < ret.size(); i++)
         r[i] = ret.get(i);
      return r;
   }

   private int getStringLength(byte[] bytes, int start) {
      int len = 0;
      for (int i = start; i < start + 4; i++)
         len = len * 256 + bytes[i];
      return len;
   }

   private String decode(byte[] bytes, int start, int len) throws Exception {
      StringBuilder sb = new StringBuilder();
      for (int i = start; i < start + len; i++) {
         if (i >= bytes.length)
            throw new Exception("Invalid bytes");
         char ch = (char) (bytes[i]);
         sb.append(ch);
      }
      return sb.toString();
   }

   // Sol2
   // Add header to each string, the header is of length k (k > Length(maxStringLength)), header
   // still
   // stores the length of the string, if there're empty digits in the header, fill with zeros.
   // This solution doesn't convert strings to bytes

   final static int headerLen = Integer.toString(Integer.MAX_VALUE).length();

   public String serialize2(String[] strs) throws Exception {
      StringBuilder sb = new StringBuilder();
      for (String str : strs) {
         sb.append(getHeader2(str));
         sb.append(str);
      }
      return sb.toString();
   }

   private String getHeader2(String s) throws Exception {
      StringBuilder sb = new StringBuilder();
      if (s.length() > headerLen)
         throw new Exception("String length exceeds");
      sb.append(s.length());
      int i = sb.length();
      StringBuilder ret = new StringBuilder();
      while (i++ < headerLen)
         ret.append(0);
      ret.append(sb);
      return ret.toString();
   }

   public String[] deserialize2(String s) {
      ArrayList<String> ret = new ArrayList<String>();
      int i = 0, N = s.length();
      while (i + headerLen < N) {
         int len = getLength(s, i);
         ret.add(s.substring(i + headerLen, i + headerLen + len));
         i = i + headerLen + len;
      }
      String[] r = new String[ret.size()];
      for (int j = 0; j < ret.size(); j++)
         r[j] = ret.get(j);
      return r;
   }

   private int getLength(String s, int start) {
      return Integer.parseInt(s.substring(start, start + headerLen));
   }

   // Sol3
   // Add header to each string, we use "(length)" as the header, add header first, then convert
   // the modified string into byte stream

   @Test
   public void test() throws Exception {
      String[] strs = new String[] { "abc", "cdf", "g90g" };
      byte[] bytes = serialize(strs);
      System.out.println(Arrays.toString(bytes));
      String[] strs2 = deserialize(bytes);
      System.out.println(Arrays.toString(strs2));
      String strs3 = serialize2(strs);
      System.out.println(strs3);
      System.out.println(Arrays.toString(deserialize2(strs3)));
   }
}
