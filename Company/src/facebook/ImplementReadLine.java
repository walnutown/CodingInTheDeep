package facebook;

public class ImplementReadLine {
   /*
    * Give you a function char* read4096(), return a string which has <= 4096 characters
    * If the string is less than 4096 characters, this means we've reached the end of file EOF
    * Use API read4096(), write a function char* readline()
    * Requirement:
    * #1 readline() returns when reading Ô\nÕ or EOF;
    * #2 readline() may be called multiple times on a file, the return value should be correct.
    * #3 readline() may return char array longer than 4096 chars.
    */
   private char[] read4k() {
      return null;
   }

   /**
    * There're two cases:
    * [1] there's a complete line in the buffer, we read the line and adjust the buffer
    * [2] there's no complete line in the buffer, we need to read more characters through read4k()
    */
   static StringBuilder buffer;

   public String readLine() {
      if (buffer.length() == 0){
         buffer.append(read4k());
         if (buffer.length()==0) // no more characters, just return empty string
            return "";
      }
      StringBuilder line = new StringBuilder();
      int i = 0;
      while (i < buffer.length() && buffer.charAt(i) != '\n')
         line.append(buffer.charAt(i++));
      buffer.delete(0, i+1);
      if (buffer.charAt(i) == '\n')
         return line.toString();
      else
         return line.toString() + readLine();
   }
}
