package ch1_arrays_strings;

import java.util.Arrays;

public class MyStringBuilder {
   private char value[]; // used for character storage
   private int count;   // number of characters used
   
   public MyStringBuilder(int capacity){
      value = new char[capacity];
   }
   
   public MyStringBuilder (String str){
      value = new char[str.length()+16];
      this.append(str);
   }
   
   public int length(){
      return count;
   }
   
   public int capacity(){
      return value.length;
   }
   
   public MyStringBuilder append(Object obj){
      return append(String.valueOf(obj));
   }
   
   public MyStringBuilder append(String str){
      if (str == null) str = "null"; // if str is null, "null" will be appended
      int len = str.length();
      if (len == 0) return this;
      int newCount = count + len;
      if (newCount > value.length)
         expandCapacity(newCount);
      str.getChars(0, len, value, count);
      count = newCount;
      return this;
   }
   /* Ensures that the capacity is at least equal to the specified minimum. 
    * If the current capacity is less than the argument, then a new internal array is allocated
    * with greater capacity. The new capacity is the larger of:
    *     The minimumCapacity argument.
    *     Twice the old capacity, plus 2.
    *  If the minimumCapacity argument is nonpositive, there's overflow
    */
   public void expandCapacity(int minimumCapacity) {
      int newCapacity = (value.length + 1) * 2;
      if (newCapacity < 0)
         newCapacity = Integer.MAX_VALUE;
      else if (newCapacity > newCapacity)
         newCapacity = minimumCapacity;
      value = Arrays.copyOf(value, newCapacity);
   }
   
   public MyStringBuilder insert(int offset, String str){
      if (offset < 0 || offset > length())
         throw new StringIndexOutOfBoundsException(offset);
      if (str == null) str = "null";
      int len = str.length();
      if (len == 0) return this;
      int newCount = count + len;
      if (newCount > value.length)
         expandCapacity(newCount);
      // arraycopy(Object src,  int  srcPos,Object dest, int destPos, int length)
      // copy the latter part of the value array to new position 
      System.arraycopy(value, offset, value, offset + len, count - offset);
      str.getChars(0, str.length(), value, offset);
      count = newCount;
      return this;
   }
   
   public String toString(){
      String s = new String();
      for (int i = 0; i < count; i++){
         s += value[i];
      }
      return s;
   }
}
